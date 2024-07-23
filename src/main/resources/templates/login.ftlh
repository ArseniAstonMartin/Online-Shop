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
<h2>Login</h2>

<form action="/signin" method="post">
    <div class="form-group">
        <label for="username">Username:</label>
            <input type="text" id="username" name="username" value="" required>
    </div>
    <div class="form-group">
        <label for="password">Password:</label>
            <input type="password" id="password" name="password" value="" required>
    </div>
    <button type="submit">Login</button>
</form>
</body>
</html>