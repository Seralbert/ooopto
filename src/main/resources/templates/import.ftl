<#import "parts/common.ftl" as c>
<@c.page>
<div class="container">
    <!--

    <div class="h3">Тестовые загрузки</div>

    <table class="table table-sm table-dark" style="background-color: rgba(0,0,0, 0.75);">
        <thead>
        <tr>
            <th scope="col">№</th>
            <th scope="col">Отдел </th>
            <th scope="col">Название книги </th>
            <th scope="col"></th>
        </tr>
        </thead>

        <tbody>
            <tr>
                <td>1</td>
                <td>Маревский отдел</td>
                <td>1-О</td>
                <td><a href="/import091o"> <span class="oi oi-data-transfer-download"></span></a></td>
            </tr>

            <tr>
                <td>2</td>
                <td>Маревский отдел</td>
                <td>2-О</td>
                <td><a href="/import092o"> <span class="oi oi-data-transfer-download"></span></a></td>
            </tr>
            <tr>
                <td>3</td>
                <td>Маревский отдел</td>
                <td>1-ДСП</td>
                <td><a href="/import091d"> <span class="oi oi-data-transfer-download"></span></a></td>
            </tr>
            <tr>
                <td>4</td>
                <td>Батецкий отдел</td>
                <td>1-О</td>
                <td><a href="/import011o"> <span class="oi oi-data-transfer-download"></span></a></td>
            </tr>

            <tr>
                <td>5</td>
                <td>Батецкий отдел</td>
                <td>3-О</td>
                <td><a href="/import013o"> <span class="oi oi-data-transfer-download"></span></a></td>
            </tr>

        </tbody>
    </table>
    -->
    <div class="h3">Загрузка книг</div>
    <form class="findform" action="/importo" method="post">
        <div class="form-row">
            <div class="form-group col-md-12 form-slim">
                <label style="color: azure" class="label-form col-form-label-sm">Фондодержатель, организация субъекта Российской Федерации</label>
                <select id="orgInfo" name="orgInfo" class="form-control form-control-sm">
                    <option>Великий Новгород</option>
                    <option>Новгородский район</option>
                    <option>Батецкий район</option>
                    <option>Боровический район</option>
                    <option>Валдайский район</option>
                    <option>Волотовский район</option>
                    <option>Демянский район</option>
                    <option>Крестецкий район</option>
                    <option>Любытинский район</option>
                    <option>Маловишерский район</option>
                    <option>Маревский район</option>
                    <option>Мошенской район</option>
                    <option>Окуловский район</option>
                    <option>Парфинский район</option>
                    <option>Пестовский район</option>
                    <option>Поддорский район</option>
                    <option>Солецкий район</option>
                    <option>Старорусский район</option>
                    <option>Хвойнинский район</option>
                    <option>Холмский район</option>
                    <option>Чудовский район</option>
                </select>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-12 form-slim">
                <label style="color: azure" class="label-form col-form-label-sm">Имя файла</label>
                <input type="text" class="form-control form-control-sm" id="fileName" name="fileName" placeholder="Введите полный путь к файлу в виде C://3-О01.xls">
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-12 form-slim">
                <label style="color: azure" class="label-form col-form-label-sm">Имя книги</label>
                <input type="text" class="form-control form-control-sm" id="bookName" name="bookName" placeholder="Введите имя книги">
            </div>
        </div>

        <div class="form-row justify-content-md-end btn-spaced">
            <button type="submit" class="col-md-2 btn btn-primary pull-right"><span class="oi oi-data-transfer-download"></span>&nbsp
                Загрузить
            </button>
        </div>


    </form>
<br>
    <div class="h3">Загрузка образов</div>
    <form class="findform" action="/importimg" method="post">
        <div class="form-row">
            <div class="form-group col-md-12 form-slim">
                <label style="color: azure" class="label-form col-form-label-sm">Фондодержатель, организация субъекта Российской Федерации</label>
                <select id="orgInfo" name="orgInfo" class="form-control form-control-sm">
                    <option>Великий Новгород</option>
                    <option>Новгородский район</option>
                    <option>Батецкий район</option>
                    <option>Боровический район</option>
                    <option>Валдайский район</option>
                    <option>Волотовский район</option>
                    <option>Демянский район</option>
                    <option>Крестецкий район</option>
                    <option>Любытинский район</option>
                    <option>Маловишерский район</option>
                    <option>Маревский район</option>
                    <option>Мошенской район</option>
                    <option>Окуловский район</option>
                    <option>Парфинский район</option>
                    <option>Пестовский район</option>
                    <option>Поддорский район</option>
                    <option>Солецкий район</option>
                    <option>Старорусский район</option>
                    <option>Хвойнинский район</option>
                    <option>Холмский район</option>
                    <option>Чудовский район</option>
                </select>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-12 form-slim">
                <label style="color: azure" class="label-form col-form-label-sm">Имя файла</label>
                <input type="text" class="form-control form-control-sm" id="fileName" name="fileName" placeholder="Введите полный путь к файлу в виде C://list.txt">
            </div>
        </div>
<!--
        <div class="form-row">
            <div class="form-group col-md-12 form-slim">
                <label style="color: azure" class="label-form col-form-label-sm">Имя книги</label>
                <input type="text" class="form-control form-control-sm" id="bookName" name="bookName" placeholder="Введите имя книги">
            </div>
        </div>
-->
        <div class="form-row justify-content-md-end btn-spaced">
            <button type="submit" class="col-md-2 btn btn-primary pull-right"><span class="oi oi-data-transfer-download"></span>&nbsp
                Загрузить
            </button>
        </div>


    </form>

</div>
</@c.page>
