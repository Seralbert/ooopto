<#import "parts/common.ftl" as c>

<@c.page>
<div class="container">

    <table class="table table-sm table-dark" style="background-color: rgba(0,0,0, 0.75);">
        <thead>
        <tr>
            <th  scope="col">ФИО</th>
            <th  scope="col">Кадастровый номер</th>
            <th  scope="col">Инвентарый номер</th>
            <th scope="col">Наименование</th>
            <th scope="col">#</th>
        </tr>
        </thead>
        <tbody>
            <#list list as r>
            <tr>
                <td>${r.userName}</td>
                <td>${r.kadNumber}</td>
                <td>${r.docNumber}</td>
                <td>${r.docName}</td>
                <td><a href="/deleteReq/#{r.id}">x</a> </td>
            </tr>
            </#list>
        </tbody>
</div>
</@c.page>