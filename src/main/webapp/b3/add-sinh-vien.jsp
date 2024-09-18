<%--
  Created by IntelliJ IDEA.
  User: Khanh Huyen
  Date: 04/09/2024
  Time: 6:36 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Student</title>
</head>
<body>
<button><a href="/sinh-vien/get-all">Home</a></button>
<form action="/sinh-vien/add" method="post">
    <label>MSSV:</label>
    <input type="text" name="mssv"> </br>
    <label> Tên:</label>
    <input type="text" name="ten"> </br>
    <label>Tuổi:</label>
    <input type="text" name="tuoi"> </br>
    <label>Địa chỉ:</label>
    <input type="text" name="diaChi"> </br>
    <label>Giới tính:</label>
    <input type="radio" name="gioiTinh" checked> Nam
    <input type="radio" name="gioiTinh"> Nữ </br>
    <button type="submit" style="margin-top: 8px">Add</button>
</form>
</body>
</html>
