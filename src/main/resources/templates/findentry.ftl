<#import "parts/common.ftl" as c>
<@c.page>

<div class="container">

    <form class="findform" action="/doFind" method="post">

        <div class="form-row">
            <div class="form-group col-md-12  form-slim">
                <label style="color: azure" class="label-form col-form-label-sm">Наименование отдела</label>
                <select id="orgInfo" name="orgInfo" class="form-control form-control-sm">
                    <option selected>---ВСЕ---</option>
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
<br>
        <div class="form-row">

            <div class="form-group col-md-3 form-slim">
                <label class="label-form col-form-label-sm label-slim">Инвентарный номер</label>
                <input type="text" class="form-control form-control-sm" id="docInvNumber" name="docInvNumber"
                       placeholder="Инвентарный номер" value=${docInvNumber!}>
            </div>
            <div class="form-group col-md-3 form-slim">
                <label class="label-form col-form-label-sm label-slim">Кадастровый номер</label>
                <input type="text" class="form-control form-control-sm" id="docKadastrNumber" name="docKadastrNumber"
                       placeholder="Кадастровый номер" value=${docKadastrNumber!}>
            </div>

            <div class="form-group col-md-3 form-slim">
                <label class="label-form col-form-label-sm label-slim">Тип документа</label>
                <select id="docType" name="docType" class="form-control form-control-sm">
                    <option selected>---ВСЕ---</option>

                        <#list voc as item>
                            <option>${item}</option>
                        </#list>
                </select>
            </div>

            <div class="form-group col-md-3 form-slim">
                <label class="label-form col-form-label-sm label-slim">Режимные ограничения</label>
                <select id="docAccessType" name="docAccessType" class="form-control form-control-sm">
                    <option>Открытые</option>
                    <option>ДСП</option>
                </select>
            </div>

        </div>
<br>
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
            <div class="form-group col-md-12 form-slim">
                <label class="label-form col-form-label-sm label-slim">Разработчик документа</label>
                <input type="text" class="form-control form-control-sm" id="docAuthor" name="docAuthor">
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-12 form-slim">
                <label class="label-form col-form-label-sm label-slim">Комментарий</label>
                <input type="text" class="form-control form-control-sm" id="docComment" name="docComment">
            </div>
        </div>

        <br>
        <div class="form-row">
            <div class="col-sm-3">
                <label class="label-form col-form-label-sm label-slim">Документ создан с</label>
                <input type="text" class="form-control form-control-sm" id="docCreateB" name="docCreateB"
                    >
            </div>
            <div class="col-sm-3">
                <label class="label-form col-form-label-sm label-slim">по</label>
                <input type="text" class="form-control form-control-sm" id="docCreateE" name="docCreateE"
                    >
            </div>

            <div class="col-sm-3">
                <label class="label-form col-form-label-sm label-slim">Передача в фонд с</label>
                <input type="date" class="form-control form-control-sm" id="docTransferB" name="docTransferB"
                    >
            </div>
            <div class="col-sm-3">
                <label class="label-form col-form-label-sm label-slim">по</label>
                <input type="date" class="form-control form-control-sm" id="docTransferE" name="docTransferE">
            </div>
        </div>

        <div class="form-row">
            <div class="col">
                <label class="label-form col-form-label-sm label-slim">Площадь от</label>
                <input type="text" class="form-control form-control-sm" id="scaleB" name="scaleB">
            </div>
            <div class="col">
                <label class="label-form col-form-label-sm label-slim">до</label>
                <input type="text" class="form-control form-control-sm" id="scaleE" name="scaleE">
            </div>

            <div class="col">
                <label class="label-form col-form-label-sm label-slim">Ценность от</label>
                <select id="objPrice" name="objPrice" class="form-control form-control-sm">
                    <option selected>---ВСЕ---</option>
                    <option>Типовой</option>
                    <option>Ценный</option>
                    <option>Особо ценный</option>
                </select>
            </div>
        </div>


                <br>
        <div class="form-row justify-content-md-end">
            <button type="submit" class="col-md-2 btn btn-primary pull-right"><span
                    class="oi oi-magnifying-glass"></span>&nbsp Поиск
            </button>
        </div>

    </form>

</div>
</@c.page>