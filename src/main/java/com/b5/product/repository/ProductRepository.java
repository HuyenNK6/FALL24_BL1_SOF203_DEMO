package com.b5.product.repository;

import com.b5.product.entity.Category;
import com.b5.product.entity.Product;
import com.b5.product.util.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    public ArrayList<Product> getAll() {
        ArrayList<Product> listProducts = new ArrayList<>();

        String sql = """
                SELECT dbo.category.id, dbo.category.category_code, dbo.category.category_name, 
                dbo.product.id AS Expr1, dbo.product.category_id, dbo.product.product_code, dbo.product.product_name, dbo.product.price, dbo.product.description
                FROM     dbo.category INNER JOIN
                dbo.product ON dbo.category.id = dbo.product.category_id
                 """;

        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            //table => kiểu dữ liệu ResultSet
            ResultSet rs = ps.executeQuery();
            //Khi kiểu dữ liệu trả về là 1 bảng => executeQuery
            while (rs.next()) {//kiểm tra xem còn có dòng để đọc tiếp ko
                //B4: Tạo đối tượng GV
                Category category = new Category();
                category.setId(rs.getInt(1));
                category.setCode(rs.getString(2));
                category.setName(rs.getString(3));
                Product product = new Product();
                product.setId(rs.getInt(4));
                product.setCategory(category);
                product.setCode(rs.getString(6));
                product.setName(rs.getString(7));
                product.setPrice(rs.getFloat(8));
                product.setDescription(rs.getString(9));

                //B6: thêm đối tượng vào danh sách
                listProducts.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listProducts;
    }

    public static void main(String[] args) {
        ProductRepository rep= new ProductRepository();
        List<Product> list= rep.getAll();
        for (Product product : list) {
            System.out.println(product.toString());
        }
    }

}
