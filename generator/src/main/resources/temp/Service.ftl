package ${package}.service;

import ${package}.model.${table.className};
import ${package}.dao.${table.className}Dao;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
/**
* author: ${author}
* createdOn: ${now?date}
*/
@Service("${table.className?uncap_first}Service")
public class ${table.className}Service extends BaseService<${table.className}Dao, ${table.className}>  {

    @Resource(name = "${table.className?uncap_first}Dao")  
    private ${table.className}Dao dao;  
      
    @Resource(name = "${table.className?uncap_first}Dao") 
    public void setDao(${table.className}Dao dao) {  
        super.setDao(dao);  
    }  
}
