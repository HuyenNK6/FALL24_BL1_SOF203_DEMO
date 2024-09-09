<%--
  Created by IntelliJ IDEA.
  User: Khanh Huyen
  Date: 07/09/2024
  Time: 10:49 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <button><a href="/sinh-vien/get-all">Home</a></button>
    <form action="/sinh-vien/update" method="post">
        <label>MSSV:</label>
        <input type="text" name="mssv" value="${svUpdate.mssv}" readonly style="color: lightslategray"> </br>
        <label> Tên:</label>
        <input type="text" name="ten" value="${svUpdate.ten}"> </br>
        <label>Tuổi:</label>
        <input type="text" name="tuoi" value="${svUpdate.tuoi}"> </br>
        <label>Địa chỉ:</label>
        <input type="text" name="diaChi" value="${svUpdate.diaChi}"> </br>
        <label>Giới tính:</label>
        <input type="radio" name="gioiTinh" ${svUpdate.gioiTinh ? "checked": ""}> Nam
        <input type="radio" name="gioiTinh" ${svUpdate.gioiTinh ? "": "checked"}> Nữ </br>
        <button type="submit" style="margin-top: 8px">Update</button>
    </form>
</body>
</html>
