package com.jnshu.serviceimpl;


import com.jnshu.entity.Student;
import com.jnshu.service.StudentService;

import java.util.List;

/**实现基本的功能
 * */

public class StudentServiceImpl implements StudentService {
    @Override
    public Long addStudent(Student student) {
        return null;
    }

    @Override
    public boolean deleteStudentByName(String name) {
        return false;
    }

    @Override
    public boolean updateStudentByName(Student student) {
        return false;
    }

    @Override
    public Student findStudentByName(String name) {
        return null;
    }

    @Override
    public List<Student> findAll() {
        return null;
    }
}
