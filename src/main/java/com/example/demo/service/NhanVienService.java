package com.example.demo.service;

import com.example.demo.entity.NhanVien;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface NhanVienService {

    List<NhanVien> getAll();

    NhanVien add(NhanVien nhanVien);

    NhanVien update(UUID id, NhanVien nhanVien);

    void delete(UUID id);

    NhanVien detail(UUID id);

    Page<NhanVien> getNhanVien(int pageNumber,int pageSize);
}
