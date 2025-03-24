<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>NaeBay</title>
</head>
<body>
<h1><a href="/">NaeBay!</a></h1>
<hr>
<h3>Log in</h3>
<form action="/user/login" method="post">
    Enter email: <input type="email" name="username"><br><br>
    Enter password: <input type="password" name="password"><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <input type="submit" value="Sign in"/>
</form>
<#if error??>
    <h2 style="color: red">${error}</h2>
</#if>
<br>
<a href="/user/registry">Registration</a>
</body>
</html>