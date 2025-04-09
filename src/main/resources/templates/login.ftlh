<#import "template.ftlh" as t>
<@t.template>
    <h3 style="text-align: center">Log in</h3>

    <form action="/login" method="post">
        <div class="mb-3">
            <label for="email" class="form-label">Enter email:</label>
            <input type="email" name="username" class="form-control" id="email" aria-describedby="emailHelp">
            <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
            <br>

            <label for="password" class="form-label">Enter password:</label>
            <input type="password" name="password" class="form-control" id="password">
        </div>

        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-outline-secondary">Sign in</button>
    </form>
    <br>

    <a>Мечтаешь стать "купи-продай"? </a>
    <a href="/registry"> Зарегистрируйся!</a>

</@t.template>