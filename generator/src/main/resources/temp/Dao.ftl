package ${package}.dao;

import ${package}.model.${tableClass.className};
import ${package}.dao.${tableClass.className}Dao;
import org.springframework.stereotype.Repository;
/**
* author: ${author}
* ${now?date}
*/
@Repository("${tableClass.className?uncap_first}Dao")
public class ${tableClass.className}Dao extends BaseDao<${tableClass.className}>{
   
}