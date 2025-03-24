<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>NaeBay</title>
</head>
<body>
<h1><a href="/">NaeBay!</a></h1>
<a href="/user/login">Log in</a>
<hr>
<h3>Detailed information</h3>
<#list  images as img>
    <img src="/images/${img.id}" alt="img${img.id}" height="100"/>
</#list>
<br><br>
<b>Title: </b>${item.title}<br>
<b>Description: </b>${item.description}<br>
<b>City: </b>${item.city}<br>
<b>Price: </b>${item.price}<br>
<b>Author: </b>${item.author}<br>
<hr>
<form action="/item/${item.id}/edit" method="get">
    <input type="submit" value="Edit"/>
</form>
<br>
<form action="/item/${item.id}/del" method="post">
    <input type="submit" value="Delete"/>
</form>
</body>
</html>