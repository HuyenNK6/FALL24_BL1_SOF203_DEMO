package com.b4.jdbc.repository;

import com.b4.jdbc.entity.GiangVien;
import com.b4.jdbc.util.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class GiangVienRepository {
    /* repository là tầng trao đổi trực tiếp với CSDL
    // CRUD:
    C: CREATE <=> INSERT INTO
    R: READ <=> SELECT => excute Query => 1 danh sach
    U: UPDATE <=> UPDATE => excuteUpdate => Tra ra so dong thuc hien thanh cong
    D: DELETE <=> DELETE

    // SELECT => 1 table

     */
    // GET ALL => Hiển thị tất cả
        public ArrayList<GiangVien> getAll(){
            //B1: Viết câu SQL
            String sql= " SELECT ma, ten, loai, tuoi, bac, gioi_tinh  FROM QLGV.dbo.giang_vien;";
            //B2: Mở cổng kết nối => xảy ra ngoại lệ => ném vào try-catch
            /*
                try(những đối tượng nào cần kế nối){

                }catch(tên lỗi){
                    //ngoại lệ
                }
             */
            //B3: tạo ArrayList
            ArrayList<GiangVien> listGVs= new ArrayList<>();
            try (Connection con= DBConnect.getConnection();
                 PreparedStatement ps= con.prepareStatement(sql)){
                //table => kiểu dữ liệu ResultSet
                ResultSet rs= ps.executeQuery();
                //Khi kiểu dữ liệu trả về là 1 bảng => executeQuery
                while (rs.next()){//kiểm tra xem còn có dòng để đọc tiếp ko
                    //B4: Tạo đối tượng GV
                    GiangVien gv= new GiangVien();
                    gv.setMaGV(rs.getString(1));
                    gv.setTen(rs.getString(2));
                    gv.setLoai(rs.getString(3));
                    gv.setTuoi(rs.getInt(4));
                    gv.setBac(rs.getInt(5));
                    gv.setGioiTinh(rs.getBoolean(6));
                    //B6: thêm đối tượng vào danh sách
                    System.out.println(gv.toString());
                    listGVs.add(gv);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            return listGVs;
        }

}
