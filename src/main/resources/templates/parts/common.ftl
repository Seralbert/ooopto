<#macro page>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>ГФД</title>
    <link rel="stylesheet" href="/css/style.css"/>

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <link rel="icon" href="imgres/favicon.ico" type="image/x-icon"/>
    <link rel="shortcut icon" href="imgres/favicon.ico" type="image/x-icon"/>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/css/bootstrap.min.css"/>
    <!--script src='https://www.google.com/recaptcha/api.js'></script-->

    <link rel="stylesheet" href="/css/open-iconic-bootstrap.min.css"/>
</head>
<body>



<div class="container">
    <#include "security.ftl">
    <#include "navbar.ftl">
    <br>

    <#nested>

</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="/js/jquery-3.3.1.slim.min.js"></script>
<script src="/js/popper.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
</body>
</html>
</#macro>