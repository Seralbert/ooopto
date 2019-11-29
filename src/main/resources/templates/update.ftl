<#import "parts/common.ftl" as c>
<@c.page>

<div class="container">

    <form class="findform" action="/update" method="post">
        <div class="form-row">
            <div class="form-group col-md-12">
                <label style="color: azure">Наименование отдела</label>
                <select id="rp" name = "rp" class="form-control">
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
            <div class="form-group col-md-4">
                <label class="label-form">Номер документа</label>
                <input type="text" class="form-control" id="docNumber" name="docNumber" placeholder="Номер документа" value = "${docNumber}">
            </div>
            <div class="form-group col-md-4">
                <label style="color: azure">Дата документа</label>
                <input type="date" class="form-control" id="docDate" name="docDate" value="${docDate}">

            </div>
            <div class="form-group col-md-2">
                <label style="color: azure">Количество листов</label>
                <input type="text" class="form-control" id="numList" name="numList" placeholder="1" value="1" value = "${numList}">
            </div>
            <div class="form-group col-md-2">
                <label style="color: azure">Система координат</label>
                <select id="sysCoord" name="sysCoord" class="form-control">
                    <option selected>МСК-22</option>
                    <option>МСК-53</option>
                </select>
            </div>

        </div>
        <div class="form-row">
            <div class="form-group col-md-12">
                <label style="color: azure">Наименование документа</label>
                <input type="text" class="form-control" id="docName" name="docName" value = "${docName}">
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-12">
                <label style="color: azure">Разработчик документа</label>
                <input type="text" class="form-control" id="docAuthor" name="docAuthor" value = "${docAuthor}">
            </div>
        </div>

        <div class="form-row justify-content-md-end">
            <a data-toggle="modal" data-target="#modalFrame" class="col-md-2 btn btn-success btn-block"><span class="oi oi-plus">&nbsp Добавить</span></a>
        </div>

        <br>
        <div class="form-row">
            <div class="form-group col-md-12">

                <table class="table table-sm">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Имя файла</th>
                        <th scope="col">#</th>
                        <th scope="col">#</th>
                    </tr>
                    </thead>
                    <tbody>
                        <#list listAppendDoc as doc>
                        <tr>
                            <th scope="row">1</th>
                            <td>${doc.description}</td>
                            <td><span class="oi oi-dial"></span></td>
                            <td><span class="oi oi-x">${doc.id}</span></td>
                        </tr>
                        <#else>
                        <tr><td>Нет образов</td></tr>
                        </#list>


                    </tbody>
                </table>
            </div>
            <div class="form-group ">

            </div>
        </div>

        <div class="form-row justify-content-md-end">
            <button type="submit" class="col-md-2 btn btn-primary pull-right"><span class="oi oi-check"></span>&nbsp Сохранить</button>
        </div>
        <div class="form-row">
            <input type="text" name="docID" value="${docID}">
        </div>
    </form>
    <#include "parts/modal.ftl">
</div>

</@c.page>