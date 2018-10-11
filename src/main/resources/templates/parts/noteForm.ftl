<div class="form-group mt-3">
    <form method="post" enctype="multipart/form-data" action="/add">
        <input name="${_csrf.parameterName}" value="${_csrf.token}" type="hidden">
        <div class="form-group ">
            <input type="text" class="form-control" name="textCaption" placeholder="Введите заголовок"/>
        </div>
        <div class="form-group">
            <textarea style="margin-top: 5px" class="form-control" id="formControlTextarea" rows="3" name="textMain"
                      placeholder="Введите основной текст"></textarea>
        </div>
        <div>
            <h5>
                Добавить фото
            </h5>
        </div>

        <div class="form-group">
            <input class="form-control mr-sm-2" type="file" name="file" id="imgFile" accept="image/*"/>

        </div>
        <div>
            <h5>
                Прикрепить файл
            </h5>
        </div>
        <div class="form-group">
            <input class="form-control mr-sm-2" type="file" name="fileDoc" id="docFile"/>
        </div>

        <div class="form-group">
            <button type="submit" class="btn btn-dark btn-block">Опубликовать</button>
        </div>
    </form>
</div>
