<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Quản lý sản phẩm</title>
    <style>
        body{font-family:Arial,sans-serif;margin:30px;background:#f6f8fb;color:#222}
        .top{display:flex;justify-content:space-between;align-items:center;gap:15px;flex-wrap:wrap}
        h1{color:#1b2a7a}
        table{width:100%;border-collapse:collapse;background:#fff;box-shadow:0 3px 10px rgba(0,0,0,.06)}
        th,td{padding:12px;border-bottom:1px solid #ddd;text-align:left}
        th{background:#1b2a7a;color:white}
        .btn{display:inline-block;padding:8px 12px;border-radius:5px;text-decoration:none;border:none;cursor:pointer}
        .create{background:#27ae60;color:white}.edit{color:#2471a3}.delete{color:#c0392b}.view{color:#6c3483}
        form.search{display:flex;gap:8px}.search input{padding:9px;width:250px}.search button{background:#1b2a7a;color:#fff}
    </style>
</head>
<body>
<div class="top">
    <div>
        <h1>Danh sách sản phẩm</h1>
        <a class="btn create" href="${pageContext.request.contextPath}/products?action=create">+ Thêm sản phẩm</a>
    </div>
    <form class="search" action="${pageContext.request.contextPath}/products" method="get">
        <input type="hidden" name="action" value="search">
        <input type="text" name="keyword" value="${keyword}" placeholder="Nhập tên sản phẩm...">
        <button class="btn" type="submit">Tìm kiếm</button>
        <a class="btn" href="${pageContext.request.contextPath}/products">Tất cả</a>
    </form>
</div>

<table>
    <thead>
    <tr>
        <th>ID</th><th>Tên sản phẩm</th><th>Giá</th><th>Mô tả</th><th>Nhà sản xuất</th><th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${products}" var="product">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.description}</td>
            <td>${product.manufacturer}</td>
            <td>
                <a class="view" href="${pageContext.request.contextPath}/products?action=view&id=${product.id}">Xem</a> |
                <a class="edit" href="${pageContext.request.contextPath}/products?action=edit&id=${product.id}">Sửa</a> |
                <a class="delete" href="${pageContext.request.contextPath}/products?action=delete&id=${product.id}">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    <c:if test="${empty products}">
        <tr><td colspan="6">Không tìm thấy sản phẩm.</td></tr>
    </c:if>
    </tbody>
</table>
</body>
</html>
