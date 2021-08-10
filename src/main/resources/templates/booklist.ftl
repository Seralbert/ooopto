<#import "parts/common.ftl" as c>
<@c.page>
<div class="container">
    <table class="table table-sm table-dark" style="background-color: rgba(0,0,0, 0.75);">
        <thead>
        <tr>
            <th  scope="col">Подразделение</th>
            <th  scope="col">Имя книги</th>
            <th scope="col">#</th>
        </tr>
        </thead>
        <tbody>
            <#list list as r>
            <tr>
                <td>${r.orgName!}</td>
                <td>${r.bookName!}</td>
                <td><a href="/delBook/${r.orgName}/${r.bookName}"><span class="oi oi-delete"> </span> </a> </td>
            </tr>
            </#list>
        </tbody>
</div>
</@c.page>