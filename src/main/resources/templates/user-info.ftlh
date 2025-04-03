<#import "template.ftlh" as t>
<@t.template>
    <h3>Detailed information by ${user.name}</h3>
    <#if user.ava??>
        <img src="/images/${user.ava.id}" style="border:2px solid black; border-radius: 20px" height="250">
    <#else><img src="/static/images/avatar.png" style="border:2px solid black; border-radius: 20px" height="125">
    </#if><br><br>
    <div style="font-size: large">
        <b>Phone: </b> ${user.phone}<br>
        <b>Date: </b> ${user.date}<br>
        <#if myLog>
            <form action="/user/edit" method="get">
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <input type="submit" class="btn btn-outline-secondary" value="Edit profile"/>
            </form>
        </#if>
    </div>
    <hr>

    <h3>Items by ${user.name}</h3>
    <div class="row row-cols-1 row-cols-md-5 g-4">
        <#list  items as item>
            <div class="card-columns" style="height: auto">
                <a href="/items/view/${item.id}" class="product-link">
                    <div class="card text-white bg-dark my-3 product">
                        <img src="/images/${item.imagePreview}" alt="img${item.imagePreview}"
                             class="card-img-top img-fluid"/>
                        <div class="card-body">
                            <h5 class="card-title">${item.title}</h5>
                            <p class="card-text">${item.price}$</p>
                        </div>
                        <div class="card-footer">
                            ${item.city}
                        </div>
                    </div>
                </a>
            </div>
        <#else>
            <h4>No items</h4>
        </#list>
    </div>

</@t.template>