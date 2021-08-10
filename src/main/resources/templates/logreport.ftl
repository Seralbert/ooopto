<#import "parts/common.ftl" as c>
<@c.page>
<div class="container">
    <table class="table table-sm table-dark" style="background-color: rgba(0,0,0, 0.75);">
        <thead>
        <tr>

            <th  scope="col">#</th>
            <th  scope="col">Запись</th>
            <th  scope="col">Образ</th>
            <th  scope="col">Исполнитель</th>
            <th  scope="col">Действие</th>
        </tr>
        </thead>

        <tbody>
            <#list list as line>
            <tr>

                <td>${line.actionDate!}</td>
                <td>${line.nameRecord!}</td>
                <td>${line.nameAppendDoc!}</td>
                <td>${line.nameAction!}</td>
                <td>${line.userName!}</td>
            </tr>
            <#else>
            <tr>
                <td>
                    Нет записей
                </td>
            </tr>
            </#list>

        </tbody>
    </table>
</div>
</@c.page>