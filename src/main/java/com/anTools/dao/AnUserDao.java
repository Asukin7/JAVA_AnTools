package com.anTools.dao;

import com.anTools.entity.AnUser;
import org.apache.ibatis.annotations.*;

@Mapper
public interface AnUserDao {

    /**根据openId查询*/
    @Select("SELECT * FROM t_user WHERE openId = #{openId}")
    public AnUser getByOpenId(String openId);

    /**插入数据*/
    @Insert("INSERT INTO t_user (openId, nickName, gender, avatarUrl) VALUES(#{openId}, #{nickName}, #{gender}, #{avatarUrl})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    public Integer insertUser(AnUser anUser);

    /**更新数据*/
    @Update("UPDATE t_user SET nickName = #{nickName}, gender = #{gender}, avatarUrl = #{avatarUrl} WHERE id = #{id} AND openId = #{openId}")
    public Integer updateUser(AnUser anUser);

}
