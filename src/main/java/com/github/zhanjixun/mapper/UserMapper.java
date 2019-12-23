package com.github.zhanjixun.mapper;


import com.github.zhanjixun.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

	@Select("SELECT * FROM user WHERE id = #{id}")
	User selectById(int id);

	@Select("SELECT * FROM user WHERE name = #{name}")
	User selectByName(@Param("name") String name);
}
