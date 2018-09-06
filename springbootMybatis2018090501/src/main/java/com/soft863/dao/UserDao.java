package com.soft863.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserDao {

    @Cacheable("queryUsers")
    @Select("select * from t_user")
    List<Map<String,Object>> queryUsers();

    @CacheEvict(value="queryUsers" , allEntries = true)
    @Delete("delete from t_user where userid = #{id}")
    int deleteUser(Integer id);
}
