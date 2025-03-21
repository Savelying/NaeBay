<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>NaeBay</title>
</head>
<body>
<h1><a href="/">NaeBay!</a></h1>
<hr>
<h3>Create new item</h3>
<form action="/items/create" method="post">
    Enter the title: <input type="text" name="title"><br><br>
    Enter the description: <input type="text" name="description"><br><br>
    Enter the city: <input type="text" name="city"><br><br>
    Enter the price: <input type="text" name="price"><br><br>
    Enter your name: <input type="text" name="author"><br><br>
    <input type="submit" value="Create"/>
</form>
</body>
</html>