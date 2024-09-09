package com.b2.form;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// value => duong dan va bat dau bang dau /. Neu k tomcat k build
// Duong dan giong y de bai
// BE & FE => tang trung gian: controller va trao doi thong qua phuong thuc HTTP.
// Co 4 loai HTTP Methods co ban:
// GET : Lay ra , Hien thi <=> READ
// POST : Add nha <=> CREATE
// PUT : Update
// DELETE : DELETE
// J4, J5: Chi lam viec vs 2 loai get , post
// Get: Lay ra, hien thi
// Post: Xu ly

//value = {"/home/login", "/ket-qua"}: Đây là một mảng các URL patterns mà servlet này sẽ xử lý.
// Khi người dùng truy cập vào một trong các URL này, servlet loginServlet sẽ được gọi để xử lý yêu cầu.
@WebServlet (name = "loginServlet", value = {"/home/login", "/ket-qua"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Truyền giá trị của 1 biến từ servlet sang jsp => set Attribute
        String message = "HuyenNK6";
        req.setAttribute("message",message);
        //Chuyển trang
        //cách 1:
        req.getRequestDispatcher("/b2/form.jsp").forward(req,resp);
        //cách 2:
        //resp.sendRedirect("/b2/form.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Bước 1: lấy dữ liệu từ jsp về servlet => get Parameter
        //=> lấy thông tin qua name
        String username= req.getParameter("usn");
        String password= req.getParameter("pw");

        //Bước 2: truyền dữ liệu từ servlet => jsp
        req.setAttribute("username",username);
        req.setAttribute("password",password);
        req.getRequestDispatcher("/b2/ket-qua.jsp").forward(req,resp);
    }
//Cách hoạt động:
//Khi người dùng truy cập vào .../home/login,
// => phương thức doGet trong LoginServlet sẽ được gọi, và trang login sẽ được trả về.
//Khi người dùng truy cập vào .../ket-qua,
// => phương thức doGet cũng sẽ được gọi, nhưng lần này trang kết quả sẽ được trả về.
}
