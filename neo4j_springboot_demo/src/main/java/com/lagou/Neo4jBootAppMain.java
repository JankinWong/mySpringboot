package com.lagou;

import com.lagou.bean.Person;
import com.lagou.service.Neo4jPersonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
@SpringBootApplication
public class Neo4jBootAppMain {
    public static void main(String[] args) {
        ApplicationContext app = SpringApplication.run(Neo4jBootAppMain.class,args);
        Neo4jPersonService personService =app.getBean(Neo4jPersonService.class);
        System.out.println(personService);
        List<Person> datas = personService.getAll();
        System.out.println(datas);
//            System.out.println(personService. shortestPath("王启年", "九品射手燕小乙"));
    }
}
