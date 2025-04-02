<#import "template.ftlh" as t>
<@t.template>
    <h3>All items</h3>
    <#list  items as item>
        <div>
            <img src="/images/${item.imagePreview}" alt="img${item.imagePreview}" height="50"/>
            <p><b>${item.title}</b> ${item.price}$ | <a href="/items/view/${item.id}">More...</a></p>
            <hr style="link: var(3)">
        </div>
    <#else>
        <h4>No items</h4>
    </#list>
</@t.template>