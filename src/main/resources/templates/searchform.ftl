<#import "parts/common.ftl" as c>

<@c.page>
<div class="container">

    <form class="findform" action="/doFindSearch" method="post">
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
            <div class="col-sm-6">
                <label class="label-form col-form-label-sm label-slim">Запрос в фонд с</label>
                <input type="date" class="form-control form-control-sm" id="docTransferB" name="docTransferB"
                >
            </div>
            <div class="col-sm-6">
                <label class="label-form col-form-label-sm label-slim">по</label>
                <input type="date" class="form-control form-control-sm" id="docTransferE" name="docTransferE">
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