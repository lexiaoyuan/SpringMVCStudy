<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajax Test</title>
    <script src="${pageContext.request.contextPath}/statics/jquery.js"></script>
    <script>
      $(function () {
          $("#search-tx").blur(function () {
              $.post({
                  url: "${pageContext.request.contextPath}/ajax/test2",
                  data: {"searchName": $("#search-tx").val()},
                  success: function (data) {
                      $("#msg").html("data:"+data);
                  },
                  error: function (data) {
                      $("#msg").html("data:"+data);
                  }

              });
          });
      });
    </script>
</head>
<body>
    <input id="search-tx" type="text" placeholder="失去焦点发送请求">
    <span id="msg"></span>
</body>
</html>
