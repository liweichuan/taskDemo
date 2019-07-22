package com.jnshu.serviceimpl;


import com.jnshu.dao.StudentDao;
import com.jnshu.entity.Student;
import com.jnshu.service.StudentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**实现基本的功能
 * */

@Service
public class StudentServiceImpl implements StudentService {

    private static final Logger Logger= LogManager.getLogger(StudentServiceImpl.class);
    @Autowired
    private StudentDao studentDao;

    //实现增加
    @Override
    public Long addStudent(Student student) {
        Logger.error(student);
        return studentDao.addStudent(student);
    }

    //删除
    @Override
    public boolean deleteStudentByName(String name) {
        Logger.error(name);
        return studentDao.deleteStudentByName(name);
    }

    //更新
    @Override
    public boolean updateStudentById(Student student) {
        Logger.error(student);
        return studentDao.updateStudentById(student);
    }

    //根据姓名查询
    @Override
    public Student findStudentByName(String name) {
        Logger.error(studentDao.findStudentByName(name));
        return studentDao.findStudentByName(name);
    }

    @Override
    public Student findStudentById(Long student_id) {
        Logger.error(studentDao.findStudentById(student_id));
        return studentDao.findStudentById(student_id);
    }

    //查询所有
    @Override
    public List<Student> findAll() {
        Logger.error(studentDao.findAll());
        return studentDao.findAll();
    }
}
