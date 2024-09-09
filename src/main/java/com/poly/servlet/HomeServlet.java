package com.poly.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "homeServlet", value = "/home/index")
public class HomeServlet extends HttpServlet {
    /* TẠO NHANH PHƯƠNG THỨC doGet và doPost:
   - Cách 1:
        Chọn Override Methods: Một danh sách các phương thức có thể override sẽ hiện ra.
        Chọn doGet và doPost: Tìm và chọn doGet và doPost, sau đó nhấn OK
   - Cách 2:
        Gõ get và nhấn Tab sẽ tạo ra phương thức doGet.
        Gõ post và nhấn Tab sẽ tạo ra phương thức doPost.
        IntelliJ sẽ tự động sinh mã phương thức doGet và doPost
     */
    /* QUY TRÌNH XỬ LÝ REQUEST
        Web Browser: http://localhost:8080/.../home/index ---gửi request đến----> Servlet
        HomeServlet.java: sẽ chuyển req ---forward() đến ----> index.jsp <=> Web Server
        JSP- html gửi response về Web Browser
     */
    /* TRUYỀN DỮ LIỆU TỪ SERVLET SANG JSP
    - Servlet sẽ nhận và xử lý yêu cầu của từ người sử dụng,tương tác CSDL…
    - JSP đóng vai trò tạo giao diện (HTML, CSS, JS…) để phản hồi người sử dụng
    - JSP cần dữ liệu chia sẻ từ kết quả xử lý của Servlet để sinh giao diện phù hợp
     */
    /*
    POST và GET là 2 phương pháp truyền dữ liệu từ trình duyệt đến server.
    Khi submit form với
    Method=“GET” thì dữ liệu form được thu thập và tạo thành chuỗi truy vấn (ghép vào sau dấu ? của url) để gửi đến server
    Method=“POST” thì trình duyệt sẽ tạo một kênh riêng để truyền dữ liệu đến server

     */
    /*
    Servlet là một lớp kế thừa từ HttpServlet được Sun cung cấp sẵn
    Override phương thức dịch vụ (service(), doGet(), doPost()) để xử lý yêu cầu từ người dùng. Trong đó
        doGet(): Xử lý GET request
        doPost(): Xử lý POST request (submit form với method là POST)
        service(): Xử lý cả 2 loại request (khi override phương thức này thì doGet() và doPost() bị vô hiệu hóa).
     */
    /* CHIA SẺ DỮ LIỆU
    - Servlet sẽ đặt dữ liệu vào request trước khi chuyển tiếp sang JSP.
            HttpServletRequest.setAttribute(name, Object)
        + setAttribute là một phương thức được sử dụng trong Java Servlet để lưu trữ một đối tượng dưới dạng thuộc tính (attribute)
        + name: Tên của thuộc tính. Đây là một chuỗi định danh duy nhất để truy cập thuộc tính đó.
        + Object: Giá trị của thuộc tính, có thể là bất kỳ đối tượng Java nào.
    - JSP lấy và hiển thị: ${name}
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        //part 1:
        req.setAttribute("message","Xin chào cả lớp");

        //part 2:
        List<String> lstNames= new ArrayList<>();
        lstNames.add("Hang");
        lstNames.add("Ngan");

        req.setAttribute("lstNames", lstNames);
        req.getRequestDispatcher("/views/index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
