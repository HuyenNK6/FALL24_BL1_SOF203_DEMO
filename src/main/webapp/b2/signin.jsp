<%--
  Created by IntelliJ IDEA.
  User: Khanh Huyen
  Date: 01/09/2024
  Time: 2:25 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Form Đăng Ký</h1>
    <%--  enctype="multipart/form-data":  dùng để chỉ định cách dữ liệu trong biểu mẫu sẽ được mã hóa (encoded) khi gửi đến máy chủ--%>
    <form action="/ket-qua-sign-in" method="post" enctype="multipart/form-data">
        <div class="container">
            <label>Họ và tên: </label>
            <input type="text" placeholder="Nhập họ và tên" name="hoTen" required>  <br/>
            <label>Ngày sinh: </label>
            <input type="date" placeholder="Nhập ngày sinh" name="ngaySinh" required>  <br/>
            <label>Số điện thoại: </label>
            <input type="tel" placeholder="Nhập số điện thoại" name="sdt" pattern="[0-9]{10}" required>  <br/>
            <%--Radio Button--%>
            <input type="radio" name="gioiTinh" value="nam" id="male" checked >
            <label for="male">Nam </label> <br/>
             <input type="radio" name="gioiTinh" value="nu" id="female"  >
            <label for="female">Nữ </label> <br/>
            <label> Địa chỉ: </label>
            <textarea name="diachi" rows="5" cols="40"></textarea><br/>
            <%-- Combobox--%>
            <label for="country">Chọn quốc gia:</label>
            <select name="quocGia" id="country">
                <option value="VN">Việt Nam</option>
                <option value="TQ">Trung Quốc</option>
                <option value="NB">Nhật Bản</option>
                <option value="HQ"Hàn Quốc</option>
            </select><br/>
            <%-- List Box--%>
            <label for="subject">Chọn Môn học:</label>
            <select name="monHoc" id="subject" size="5" multiple>
                <option value="toan">Toán</option>
                <option value="van">Văn</option>
                <option value="anh">Anh</option>
            </select><br/>
            <%-- List CheckBox--%>
            <input type="checkbox" id="hobby1" name="soThich" value="reading">
            <label for="hobby1"> Đọc sách </label> <br/>
            <input type="checkbox" id="hobby2" name="soThich" value="traveling">
            <label for="hobby2"> Du lịch </label> <br/>
            <input type="checkbox" id="hobby3" name="soThich" value="music">
            <label for="hobby3"> Nghe nhạc </label> <br/>

            <label> Ảnh đại diện </label> <br/>
            <input type="file" name="photo" ><br/>

            <button type="submit">Đăng Ký</button>
        </div>
    </form>
</body>
</html>
