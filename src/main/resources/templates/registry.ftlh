<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>NaeBay</title>
</head>
<body>
<h1><a href="/">NaeBay!</a></h1>
<br>
<hr>
<h3>Registration</h3>
<form action="/registry" method="post">
    Enter name: <input type="text" name="name"><br><br>
    Enter email: <input type="email" name="email"><br><br>
    Enter phone: <input type="text" name="phone"><br><br>
    Enter password: <input type="password" name="password"><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <input type="submit" value="Registration"/>
</form>
<#if error??>
    <h4 style="color: red">${error}</h4>
</#if>
</body>
</html>