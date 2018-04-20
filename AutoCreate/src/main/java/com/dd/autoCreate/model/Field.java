package com.dd.autoCreate.model;

import lombok.Data;

@Data
public class Field {
    String fieldInDB;
    String fieldInClass;
    String typeInDB;
    String typeInClass;
    String collation;
    String nvll;
    String key;
    String defaults;
    String extra;
    String privileges;
    String comment;
    
}
