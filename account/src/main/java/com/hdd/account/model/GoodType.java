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
public class GoodType extends BaseEntity  implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    /**
     * 商品类型代码
    */ 
    private String goodTypeCode;
    
    /**
     * 商品类型名称
    */ 
    private String goodTypeName;
    
     
}
