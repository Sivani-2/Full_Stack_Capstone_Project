<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
    <title>Buyer Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 20px;
        }
        h1 {
            color: #333;
        }
        .product-container {
            border: 1px solid #ccc;
            padding: 10px;
            margin-bottom: 20px;
        }
        .product-container h3 {
            margin-top: 0;
            color: #555;
        }
        .product-container p {
            margin-bottom: 10px;
        }
        .product-container form {
            margin-top: 10px;
        }
        .product-container form input[type="number"] {
            width: 50px;
        }
        .product-container form input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 8px 12px;
            cursor: pointer;
        }
        .product-container form input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h1>Welcome, ${username}!</h1>
    
    <a href="ViewProductsServlet">View Products</a><br><br>
    
    <h2>Available Products</h2>
    
    <c:forEach var="product" items="${products}">
        <div class="product-container">
            <h3>${product.prodName}</h3>
            <p>${product.productDescription}</p>
            <p>Price: ${product.price}</p>
            
            <form action="AddToCartServlet" method="post">
                <input type="hidden" name="productId" value="${product.prodId}">
                Quantity: <input type="number" name="quantity" value="1" min="1">
                <input type="submit" value="Add to Cart">
            </form>
            
            <form action="DeleteFromCartServlet" method="post">
                <input type="hidden" name="productId" value="${product.prodId}">
                <input type="submit" value="Remove from Cart">
            </form>
        </div>
        <br>
    </c:forEach>
</body>
</html>