<form method="post" action="/addDoc" enctype="multipart/form-data">
    <input name="${_csrf.parameterName}" value="${_csrf.token}" type="hidden">
    <div class="input-group">
        <input class="form-control" type="text" name="caption" placeholder="Введите описание" />
    </div>
<br>
    <div class="text">
        <h5>Добавить документ</h5>
    </div>

    <div class="form-group">
        <input class="form-control mr-sm-2" type="file" name="file" id="docFile"  />
    </div>

    <div class="form-group">
        <button type="submit" class="btn btn-dark btn-block">Опубликовать</button>
    </div>

</nav>
</form>