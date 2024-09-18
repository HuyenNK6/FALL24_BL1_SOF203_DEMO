<%--
  Created by IntelliJ IDEA.
  User: Khanh Huyen
  Date: 30/08/2024
  Time: 10:58 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form Đăng nhập</title>
</head>
<body>
    <h1>${message}</h1>
    <%--    Form Control
        @action: địa chỉ URL nhận dữ liệu form khi nhấp nút submit
        @method: hình thức gửi dữ liệu form, có 2 giá trị
             -   GET: Tạo chuỗi truy vấn và đính kèm URL của @action
             -   POST: Mở kênh truyền thông ngầm gửi dữ liệu lên server
    --%>
    <form action="/login" method="post">
        <div class="container">
            <label><b>Username</b></label>
            <input type="text" placeholder="Enter Username" name="usn"required>
            <br/>
            <label><b>Password</b></label>
            <input type="password" placeholder="Enter Password" name="pw" required>
            <br/>
            <input type="checkbox" id="cboxid" name="cb" >
            <label for="cboxid"><b>Remember me?</b></label>
            <br/>
            <button type="submit">Login</button>
        </div>
    </form>
    <h4>${messageResult}</h4>
</body>
</html>
