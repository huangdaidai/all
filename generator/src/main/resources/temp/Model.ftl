package ${package}.model;

<#list allTypes as t>
import ${t};
</#list>
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;

/**
* author: ${author}
* ${now?date}
*/
@Data
@EqualsAndHashCode(callSuper=true)
public class ${tableClass.className} extends BaseEntity<${tableClass.className}>  implements Serializable{
    private static final long serialVersionUID = 1L;
    <#list fields as f>
	<#if f.key!='PRI'>
    /**
     * ${f.comment}
    */ 
    private ${f.type} ${f.field};
    
    </#if>
    </#list>
     
}
