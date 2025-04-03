<#import "template.ftlh" as t>
<@t.template>
    <h3 style="text-align: center">Admin panel</h3>

    <table class="table table-bordered" style="text-align: center">
        <tr>
            <th>Email</th>
            <th>Phone</th>
            <th>Active</th>
            <th>Ban</th>
            <th>Roles</th>
            <th>Details</th>
            <th>Edit</th>
        </tr>
        <#list users as user>
            <tr>
                <th style="text-align: left">${user.email}</th>
                <th>${user.phone}</th>
                <th><#if user.active><a>Yes</a><#else><a>No</a></#if></th>
                <th>
                    <form action="/admin/user/ban/${user.id}" method="post">
                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                        <#if user.active><input type="submit" value="Ban">
                        <#else><input type="submit" value="Unban"></#if>
                    </form>
                </th>
                <th><#list user.roles as role>${role}<#sep>, </#sep></#list></th>
                <th><a href="/user/${user.id}">More</a></th>
                <th><a href="/admin/user/edit/${user.id}">Edit</a></th>
            </tr>
        <#else>
            <h4>No users</h4>
        </#list>
    </table>

</@t.template>