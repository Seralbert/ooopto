<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top sticky-top">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand" href="http://${serverAddr}:8080/">
        <img src="../imgres/logo.png" width="30" height="30">
    </a>

    <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <li class="nav-item active">
                <a class="nav-link" href="http://${serverAddr}:8080/">Новости <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="http://${serverAddr}:8080/docs">Документы</a>
            </li>

            <#if userLocal??>
            <li class="nav-item">
                <a class="nav-link" href="http://${serverAddr}:8080/users">Пользователи</a>
            </li>
            </#if>

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
                    <a class="nav-link" href="/logout">Выйти</a>
                </li>
            <#else>
                <li class="nav-item">
                    <a class="nav-link" href="http://${serverAddr}:8080/login">Войти</a>
                </li>
            </#if>
        </ul>

    </div>
</nav>