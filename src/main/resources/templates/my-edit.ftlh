<#import "template.ftlh" as t>
<@t.template>
    <h3>Edit my information</h3>
    <#if user.ava??>
        <img src="/images/${user.ava.id}" style="border:2px solid black; border-radius: 20px" height="120">
    <#else><img src="/static/images/avatar.png" style="border:2px solid black; border-radius: 20px" height="120">
    </#if>
    <br><br>
    <form action="/user/edit" method="post" enctype="multipart/form-data">
        Add avatar: <input type="file" name="file"><br><br>
        Enter name: <input type="text" name="name" value="${user.name}"><br><br>
        Enter phone: <input type="text" name="phone" value="${user.phone}"><br><br>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input type="submit" value="Update"/>
    </form>
    <#if error??>
        <h4 style="color: red">${error}</h4>
    </#if>
</@t.template>