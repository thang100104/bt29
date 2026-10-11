<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head><meta charset="UTF-8"><title>Xóa sản phẩm</title>
<style>
body{font-family:Arial;background:#f6f8fb}.box{max-width:520px;margin:70px auto;background:#fff;padding:30px;text-align:center;border-radius:8px;box-shadow:0 3px 10px rgba(0,0,0,.08)}
.btn{padding:10px 16px;border:0;border-radius:5px;text-decoration:none;cursor:pointer}.danger{background:#c0392b;color:#fff}.cancel{background:#bdc3c7;color:#222}
</style></head>
<body><div class="box">
<h2>Xác nhận xóa</h2>
<p>Bạn có chắc muốn xóa sản phẩm <strong>${product.name}</strong>?</p>
<form action="${pageContext.request.contextPath}/products?action=delete" method="post">
<input type="hidden" name="id" value="${product.id}">
<button class="btn danger" type="submit">Đồng ý xóa</button>
<a class="btn cancel" href="${pageContext.request.contextPath}/products">Hủy</a>
</form>
</div></body></html>
