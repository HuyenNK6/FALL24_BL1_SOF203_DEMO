<%@ page import="com.b3.listphantrang.entity.TraSua" %><%--
  Created by IntelliJ IDEA.
  User: Huyen
  Date: 9/22/2024
  Time: 7:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/tra-sua/tim-kiem" method="get">
        <label> Tên thương hiệu: </label> <input name="ten" placeholder="Nhập tên cần tìm">
        <button type="submit"> Search</button>
    </form>
    <%
        TraSua ts = (TraSua) request.getAttribute("ts");
        String selectedThuongHieu = "TocoToco";
        if(ts != null){
             selectedThuongHieu = ts.getThuongHieu();
        }
    %>
    <form action="/tra-sua/hien-thi" method="post">
        <label>Mã: </label>
        <input type="text" name="ma" value="${ts.ma}" required> </br>
        <label>Vị: </label>
        <input type="text" name="vi" value="${ts.vi}" required> </br>
        <label>Giá: </label>
        <input type="text" name="gia" value="${ts.gia}" required> </br>
        <label>Size: </label>
        <input type="text" name="size" value="${ts.size}" required> </br>
        <label>Thương hiệu: </label>
<%--        <input type="text" name="thuongHieu" value="${ts.thuongHieu}" required> </br>--%>
<%--        Thẻ <%= %> trong JSP được gọi là Expression Tag (Thẻ biểu thức).
Thẻ này cho phép bạn chèn và hiển thị trực tiếp giá trị của một biểu thức Java vào trong nội dung HTML của trang JSP.
Các biểu thức này sẽ được đánh giá và kết quả của chúng sẽ được chèn vào vị trí của thẻ trong HTML.--%>
        <select name="thuongHieu" id="thuongHieu">
            <option value="TocoToco" <%= "TocoToco".equals(selectedThuongHieu) ? "selected" : "" %>>TocoToco</option>
            <option value="DingTea" <%= "DingTea".equals(selectedThuongHieu) ? "selected" : "" %>>DingTea</option>
            <option value="Highland" <%= "Highland".equals(selectedThuongHieu) ? "selected" : "" %>>Highland</option>
            <option value="Mixue" <%= "Mixue".equals(selectedThuongHieu) ? "selected" : "" %>>Mixue</option>
            <option value="The Coffee House" <%= "The Coffee House".equals(selectedThuongHieu) ? "selected" : "" %>>The Coffee House</option>
        </select>
        <button type="submit" name="action" value="add">Add</button>
        <button type="submit" name="action" value="update">Update</button>
    </form>

    <table style="border: 1px solid;">
    <tr>
        <th>STT</th>
        <th>Ma</th>
        <th>Vị</th>
        <th>Giá</th>
        <th>Size</th>
        <th>Thương hiệu</th>
        <th colspan="2"> Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listTS}" var="ts" varStatus="i">
        <tr>
            <td>${i.index + 1}</td>
            <td>${ts.ma}</td>
            <td>${ts.vi}</td>
            <td>${ts.gia}</td>
            <td>${ts.size}</td>
            <td>${ts.thuongHieu}</td>
            <td>
                <a href="/tra-sua/chi-tiet?ma=${ts.ma}">Detail</a>
                <a href="/tra-sua/xoa?ma=${ts.ma}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
