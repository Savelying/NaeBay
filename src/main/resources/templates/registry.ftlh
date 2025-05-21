<#import "template.ftlh" as t>
<@t.template>
    <h3 style="text-align: center">Registration</h3>
    <form action="/registry" method="post">
        <div class="mb-3">
            <label for="name" class="form-label">Enter name:</label>
            <input type="text" name="name" class="form-control" id="name">
            <br>

            <label for="email" class="form-label">Enter email:</label>
            <input type="email" name="email" class="form-control" id="email" aria-describedby="emailHelp">
            <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
            <br>

            <label for="phone" class="form-label">Enter phone:</label>
            <input type="text" name="phone" class="form-control" id="phone">
            <br>


            <label for="password" class="form-label">Enter password:</label>
            <input type="password" name="password" class="form-control" id="password">
        </div>

        <#--        <div class="mb-3 form-check">-->
        <#--            <input type="checkbox" class="form-check-input" id="exampleCheck1">-->
        <#--            <label class="form-check-label" for="exampleCheck1">Check me out</label>-->
        <#--        </div>-->

        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-outline-success">Registration</button>
    </form>

    <#if error??>
        <h4 style="color: red">${error}</h4>
    </#if>
</@t.template>
