package com.b3.listfixcung.service;

import com.b3.listfixcung.entity.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class SinhVienService {
    private List<SinhVien> listSinhVien = new ArrayList<>();

    public SinhVienService() {
        listSinhVien.add(new SinhVien("1230", "Hang", 17, false, "HN"));
        listSinhVien.add(new SinhVien("1234", "Ngan", 17, false, "HN"));
        listSinhVien.add(new SinhVien("1235", "Phong", 18, true, "HN"));
        listSinhVien.add(new SinhVien("1236", "Nguyen", 19, true, "HN"));
        listSinhVien.add(new SinhVien("1237", "Tien", 20, true, "HN"));
        listSinhVien.add(new SinhVien("1238", "Dung", 21, true, "HN"));
        listSinhVien.add(new SinhVien("1239", "Khanh", 22, true, "HN"));
    }

    public List<SinhVien> getAllListSinhVien() {
        return listSinhVien;
    }

    public SinhVien searchSinhVienByMSSV(String mssv) {
        //gõ nhanh foreach: iter + tab (Iterable)
        for (SinhVien sinhVien : listSinhVien) {
            if (sinhVien.getMssv().equalsIgnoreCase(mssv)) {
                return sinhVien;
            }
        }
        return null;
    }
    public List<SinhVien>  searchSinhVienByName(String ten) {
        List<SinhVien> listResults= new ArrayList<>();
        //gõ nhanh foreach: iter + tab (Iterable)
        for (SinhVien sinhVien : listSinhVien) {
            sinhVien.toString();
            if (sinhVien.getTen().contains(ten)) {
                listResults.add(sinhVien);
                System.out.println("đã tìm thấy" + sinhVien.getTen());
            }
        }
        return listResults;
    }

    public void addSinhVien(SinhVien sv) {
        listSinhVien.add(sv);
    }

    public void updateSinhVien(SinhVien sv) {
        for (SinhVien sinhVien : listSinhVien) {
            if (sinhVien.getMssv().equalsIgnoreCase(sv.getMssv())) {
                sinhVien.setTen(sv.getTen());
                sinhVien.setTuoi(sv.getTuoi());
                sinhVien.setGioiTinh(sv.isGioiTinh());
                sinhVien.setDiaChi(sv.getDiaChi());
                break;
            }
        }
    }
    
    public void removeSinhVien(String mssv) {
        for (SinhVien sinhVien : listSinhVien) {
            if(sinhVien.getMssv().equalsIgnoreCase(mssv)){
                listSinhVien.remove(sinhVien);
                break;
            }
        }
    }
}
