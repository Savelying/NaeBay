<#import "template.ftlh" as t>
<@t.template>
    <h3 style="text-align: center">Detailed item information</h3>
    <div align="center">
        <div id="itemImages" class="carousel slide col-5">

            <div class="carousel-indicators">
                <#list  images as img>
                    <button type="button" data-bs-target="#itemImages" data-bs-slide-to="${img_index}"
                            aria-label="Slide ${img_index}" <#if img_index == 0>class="active"
                            aria-current="true"</#if>></button>
                </#list>
            </div>

            <div class="carousel-inner">
                <#list  images as img>
                    <div class="carousel-item <#if img_index == 0>active</#if>">
                        <a href="/images/${img.id}">
                            <img src="/images/${img.id}" class="product img-fluid" alt="img"
                                 data-bs-slide-to="${img_index}">
                        </a>
                    </div>
                </#list>
            </div>

            <button class="carousel-control-prev" type="button" data-bs-target="#itemImages"
                    data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#itemImages"
                    data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>

        </div>
        <#list  images as img>
            <img src="/images/${img.id}" alt="img${img.id}" height="100"/>
        </#list>
    </div><br>

<#--    <table class="table table-bordered w-auto">-->
<#--        <tbody>-->
<#--        <tr><th&lt;#&ndash; class="col-auto"&ndash;&gt;>Title:</th><th>${item.title}</th></tr>-->
<#--        <tr><th&lt;#&ndash; class="col-1"&ndash;&gt;>Description:</th><th>${item.description}</th></tr>-->
<#--        <tr><th&lt;#&ndash; class="col-2"&ndash;&gt;>City:</th><th>${item.city}</th></tr>-->
<#--        <tr><th&lt;#&ndash; class="col-2"&ndash;&gt;>Price:</th><th>${item.price}$</th></tr>-->
<#--        </tbody>-->
<#--    </table>-->

    <div style="font-size: large">
        <b>Title: </b>${item.title}<br>
        <b>Description: </b>${item.description}<br>
        <b>City: </b>${item.city}<br>
        <b>Date: </b>${item.date}<br>
        <b>Price: </b>${item.price}$<br>
        <#if !myLog>
            <b>Author: </b><a href="/user/${item.user.id}">${item.user.name}</a><br>
            <b>Phone: </b>${item.user.phone}<br><br>
        </#if>
    </div>
    <br>
    <#if myLog>
        <form action="/items/edit/${item.id}" method="get">
            <input type="submit" class="btn btn-outline-secondary" value="Edit item"/>
        </form>
    </#if>
</@t.template>