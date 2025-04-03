<#import "template.ftlh" as t>
<@t.template>
    <h3>Edit my information</h3>

    <#if user.ava??>
        <img src="/images/${user.ava.id}" style="border:2px solid black; border-radius: 20px" height="250" alt="">
        <br><br>
        <form action="/user/delAva" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button type="submit" class="btn btn-outline-danger">Delete avatar</button>
        </form>
    <#else><img src="/static/images/avatar.png" style="border:2px solid black; border-radius: 20px" height="125" alt="">
    </#if>
    <br><br>

    <form action="/user/edit" method="post" enctype="multipart/form-data">

        <div class="mb-3">
            <label for="file" class="form-label">Choose the avatar image:</label>
            <input type="file" name="file" class="form-control" id="file">
            <br>

            <label for="name" class="form-label">Enter name:</label>
            <input type="text" name="name" class="form-control" id="name" value="${user.name}">
            <br>

            <label for="phone" class="form-label">Enter phone:</label>
            <input type="text" name="phone" class="form-control" id="phone" value="${user.phone}">
            <br>
        </div>

        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-outline-success">Update</button>
    </form>

</@t.template>