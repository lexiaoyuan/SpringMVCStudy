<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <h3>登录</h3>
    <form action="${pageContext.request.contextPath}/user/login" method="post">
        <label for="username">用户名：</label>
        <input type="text" name="username" id="username">
        <label for="password">密码：</label>
        <input type="password" name="password" id="password">
        <input type="submit" value="登录">
    </form>
</body>
</html>
