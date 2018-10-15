<nav class="navbar navbar-dark bg-dark sticky-top  navbar-expand-lg  fixed-top">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03"
            aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand" href="http://${serverAddr}:8080/">
        <img src="../imgres/logo.png" width="30" height="30">
    </a>

    <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="http://${serverAddr}:8080/">Новости <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link " href="http://${serverAddr}:8080/docs">Документы</a>
            </li>

        <#if userLocal??>
        <#if userLocal.isAdmin()>
            <li class="nav-item">
                <a class="nav-link" href="http://${serverAddr}:8080/users">Пользователи </a>
            </li>
        </#if>
        </#if>
        </ul>
            <ul class="navbar-nav justify-content-end">
            <#if !userLocal??>
                <li class="nav-item">
                    <a class="nav-link" href="http://${serverAddr}:8080/reg">Регистрация</a>
                </li>
            </#if>
                <li class="nav-item">
                    <div class="text">

                    </div>
                </li>
            <#if userLocal??>

                <li class="nav-item">
                    <a class="nav-link btn btn-outline-info" href="/logout">Выйти</a>
                </li>
            <#else>
                <li class="nav-item">
                    <a class="nav-link btn btn-outline-info" href="http://${serverAddr}:8080/login">Войти</a>
                </li>
            </#if>
        </ul>

    </div>
</nav>
