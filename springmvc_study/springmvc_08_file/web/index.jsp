<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>文件上传和下载</title>
  </head>
  <body>
    <form action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data" method="post">
      <input type="file" name="file"/>
      <input type="submit" value="上传">
    </form>

    <a href="${pageContext.request.contextPath}/download">下载文件</a>

  </body>
</html>
