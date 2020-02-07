package com.anTools.common;

import com.anTools.util.TokenUtil;
import com.auth0.jwt.exceptions.JWTDecodeException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * 自定义的验证方法
 */

public class ShiroRealm extends AuthorizingRealm {

    /**
     * 获得自己定义的token
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * 授权方法，要在控制器层调用才会执行，验证方法在下面
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //这里PrincipalCollection对象存放的是SimpleAuthenticationInfo(jwtToken, role, getName())里的验证信息
        System.out.println("[ShiroRealm] - Realm处理授权");
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        System.out.println("[ShiroRealm] - realm获取的token解密后: " + TokenUtil.getTokenData((String) principals.getPrimaryPrincipal()));
        simpleAuthorizationInfo.addRole(TokenUtil.getTokenData((String) principals.getPrimaryPrincipal()).getRole());
        return simpleAuthorizationInfo;
    }

    /**
     * 校验 验证token逻辑
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) {
        String jwtToken = (String) token.getCredentials();
        System.out.println("[ShiroRealm] - 开始token验证 token: " + jwtToken);
        try {
            String role = TokenUtil.getTokenData(jwtToken).getRole();
            if (role != null) {
                System.out.println("[ShiroRealm] - 用户有效 role: " + role);
            } else {
                //token解密失败时，返回filter
                throw new AuthenticationException("token is invalid, please check your token");
            }
        } catch (JWTDecodeException e) {
            //token解密失败时，返回filter
            throw new AuthenticationException("token is invalid, please check your token");
        }

        //坑在这里（否则验证不通过！）
        setCredentialsMatcher(credentialsMatcher());
        return new SimpleAuthenticationInfo(jwtToken, jwtToken, getName());
    }

    /**
     * 注意坑点 : 密码校验，这里因为是JWT形式，就无需密码校验和加密，直接让其返回为true(如果不设置的话，该值默认为false，即始终验证不通过)
     */
    private CredentialsMatcher credentialsMatcher() {
        return (token, info) -> true;
    }

}
