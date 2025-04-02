<#import "template.ftlh" as t>
<@t.template>
    <h3>Log in</h3>
    <form action="/login" method="post">
        Enter email: <input type="email" name="username"><br><br>
        Enter password: <input type="password" name="password"><br><br>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input type="submit" value="Sign in"/>
    </form>
    <form action="/registry" method="get">
        <input type="submit" value="Registration"/>
    </form>
</@t.template>