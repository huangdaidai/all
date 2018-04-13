package ${package}.service;

import ${package}.model.${tableClass.className};
import ${package}.dao.${tableClass.className}Dao;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
/**
* author: ${author}
* createdOn: ${now?date}
*/
@Service("${tableClass.className?uncap_first}Service")
public class ${tableClass.className}Service extends BaseService<${tableClass.className}Dao, ${tableClass.className}>  {

    @Resource(name = "${tableClass.className?uncap_first}Dao")  
    private ${tableClass.className}Dao dao;  
      
    @Resource(name = "${tableClass.className?uncap_first}Dao") 
    public void setDao(${tableClass.className}Dao dao) {  
        super.setDao(dao);  
    }  
}
