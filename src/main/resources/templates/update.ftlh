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

<form action="/product/update/${product.id}" method="post" enctype="multipart/form-data">

    Title <input type="text" name="title" id="productTitle" value="">
    <script>
        document.getElementById("productTitle").value = "${product.title}";
    </script><br>

    Description <input type="text" name="description" id="productDescription" value="">
    <script>
        document.getElementById("productDescription").value = "${product.description}";
    </script><br>

    Price <input type="number" name="price" value=${product.price}><br>

    City <input type="text" name="city" id="productCity" value="">
    <script>
        document.getElementById("productCity").value = "${product.city}";
    </script><br>

    Author <input type="text" name="author" id="productAuthor" value="">
    <script>
        document.getElementById("productAuthor").value = "${product.author}";
    </script><br>
    preview <input type="file" name="preview"><br>
    first image <input type="file" name="image0"><br>
    second image <input type="file" name="image1"><br>
    <input type="submit" value="save updates">
</form>
</body>
</html>