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

    <#--header-->
    <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
        <div class="col-md-3 mb-0 mb-md-0">
            <h3><a href="/" class="d-inline-flex link-body-emphasis text-decoration-none">
                    <img src="/static/images/NaeBay.png" alt="NaeBay!" height="50"/></a></h3>
        </div>
        <h4>Налетай торопись, покупай не скупись!</h4>

        <div class="col-md-3 text-end">
            <#if isLog>
                <#if userLog.isAdmin()>
                    <form action="/admin" method="get">
                        <input type="submit" value="Admin"/>
                    </form>
                </#if>
                <div class="dropdown text-end">
                    <a href="user/${userLog.id}" class="d-block link-body-emphasis text-decoration-none dropdown-toggle"
                       data-bs-toggle="dropdown" aria-expanded="false">
                        <#if userLog.ava??>
                            <img src="/images/${userLog.ava.id}" alt="mdo" width="50" height="50"
                                 class="rounded-circle">
                        <#else><img src="/static/images/avatar.png" alt="mdo" width="50" height="50"
                                    class="rounded-circle">
                        </#if>
                    </a>
                    <ul class="dropdown-menu text-small">
                        <li><a class="dropdown-item" href="user/${userLog.id}">Account</a></li>
                        <#--                    <li><a class="dropdown-item" href="#">Settings</a></li>-->
                        <#--                    <li><a class="dropdown-item" href="#">Profile</a></li>-->
                        <li>
                            <hr class="dropdown-divider">
                        </li>
                        <li><a class="dropdown-item" href="/logout">Sign out</a></li>
                    </ul>
                </div>
            <#else>
                <button type="button" class="btn btn-outline-primary me-2" onclick="window.location.href = '/login'">
                    Login
                </button>
            </#if>
        </div>
    </header>

    <div class="container mt-4">
        <#nested/>
    </div>

    <footer class="container">
        <br><hr>
        <p class="float-end"><a href="#">Back to top</a></p>
        <p>© 2017–2024 Company, Inc. · <a href="#">Privacy</a> · <a href="#">Terms</a></p>
    </footer>
    </body>
    </html>
</#macro>