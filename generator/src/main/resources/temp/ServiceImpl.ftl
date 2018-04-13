package ${package}.service.impl;

import ${package}.service.${tableClass.className}Service;
import ${package}.dao.${tableClass.className}Dao;
import ${package}.model.${tableClass.className};
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
* author: ${author}
* createdOn: ${now?date}
*/
@Service
public class ${tableClass.className}ServiceImpl extends BaseServiceImpl<${tableClass.className}>  implements ${tableClass.className}Service {

    @Resource
    ${tableClass.className}Dao ${tableClass.className?uncap_first}Dao;
	
    @Resource
    public void set${tableClass.className}Dao(${tableClass.className}Dao ${tableClass.className?uncap_first}Dao) {
        this.${tableClass.className?uncap_first}Dao = ${tableClass.className?uncap_first}Dao;
        super.setBaseDao(${tableClass.className?uncap_first}Dao);
    }
 
}