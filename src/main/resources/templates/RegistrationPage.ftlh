<!doctype html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<h2>Registration</h2>
<form action="/register/saveUser" method="POST">
    <label for="name">Username:</label><br>
    <input type="text" id="name" name="name"><br><br>

    <label for="password">Password:</label><br>
    <input type="password" id="password" name="password"><br><br>

    <label for="role">Role:</label><br>
    <select id="role" name="role">
        <option value="USER">USER</option>
        <option value="ADMIN">ADMIN</option>
    </select>

    <input type="submit" value="Submit">
</form>
</body>
</html>