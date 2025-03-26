<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>NaeBay</title>
</head>
<body>
<h1><a href="/">NaeBay!</a></h1>
<hr>
<h3>Налетай торопись покупай не скупись!</h3>
<#list  items as item>
    <div>
        <p><b>${item.title}</b> ${item.price}$ | <a href="/items/${item.id}">More...</a></p>
    </div>
<#else>
    <h4>No items</h4>
</#list>
</body>
</html>