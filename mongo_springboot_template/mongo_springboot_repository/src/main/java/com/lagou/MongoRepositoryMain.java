package com.lagou;


import com.lagou.bean.Resume;
import com.lagou.bean.Score;
import com.lagou.repository.ResumeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@SpringBootApplication
public class MongoRepositoryMain {
    public static void main(String[] args) {

        ApplicationContext applicationContext = SpringApplication.run(MongoRepositoryMain.class,args);
        ResumeRepository  resumeRepository = applicationContext.getBean(ResumeRepository.class);


        Resume resume = new Resume();
        resume.setName("wanger");
        resume.setCity("bj");
        Date date = null;
        String dateStr = "yyyy-MM-dd hh:mm:ss";
        SimpleDateFormat simpleDateFormatter = new SimpleDateFormat(dateStr);
        try {
            date = simpleDateFormatter.parse("2002-10-01 11:13:14");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        resume.setBirthday(date);
        resume.setExpectSalary(18000);
        Score score = new Score();
        score.setChinese(100);
        score.setEnglish(120);
        score.setMath(140);
        resume.setScore(score);
        resumeRepository.insert(resume);


//        resumeDao.insertResume(resume);
//
//        Resume resume = resumeDao.findByName("lisi");
//        System.out.println(resume);
//
//        List<Resume> resumeList  = resumeDao.findList("zhangsan");
//        System.out.println(resumeList);
//
//        List<Resume> resumeList1 = resumeDao.findListByNameAndExpectSalary("zhangsan",25000);
//        System.out.println(resumeList1);
//        System.out.println(resumeRepository.findAll());
//        System.out.println(resumeRepository.findByNameEquals("zhangsan"));
//        System.out.println(resumeRepository.findByNameAndExpectSalary("zhangsan",18000));
    }
}
