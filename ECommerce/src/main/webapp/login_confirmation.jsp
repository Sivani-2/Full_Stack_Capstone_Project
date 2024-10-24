<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Product Added Successfully</title>
</head>
<body>
    <h2>Product Added Successfully</h2>
    <table border="1">
        <tr>
            <th>Product ID</th>
            <th>Product Name</th>
            <th>Quantity</th>
            <th>Price</th>
        </tr>
        <tr>
            <td>${product.productId}</td>
            <td>${product.productName}</td>
            <td>${product.quantity}</td>
            <td>${product.price}</td>
        </tr>
    </table>
</body>
</html>