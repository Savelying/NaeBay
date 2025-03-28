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
<h3>Detailed information by ${user.name}</h3>
<b>Email: </b> ${user.email}<br><br>
<b>Phone: </b> ${user.phone}<br><br>
<b>Date: </b> ${user.date}<br><br>
<#if myLog>
    <form action="/user/edit" method="get">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input type="submit" value="Edit"/>
    </form>
</#if>
<hr>
<h3>Items by ${user.name}</h3>
<#list  items as item>
    <div>
        <p><b>${item.title}</b> ${item.price}$ | <a href="/items/view/${item.id}">More...</a></p>
    </div>
<#else>
    <h4>No items</h4>
</#list>
<#if error??>
    <h2 style="color: red">${error}</h2>
</#if>
</body>
</html>