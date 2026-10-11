# BT29 - Ứng dụng quản lý sản phẩm

Bài tập Java Web theo kiến trúc MVC, sử dụng Servlet + JSP + JSTL.

## Chức năng
- Hiển thị danh sách sản phẩm
- Tạo sản phẩm mới
- Cập nhật thông tin sản phẩm
- Xóa sản phẩm
- Xem chi tiết sản phẩm
- Tìm kiếm sản phẩm theo tên

## Thuộc tính Product
- id
- name
- price
- description
- manufacturer

## Công nghệ
- Java 17
- Maven
- Jakarta Servlet 6
- JSP/JSTL
- Tomcat 10.1+

## Cấu trúc MVC
- Model: `Product.java`
- Service: `ProductService.java`, `ProductServiceImpl.java`
- Controller: `ProductServlet.java`
- View: các file JSP trong `src/main/webapp/product/`

## Chạy dự án
```bash
mvn clean package
```

Sau khi build thành công, deploy:
`target/product-management.war`

Truy cập:
`http://localhost:8080/product-management/products`
