<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body class="container">
<div class="row">
    <div class="mx-auto col-10 col-md-8 col-lg-6">
        <form:form action="/nhan-vien/add" method="post" modelAttribute="nv">
        <div class="mb-3 form-group">
            <label>ID</label>
            <form:input path="id" disabled="true" value="${nv.id}"/>

        </div>
        <div class="mb-3 form-group">
            <label>Mã</label>
            <form:input path="ma" value="${nv.ma}"/>
            <form:errors path="ma"/>
        </div>
        <div class="mb-3 form-group">
            <label>Tên</label>
            <form:input path="ten" value="${nv.ten}"/>
            <form:errors path="ten"/>
        </div>
        <div class="mb-3 form-group">
            <label>Tên đệm</label>
            <form:input path="tenDem" value="${nv.tenDem}"/>
            <form:errors path="tenDem"/>
        </div>
        <div class="mb-3 form-group">
            <label>Họ</label>
            <form:input path="ho" value="${nv.ho}"/>
            <form:errors path="ho"/>
        </div>
        <div class="mb-3 form-group">
            <label>Giới tính</label>
            <form:radiobutton path="gioiTinh" value="Nam" checked="true"/> Nam
            <form:radiobutton path="gioiTinh" value="Nữ"/> Nữ
        </div>
        <div class="mb-3 form-group">
            <label>Ngày sinh</label>
            <form:input path="ngaySinh" value="${nv.ngaySinh}"/>
            <form:errors path="ngaySinh"/>
        </div>
        <div class="mb-3 form-group">
            <label>Địa chỉ</label>
            <form:input path="diaChi" value="${nv.diaChi}"/>
            <form:errors path="diaChi"/>
        </div>
        <div class="mb-3 form-group">
            <label>Số điện thoại</label>
            <form:input path="sdt" value="${nv.sdt}"/>
            <form:errors path="sdt"/>
        </div>
        <div class="mb-3 form-group">
            <label>Mật khẩu</label>
            <form:input path="matKhau" value="${nv.matKhau}"/>
            <form:errors path="matKhau"/>
        </div>
        <div class="mb-3 form-group">
            <label>Cửa hàng</label>
            <form:select path="cuaHang">
                <form:options items="${listCuaHang}" itemValue="id" itemLabel="ten"/>
            </form:select>
        </div>
        <div class="mb-3 form-group">
            <label>Chức vụ</label>
            <form:select path="chucVu">
                <form:options items="${listChucVu}" itemValue="id" itemLabel="ten"/>
            </form:select>
            <form:button type="submit">add</form:button>
            </form:form>
        </div>
    </div>
</div>


</body>
<table class="table">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Mã</th>
        <th scope="col">Tên</th>
        <th scope="col">Tên Đệm</th>
        <th scope="col">Họ</th>
        <th scope="col">Giới tính</th>
        <th scope="col">Ngày Sinh</th>
        <th scope="col">Địa chỉ</th>
        <th scope="col">Số điện thoại</th>
        <th scope="col">Mật khẩu</th>
        <th scope="col">Cửa hàng</th>
        <th scope="col">Chức vụ</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listNhanVien}" var="nv">
        <tr>
            <td>${nv.id}</td>
            <td>${nv.ma}</td>
            <td>${nv.ten}</td>
            <td>${nv.tenDem}</td>
            <td>${nv.ho}</td>
            <td>${nv.gioiTinh}</td>
            <td><fmt:formatDate value="${nv.ngaySinh}" pattern="yyyy-MM-dd" /></td>
            <td>${nv.diaChi}</td>
            <td>${nv.sdt}</td>
            <td>${nv.matKhau}</td>
            <td>${nv.cuaHang.ten}</td>
            <td>${nv.chucVu.ten}</td>
            <td>
                <button>
                    <a href="/nhan-vien/detail/${nv.id}">Detail</a>
                </button>
                <button>
                    <a href="/nhan-vien/remove/${nv.id}">Delete</a>
                </button>
                <button>
                    <a href="/nhan-vien/view-update/${nv.id}">Edit</a>
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<nav aria-label="Page navigation example">
    <ul class="pagination">
        <li class="page-item"><a class="page-link" href="/nhan-vien/hien-thi/phan-trang?page=0">1</a></li>
        <li class="page-item"><a class="page-link" href="/nhan-vien/hien-thi/phan-trang?page=1">2</a></li>
        <li class="page-item"><a class="page-link" href="/nhan-vien/hien-thi/phan-trang?page=2">3</a></li>

    </ul>
</nav>
</html>