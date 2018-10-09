<#import "parts/common.ftl" as c>
<@c.page>
<br/>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-4">

            <form method="post" action="/updateUser">
                <input name="${_csrf.parameterName}" value="${_csrf.token}" type="hidden">
                <input name="userId" value="${user.id}" type="hidden">
                <div class="form-group">
                    <input type="text" class="form-control" disabled value="${user.username}" name="username">
                </div>

                <div class="form-group">
                    <input type="password" class="form-control" value="" name="password">
                </div>

                <div class="form-group">

                    <#list roles as role>
                        <div>
                            <label><input type="checkbox" name="${role}"  ${user.authorities?seq_contains(role)?string("checked", "")}/>${role}</label>


                        </div>
                    </#list>

                </div>

                <div class="form-group">
                    <button type="submit" class="btn btn-dark btn-block">Обновить</button>
                </div>
            </form>

        </div>
    </div>
</div>
</@c.page>