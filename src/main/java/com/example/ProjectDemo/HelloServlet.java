package com.example.ProjectDemo;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
//Đây là một annotation được sử dụng để định nghĩa một servlet trong ứng dụng Java web.
@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");

        // Lấy các thông tin từ URL
        String url = request.getRequestURL().toString();
        //queryString là một phần của URL chứa các tham số được gửi đến máy chủ trong một yêu cầu HTTP.
        //// Nó thường xuất hiện sau dấu chấm hỏi ? trong URL và bao gồm các cặp khóa-giá trị, mỗi cặp được ngăn cách bởi dấu &.
        String queryString = request.getQueryString();
        String protocol = request.getProtocol();
        String method = request.getMethod();
        String contextPath = request.getContextPath();
        String servletPath = request.getServletPath();

        System.out.println("Thông tin URL");
        System.out.println(url);
        System.out.println(queryString);
        System.out.println(protocol);
        System.out.println(method);
        System.out.println(contextPath);
        System.out.println(servletPath);
    }

    public void destroy() {
    }
}