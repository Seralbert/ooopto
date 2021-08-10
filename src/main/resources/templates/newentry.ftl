<#import "parts/common.ftl" as c>
<@c.page>

<div class="container">

    <form class="findform" enctype="multipart/form-data" action="/addNewRecord" method="post">
        <div class="form-row">
            <div class="form-group col-md-12 form-slim">
                <label style="color: azure" class="label-form col-form-label-sm">Фондодержатель, организация субъекта Российской Федерации</label>
                <select id="orgInfo" name="orgInfo" class="form-control form-control-sm">
                    <option selected>Великий Новгород</option>
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
            <div class="form-group col-md-2 form-slim">
                <label class="label-form col-form-label-sm label-slim">Тип документа</label>
                <select id="docType" name="docType" class="form-control form-control-sm">
                    <!--option>Debug</option-->
                    <#list voc as item>
                        <option>${item}</option>
                    </#list>
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
                <label class="label-form col-form-label-sm label-slim">Год создания документа</label>
                <input type="text" class="form-control form-control-sm " id="docCreate" name="docCreate" value="0">
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
                <input type="text" class="form-control form-control-sm" id="pageCount" name="pageCount" placeholder="0" value="0">
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
                <select id="objPrice" name="objPrice" class="form-control form-control-sm">
                    <option selected>Типовой</option>
                    <option>Ценный</option>
                    <option>Особо ценный</option>
                </select>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-12 form-slim">
                <label class="label-form col-form-label-sm label-slim">Комментарий</label>
                <input type="text" class="form-control form-control-sm" id="docComment" name="docComment">
            </div>
        </div>



        <div class="form-row">
            <div class="form-group col-md-4 form-slim">
                <label class="label-form col-form-label-sm label-slim">Комментарий</label>

                <input type="text" class="form-control form-control-sm">
            </div>

            <div class="form-group col-md-4 form-slim">
                <label class="label-form col-form-label-sm label-slim">Предыдущее место</label>

                <input type="text" class="form-control form-control-sm">
            </div>

            <div class="form-group col-md-4 form-slim">
                <label class="label-form col-form-label-sm label-slim">Сотрудник фонда</label>

                <input type="text" class="form-control form-control-sm">
            </div>
        </div>



        <div class="form-row justify-content-md-end btn-spaced">

            <button type="submit" class="col-md-2 btn btn-primary pull-right"><span class="oi oi-check"></span>&nbsp
                Создать
            </button>
        </div>

    </form>

</div>

</@c.page>