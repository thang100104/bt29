<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head><meta charset="UTF-8"><title>Cập nhật sản phẩm</title>
<style>
body{font-family:Arial;background:#f6f8fb}.box{max-width:520px;margin:50px auto;background:#fff;padding:28px;border-radius:8px;box-shadow:0 3px 10px rgba(0,0,0,.08)}
input,textarea{width:100%;padding:10px;margin:7px 0 15px;box-sizing:border-box}.btn{padding:10px 16px;border:0;border-radius:5px;background:#2980b9;color:#fff}.error{color:#c0392b}
</style></head>
<body><div class="box">
<h2>Cập nhật sản phẩm</h2>
<c:if test="${not empty error}"><p class="error">${error}</p></c:if>
<form action="${pageContext.request.contextPath}/products?action=edit" method="post">
<input type="hidden" name="id" value="${product.id}">
<label>Tên sản phẩm</label><input name="name" value="${product.name}" required>
<label>Giá sản phẩm</label><input name="price" type="number" step="0.01" min="0" value="${product.price}" required>
<label>Mô tả</label><textarea name="description" required>${product.description}</textarea>
<label>Nhà sản xuất</label><input name="manufacturer" value="${product.manufacturer}" required>
<button class="btn" type="submit">Cập nhật</button>
</form>
<p><a href="${pageContext.request.contextPath}/products">← Quay lại danh sách</a></p>
</div></body></html>
