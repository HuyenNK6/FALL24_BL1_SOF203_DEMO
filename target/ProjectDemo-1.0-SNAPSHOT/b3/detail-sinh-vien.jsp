<%--
  Created by IntelliJ IDEA.
  User: Khanh Huyen
  Date: 06/09/2024
  Time: 12:40 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thông tin chi tiết</title>
</head>
<body>
<button><a href="/sinh-vien/get-all">Home</a></button>
<table style="border: 1px solid;">
    <tr>
        <th>MSSV</th>
        <th>Tên</th>
        <th>Tuổi</th>
        <th>Địa chỉ</th>
        <th>Giới tính</th>
    </tr>
    </thead>
    <tbody>
        <tr>
            <td>${sv.mssv}</td>
            <td>${sv.ten}</td>
            <td>${sv.tuoi}</td>
            <td>${sv.gioiTinh}</td>
            <td>${sv.diaChi}</td>
        </tr>
    </tbody>
</table>
</body>
</html>
