<#import "template.ftlh" as t>
<@t.template>
    <h3>Registration</h3>
    <form action="/registry" method="post">
        Enter name: <input type="text" name="name"><br><br>
        Enter email: <input type="email" name="email"><br><br>
        Enter phone: <input type="text" name="phone"><br><br>
        Enter password: <input type="password"><br><br>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input type="submit" value="Registration"/>
    </form>

    <#if error??>
        <h4 style="color: red">${error}</h4>
    </#if>
</@t.template>