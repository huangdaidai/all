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
public class UmGroup extends BaseEntity  implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    /**
     * 小组代码
    */ 
    private String groupCode;
    
    /**
     * 小组名称
    */ 
    private String groupName;
    
    /**
     * 创建时间
    */ 
    private Date createTime;
    
     
}
