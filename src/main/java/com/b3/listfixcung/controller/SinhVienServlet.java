package com.b3.listfixcung.controller;

import com.b3.listfixcung.entity.SinhVien;
import com.b3.listfixcung.service.SinhVienService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SinhVienServlet", value = {
        "/sinh-vien/get-all",   // GET
        "/sinh-vien/search",    // GET
        "/sinh-vien/view-detail",    // GET
        "/sinh-vien/remove",    // GET
        "/sinh-vien/view-add",    // GET
        "/sinh-vien/view-update",    // GET
        "/sinh-vien/add",   // POST
        "/sinh-vien/update"  // POST
})
public class SinhVienServlet extends HttpServlet {
    private SinhVienService service= new SinhVienService();
    private List<SinhVien> listSV= new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //B1: Lấy uri từ đường dẫn
        String uri = req.getRequestURI();
        if(uri.contains("get-all")){
            this.getAll(req,resp);
        }else if(uri.contains("search")){
            this.search(req,resp);
        }else if(uri.contains("detail")){
            this.viewDetail(req,resp);
        }else if(uri.contains("remove")){
            this.remove(req,resp);
        }else if(uri.contains("view-update")){
            this.viewUpdate(req,resp);
        }else if(uri.contains("view-add")){
            this.viewAdd(req,resp);
        }else{
            this.getAll(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("update")){
            this.update(req,resp);
        }else{
            this.add(req,resp);
        }

    }
    private void getAll (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        listSV = service.getAllListSinhVien();
        req.setAttribute("listSV", listSV);
        req.getRequestDispatcher("/b3/sinh-vien.jsp").forward(req,resp);

    }
    private void viewDetail (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mssv= req.getParameter("mssv");
        SinhVien sv= service.searchSinhVienByMSSV(mssv);
        req.setAttribute("sv",sv);
        req.getRequestDispatcher("/b3/detail-sinh-vien.jsp").forward(req,resp);
    }
    private void viewAdd (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/b3/add-sinh-vien.jsp").forward(req,resp);
    }
    @SneakyThrows
    private void add (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //B1: lấy dữ liệu từ view => servlet
//        String mssv= req.getParameter("mssv");
//        String ten= req.getParameter("ten");
//        String tuoi= req.getParameter("tuoi");
//        String diaChi= req.getParameter("diaChi");
//        String gioiTinh= req.getParameter("gioiTinh");
//
//        //B2: Khởi tạo đối tượng
//        SinhVien sv= new SinhVien(mssv,ten,
//                Integer.valueOf(tuoi),
//                Boolean.valueOf(gioiTinh), diaChi);
//        //B3: Gọi service
//        service.addSinhVien(sv);
//        //B4: Quay lại trang chủ
//        //get lại list
//        listSV= service.getAllListSinhVien();
//        req.setAttribute("listSV", listSV);
//        req.getRequestDispatcher("/b3/sinh-vien.jsp").forward(req,resp);
        /////////////////////////////////////////
        //Cách 2: BeanUtils
        SinhVien sv= new SinhVien();
        //add anotation @SneakyThrows
        BeanUtils.populate(sv, req.getParameterMap());
        service.addSinhVien(sv);
        resp.sendRedirect("/b3/sinh-vien.jsp");

    }
    private void viewUpdate (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mssvUpdate= req.getParameter("mssv");
        SinhVien svUpdate= service.searchSinhVienByMSSV(mssvUpdate);
        req.setAttribute("svUpdate",svUpdate);
        req.getRequestDispatcher("/b3/update-sinh-vien.jsp").forward(req,resp);
    }
    private void update (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //B1: lấy dữ liệu từ view => servlet
        String mssv= req.getParameter("mssv");
        String ten= req.getParameter("ten");
        String tuoi= req.getParameter("tuoi");
        String diaChi= req.getParameter("diaChi");
        String gioiTinh= req.getParameter("gioiTinh");

        //B2: Khởi tạo đối tượng
        SinhVien sv= new SinhVien(mssv,ten,
                Integer.valueOf(tuoi),
                Boolean.valueOf(gioiTinh), diaChi);
        //B3: Gọi service
        service.updateSinhVien(sv);
        //B4: Quay lại trang chủ
        //get lại list
        listSV= service.getAllListSinhVien();
        req.setAttribute("listSV", listSV);
        req.getRequestDispatcher("/b3/sinh-vien.jsp").forward(req,resp);

    }

    private void remove (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mssvRemove= req.getParameter("mssv");
        service.removeSinhVien(mssvRemove);
        //get lại list
        listSV= service.getAllListSinhVien();
        req.setAttribute("listSV", listSV);
        req.getRequestDispatcher("/b3/sinh-vien.jsp").forward(req,resp);
    }
    private void search (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ten= req.getParameter("ten");
        List<SinhVien> listSV= service.searchSinhVienByName(ten);
        System.out.println(listSV.size());
        req.setAttribute("listSV",listSV);
        req.getRequestDispatcher("/b3/sinh-vien.jsp").forward(req,resp);
    }
}
