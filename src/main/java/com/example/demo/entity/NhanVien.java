package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.UUID;

@Table(name = "NhanVien")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class NhanVien {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "Id")
    private UUID id;

    @Column(name = "Ma")
    @NotEmpty(message = "không được để trống")
    private String ma;

    @Column(name = "Ten")
    @NotEmpty(message = "không được để trống")
    private String ten;

    @Column(name = "TenDem")
    @NotEmpty(message = "không được để trống")
    private String tenDem;

    @Column(name = "Ho")
    @NotEmpty(message = "không được để trống")
    private String ho;

    @Column(name = "GioiTinh")
    private String gioiTinh;

    @Column(name = "NgaySinh")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "không được để trống")
    private Date ngaySinh;

    @Column(name = "DiaChi")
    @NotEmpty(message = "không được để trống")
    private String diaChi;

    @Column(name = "Sdt")
    @NotEmpty(message = "không được để trống")
    private String sdt;

    @Column(name = "MatKhau")
    @NotEmpty(message = "không được để trống")
    private String matKhau;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdCH",referencedColumnName = "id")
    private CuaHang cuaHang;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdCV",referencedColumnName = "id")
    private ChucVu chucVu;



}
