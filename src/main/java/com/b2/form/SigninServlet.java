package com.b2.form;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

@MultipartConfig
@WebServlet (name = "signinServlet", value = {"/home/signin", "/ket-qua-sign-in"})
public class SigninServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/b2/signin.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String hoTen = req.getParameter("hoTen");
        String ngaySinh= req.getParameter("ngaySinh");
        LocalDate dateOfBirth= LocalDate.parse(ngaySinh);
        String sdt= req.getParameter("sdt");
        String gioiTinh= req.getParameter("gioiTinh");
        String diaChi= req.getParameter("diaChi");
        String quocGia= req.getParameter("quocGia");
        String[] monHocs= req.getParameterValues("monHoc");
        String[] soThichs= req.getParameterValues("soThich");


//        Set Attribute
        req.setAttribute("hoTen",hoTen);
        req.setAttribute("dateOfBirth",dateOfBirth);
        req.setAttribute("sdt",sdt);
        req.setAttribute("gioiTinh",gioiTinh);
        req.setAttribute("diaChi",diaChi);
        req.setAttribute("quocGia",quocGia);
        req.setAttribute("monHocs",monHocs);
        req.setAttribute("soThichs",soThichs);

        Part part= req.getPart("photo");
        String realPath= req.getServletContext().getRealPath("/uploads");
        String fileName= Paths.get(part.getSubmittedFileName()).getFileName().toString();

        if(!Files.exists(Paths.get(realPath))){
            Files.createDirectory(Paths.get(realPath));
        }
        part.write(realPath+"/"+fileName);
//        try (PrintWriter out = resp.getWriter()){
//            out.println("<img src= 'uploads/"+fileName+"'>");
//        }catch (Exception e){
//
//        }

        // Đặt tên file như một thuộc tính và chuyển hướng đến JSP
        req.setAttribute("fileName", fileName);


        req.getRequestDispatcher("/b2/ket-qua-sign-in.jsp").forward(req,resp);
    }
}
