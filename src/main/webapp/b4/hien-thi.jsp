<%--
  Created by IntelliJ IDEA.
  User: Huyen
  Date: 9/16/2024
  Time: 1:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/giang-vien/search" method="get">
    <label> Tên gv: </label> <input name="ten" placeholder="Nhập tên cần tìm">
    <button type="submit"> Search</button>
</form>
<button><a href="/giang-vien/view-add">Add New Teacher</a></button>
<table style="border: 1px solid;">
    <tr>
        <th>STT</th>
        <th>Mã GV</th>
        <th>Tên</th>
        <th>Tuổi</th>
        <th>Loại</th>
        <th>Bậc</th>
        <th>Giới tính</th>
        <th colspan="2"> Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listGVs}" var="gv" varStatus="i">
        <tr>
            <td>${i.index + 1}</td>
            <td>${gv.maGV}</td>
            <td>${gv.ten}</td>
            <td>${gv.tuoi}</td>
            <td>${gv.loai}</td>
            <td>${gv.bac}</td>
            <td>${gv.gioiTinh}</td>
            <td>
                <a href="/giang-vien/view-detail?msgv=${gv.maGV}">Detail</a>
                <a href="/giang-vien/view-update?msgv=${gv.maGV}">Update</a>
                <a href="/giang-vien/remove?msgv=${gv.maGV}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
