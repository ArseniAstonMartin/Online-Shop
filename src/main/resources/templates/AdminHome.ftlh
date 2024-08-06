<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<h1>this is admin page</h1>
<h3>
    Create new product
    <form action="/product/create" method="post" enctype="multipart/form-data">
        Title <input type="text" name="title"><br>
        description <input type="text" name="description"><br>
        price <input type="number" name="price"><br>
        city <input type="text" name="city"><br>
        preview <input type="file" name="preview"><br>
        first image <input type="file" name="image0"><br>
        second image <input type="file" name="image1"><br>
        <#--<input type = "hidden" name = "_csrf" value = "${csrf.token}">-->
        <input type="submit" value="Добавить товар"/><br>
    </form>
</h3>
</body>
</html>