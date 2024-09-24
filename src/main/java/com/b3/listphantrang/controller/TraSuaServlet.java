package com.b3.listphantrang.controller;

import com.b3.listfixcung.entity.SinhVien;
import com.b3.listphantrang.entity.TraSua;
import com.b3.listphantrang.service.TraSuaService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "traSuaServlet", value = {
                                    "/tra-sua/hien-thi",
                                    "/tra-sua/tim-kiem",
                                    "/tra-sua/chi-tiet",
                                    "/tra-sua/xoa",
})
public class TraSuaServlet extends HttpServlet {
    TraSuaService service= new TraSuaService();
    List<TraSua> listTS= new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//B1: Lấy uri từ đường dẫn
        String uri = req.getRequestURI();
        if(uri.contains("hien-thi")){
            this.getAll(req,resp);
        }else if(uri.contains("tim-kiem")){
           // this.search(req,resp);
        }else if(uri.contains("chi-tiet")){
            this.chiTiet(req,resp);
        }else if(uri.contains("xoa")){
            this.xoa(req,resp);
        }else{
            this.getAll(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Lấy giá trị của button từ thuộc tính name="action"
        String action = req.getParameter("action");

        if (action.equals("add")) {
            // Xử lý logic khi người dùng nhấn nút Add
            this.add(req,resp);
        } else if ("update".equals(action)) {
            // Xử lý logic khi người dùng nhấn nút Update
            this.update(req,resp);
        }
    }
    protected void getAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        listTS = service.getAll();
        req.setAttribute("listTS",listTS);
        req.getRequestDispatcher("/b32/hien-thi.jsp").forward(req,resp);
    }

    private void add (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //B1: lấy dữ liệu từ view => servlet
        String ma= req.getParameter("ma");
        String vi= req.getParameter("vi");
        String gia= req.getParameter("gia");
        String size= req.getParameter("size");
        String thuongHieu= req.getParameter("thuongHieu");

        //B2: Khởi tạo đối tượng sử dụng Builder
        /*
        TraSua.builder():
            Phương thức này được Lombok tự động tạo ra nhờ annotation @Builder.
            Nó trả về một đối tượng của lớp TraSua.TraSuaBuilder, đây là lớp nội bộ được Lombok tạo ra để hỗ trợ việc xây dựng đối tượng TraSua.
            Lombok sẽ tự động tạo ra các phương thức setter cho từng thuộc tính, nhưng không đặt tên theo quy ước setAttribute(), mà dùng chính tên thuộc tính.
            Ví dụ, thay vì gọi setMa(), bạn gọi trực tiếp ma().
        .ma("giá trị"): Đây là phương thức setter do Lombok tạo ra để gán giá trị cho thuộc tính mã
        .build():
            Phương thức build() được tự động tạo ra bởi Lombok và có nhiệm vụ tạo ra đối tượng TraSua hoàn chỉnh với tất cả các thuộc tính đã được cấu hình trước đó (trong các bước gọi setter).
            Sau khi build() được gọi, một đối tượng TraSua sẽ được trả về.
         */
        TraSua ts= TraSua.builder()
                .ma(ma)
                .vi(vi)
                .gia(Integer.valueOf(gia))
                .size(size.charAt(0))
                .thuongHieu(thuongHieu)
                .build();
        //B3: Gọi service
        service.addTS(ts);
        //B4: Quay lại trang chủ
        //get lại list
        listTS= service.getAll();
        req.setAttribute("listTS", listTS);
        req.getRequestDispatcher("/b32/hien-thi.jsp").forward(req,resp);

    }
    private void update (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //B1: lấy dữ liệu từ view => servlet
        String ma= req.getParameter("ma");
        String vi= req.getParameter("vi");
        String gia= req.getParameter("gia");
        String size= req.getParameter("size");
        String thuongHieu= req.getParameter("thuongHieu");

        //B2: Khởi tạo đối tượng
        TraSua ts= TraSua.builder()
                .ma(ma)
                .vi(vi)
                .gia(Integer.valueOf(gia))
                .size(size.charAt(0))
                .thuongHieu(thuongHieu)
                .build();
        //B3: Gọi service
        service.updateTS(ts);
        //B4: Quay lại trang chủ
        //get lại list
        listTS= service.getAll();
        req.setAttribute("listTS", listTS);
        req.getRequestDispatcher("/b32/hien-thi.jsp").forward(req,resp);

    }
    private void chiTiet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ma= req.getParameter("ma");
        TraSua ts= service.searchTraSuaByMa(ma);
        req.setAttribute("ts",ts);

        listTS= service.getAll();
        req.setAttribute("listTS", listTS);
        req.getRequestDispatcher("/b32/hien-thi.jsp").forward(req,resp);
    }
    private void xoa (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ma= req.getParameter("ma");
        service.removeTS(ma);

        listTS= service.getAll();
        req.setAttribute("listTS", listTS);
        req.getRequestDispatcher("/b32/hien-thi.jsp").forward(req,resp);
    }
}
