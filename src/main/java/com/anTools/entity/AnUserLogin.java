package com.anTools.entity;

import java.io.Serializable;

public class AnUserLogin implements Serializable {

    private static final long serialVersionUID = 1L;

    private String code;
    private String session;
    private String token;
    private String encryptedData;
    private String iv;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }

    @Override
    public String toString() {
        return "AnUserLogin{" +
                "code='" + code + '\'' +
                ", session='" + session + '\'' +
                ", token='" + token + '\'' +
                ", encryptedData='" + encryptedData + '\'' +
                ", iv='" + iv + '\'' +
                '}';
    }

}
