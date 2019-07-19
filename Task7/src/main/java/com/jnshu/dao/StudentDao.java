package com.jnshu.dao;

import com.jnshu.entity.Student;

import java.util.List;

/**这里写student的增删查改
 * */


public interface StudentDao {
    //增加
    int addStudent(Student student);
    //删除
    boolean deleteStudentByName(Long id);
    //更新
    boolean updateStudentByName(Student student);
    //靠id查询
    Student findStudentById(Long id);
    //查询
    List<Student> findAll();
}
