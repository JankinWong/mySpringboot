package com.lagou.bean;

import org.neo4j.ogm.annotation.*;

import java.util.Set;


@NodeEntity
public class Person {
    @Id
    @GeneratedValue
    private Long id;
    @Property("cid")
    private  int  pid;
    @Property
    private  String name;
    private  String character;
    private  double money;

    private  int gender;
    private  int age;
    private  String description;
    @Relationship(type = "Friends",direction = Relationship.INCOMING)
    private Set<Person> relationPersons;

    public Person(Long id, int pid, String name, String character, double money, int gender, int age, String description, Set<Person> relationPersons) {
        this.id = id;
        this.pid = pid;
        this.name = name;
        this.character = character;
        this.money = money;
        this.gender = gender;
        this.age = age;
        this.description = description;
        this.relationPersons = relationPersons;
    }

    public Person() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Person> getRelationPersons() {
        return relationPersons;
    }

    public void setRelationPersons(Set<Person> relationPersons) {
        this.relationPersons = relationPersons;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                ", character='" + character + '\'' +
                ", money=" + money +
                ", gender=" + gender +
                ", age=" + age +
                ", description='" + description + '\'' +
                ", relationPersons=" + relationPersons +
                '}';
    }
}
