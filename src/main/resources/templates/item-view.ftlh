<#import "template.ftlh" as t>
<@t.template>
    <h3>Detailed information</h3>
    <#list  images as img>
        <img src="/images/${img.id}" alt="img${img.id}" height="100"/>
    </#list>
    <br><br>
    <b>Title: </b>${item.title}<br>
    <b>Description: </b>${item.description}<br>
    <b>City: </b>${item.city}<br>
    <b>Price: </b>${item.price}<br>
    <#if !myLog>
        <b>Author: </b><a href="/user/${item.user.id}">${item.user.name}</a><br>
        <b>Phone: </b>${item.user.phone}<br><br>
    </#if>
    <br>
    <#if myLog>
        <form action="/items/edit/${item.id}" method="get">
            <input type="submit" value="Edit"/>
        </form>
    </#if>
</@t.template>