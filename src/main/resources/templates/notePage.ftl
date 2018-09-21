<#import "parts/common.ftl" as c>
<@c.page>
<#include "parts/naviBar.ftl">
<br />
    <#if note.fileName??>
<img class="rounded float-left" style="margin-right: 20px" width="320" height="240" src="/img/${note.fileName}" alt="Test Image" />
    </#if>
<h5>${note.textCaption}</h5>
<pre>${note.textMain}</pre>
    <#if note.fileDocName??>
<nav class="navbar fixed-bottom sticky-bottom">
    Прикрепленный документ <a href="/doc/${note.fileDocName}" class="nav-link">Ссылка</a>
</nav>
    </#if>

</@c.page>