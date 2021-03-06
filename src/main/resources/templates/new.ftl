<#import "parts/common_joke.ftl" as c>
<@c.page>

<div class="container">

    <form class="findform" enctype="multipart/form-data" action="/addNew" method="post">
        <div class="form-row">
            <div class="form-group col-md-12">
                <label style="color: azure">Наименование отдела</label>
                <select id="rp" name="rp" class="form-control">
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
                <input type="text" class="form-control" id="docNumber" name="docNumber" placeholder="Номер документа">
            </div>
            <div class="form-group col-md-4">
                <label style="color: azure">Дата документа</label>
                <input type="date" class="form-control " id="docDate" name="docDate">
            </div>
            <div class="form-group col-md-2">
                <label style="color: azure">Количество листов</label>
                <input type="text" class="form-control" id="numList" name="numList" placeholder="1" value="1">
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
                <input type="text" class="form-control" id="docName" name="docName">
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-12">
                <label style="color: azure">Разработчик документа</label>
                <input type="text" class="form-control" id="docAuthor" name="docAuthor">
            </div>
        </div>

        <div class="form-row justify-content-md-end">

            <button type="submit" class="col-md-2 btn btn-primary pull-right"><span class="oi oi-check"></span>&nbsp
                Создать
            </button>
        </div>

    </form>
    <#include "parts/modal.ftl">
</div>

</@c.page>