<#import "parts/common.ftl" as c>
<@c.page>

<div class="container">

    <form class="findform" enctype="multipart/form-data" action="/addNew" method="post">
        <div class="form-row">
            <div class="form-group col-md-12 form-slim">
                <label style="color: azure" class="label-form col-form-label-sm">Фондодержатель, организация субъекта Российской Федерации</label>
                <select id="orgInfo" name="orgInfo" class="form-control form-control-sm">
                    <option selected>Великий Новгород</option>
                    <option>Батецкий межмуниципальный отдел</option>
                    <option>Боровический межмуниципальный отдел</option>
                    <option>Валдайский межмуниципальный отдел</option>
                    <option>Демянский межмуниципальный отдел</option>
                    <option>Крестецкий межмуниципальный отдел</option>
                    <option>Маловишерский межмуниципальный отдел</option>
                    <option>Окуловский межмуниципальный отдел</option>
                    <option>Парфинский межмуниципальный отдел</option>
                    <option>Солецкий межмуниципальный отдел</option>
                    <option>Старорусский межмуниципальный отдел</option>
                    <option>Холмский межмуниципальный отдел</option>
                    <option>Новгородский межмуниципальный отдел</option>
                </select>
            </div>
        </div>


        <div class="form-row">
            <div class="form-group col-md-2 form-slim">
                <label class="label-form col-form-label-sm label-slim">Тип документа</label>
                <select id="docType" name="docType" class="form-control form-control-sm">
                    <option selected>1.1.1.1</option>
                    <option>1.1.1.2</option>
                    <option>1.1.1.3</option>
                    <option>1.1.1.4</option>
                    <option>1.1.1.5</option>
                    <option>1.1.1.6</option>
                    <option>1.1.1.7</option>
                </select>
            </div>

            <div class="form-group col-md-3 form-slim">
                <label class="label-form col-form-label-sm label-slim">Инвентарный номер</label>
                <input type="text" class="form-control form-control-sm" id="docInvNumber" name="docInvNumber" placeholder="Инвентарный номер">
            </div>
            <div class="form-group col-md-3 form-slim">
                <label class="label-form col-form-label-sm label-slim">Кадастровый номер</label>
                <input type="text" class="form-control form-control-sm" id="docKadastrNumber" name="docKadastrNumber" placeholder="Кадастровый номер">
            </div>

            <div class="form-group col-md-2 form-slim">
                <label class="label-form col-form-label-sm label-slim">Дата документа</label>
                <input type="date" class="form-control form-control-sm " id="docCreate" name="docCreate">
            </div>

            <div class="form-group col-md-2 form-slim">
                <label class="label-form col-form-label-sm label-slim">Передано в фонд</label>
                <input type="date" class="form-control form-control-sm " id="docTransfer" name="docTransfer">
            </div>

            <div class="form-group col-md-3 form-slim">
                <label class="label-form col-form-label-sm label-slim">Режимные ограничения</label>
                <select id="docAccessType" name="docAccessType" class="form-control form-control-sm">
                    <option selected>Открытые</option>
                    <option>ДСП</option>
                </select>
            </div>
            <div class="form-group col-md-2 form-slim">
                <label class="label-form col-form-label-sm label-slim">Количество листов</label>
                <input type="text" class="form-control form-control-sm" id="pageCount" name="pageCount" placeholder="1" value="1">
            </div>
            <div class="form-group col-md-2 form-slim">
                <label class="label-form col-form-label-sm label-slim">Система координат</label>
                <select id="sysCoord" name="sysCoord" class="form-control form-control-sm">
                    <option selected>МСК-53</option>
                    <option>МСК-53</option>
                </select>
            </div>

            <div class="form-group col-md-2 form-slim">
                <label class="label-form col-form-label-sm label-slim">Масштаб</label>
                <input type="text" class="form-control form-control-sm" id="scale" name="scale">
            </div>

            <div class="form-group col-md-3 form-slim">
                <label class="label-form col-form-label-sm label-slim">Площадь</label>
                <input type="text" class="form-control form-control-sm" id="objArea" name="objArea">
            </div>

        </div>
        <div class="form-row">
            <div class="form-group col-md-12 form-slim">
                <label class="label-form col-form-label-sm label-slim">Наименование документа</label>
                <input type="text" class="form-control form-control-sm" id="docName" name="docName">
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-12 form-slim">
                <label class="label-form col-form-label-sm label-slim">Наименование объекта</label>
                <input type="text" class="form-control form-control-sm" id="objName" name="objName">
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-9 form-slim">
                <label class="label-form col-form-label-sm label-slim">Разработчик документа</label>
                <input type="text" class="form-control form-control-sm" id="docAuthor" name="docAuthor">
            </div>

            <div class="form-group col-md-3 form-slim">
                <label class="label-form col-form-label-sm label-slim">Ценность</label>
                <input type="text" class="form-control form-control-sm" id="objPrice" name="objPrice">
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-12 form-slim">
                <label class="label-form col-form-label-sm label-slim">Комментарий</label>
                <input type="text" class="form-control form-control-sm" id="docComment" name="docComment">
            </div>
        </div>

        <div class="form-row justify-content-md-end btn-spaced">

            <button type="submit" class="col-md-2 btn btn-primary pull-right"><span class="oi oi-magnifying-glass"></span>&nbsp Поиск</button>
        </div>

    </form>
</div>

</@c.page>