<#import "template.ftlh" as t>
<@t.template>
    <h3 style="text-align: center">Create new item</h3>

    <form action="/items/create" method="post" enctype="multipart/form-data">

        <div class="mb-3">
            <label for="title" class="form-label">Enter the title:</label>
            <input type="text" name="title" class="form-control" id="title" placeholder="">
            <br>

            <label for="city" class="form-label">Enter the city:</label>
            <input type="text" name="city" class="form-control" id="city" placeholder="">
            <br>

            <label for="price" class="form-label">Enter the price:</label>
            <input type="text" name="price" class="form-control" id="price" placeholder="">
            <br>

            <label for="description" class="form-label">Enter the description:</label>
            <textarea name="description" class="form-control" id="description" rows="auto"></textarea>
            <br>

            <label for="file1" class="form-label">Choose the first image:</label>
            <input type="file" name="file1" class="form-control" id="file1">
            <br>

            <label for="file12" class="form-label">Choose the second image:</label>
            <input type="file" name="file2" class="form-control" id="file2">
            <br>

            <label for="file3" class="form-label">Choose the third image:</label>
            <input type="file" name="file3" class="form-control" id="file3">
        </div>

        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-outline-primary">Create</button>
    </form>

</@t.template>