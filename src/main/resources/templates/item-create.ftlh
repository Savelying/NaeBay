<#import "template.ftlh" as t>
<@t.template>
    <h3>Create new item</h3>
    <form action="/items/create" method="post" enctype="multipart/form-data">
        Enter the title: <input type="text" name="title"><br><br>
        Enter the city: <input type="text" name="city"><br><br>
        Enter the price: <input type="text" name="price"><br><br>
        Enter the description: <input type="text" name="description"><br><br>
        Image 1: <input type="file" name="file1"><br><br>
        Image 2: <input type="file" name="file2"><br><br>
        Image 3: <input type="file" name="file3"><br><br>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input type="submit" value="Create"/>
    </form>
</@t.template>