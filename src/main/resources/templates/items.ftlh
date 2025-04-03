<#import "template.ftlh" as t>
<@t.template>
    <h3 style="text-align: center">All items</h3>

<#--    <form method="get" action="/">-->
<#--        <div class="form-row">-->
<#--            <div class="form-group col-md-2">-->
<#--                <label for="searchCity">Город</label>-->
<#--                <select id="searchCity" class="form-control">-->
<#--                    <option value="">Город не выбран</option>-->
<#--                    <option value="Москва">Москва</option>-->
<#--                    <option value="Красноярск">Красноярск</option>-->
<#--                    <option value="Казань">Казань</option>-->
<#--                </select>-->
<#--            </div>-->
<#--            <div class="form-group col-md-8">-->
<#--                <label for="searchWord">Поиск по объявлениям</label>-->
<#--                <input type="text" name="searchWord" <#if searchWord??>value="${searchWord}"</#if> class="form-control"-->
<#--                       id="searchWord">-->
<#--            </div>-->
<#--            <button style="width: 100%" type="submit" class="btn btn-dark">Поиск</button>-->
<#--        </div>-->
<#--    </form>-->
<#--    <hr>-->

    <div class="row row-cols-1 row-cols-md-5 g-4">
        <#list  items as item>
            <div class="card-columns" style="height: auto">
                <a href="/items/view/${item.id}" class="product-link">
                    <div class="card text-white bg-dark my-3 product">
                        <img src="/images/${item.imagePreview}" alt="img${item.imagePreview}" class="card-img-top img-fluid"/>
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