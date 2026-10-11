package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import com.codegym.service.ProductServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    private final ProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "";

        switch (action) {
            case "create" -> showCreateForm(request, response);
            case "edit" -> showEditForm(request, response);
            case "delete" -> showDeleteForm(request, response);
            case "view" -> viewProduct(request, response);
            case "search" -> searchProduct(request, response);
            default -> listProducts(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) action = "";

        switch (action) {
            case "create" -> createProduct(request, response);
            case "edit" -> updateProduct(request, response);
            case "delete" -> deleteProduct(request, response);
            default -> response.sendRedirect(request.getContextPath() + "/products");
        }
    }

    private void listProducts(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("products", productService.findAll());
        request.getRequestDispatcher("/product/list.jsp").forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/product/create.jsp").forward(request, response);
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Product product = readProductFromRequest(request);
            productService.save(product);
            response.sendRedirect(request.getContextPath() + "/products");
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Giá sản phẩm không hợp lệ.");
            request.getRequestDispatcher("/product/create.jsp").forward(request, response);
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Product product = getProduct(request);
        if (product == null) {
            forward404(request, response);
            return;
        }
        request.setAttribute("product", product);
        request.getRequestDispatcher("/product/edit.jsp").forward(request, response);
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        if (productService.findById(id) == null) {
            forward404(request, response);
            return;
        }

        try {
            Product product = readProductFromRequest(request);
            productService.update(id, product);
            response.sendRedirect(request.getContextPath() + "/products");
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Giá sản phẩm không hợp lệ.");
            request.setAttribute("product", productService.findById(id));
            request.getRequestDispatcher("/product/edit.jsp").forward(request, response);
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Product product = getProduct(request);
        if (product == null) {
            forward404(request, response);
            return;
        }
        request.setAttribute("product", product);
        request.getRequestDispatcher("/product/delete.jsp").forward(request, response);
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        productService.remove(id);
        response.sendRedirect(request.getContextPath() + "/products");
    }

    private void viewProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Product product = getProduct(request);
        if (product == null) {
            forward404(request, response);
            return;
        }
        request.setAttribute("product", product);
        request.getRequestDispatcher("/product/view.jsp").forward(request, response);
    }

    private void searchProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        List<Product> products = productService.findByName(keyword);
        request.setAttribute("products", products);
        request.setAttribute("keyword", keyword);
        request.getRequestDispatcher("/product/list.jsp").forward(request, response);
    }

    private Product getProduct(HttpServletRequest request) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            return productService.findById(id);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private Product readProductFromRequest(HttpServletRequest request) {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        String manufacturer = request.getParameter("manufacturer");
        return new Product(0, name, price, description, manufacturer);
    }

    private void forward404(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/error-404.jsp");
        dispatcher.forward(request, response);
    }
}
