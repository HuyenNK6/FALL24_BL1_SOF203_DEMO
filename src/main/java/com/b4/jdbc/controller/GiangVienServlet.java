package com.b4.jdbc.controller;

import com.b4.jdbc.entity.GiangVien;
import com.b4.jdbc.repository.GiangVienRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "giangVienServlet", value = "/hien-thi")
public class GiangVienServlet extends HttpServlet {

    private GiangVienRepository gvRep= new GiangVienRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listGVs", gvRep.getAll());
        req.getRequestDispatcher("/b4/hien-thi.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
