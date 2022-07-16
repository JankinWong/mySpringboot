package lagou.dao;

import lagou.bean.Resume;

import java.util.List;

public interface ResumeDAO {

    void insertResume(Resume resume);
    Resume findByName(String name);
    List<Resume> findList(String name);
    List<Resume> findListByNameAndExpectSalary(String name,double expectSalary);
}
