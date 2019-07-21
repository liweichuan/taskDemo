package com.jnshu.service;

import com.jnshu.entity.Student;

import java.util.List;

/**这里student服务层的接口功能和Dao层一样，实现学员报名系统
 * */

public interface StudentService {
    //增加
    Long addStudent(Student student);
    //删除
    boolean deleteStudentByName(String name);
    //更新
    boolean updateStudentByName(Student student);
    //靠id查询
    Student findStudentByName(String name);
    //查询
    List<Student> findAll();
}
