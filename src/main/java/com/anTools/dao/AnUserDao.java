package com.anTools.dao;

import com.anTools.entity.AnUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AnUserDao {

    /**查询所有*/
    @Select("SELECT * FROM t_user")
    public List<AnUser> listAll();

    /**根据openId查询*/
    @Select("SELECT * FROM t_user WHERE openId = #{openId}")
    public AnUser getByOpenId(String openId);

    /**插入数据*/
    @Insert("INSERT INTO t_user (openId, nickName, gender, avatarUrl) VALUES(#{openId}, #{nickName}, #{gender}, #{avatarUrl})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    Integer insertUser(AnUser anUser);

    /**更新数据*/
    @Update("UPDATE t_user SET nickName = #{nickName}, gender = #{gender}, avatarUrl = #{avatarUrl} WHERE id = #{id} AND openId = #{openId}")
    Integer updateUser(AnUser anUser);

}
