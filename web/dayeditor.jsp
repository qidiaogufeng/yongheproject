<%--
  Created by IntelliJ IDEA.
  User: 12460
  Date: 2020/7/15
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>日总结编写</title>
    <%--引入插件--%>
    <script type="text/javascript" src="ueditor/ueditor.config.js"></script>
    <script type="text/javascript" src="ueditor/ueditor.all.js"></script>
    <link rel="stylesheet" href="ueditor/themes/default/css/ueditor.css">
</head>
<body>
    <%--整个富文本编辑器，可以放入一个form表单，方便提交--%>
    <form action="${pageContext.request.contextPath}/doueditor" method="post" style="width: 800px">
        <%--此标签是多行文本输入控件(可容纳无限数量的文本)--%>
        <textarea name="content" id="myEditor">
            此处可编写内容
        </textarea>

        <script>
            UE.getEditor("myEditor");  //初始化编辑器 id要保持一致
        </script>
        <input type="submit" value="提交">
    </form>
</body>
</html>
