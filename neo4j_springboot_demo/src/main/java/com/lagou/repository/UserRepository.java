package com.lagou.repository;

import com.lagou.bean.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends Neo4jRepository<User,Long> {

    List<User> getUsersByName(@Param("name") String name);

    /**
     * 根据年龄查询用户节点
     * @param age
     * @return
     */
    @Query("match(n:User) where n.age >{age} return n")
    List<User> getUsers(@Param("age") Integer age);

}
