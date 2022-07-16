package com.lagou.bean;

import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Documented;
import java.util.Date;


@Document("lg_resume_datas")
public class Resume {

    private String id;
    private String name;
    private String city;
    private Date birthday;
    private double expectSalary;
    private Score score;

    public Resume(String id, String name, String city, Date birthday, double expectSalary, Score score) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.birthday = birthday;
        this.expectSalary = expectSalary;
        this.score = score;
    }

    public Resume() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public double getExpectSalary() {
        return expectSalary;
    }

    public void setExpectSalary(double expectSalary) {
        this.expectSalary = expectSalary;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", birthday=" + birthday +
                ", expectSalary=" + expectSalary +
                ", score=" + score +
                '}';
    }
}
