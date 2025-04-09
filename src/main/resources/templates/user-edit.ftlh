<#import "template.ftlh" as t>
<@t.template>
<h3>Edit user ${user.name}</h3>
<form action="/admin/user/edit" method="post">
    <#list  roles as role>
        <div>
            <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}> ${role}
            </label>
        </div>
    </#list>
    <br>
    <input type="hidden" value="${user.id}" name="userId">
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <button type="button" class="btn btn-primary">Save</button>
</form>
</@t.template>