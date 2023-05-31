<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body class="container">
<form:form action="/nhan-vien/update/${nv.id}" method="post" modelAttribute="nv">
    <div class="mb-3">
        <label>ID</label>
        <form:input path="id" disabled="true" value="${nv.id}"/>
    </div>
    <div class="mb-3">
        <label>Mã</label>
        <form:input path="ma" value="${nv.ma}"/>
    </div>
    <div class="mb-3">
        <label>Tên</label>
        <form:input path="ten" value="${nv.ten}"/>
    </div>
    <div class="mb-3">
        <label>Tên đệm</label>
        <form:input path="tenDem" value="${nv.tenDem}"/>
    </div>
    <div class="mb-3">
        <label>Họ</label>
        <form:input path="ho" value="${nv.ho}"/>
    </div>
    <div class="mb-3">
        <label>Giới tính</label>
        <form:radiobutton path="gioiTinh"  value="Nam" checked="true"/> Nam
        <form:radiobutton path="gioiTinh" value="Nữ"/> Nữ
    </div>
    <div class="mb-3">
<%--        sửa lại để có thể chọn ngày không cần phải nhập tay--%>
        <label>Ngày sinh</label>
            <form:input path="ngaySinh"  type="Date"  pattern="yyyy-MM-dd"/>
    </div><div class="mb-3">
    <label>Địa chỉ</label>
    <form:input path="diaChi" value="${nv.diaChi}"/>
</div>
    <div class="mb-3">
        <label>Số điện thoại</label>
        <form:input path="sdt" value="${nv.sdt}"/>
    </div>
    <div class="mb-3">
        <label>Mật khẩu</label>
        <form:input path="matKhau" value="${nv.matKhau}"/>
    </div>
    <div class="mb-3">
        <label>Cửa hàng</label>
        <form:select path="cuaHang">
            <form:options items="${listCuaHang}" itemValue="id" itemLabel="ten"/>
        </form:select>
    </div>
    <div class="mb-3">
        <label>Chức vụ</label>
        <form:select path="chucVu">
            <form:options items="${listChucVu}" itemValue="id" itemLabel="ten"/>
        </form:select>

    </div>
    <form:button type="submit">Update</form:button>
</form:form>


</body>

</html>