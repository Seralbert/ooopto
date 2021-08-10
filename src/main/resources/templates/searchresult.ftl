<#import "parts/common.ftl" as c>

<@c.page>
<div class="container">
    <div class="h3 findform">
    Количество обращений - ${size}
    </div>

    <table class="table table-sm table-dark" style="background-color: rgba(0,0,0, 0.75);">
        <thead>
        <tr>
            <th  scope="col">ФИО</th>
            <th  scope="col">Подразделение</th>
            <th  scope="col">Кадастровый номер</th>
            <th  scope="col">Инвентарый номер</th>
            <th  scope="col">Дата поиска</th>
            <th scope="col">#</th>
            <th scope="col">#</th>
        </tr>
        </thead>
<tbody>
    <#list list as r>
    <tr>
        <td>${r.userName}</td>
        <td>${r.orgName!}</td>
        <td>${r.kadNumber}</td>
        <td>${r.docNumber}</td>
        <td>${r.actionDate}</td>
        <td><a href="/searchGen/#{r.id}">Сформировать</a></td>
        <td><a href="/searchDel/#{r.id}">x</a> </td>
    </tr>
    </#list>
</tbody>
</div>
</@c.page>