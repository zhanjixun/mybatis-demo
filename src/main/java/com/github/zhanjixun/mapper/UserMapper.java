package com.github.zhanjixun.mapper;


import com.github.zhanjixun.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {

    @Select("SELECT * FROM user WHERE id = #{id}")
    User selectById(int id);

    @Select("SELECT * FROM user WHERE name = #{name}")
    User selectByName(@Param("name") String name);

    @Insert("INSERT INTO user(name,age,sex) VALUES (#{user.name},#{user.age},#{user.sex})")
    int insertUser(@Param("user") User user);

    @Update("UPDATE user SET age=#{age} WHERE id=#{id}")
    int updateUser(@Param("age") int age, @Param("id") int id);

}
