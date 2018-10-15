<#import "parts/common.ftl" as c>
<@c.page>
    <#include "parts/security.ftl">


    <#if userLocal??>
        <#if userLocal.isEditor()>
            <#include "parts/noteForm.ftl" />
        </#if>
    </#if>
<br>
    <#include "parts/noteList.ftl" />
</@c.page>
