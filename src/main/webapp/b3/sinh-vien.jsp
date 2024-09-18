
<%--
  Created by IntelliJ IDEA.
  User: Khanh Huyen
  Date: 04/09/2024
  Time: 2:25 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>QL Sinh Viên</title>
</head>
<body>
    <form action="/sinh-vien/search" method="get">
        <label> Tên SV: </label> <input name="ten" placeholder="Nhập tên cần tìm">
        <button type="submit"> Search</button>
    </form>
    <button><a href="/sinh-vien/view-add">Add New Student</a></button>
    <table style="border: 1px solid;">
        <tr>
            <th>STT</th>
            <th>MSSV</th>
            <th>Tên</th>
            <th>Tuổi</th>
            <th>Địa chỉ</th>
            <th>Giới tính</th>
            <th colspan="2"> Action</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${listSV}" var="sv" varStatus="i">
                <tr>
                    <td>${i.index + 1}</td>
                    <td>${sv.mssv}</td>
                    <td>${sv.ten}</td>
                    <td>${sv.tuoi}</td>
                    <td>${sv.gioiTinh}</td>
                    <td>${sv.diaChi}</td>
                    <td>
                        <a href="/sinh-vien/view-detail?mssv=${sv.mssv}">Detail</a>
                        <a href="/sinh-vien/view-update?mssv=${sv.mssv}">Update</a>
                        <a href="/sinh-vien/remove?mssv=${sv.mssv}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>
