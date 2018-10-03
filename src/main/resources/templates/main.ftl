<#import "parts/common.ftl" as c>
<@c.page>
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
        <#include "parts/noteForm.ftl" />
    </#if>
    <br>
<#include "parts/noteList.ftl" />
</@c.page>
