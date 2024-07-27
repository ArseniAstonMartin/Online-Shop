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
<h1 style="text-align: center">THIS IS USER PAGE</h1><br>
<h2>Username: ${user.username}</h2>
<h3>This is his products</h3>
<#list products as product>
    <div>
        <h3>${product.title}</h3>
        <b>Price:</b> ${product.price}
        <br>
    </div>
</#list>
</body>
</html>