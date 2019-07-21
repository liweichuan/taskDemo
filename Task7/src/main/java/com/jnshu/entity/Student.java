package com.jnshu.entity;

import lombok.Data;
/**这里是报名贴信息
 * */

@Data
public class Student {
    private Long id;
    private String name;
    private Long qq;
    private Long start_time;
    private String graduation;
    private Long student_id;
    private String link;
    private String wish;
    private String senior;
    private int status;
    private String create_by;
    private String update_by;
    private Long create_time;
    private Long update_time;
    //getter&getter
}
