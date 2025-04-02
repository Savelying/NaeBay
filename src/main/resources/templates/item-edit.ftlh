<#import "template.ftlh" as t>
<@t.template>
<h3>Edit my item</h3>
<form action="/items/edit/${item.id}" method="post" enctype="multipart/form-data">
    Enter the title: <input type="text" name="title" value="${item.title}"><br><br>
    Enter the description: <input type="text" name="description" value="${item.description}"><br><br>
    Enter the city: <input type="text" name="city" value="${item.city}"><br><br>
    Enter the price: <input type="text" name="price" value="${item.price}"><br><br>
<#--    Image 1: <input type="file" name="file1"><br><br>-->
<#--    Image 2: <input type="file" name="file2"><br><br>-->
<#--    Image 3: <input type="file" name="file3"><br><br>-->
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <input type="submit" value="Update"/>
</form>
<br>
<form action="/items/delete/${item.id}" method="post">
    <input type="submit" value="Delete"/>
</form>
</@t.template>