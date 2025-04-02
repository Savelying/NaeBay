<#import "template.ftlh" as t>
<@t.template>
    <h3>Detailed information by ${user.name}</h3>
    <#if user.ava??>
        <img src="/images/${user.ava.id}" style="border:2px solid black; border-radius: 20px" height="120">
    <#else><img src="/static/images/avatar.png" style="border:2px solid black; border-radius: 20px" height="120">
    </#if><br><br>
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
</@t.template>