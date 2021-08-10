<#import "parts/common.ftl" as c>
<@c.page>
<div class="container">
    <br>
    <br>
    <br>
    <br>
    <div class="row justify-content-center">
        <div class="col-6">

            <form method="post" action="/adduser">
            <#-- <input name="${_csrf.parameterName}" value="${_csrf.token}" type="hidden">-->
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Фамилия Имя Отчество" name="fio">
                </div>

                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Введите имя пользователя" name="username">
                </div>

                <div class="form-group">
                    <input type="password" class="form-control" placeholder="Введите пароль" name="password">
                </div>

                <div class="form-group">
                    <select id="role" name="role" class="form-control">
                        <option selected>Просмотр</option>
                        <option>Редактор</option>
                        <option>Администратор</option>
                    </select>
                </div>


                <div class="form-group">
                    <button type="submit" class="btn btn-dark btn-block" value="Login">Создать</button>
                </div>
            </form>

        </div>
    </div>
</div>
</@c.page>