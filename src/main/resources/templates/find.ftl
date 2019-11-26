<#import "parts/common.ftl" as c>
<@c.page>

<div class="container">

    <form class="findform" action="/dofind" method="post">
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
                <label class="label-form">Номер документа</label>
                <input type="text" class="form-control" id="docNumber" placeholder="Номер документа">
            </div>
            <div class="form-group col-md-4">
                <label class="label-form">Дата документа</label>
                <input type="date" class="form-control" id="docDate" placeholder="01.01.2000">
            </div>
            <div class="form-group col-md-4">
                <label class="label-form">&nbsp;</label>
                <input type="date" class="form-control" id="docDate" placeholder="01.01.2000">
            </div>


            <div class="form-group col-md-2">
                <label class="label-form">Система координат</label>
                <select id="sysCoord" class="form-control">
                    <option selected>МСК-22</option>
                    <option>...</option>
                </select>
            </div>

        </div>
        <div class="form-row">
            <div class="form-group col-md-12">
                <label class="label-form">Название документа содержит</label>
                <input type="text" class="form-control" id="docName">
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-12">
                <label class="label-form">Разработчик документа</label>
                <input type="text" class="form-control" id="docAuthor">
            </div>
        </div>

        <div class="form-row justify-content-md-end">
            <button type="submit" class="col-md-2 btn btn-primary pull-right"><span class="oi oi-magnifying-glass"></span>&nbsp Поиск</button>
        </div>

    </form>

</div>
</@c.page>