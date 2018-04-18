package com.hdd.account.model;

import java.math.BigDecimal;
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
public class Comsume extends BaseEntity  implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    /**
     * 
    */ 
    private String id;
    
    /**
     * 用户id
    */ 
    private String userId;
    
    /**
     * 金额
    */ 
    private BigDecimal account;
    
    /**
     * 商品代码
    */ 
    private String goodCode;
    
    /**
     * 使用者类型：  0：自己使用    1：小组使用
    */ 
    private String userType;
    
    /**
     * 小组代码
    */ 
    private String groupCode;
    
    /**
     * 备注
    */ 
    private String remark;
    
    /**
     * 消费时间
    */ 
    private Date creatTime;
    
     
}
