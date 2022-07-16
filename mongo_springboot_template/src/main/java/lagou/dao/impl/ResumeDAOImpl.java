package lagou.dao.impl;

import lagou.bean.Resume;
import lagou.dao.ResumeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("resumeDao")
public class ResumeDAOImpl implements ResumeDAO {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void insertResume(Resume resume) {
        mongoTemplate.insert(resume,"lg_resume_datas");
    }

    @Override
    public Resume findByName(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        List<Resume> resumeList = mongoTemplate.find(query,Resume.class,"lg_resume_datas");
        return resumeList.isEmpty()?null: resumeList.get(0);
    }

    @Override
    public List<Resume> findList(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        List<Resume> resumeList = mongoTemplate.find(query,Resume.class,"lg_resume_datas");
        return resumeList;
    }

    @Override
    public List<Resume> findListByNameAndExpectSalary(String name, double expectSalary) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name).andOperator(Criteria.where("expectSalary").is(expectSalary)));
        List<Resume> resumeList = mongoTemplate.find(query,Resume.class,"lg_resume_datas");
        return resumeList;

    }
}
