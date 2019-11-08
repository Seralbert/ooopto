<#import "parts/common.ftl" as c>
<@c.page>
<div class="container">
    <table class="table table-sm table-dark">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Номер документа</th>
            <th scope="col">Дата документа</th>
            <th scope="col">Название документа</th>
            <th scope="col">Отдел </th>
            <th scope="col">Разработчик </th>
        </tr>
        </thead>

        <tbody>
            <#list docs as doc>
            <tr>
                <td>
                ${doc.id}
                </td>
                <td>
                ${doc.numDoc}
                </td>
                <td>
                ${doc.dateDoc}
                </td>
                <td>
                ${doc.nameDoc}
                </td>
                <td>
                ${doc.nameTO}
                </td>
                <td>
                ${doc.authorDoc}
                </td>
            </tr>
            <#else>
            <tr>
                <td>
                    Нет документов
                </td>
            </tr>
            </#list>

        </tbody>
    </table>

    <a class="btn btn-danger" href="/gen">Generate!</a>
</div>
</@c.page>