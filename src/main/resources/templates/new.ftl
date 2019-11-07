<#import "parts/common.ftl" as c>
<@c.page>

    <#include "parts/navbar.ftl">
<br>
<div class="container">

    <form class="findform">
        <div class="form-row">
            <div class="form-group col-md-12">
                <label style="color: azure">Наименование отдела</label>
                <select id="rp" class="form-control">
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
                <label style="color: azure">Номер документа</label>
                <input type="text" class="form-control" id="docNumber" placeholder="Номер документа">
            </div>
            <div class="form-group col-md-4">
                <label style="color: azure">Дата документа</label>
                <input type="date" class="form-control" id="docDate" placeholder="01.01.2000">
            </div>
            <div class="form-group col-md-2">
            <label style="color: azure">Количество листов</label>
            <input type="text" class="form-control" id="inputAddress" placeholder="1">
            </div>
            <div class="form-group col-md-2">
                <label style="color: azure">Система координат</label>
                <select id="sysCoord" class="form-control">
                    <option selected>МСК-22</option>
                    <option>...</option>
                </select>
            </div>

        </div>
        <div class="form-row">
            <div class="form-group col-md-12">
                <label style="color: azure">Наименование документа</label>
                <input type="text" class="form-control" id="docName">
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-12">
                <label style="color: azure">Разработчик документа</label>
                <input type="text" class="form-control" id="docAuthor">
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-10">

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
                    <tr>
                        <th scope="row">1</th>
                        <td>Test name</td>
                        <td><span class="oi oi-dial"></span></td>
                        <td><span class="oi oi-x"></span></td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <div class="form-group ">
                <button class="btn btn-success btn-block">
                <span class="oi oi-plus">&nbsp Добавить</span></button>
            </div>
        </div>

        <div class="form-row justify-content-md-end">
            <button type="submit" class="col-md-2 btn btn-primary pull-right"><span class="oi oi-check"></span>&nbsp Создать</button>
        </div>

    </form>

</div>
</@c.page>