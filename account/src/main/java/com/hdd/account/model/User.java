package com.hdd.account.model;

import java.lang.String;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;

/**
* author: hdd
* 2018-4-18
*/
@Data
@EqualsAndHashCode(callSuper=true)
public class User extends BaseEntity  implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    /**
     * 用户id
    */ 
    private String userId;
    
    /**
     * 用户名
    */ 
    private String userName;
    
    /**
     * 密码
    */ 
    private String password;
    
    /**
     * 邮件
    */ 
    private String email;
    
    /**
     * 注册时间
    */ 
    private Date registerTime;
    
    /**
     * 小组代码
    */ 
    private String groupCode;
    
     
}
