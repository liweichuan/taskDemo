package com.jnshu.entity;

import lombok.Data;

/**这是注册信息
 * */

@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private String email;
    private int phone;
    private String picture;
    private int message;
    private int type;
    private String create_by;
    private String update_by;
    private Long create_time;
    private Long update_time;
    //getter&getter
}
