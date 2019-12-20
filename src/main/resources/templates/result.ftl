<#import "parts/common_joke.ftl" as c>
<@c.page>
<div class="container">
    <table class="table table-sm table-dark" style="background-color: rgba(0,0,0, 0.75);">
        <thead>
        <tr>

            <th scope="col">Номер документа</th>
            <th scope="col">Дата документа</th>
            <th scope="col">Название документа</th>
            <th scope="col">Отдел </th>
            <th scope="col">Разработчик </th>
            <th scope="col">#</th>
        </tr>
        </thead>

        <tbody>
            <#list docs as doc>
            <tr>
                <td>
                ${doc.numDoc}
                </td>
                <td>
                ${doc.dateDoc?string("dd.MM.yyyy")}
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

                <td>
                    <a href ="/edit/${doc.id}">
                        <span class="oi oi-pencil"></span>
                    </a>
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
</div>
</@c.page>
