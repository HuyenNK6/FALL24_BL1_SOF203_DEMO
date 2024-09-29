package com.b4.jdbc.repository;

import com.b4.jdbc.entity.GiangVien;
import com.b4.jdbc.util.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
    public ArrayList<GiangVien> getAll() {
        //B1: Viết câu SQL
        String sql = " SELECT ma, ten, loai, tuoi, bac, gioi_tinh  FROM QLGV.dbo.giang_vien;";

        //B2: Mở cổng kết nối => xảy ra ngoại lệ => ném vào try-catch
            /*
                try(những đối tượng nào cần kế nối){

                }catch(tên lỗi){
                    //ngoại lệ
                }
             */
        //B3: tạo ArrayList
        ArrayList<GiangVien> listGVs = new ArrayList<>();
        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            //table => kiểu dữ liệu ResultSet
            ResultSet rs = ps.executeQuery();
            //Khi kiểu dữ liệu trả về là 1 bảng => executeQuery
            while (rs.next()) {//kiểm tra xem còn có dòng để đọc tiếp ko
                //B4: Tạo đối tượng GV
                GiangVien gv = new GiangVien();
                gv.setMaGV(rs.getString(1));
                gv.setTen(rs.getString(2));
                gv.setLoai(rs.getString(3));
                gv.setTuoi(rs.getInt(4));
                gv.setBac(rs.getInt(5));
                gv.setGioiTinh(rs.getBoolean(6));
                //B6: thêm đối tượng vào danh sách
                listGVs.add(gv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listGVs;
    }

    public GiangVien getOne(String ma) {
        //B1: Viết câu SQL
        String sql = "SELECT ma, ten, loai, tuoi, bac, gioi_tinh\n" +
                "FROM     dbo.giang_vien\n" +
                "WHERE ma = ?";

        //B2: Mở cổng kết nối => xảy ra ngoại lệ => ném vào try-catch

        //B3: tạo ArrayList
        GiangVien gv = new GiangVien();
        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ma);
            //table => kiểu dữ liệu ResultSet
            ResultSet rs = ps.executeQuery();
            //Khi kiểu dữ liệu trả về là 1 bảng => executeQuery
            if (rs.next()) {//kiểm tra xem còn có dòng để đọc tiếp ko
                //B4: Tạo đối tượng GV
//                    GiangVien gv= new GiangVien();
                gv.setMaGV(rs.getString(1));
                gv.setTen(rs.getString(2));
                gv.setLoai(rs.getString(3));
                gv.setTuoi(rs.getInt(4));
                gv.setBac(rs.getInt(5));
                gv.setGioiTinh(rs.getBoolean(6));

                return gv;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
/*
- Select => trả về 1 bảng, có thể có 1 hoặc nhiều dòng
=> lấy dc 1 list hoặc 1 đối tượng
- Insert/update/delete => trả về 1 dòng thông báo (1 row thành công hoặc 0 row)
 */
    public Boolean add(GiangVien gv) {
        int check = 0;
        String sql = "INSERT INTO [dbo].[giang_vien]\n" +
                "           ([ma]\n" +
                "           ,[ten]\n" +
                "           ,[loai]\n" +
                "           ,[tuoi]\n" +
                "           ,[bac]\n" +
                "           ,[gioi_tinh])\n" +
                "     VALUES\n" +
                "           (?,?,?,?,?,?)";
        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setObject(1, gv.getMaGV());
            ps.setObject(2, gv.getTen());
            ps.setObject(3, gv.getLoai());
            ps.setObject(4, gv.getTuoi());
            ps.setObject(5, gv.getBac());
            ps.setObject(6, gv.isGioiTinh());

            check =ps.executeUpdate();// thực hiện truy vấn
        } catch (Exception e) {
            e.printStackTrace();
        }

        return check > 0;
    }
    public Boolean update(GiangVien gv, String maUpdate) {
        int check = 0;
        String sql = "UPDATE [dbo].[giang_vien]\n" +
                "   SET [ten] = ?\n" +
                "      ,[loai] = ?\n" +
                "      ,[tuoi] = ?\n" +
                "      ,[bac] = ?\n" +
                "      ,[gioi_tinh] = ?\n" +
                " WHERE [ma] = ?";
        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setObject(1, gv.getTen());
            ps.setObject(2, gv.getLoai());
            ps.setObject(3, gv.getTuoi());
            ps.setObject(4, gv.getBac());
            ps.setObject(5, gv.isGioiTinh());
            ps.setObject(6, maUpdate);

            check =ps.executeUpdate();// thực hiện truy vấn
        } catch (Exception e) {
            e.printStackTrace();
        }

        return check > 0;
    }
    public Boolean delete( String maGV) {
        int check = 0;
        String sql = "DELETE FROM [dbo].[giang_vien]"+
                " WHERE [ma] = ?";
        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setObject(1, maGV);

            check =ps.executeUpdate();// thực hiện truy vấn
        } catch (Exception e) {
            e.printStackTrace();
        }

        return check > 0;
    }

    public static void main(String[] args) {
        GiangVienRepository rep= new GiangVienRepository();
        GiangVien gv = rep.getOne("HangNT169");
        System.out.println(gv.toString());
        Boolean checkAdd= rep.add(new GiangVien("HuyenNK6","Khanh Huyen","Loai 2",18,1,false));
        System.out.println(checkAdd);
        List<GiangVien> list= rep.getAll();
        for (GiangVien giangVien : list) {
            System.out.println(giangVien.toString());
        }
        Boolean checkUp= rep.update(new GiangVien("HuyenNK6","Khanh Huyen","Loai 2",18,2,false),"HuyenNK6");
        System.out.println(checkUp);
        List<GiangVien> list2= rep.getAll();
        for (GiangVien giangVien : list2) {
            System.out.println(giangVien.toString());
        }
        Boolean checkDel= rep.delete("HuyenNK6");
        System.out.println(checkDel);
        List<GiangVien> list3= rep.getAll();
        for (GiangVien giangVien : list3) {
            System.out.println(giangVien.toString());
        }
    }
}
