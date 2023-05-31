package com.example.demo.controller;

import com.example.demo.entity.ChucVu;
import com.example.demo.entity.CuaHang;
import com.example.demo.entity.NhanVien;
import com.example.demo.service.ChucVuService;
import com.example.demo.service.CuaHangService;
import com.example.demo.service.NhanVienService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;
import java.util.UUID;

@Controller
public class NhanVienController {

    @Autowired
    private NhanVienService nhanVienService;
    @Autowired
    private CuaHangService cuaHangService;
    @Autowired
    private ChucVuService chucVuService;

    @RequestMapping("/nhan-vien/hien-thi")
    public String getAll(Model model){
        List<NhanVien> nhanVienList = nhanVienService.getAll();
        List<CuaHang> cuaHangList = cuaHangService.getAll();
        List<ChucVu> chucVuList = chucVuService.getAll();
        model.addAttribute("listNhanVien",nhanVienList);
        model.addAttribute("listCuaHang",cuaHangList);
        model.addAttribute("listChucVu",chucVuList);
        model.addAttribute("nv",new NhanVien());
        return "nhan-vien";
    }
    @RequestMapping(value = "/nhan-vien/add",method = RequestMethod.POST)
    public String add(@Valid @ModelAttribute("nv") NhanVien nhanVien, BindingResult result,Model model){
        List<CuaHang> cuaHangList = cuaHangService.getAll();
        List<ChucVu> chucVuList = chucVuService.getAll();
        model.addAttribute("listCuaHang",cuaHangList);
        model.addAttribute("listChucVu",chucVuList);
        if(result.hasErrors()){
            return "nhan-vien";
        }
        nhanVienService.add(nhanVien);
        return "redirect:/nhan-vien/hien-thi";
    }
    @RequestMapping("/nhan-vien/detail/{id}")
    public String detail(@PathVariable("id") UUID id,Model model){
        NhanVien nhanVien = nhanVienService.detail(id);
        List<CuaHang> cuaHangList = cuaHangService.getAll();
        List<ChucVu> chucVuList = chucVuService.getAll();
        model.addAttribute("listCuaHang",cuaHangList);
        model.addAttribute("listChucVu",chucVuList);
        model.addAttribute("nv",nhanVien);
        return "nhan-vien";
    }
    @RequestMapping("/nhan-vien/remove/{id}")
    public String remove(@PathVariable("id") UUID id){
        nhanVienService.delete(id);
        return "redirect:/nhan-vien/hien-thi";
    }
    @RequestMapping("/nhan-vien/view-update/{id}")
    public String viewUpdate(@PathVariable("id")UUID id,Model model){
        NhanVien nhanVien1 = nhanVienService.detail(id);
        List<CuaHang> cuaHangList = cuaHangService.getAll();
        List<ChucVu> chucVuList = chucVuService.getAll();
        model.addAttribute("listCuaHang",cuaHangList);
        model.addAttribute("listChucVu",chucVuList);
        model.addAttribute("nv",nhanVien1);
        return "nhan-vien-view-update";
    }
    @RequestMapping(value = "/nhan-vien/update/{id}",method = RequestMethod.POST)
    public String update(@PathVariable("id")UUID id,NhanVien nhanVien){
        nhanVienService.update(id,nhanVien);
        return "redirect:/nhan-vien/hien-thi";
    }
    @RequestMapping("/nhan-vien/hien-thi/phan-trang")
    public String phanTrang(@RequestParam(defaultValue = "0") int page,
                            @RequestParam(defaultValue = "3") int size,
                            Model model){
        Page<NhanVien> page1 = nhanVienService.getNhanVien(page,size);
        List<CuaHang> cuaHangList = cuaHangService.getAll();
        List<ChucVu> chucVuList = chucVuService.getAll();
        model.addAttribute("listCuaHang",cuaHangList);
        model.addAttribute("listChucVu",chucVuList);
        model.addAttribute("nv",new NhanVien());
        model.addAttribute("listNhanVien",page1.getContent());
        return "nhan-vien";
    }
}
