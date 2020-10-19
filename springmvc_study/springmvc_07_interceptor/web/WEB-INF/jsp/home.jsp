<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
    <h3>首页</h3>
    <p>这里是首页的一些内容。。。</p>
    <p>欢迎你：${username}</p>
    <a href="${pageContext.request.contextPath}/user/logout">注销</a>
    <a href="${pageContext.request.contextPath}/index.jsp">返回index</a>
</body>
</html>
