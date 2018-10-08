<form method="post" action="/addDoc" enctype="multipart/form-data">
    <input name="${_csrf.parameterName}" value="${_csrf.token}" type="hidden">
    <div class="input-group">
        <input class="form-control" type="text" name="caption" placeholder="Введите описание" />
    </div>
    <nav class="navbar navbar-light bg-light ">
        <span class="navbar-text">Добавить документ</span>

    <div class="input-group">
        <input class="form-control mr-sm-2" type="file" name="file" id="docFile"  />
        <button type="submit" class="btn btn-primary pull-right my-2  my-sm-0">Опубликовать</button>
    </div>

</nav>
</form>