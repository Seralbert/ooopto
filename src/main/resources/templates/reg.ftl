<#import "parts/common.ftl" as c>
<@c.page>
<br/>

<form class="col-6 sm-6" method="post" action="/reg">
    <input name="${_csrf.parameterName}" value="${_csrf.token}" type="hidden">
    <div class="form-group">
        <input type="text" class="form-control" placeholder="Введите имя пользователя" name="username">
    </div>
    <div class="form-group">
         <input type="password" class="form-control" placeholder="Введите пароль" name="password">
    </div>
    <div class="form-group">
    <button type="submit" class="btn btn-primary btn-block">Зарегистрироваться</button>
    </div>
</form>
</@c.page>