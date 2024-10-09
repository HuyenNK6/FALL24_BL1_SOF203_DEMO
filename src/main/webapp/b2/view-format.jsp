<%--
  Created by IntelliJ IDEA.
  User: Huyen
  Date: 10/7/2024
  Time: 11:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <!-- Định dạng số với dấu phân cách hàng nghìn -->
    <p>Số ban đầu: ${number}</p>
    <p>Số đã định dạng: <fmt:formatNumber value="${number}" type="number" groupingUsed="true" /></p>

    <!-- Định dạng tiền tệ -->
    <p>Số tiền ban đầu: ${currency}</p>
    <p>Số tiền đã định dạng: <fmt:formatNumber value="${currency}" type="currency" currencySymbol="VND" /></p>
<%--<jsp:useBean> là một thẻ trong JSP (JavaServer Pages) được sử dụng để khởi tạo và quản lý các JavaBean trong trang JSP.
JavaBean là các đối tượng Java tuân theo một số quy tắc nhất định, giúp tái sử dụng mã và quản lý dữ liệu hiệu quả trong ứng dụng web.--%>

    <jsp:useBean id="now" class="java.util.Date"></jsp:useBean>
    <p>Ngày hiện tại:<fmt:formatDate value="${now}"></fmt:formatDate><br></p>
    <p>Ngày định dạng:
    <fmt:formatDate value="${now}" pattern="dd-mm-yyyy"></fmt:formatDate><br>
    <fmt:formatNumber value="${now.time}" pattern="#,###.0"></fmt:formatNumber><br>
    </p>
</body>
</html>
