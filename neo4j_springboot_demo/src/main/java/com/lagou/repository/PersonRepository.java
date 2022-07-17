package com.lagou.repository;

import com.lagou.bean.Person;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends Neo4jRepository<Person,Long> {

    @Query("match(p:Person) where p.money > {0} return p")
    List<Person> personList(double money);
    @Query("MATCH p=shortestPath((person:Person {name:{0}})-[*1..4]- (person2:Person {name:{1}}) ) RETURN p")
    List<Person> shortestPath(String startName, String endName);

//    @Query("match(p:Person) where p.money>{money} return p")
//    List<Person> personList(@Param("money") double money);



}
