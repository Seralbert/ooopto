<#import "parts/common.ftl" as c>
<@c.page>
<br />

    <#if note.fileName??>
<img class="rounded float-left" style="margin-right: 20px" width="320" height="240" src="/img/${note.fileName}" />
    </#if>
<div align="right">
<a class="text" href="/noteEdit/${note.id}">Редактировать</a>
</div>
<h5>${note.textCaption}
</h5>
<br>

<pre>${note.textMain}</pre>
    <#if note.fileDocName??>
<nav class="navbar fixed-bottom sticky-bottom navbar-dark bg-dark">
    <div class="navbar-text">Прикрепленный документ</div>  <a href="/doc/${note.fileDocName}" class="nav-link">Ссылка</a>
</nav>
    </#if>

</@c.page>