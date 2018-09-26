<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<body>
  <center>
        <table width="200" border="1">
          <tr>
            <th scope="col">ID</th>
            <th scope="col">密码</th>
            <th scope="col">姓名</th>

          </tr>
          <c:forEach  items="${requestScope.users}"  var="list"  varStatus="userlist">
          <tr>
            <td>${list.ID}</td>
            <td>${list.passWord}</td>
            <td>${list.name}</td>
          </tr>
          </c:forEach>
        </table>
         <p>一共${page.pages}页</p> <p>当前第${page.pageNum}页</p>
        <a href="http://localhost:8025/WebTest/helloWord/hw4.do?page=${page.firstPage}">第一页</a>
        <a href="http://localhost:8025/WebTest/helloWord/hw4.do?page=${page.nextPage}">下一页</a>
        <a href="http://localhost:8025/WebTest/helloWord/hw4.do?page=${page.prePage}">上一页</a>
        <a href="http://localhost:8025/WebTest/helloWord/hw4.do?page=${page.lastPage}">最后页</a>
    </center>
  </body>
</body>
</html>