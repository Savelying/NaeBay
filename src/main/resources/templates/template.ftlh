<#macro template>
    <!doctype html>
    <html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="/static/css/style.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
              crossorigin="anonymous">
        <title>NaeBay!</title>
    </head>
    <body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
    <script src="/docs/5.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>

    <header class="p-3 mb-3 border-bottom">
        <div class="container">
            <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
                <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 link-body-emphasis text-decoration-none">
<#--                    <svg class="bi me-2" width="60" height="45" role="img" aria-label="Naebay!">-->
<#--                        <use xlink:href="#bootstrap"></use>-->
<#--                    </svg>-->
                    <img src="/static/images/NaeBay.png" alt="NaeBay!" height="45">
                </a>

                <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
<#--                    <li><a href="#" class="nav-link px-2 link-body-emphasis">Inventory</a></li>-->
<#--                    <li><a style="font-size: large"> НАЛЕТАЙ </a></li>-->
<#--                    <li><a style="font-size: large"> ТОРОПИСЬ, </a></li>-->
<#--                    <li><a style="font-size: large"> ПОКУПАЙ </a></li>-->
<#--                    <li><a style="font-size: large"> НЕ СКУПИСЬ! </a></li>-->
                    <li><h5 style="text-align: center"> НАЛЕТАЙ ТОРОПИСЬ, ПОКУПАЙ НЕ СКУПИСЬ! </h5></li>
                </ul>

                <#if isLog>
                    <#if userLog.isAdmin()>
                        <button type="button" class="btn btn-outline-secondary me-2"
                                onclick="window.location.href = '/admin'">Admin
                        </button>
                    </#if>
                    <div class="dropdown text-end">
                        <a href="#" class="d-block link-body-emphasis text-decoration-none dropdown-toggle"
                           data-bs-toggle="dropdown" aria-expanded="false">
                            <#if userLog.ava??>
                                <img src="/images/${userLog.ava.id}" alt="mdo" width="45" height="45"
                                     class="rounded-circle">
                            <#else>
                                <img src="/static/images/avatar.png" alt="mdo" width="45" height="45"
                                     class="rounded-circle">
                            </#if>
                        </a>
                        <ul class="dropdown-menu text-small" style="">
                            <li><a class="dropdown-item" href="/items/create">New item</a></li>
                            <li><a class="dropdown-item" href="/user/${userLog.id}">Profile</a></li>
                            <li><hr class="dropdown-divider"></li>
                            <li>
                                <form action="/logout" method="post">
                                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                                    <input type="submit" class="btn btn-outline-secondary" value="Sign out"/>
                                </form>
                            </li>
                        </ul>
                    </div>
                <#else>
                    <button type="button" class="btn btn-outline-primary me-2"
                            onclick="window.location.href = '/login'">
                        Login
                    </button>
                </#if>
            </div>
        </div>
    </header>

    <div class="container mt-4">
        <#nested/>
    </div>

    <footer class="container">
        <br>
        <hr>
        <p class="float-end"><a href="#">Back to top</a></p>
        <p>© 2017–2024 Company, Inc.<#-- · <a href="#">Privacy</a> · <a href="#">Terms</a>--></p>
    </footer>
    </body>
    </html>
</#macro>
