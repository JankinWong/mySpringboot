package lagou;

import lagou.bean.Resume;
import lagou.dao.ResumeDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@SpringBootApplication
public class MongoTemplateMain {
    public static void main(String[] args) {
//        ClassPathXmlApplicationContext applicationContext =
//                new ClassPathXmlApplicationContext("applicationContext.xml");

        ApplicationContext applicationContext = SpringApplication.run(MongoTemplateMain.class);
        ResumeDAO resumeDao = applicationContext.getBean("resumeDao",ResumeDAO.class);

//        Resume resume = new Resume();
//        resume.setName("zhangsan");
//        resume.setCity("bj");
//        Date date = null;
//        String dateStr = "yyyy-MM-dd hh:mm:ss";
//        SimpleDateFormat simpleDateFormatter = new SimpleDateFormat(dateStr);
//        try {
//            date = simpleDateFormatter.parse("2002-10-01 11:13:14");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        resume.setBirthday(date);
//        resume.setExpectSalary(18000);
//        resumeDao.insertResume(resume);

        Resume resume = resumeDao.findByName("zhangsan");
        System.out.println(resume);

//        List<Resume> resumeList  = resumeDao.findList("zhangsan");
//        System.out.println(resumeList);
//
//        List<Resume> resumeList1 = resumeDao.findListByNameAndExpectSalary("zhangsan",25000);
//        System.out.println(resumeList1);
    }
}
