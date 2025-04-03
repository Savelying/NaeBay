<#import "template.ftlh" as t>
<@t.template>
    <h3 style="text-align: center">Welcome to our perfect site!</h3>
    <h2 style="text-align: center">${userLog.name}!</h2>
    <br>
    <p style="text-align: center"><a href="/items">[View items]</a> or <a href="items/create">[Add item]</a></p>
</@t.template>