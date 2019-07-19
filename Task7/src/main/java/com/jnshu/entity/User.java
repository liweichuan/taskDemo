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
    //getter&getter
}
