<div class="form-group mt-3">
<form method="post" enctype="multipart/form-data" action="/add">
    <input name="${_csrf.parameterName}" value="${_csrf.token}" type="hidden">
    <div class="input-group ">
        <input type="text" class="form-control" name="textCaption" placeholder="Введите заголовок" />
    </div>
    <div class="input-group">
    <textarea style="margin-top: 5px" class="form-control" id="formControlTextarea" rows="3" name="textMain" placeholder="Введите основной текст"></textarea>
    </div>
    <nav class="navbar navbar-light bg-light">
        <span class="navbar-text">Добавить фото</span>
        <div class="input-group">
        <input class="form-control mr-sm-2" type="file" name="file" id="imgFile" accept="image/*" />
        <button type="submit" class="btn btn-primary pull-right my-2  my-sm-0">Опубликовать</button>
        </div>
    </nav>

    <nav class="navbar navbar-light bg-light">
        <span class="navbar-text">Прикрепить файл</span>
        <input class="form-control mr-sm-2" type="file" name="fileDoc" id="docFile" />

    </nav>
</form>
</div>
