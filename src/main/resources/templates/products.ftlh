<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <h1><a href="/">AMACROSS</a></h1>
    <form action="/product/search" method="get">
        Title <input type="text" name="title"><br>
        <input type="submit" value="Выполнить поиск"/><br>
    </form>

    <#list products as product>
            <div>
                <h3>${product.title}</h3>
                <b>Price:</b> ${product.price} |
                <a href="/product/${product.id}">See more</a>;
                <br>
            </div>
    </#list>
    <h3>
        Create new product
        <form action="/product/create" method="post" enctype="multipart/form-data">
            Title <input type="text" name="title"><br>
            description <input type="text" name="description"><br>
            price <input type="number" name="price"><br>
            city <input type="text" name="city"><br>
            author <input type="text" name="author"><br>
            preview <input type="file" name="preview"><br>
            first image <input type="file" name="image0"><br>
            second image <input type="file" name="image1"><br>
            <input type="submit" value="Добавить товар"/><br>
        </form>
    </h3>
</body>
</html>