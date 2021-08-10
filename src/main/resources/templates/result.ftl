<#import "parts/common.ftl" as c>
<#import "parts/pager.ftl" as p>
<@c.page>
<div class="container">
    <div class="h3 findform">
        ${header}
    </div>
    <@p.pager url page />
    <table class="table table-sm table-dark" style="background-color: rgba(0,0,0, 0.75);">
        <thead>
        <tr>
            <th  scope="col">Инвентарный номер</th>
            <th  scope="col">Год создания</th>
            <th  scope="col">Название документа</th>
            <th  scope="col">Список файлов </th>
            <th  scope="col">#</th>
            <th scope="col">#</th>
        </tr>
        </thead>

        <tbody>
            <#list page.content as doc>
            <tr>
                <td>
                <#if doc.docType != "">
                    <div class="green">
                <#else>
                    <div class="red">
                </#if>
                ${doc.docInvNumber}
                </div>

                </td>
                <td>
                ${doc.docCreate}
                </td>
                <td>
                ${doc.docName}
                </td>
                <td>
                <#list doc.listDoc as img>
                    <a href="/docs/${img.orgName}/${doc.docInvNumber}/${img.filePath}" target="_blank">
                    ${img.filePath}
                    </a><br>
                </#list>
                </td>

                <td>
                    <a href ="/edit/#{doc.id}" target="_blank">
                        <span class="oi oi-pencil"></span>
                    </a>
                </td>
                <td>
                    <a href ="/delete/#{doc.id}">
                        <span class="oi oi-x red"></span>
                    </a>
                </td>

            </tr>
            <#else>
            <tr>
                <td>
                    <div class="justify-content-center text-center">
                    <a class="btn btn-primary btn-sm" href="/fillRequest">Сформировать запрос</a>&nbsp;&nbsp;&nbsp;&nbsp;Нет документов
                    </div>
                </td>
            </tr>
                </#list>

        </tbody>
    </table>
</div>
</@c.page>