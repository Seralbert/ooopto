<#import "parts/common.ftl" as c>
<@c.page>

<div class="container">

    <form class="findform" enctype="multipart/form-data" action="/editRecord/#{id}" method="post">
        <div class="form-row">
            <div class="form-group col-md-12 form-slim">
                <label style="color: azure" class="label-form col-form-label-sm">Фондодержатель, организация субъекта
                    Российской Федерации</label>
                <select id="orgInfo" name="orgInfo" class="form-control form-control-sm">
                    <option selected>${orgInfo}</option>
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
            <div class="form-group col-md-2 form-slim">
                <label class="label-form col-form-label-sm label-slim">Тип документа</label>
                <select id="docType" name="docType" class="form-control form-control-sm">

                    <option selected>${docType}</option>

                    <#list voc as item>
                        <option>${item}</option>
                    </#list>
                </select>
            </div>

            <div class="form-group col-md-3 form-slim">
                <label class="label-form col-form-label-sm label-slim">Инвентарный номер</label>
                <input type="text" class="form-control form-control-sm" id="docInvNumber" name="docInvNumber"
                       placeholder="Инвентарный номер" value="${docInvNumber}">
            </div>
            <div class="form-group col-md-3 form-slim">
                <label class="label-form col-form-label-sm label-slim">Кадастровый номер</label>
                <input type="text" class="form-control form-control-sm" id="docKadastrNumber" name="docKadastrNumber"
                       placeholder="Кадастровый номер" value="${docKadastrNumber}">
            </div>

            <div class="form-group col-md-2 form-slim">
                <label class="label-form col-form-label-sm label-slim">Год создания документа</label>
                <input type="text" class="form-control form-control-sm " id="docCreate" name="docCreate"
                       value="#{docCreate}">
            </div>

            <div class="form-group col-md-2 form-slim">
                <label class="label-form col-form-label-sm label-slim">Передано в фонд</label>
                <input type="date" class="form-control form-control-sm " id="docTransfer" name="docTransfer"
                       value="${docTransfer}">
            </div>

            <div class="form-group col-md-3 form-slim">
                <label class="label-form col-form-label-sm label-slim">Режимные ограничения</label>
                <select id="docAccessType" name="docAccessType" class="form-control form-control-sm">
                    <option selected>${docAccessType}</option>
                    <option>Открытые</option>
                    <option>ДСП</option>
                </select>
            </div>
            <div class="form-group col-md-2 form-slim">
                <label class="label-form col-form-label-sm label-slim">Количество листов</label>
                <input type="text" class="form-control form-control-sm" id="pageCount" name="pageCount"
                       value=#{pageCount}>
            </div>
            <div class="form-group col-md-2 form-slim">
                <label class="label-form col-form-label-sm label-slim">Система координат</label>
                <select id="sysCoord" name="sysCoord" class="form-control form-control-sm">
                    <option selected>${sysCoord}</option>
                    <option>МСК-53</option>
                    <option>МСК-53</option>
                </select>
            </div>

            <div class="form-group col-md-2 form-slim">
                <label class="label-form col-form-label-sm label-slim">Масштаб</label>
                <input type="text" class="form-control form-control-sm" id="scale" name="scale" value="${scale}">
            </div>

            <div class="form-group col-md-3 form-slim">
                <label class="label-form col-form-label-sm label-slim">Площадь</label>
                <input type="text" class="form-control form-control-sm" id="objArea" name="objArea" value=#{objArea}>
            </div>

        </div>
    <#--<div class="form-row">
        <div class="form-group col-md-12 form-slim">
            <label class="label-form col-form-label-sm label-slim">Наименование документа</label>
            <input type="text" class="form-control form-control-sm" id="docName" name="docName" value="${docName}">
        </div>
    </div>-->

        <div class="form-row">
            <div class="form-group col-md-12 form-slim">
                <label class="label-form col-form-label-sm label-slim">Наименование документа</label>
                <textarea type="text" rows="4" class="form-control form-control-sm" id="docName" name="docName"
                          value="${docName}">${docName}
                </textarea>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-12 form-slim">
                <label class="label-form col-form-label-sm label-slim">Наименование объекта</label>
                <input type="text" class="form-control form-control-sm" id="objName" name="objName"
                       value="${objName}">
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-9 form-slim">
                <label class="label-form col-form-label-sm label-slim">Разработчик документа</label>
                <input type="text" class="form-control form-control-sm" id="docAuthor" name="docAuthor"
                       value="${docAuthor}">
            </div>

            <div class="form-group col-md-3 form-slim">
                <label class="label-form col-form-label-sm label-slim">Ценность</label>
                <select id="objPrice" name="objPrice" class="form-control form-control-sm">
                    <option selected>${objPrice}</option>
                    <option>Типовой</option>
                    <option>Ценный</option>
                    <option>Особо ценный</option>
                </select>
            </div>
        </div>

        <#--<div class="form-row">
            <div class="form-group col-md-12 form-slim">
                <label class="label-form col-form-label-sm label-slim">Комментарий</label>
                <input type="text" class="form-control form-control-sm" id="docComment" name="docComment"
                       value="${docComment}">
            </div>
        </div>-->


        <div class="form-row">
            <div class="form-group col-md-4 form-slim">
                <label class="label-form col-form-label-sm label-slim">Комментарий</label>

            <input type="text" class="form-control form-control-sm" id="docComment" name="docComment"
                   value="${docComment}">
            </div>

            <div class="form-group col-md-4 form-slim">
                <label class="label-form col-form-label-sm label-slim">Предыдущее место</label>

            <input type="text" class="form-control form-control-sm" id="docPlace" name="docPlace" value="${docPlace!}">
            </div>

            <div class="form-group col-md-4 form-slim">
                <label class="label-form col-form-label-sm label-slim">Сотрудник фонда</label>

            <input type="text" class="form-control form-control-sm" id="fondEmpl" name="fondEmpl" value="${fondEmpl!}" >
            </div>
        </div>



        <br>
        <div class="form-row justify-content-md-end">
            <a data-toggle="modal" data-target="#modalFrame" class="col-md-2 btn btn-success btn-block"><span
                    class="oi oi-plus">&nbsp Добавить</span></a>
        </div>

        <br>
        <div class="form-row">
            <div class="form-group col-md-12">

                <table class="table table-sm">
                    <thead>
                    <tr>
                        <th scope="col">Имя файла</th>
                        <th scope="col">Описание</th>
                        <th scope="col">#</th>
                        <th scope="col">#</th>
                    </tr>
                    </thead>
                    <tbody>
                        <#list listAppendDoc as doc>
                        <tr>
                            <th scope="row">${doc.filePath}</th>
                            <td>${doc.description}</td>
                            <td><a href="/docs/${doc.orgName}/${docInvNumber}/${doc.filePath}" target="_blank"> <span
                                    class="oi oi-dial"></span></a></td>
                            <td><a href="/editRecord/#{id}/delAddDoc/${doc.uuidFile}"><span class="oi oi-x red"></span></a>
                            </td>
                        </tr>
                        <#else>
                        <tr>
                            <td>Нет образов</td>
                        </tr>
                        </#list>


                    </tbody>
                </table>
            </div>
        </div>
        <div class="form-row justify-content-md-end btn-spaced">
            <button type="submit" class="col-md-2 btn btn-primary pull-right"><span class="oi oi-check"></span>&nbsp
                Сохранить
            </button>
        </div>
    </form>
    <#include "parts/modal.ftl">
</div>

</@c.page>