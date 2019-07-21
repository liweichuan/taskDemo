package com.jnshu.dao;

import com.jnshu.entity.Student;

import java.util.List;

/**这里写student的增删查改
 * */


public interface StudentDao {
    //增加
    Long addStudent(Student student);
    //删除
    boolean deleteStudentByName(String name);
    //更新
    boolean updateStudentByName(Student student);
    //靠name查询
    Student findStudentByName(String name);
    //查询
    List<Student> findAll();
}
