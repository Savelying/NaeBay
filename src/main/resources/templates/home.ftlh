<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>NaeBay</title>
</head>
<body>
<h1>NaeBay!</h1>
<#if user.name??>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input type="submit" value="Log out"/>
    </form>
    <#if user.isAdmin()>
        <form action="/admin" method="get">
            <input type="submit" value="Admin"/>
        </form>
    </#if>
<#else>
    <form action="/login" method="get">
        <input type="submit" value="Log in"/>
    </form>
</#if>
<hr>
<h3>Welcome to our perfect site!</h3>
<br>
<a href="/items">[View items]</a> or <a href="items/create">[Add item]</a>
</body>
</html>