<#import "parts/common.ftl" as c>
<@c.page>
<br/>
<div>

    <table class="table">
        <thead>
        <tr>
            <th>Имя пользователя</th>
            <th>Роль</th>
            <th>Аккаунт просрочен</th>
            <th>Права просрочены</th>
            <th>Заблокирован</th>
            <th>Активирован</th>


        </tr>
        </thead>
        <tbody>
            <#list users as user>
            <tr>
                <td>
                ${user.username}
                </td>
                <td>
                    <#list user.authorities as role>${role}<#sep>, </#list>
                </td>
                <td>
                    <#if !user.accountNonExpired??>TRUE<#else>FALSE</#if>
                </td>
                <td>
                    <#if !user.accountNonExpired??>TRUE<#else>FALSE</#if>
                </td>
                <td>
                    <#if !user.accountNonExpired??>TRUE<#else>FALSE</#if>
                </td>
                <td>
                    <#if user.enabled??>TRUE
                    <#else>FALSE
                    </#if>
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