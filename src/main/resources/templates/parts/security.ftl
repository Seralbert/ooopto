<#assign
known = Session.SPRING_SECURITY_CONTEXT??
>

<#if known>
    <#assign
    userLocal = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    name = userLocal.getUsername()
    fullName = userLocal.getFio()
    >
<#else>
    <#assign
    name = "unknown"
    fullName = ""
    currentUserId = -1
    >
</#if>