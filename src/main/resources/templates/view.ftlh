<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>NaeBay</title>
</head>
<body>
<h1><a href="/">NaeBay!</a></h1>
<hr>
<h3>Detailed information</h3>
<b>Title: </b>${item.title}<br>
<b>Description: </b>${item.description}<br>
<b>City: </b>${item.city}<br>
<b>Price: </b>${item.price}<br>
<b>Author: </b>${item.author}<br>
<hr>
<form action="/items/${item.id}/edit" method="get">
    <input type="submit" value="Edit"/>
</form>
<br>
<form action="/items/${item.id}/del" method="post">
    <input type="submit" value="Delete"/>
</form>
</body>
</html>