<nav class="navbar navbar-dark bg-dark sticky-top  navbar-expand-lg  fixed-top">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarToggler"
            aria-controls="navbarToggler" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarToggler">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/"><span class="oi oi-home"></span> <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link " href="/find">Поиск</a>
            </li>

            <li class="nav-item">
                <a class="nav-link " href="/new">Новый</a>
            </li>

            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Отчет
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="/genreport1">Наполнение</a>
                    <a class="dropdown-item" href="/genreport2">Отчет по книгам</a>
                    <a class="dropdown-item" href="/searchRequestForm">Отчет по запросам в ГФД</a>
                    <a class="dropdown-item" href="/fillRequestList">Запрос на внесение данных в ГФД</a>
                </div>
            </li>

            <li class="nav-item">
                <a class="nav-link disabled" href="/genxls">Формирование книги</a>
            </li>

            <li class="nav-item">
                <a class="nav-link " href="#"> ${fullName}</a>
            </li>

        </ul>
        <ul class="navbar-nav justify-content-end">
        <#if userLocal??>
            <#if userLocal.isAdmin()>
                <li>
                    <a class="nav-link" href="/users"> <span
                        class="oi oi-person">&nbsp;&nbsp;Пользователи&nbsp;&nbsp;</span></a>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown1" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Транзакции
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown1">
                        <a class="dropdown-item" href="/import">Импорт</a>
                        <a class="dropdown-item" href="#">Экспорт</a>
                        <a class="dropdown-item" href="/bookList">Экспорт</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item"  href="/getLog">Log</a>
                    </div>
                </li>

            </#if>
            <li>
                <a class="nav-link" href="/logout"> <span
                    class="oi oi-account-logout">&nbsp;Выйти&nbsp;&nbsp;</span></a>
            </li>
        <#else>
            <li>
                <a class="nav-link" href="/login"> <span
                    class="oi oi-account-login">&nbsp;Войти&nbsp;&nbsp;</span></a>
            </li>
        </#if>
        </ul>

    </div>
</nav>