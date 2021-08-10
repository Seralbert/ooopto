<#import "parts/common.ftl" as c>
<@c.page>
<div class="container">
    <table class="table table-sm table-dark" style="background-color: rgba(0,0,0, 0.75);">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Login</th>
            <th scope="col">ФИО</th>
            <th scope="col">#</th>
            <th scope="col">#</th>
        </tr>
        </thead>

        <tbody>
            <#list userlist as usr>
            <tr>
                <td>
                ${usr.id}
                </td>
                <td>
                ${usr.username}
                </td>
                <td>
                ${usr.fio}
                </td>
                <td>
                    <a href ="/edituser/#{usr.id}">
                        <span class="oi oi-pencil"></span>
                    </a>
                </td>
                <td>
                    <a href ="/deleteuser/#{usr.id}">
                        <span class="oi oi-x"></span>
                    </a>
                </td>
            </tr>
            </#list>

        </tbody>
    </table>

    <a class="btn btn-danger" href="/adduser">Создать нового пользователя</a>
</div>
</@c.page>