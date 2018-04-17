package ${package}.controller;

<#list allTables as t>
import ${package}.service.${t.className}Service;
</#list>
import org.springframework.beans.factory.annotation.Autowired;

/**
* author: ${author}
* createdOn: ${now?date}
*/
public class BaseController {
	<#list allTables as t>
	@Autowired
	${t.className}Service ${t.className?uncap_first}Service;
	
	</#list>
    
}
