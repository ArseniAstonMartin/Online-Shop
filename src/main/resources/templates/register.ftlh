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
<form action="/finish" th:object="${registerDTO}" method="POST">
    <div>
        <label>Email</label>
        <input type="text" th:field="*{registerDTO.email}">
    </div>
    <div>
        <label>Name</label>
        <input type="text" th:field="*{registerDTO.name}">
    </div>
    <div>
        <label>Password</label>
        <input type="password" th:field="*{registerDTO.password}">
    </div>
    <div>
        <button type="submit">Submit</button>
    </div>

</form>
</body>
</html>