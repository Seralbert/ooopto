<#assign
known = Session.SPRING_SECURITY_CONTEXT??
>

<#if known>
    <#assign
    userLocal = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    name = userLocal.getUsername()
    >
<#else>
    <#assign
    name = "unknown"
    currentUserId = -1
    >
</#if>