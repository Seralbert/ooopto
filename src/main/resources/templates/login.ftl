<#import "parts/common.ftl" as c>
<@c.page>
    <div class="card">
        <form method="post" action="/login">
            <input name="${_csrf.parameterName}" value="${_csrf.token}" type="hidden">
            <div class="input group">
            <input type="text" placeholder="Имя пользователя" name="username">
            </div>
            <div class="input group">
            <input type="password" name="password">
            </div>
            <button class="button" type="submit">Войти</button>
        </form>
    </div>

</@c.page>