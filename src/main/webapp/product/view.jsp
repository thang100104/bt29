<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head><meta charset="UTF-8"><title>Chi tiết sản phẩm</title>
<style>
body{font-family:Arial;background:#f6f8fb}.box{max-width:560px;margin:60px auto;background:#fff;padding:30px;border-radius:8px;box-shadow:0 3px 10px rgba(0,0,0,.08)}
table{width:100%;border-collapse:collapse}td{padding:10px;border-bottom:1px solid #ddd}.label{font-weight:bold;width:35%}
</style></head>
<body><div class="box">
<h2>Chi tiết sản phẩm</h2>
<table>
<tr><td class="label">ID</td><td>${product.id}</td></tr>
<tr><td class="label">Tên</td><td>${product.name}</td></tr>
<tr><td class="label">Giá</td><td>${product.price}</td></tr>
<tr><td class="label">Mô tả</td><td>${product.description}</td></tr>
<tr><td class="label">Nhà sản xuất</td><td>${product.manufacturer}</td></tr>
</table>
<p><a href="${pageContext.request.contextPath}/products">← Quay lại danh sách</a></p>
</div></body></html>
