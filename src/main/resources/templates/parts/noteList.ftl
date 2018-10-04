<div class="row">
<#list notes as note>

    <div class="col-sm-6 col-lg-4 mb-3">

        <div class="card">
            <div class="card-header text-center">${note.date}</div>
            <a href="./${note.id}" class="text-muted">
            <#if note.fileName??>
            <img class="card-img-top" width="268" height="180" src="/img/${note.fileName}" alt="Test Image" />
            </#if>
            <div class="card-body">

                <h5 class="card-title">${note.textCaption}</h5>
                <div class="text-right">
                    <a href="./delete/${note.id}" class="card-link text-right">Удалить</a>
                </div>
            </div>
            </a>

        </div>
    </div>
<#else>
<div class="col-sm-3 text">Нет записей</div>

</#list>
</div>