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
<div>
    <h1><a href="/">AMACROSS</a></h1>

    <img src="/image/${preview.id}" height="100px" width="100px" alt=""/>
    <#if image1?has_content><img src="/image/${image1.id}" height="100px" width="100px" alt=""/></#if>
    <#if image2?has_content><img src="/image/${image2.id}" height="100px" width="100px" alt=""/></#if>
    <h2>${product.title}</h2><br>
    <b>Description:</b> ${product.description}<br>
    <b>Price:</b> ${product.price} byn.<br>
    <b>City:</b> ${product.city}<br>
    <b>Poster:</b> <a href="/user/${product.user.id}">${product.user.username}</a><br>
</div>
<#if currentUserId??>
    <#--<#if product.user.id == currentUserId>-->
        <form action="/product/delete/${product.id}" method="post">
        <input type="submit" value="delete product">
        </form>
        <form action="/product/update/${product.id}" method="get">
            <input type="submit" value="update product">
        </form>
    <#--</#if>-->
</#if>
</body>
</html>