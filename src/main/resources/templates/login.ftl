<#import "parts/common.ftl" as c>
<@c.page>
<div class="container">
    <br>
    <br>
    <br>
    <br>
    <div class="row justify-content-center">
    <div class="col-6">

        <form method="post" action="/login">
           <#-- <input name="${_csrf.parameterName}" value="${_csrf.token}" type="hidden">-->
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Введите имя пользователя" name="username">
            </div>

            <div class="form-group">
                <input type="password" class="form-control" placeholder="Введите пароль" name="password">
            </div>

            <div class="form-group">
                <button type="submit" class="btn btn-dark btn-block" value="Login">Войти</button>
            </div>
        </form>

    </div>
</div>
</div>
</@c.page>
