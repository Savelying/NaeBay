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
<h3>Editing item</h3>
<form action="/items/${item.id}/edit" method="post">
    Enter the title: <input type="text" name="title" value="${item.title}"><br><br>
    Enter the description: <input type="text" name="description" value="${item.description}"><br><br>
    Enter the city: <input type="text" name="city" value="${item.city}"><br><br>
    Enter the price: <input type="text" name="price" value="${item.price}"><br><br>
    Enter your name: <input type="text" name="author" value="${item.author}"><br><br>
    <input type="submit" value="Update"/>
</form>
</body>
</html>