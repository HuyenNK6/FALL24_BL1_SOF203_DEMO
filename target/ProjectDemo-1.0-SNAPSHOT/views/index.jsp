<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
    <h1><%= "Hello World!" %>
    </h1>
    <h1>FPT POLYTECHNIC</h1>
    <%--Ctrl+ shift+ /--%>
    <%--Chỉ thị này giúp module hóa các thành phần giao diện,
     giúp chèn toàn bộ mã JSP của trang sub.jsp tại vị trí đặt chỉ thị @include --%>
    <%@include file="sub.jsp"%>
    <%--Chú ý sự khác biệt so với chỉ thị <%@include%>
        <%@include%> chèn mã trong khi đó <jsp:include> render kết quả
        <%@include%> xảy ra lúc dịch trong khi đó <jsp:include> xảy ra lúc chạy
    --%>
    <jsp:include page="subpage.jsp">
        <jsp:param name="message" value="Hello sub page"/>
    </jsp:include>

    <%--   ${item}  Truy xuất giá trị của attribute item trong request--%>
    <h2>${message}</h2>
    <br/>
    <a href="hello-servlet">Hello Servlet</a>

    <%--    Truy xuất List --%>
    <h2> Danh sách Họ tên</h2>
    <li>list[0]: ${lstNames[0]}</li>
    <li>list[1]: ${lstNames[1]}</li>
</body>
</html>