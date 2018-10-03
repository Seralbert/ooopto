<#import "parts/common.ftl" as c>
<@c.page>
<br />
<div>

    <table class="table">
        <thead>
        <tr>
            <th>Имя пользователя</th>
            <th>Роль</th>
        </tr>
        </thead>

        <tbody>
            <#list users as user>
            <tr>
                <td>
                ${user.username}
                </td>
                <td>
                    USER
                </td>
            </tr>
            <#else>
            <tr>
                <td>
                    Нет пользователей
                </td>
            </tr>
            </#list>
        </tbody>
    </table>
</div>
</@c.page>