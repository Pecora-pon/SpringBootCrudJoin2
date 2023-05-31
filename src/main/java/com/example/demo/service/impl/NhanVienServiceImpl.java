package com.example.demo.service.impl;

import com.example.demo.entity.NhanVien;
import com.example.demo.repository.NhanVienRepository;
import com.example.demo.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class NhanVienServiceImpl implements NhanVienService {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Override
    public List<NhanVien> getAll() {
        return nhanVienRepository.findAll();
    }

    @Override
    public NhanVien add(NhanVien nhanVien) {
        return nhanVienRepository.save(nhanVien);
    }

    @Override
    public NhanVien update(UUID id, NhanVien nhanVien) {
        NhanVien nhanVien1 = detail(id);
        if(nhanVien1 != null){
            nhanVien1.setMa(nhanVien.getMa());
            nhanVien1.setTen(nhanVien.getTen());
            nhanVien1.setTenDem(nhanVien.getTenDem());
            nhanVien1.setHo(nhanVien.getHo());
            nhanVien1.setGioiTinh(nhanVien.getGioiTinh());
            nhanVien1.setNgaySinh(nhanVien.getNgaySinh());
            nhanVien1.setSdt(nhanVien.getSdt());
            nhanVien1.setMatKhau(nhanVien.getMatKhau());
            nhanVien1.setCuaHang(nhanVien.getCuaHang());
            nhanVien1.setChucVu(nhanVien.getChucVu());
            nhanVienRepository.save(nhanVien);
        }
        return null;

    }

    @Override
    public void delete(UUID id) {
        nhanVienRepository.deleteById(id);
    }

    @Override
    public NhanVien detail(UUID id) {
        return nhanVienRepository.findById(id).orElse(null);
    }

    @Override
    public Page<NhanVien> getNhanVien(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        return nhanVienRepository.findAll(pageable);
    }
}
