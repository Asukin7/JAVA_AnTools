package com.anTools.dao;

import com.anTools.entity.AnUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AnUserDao {

    /**查询所有*/
    @Select("select * from t_user")
    public List<AnUser> listAll();

    /**插入数据*/
    @Insert("INSERT INTO t_user (openId, nickName, gender, avatarUrl) VALUES(#{openId}, #{nickName}, #{gender}, #{avatarUrl})")
    Integer insertUser(AnUser anUser);

    /**更新数据*/
    @Update("UPDATE t_user SET nickName = #{nickName}, gender = #{gender}, avatarUrl = #{avatarUrl} WHERE openId = #{openId}")
    Integer updateUser(AnUser anUser);

}
