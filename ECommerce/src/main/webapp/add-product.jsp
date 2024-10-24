<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Product</title>
    <style>
    	body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        form {
            width: 300px;
            margin: 0 auto;
        }
        label {
            display: block;
            margin-bottom: 8px;
        }
        input, textarea {
            width: 100%;
            padding: 8px;
            margin-bottom: 12px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
            padding: 10px 20px;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

<center><h2>Add New Product</h2></center>
<form action="AddProductServlet" method="POST" onsubmit="return validateForm()">
    <label for="productName">Product Name:</label>
    <input type="text" id="productName" name="productName" required><br>

    <label for="productDescription">Product Description:</label>
    <textarea id="productDescription" name="productDescription" required></textarea><br>

    <label for="price">Price:</label>
    <input type="number" id="price" name="price" step="0.01" required><br>

    <input type="submit" value="Add Product">
</form>

<script>
    function validateForm() {
        var name = document.getElementById("productName").value;
        var description = document.getElementById("productDescription").value;
        var price = document.getElementById("price").value;

        if (name == "" || description == "" || price == "") {
            alert("All fields must be filled out");
            return false;
        }
        return true;
    }
</script>

</body>
</html>
