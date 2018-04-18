package com.hdd.account.model;

import java.lang.String;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;

/**
* author: hdd
* 2018-4-18
*/
@Data
@EqualsAndHashCode(callSuper=true)
public class GoodDetail extends BaseEntity  implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    /**
     * 商品代码
    */ 
    private String goodCode;
    
    /**
     * 商品名称
    */ 
    private String goodName;
    
     
}
