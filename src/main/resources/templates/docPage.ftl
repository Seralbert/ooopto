<#import "parts/common.ftl" as c>
<@c.page>
<br />
    <#assign
    chkSession = Session.SPRING_SECURITY_CONTEXT??
    >
    <#if chkSession>
        <#assign
        userLocal = Session.SPRING_SECURITY_CONTEXT.authentication.principal
        name = userLocal.getUsername()
        >
    </#if>
    <#if userLocal??>


        <#include "parts/docForm.ftl">
    </#if>

    <#include "parts/docList.ftl">
</@c.page>