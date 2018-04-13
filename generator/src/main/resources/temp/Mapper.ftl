<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >

<!--
* author: ${author}
* ${now?date}
-->
<mapper namespace="${package}.dao.${tableClass.className}Dao">
    <resultMap id="${tableClass.className?uncap_first}" type="${tableClass.className}">
    <#list fields as f>
        <#if f.key=='PRI'>
        <id property="${f.field}" column="${f.field_}"/>
        </#if>
    </#list>
    <#list fields as f>
        <#if f.key!='PRI'>
        <result property="${f.field}" column="${f.field_}"/>
        </#if>
    </#list>
    </resultMap>

    <sql id="columns">
       ${fields?join(", ", "None")}
    </sql>

    <insert id="insert">
        INSERT INTO ${table}
        (<#list fields as f>  
	        <#if f_has_next>
	        ${f.field_} ,<#rt/>
	        <#else >
            ${f.field_}
	        </#if>
        </#list>)
        VALUES (
        <#list fields as f>
        	<#if f_has_next>
            ${r'#{'}${f.field}${r'}'},<#rt/> 
	        <#else >
            ${r'#{'}${f.field}${r'}'}
	        </#if> 
        </#list>)
    </insert>

    <delete id="delete">
        DELETE FROM ${table}
        <trim prefix="where " prefixOverrides="and ">
        <#list fields as f>
            <if test="${f.field} != null">
                AND ${f.field_} = ${r'#{'}${f.field}${r'}'}
            </if>
        </#list>
        </trim>
    </delete>

    <update id="update">
        UPDATE ${table}
        <set>
        <#list fields as f>
        	<#if f_has_next>
            ${f.field_} = ${r'#{'}${f.field}${r'}'},<#rt/>
	        <#else >
            ${f.field_} = ${r'#{'}${f.field}${r'}'}
	        </#if> 
        </#list>
        </set>
        WHERE ID = ${r'#{ID}'}
    </update>

    <select id="select" resultMap="${tableClass.className?uncap_first}">
        SELECT
        <include refid="columns" />
        FROM ${table}
        <trim prefix="where " prefixOverrides="and ">
        <#list fields as f>
            <if test="${f.field} != null">
            AND ${f.field_} = ${r'#{'}${f.field}${r'}'}
            </if>
        </#list>
        </trim>
    </select>
    
    <select id="selectOne" resultMap="${tableClass.className?uncap_first}">
        SELECT
        <include refid="columns" />
        FROM ${table}
        WHERE 
        <#list fields as f>
	        <#if f.key=='PRI'>
	        ${f.key}=#{id}
	        </#if>
	    </#list>
        
        
    </select>
</mapper>