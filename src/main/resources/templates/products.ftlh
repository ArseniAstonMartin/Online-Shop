<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">AMACROSS</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/admin">Admin page</a>
            </li>
            <#if user.username??>
            <li class="nav-item">
                <a class="nav-link" href="/user/${user.id}">User Page</a>
            </li>
            </#if>
        </ul>
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="btn btn-primary" href="/register/input">Register</a>
            </li>
            <li class="nav-item">

                <#if user.username??>
                    <h3>Имя пользователя: <i>${user.username}</i></h3>
                    <form action="/logout" method="post">
                        <input type="submit" value="Выйти"/>
                    </form>
                <#else>
                    <a class="btn btn-outline-primary me-2" href="/login">Login</a>
                </#if>
            </li>
        </ul>
    </div>
</nav>
    <h1 style="text-align: center">THIS IS HOME PAGE</h1>
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
<#if user.username??>
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
</#if>

</body>
</html>