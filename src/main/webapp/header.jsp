<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<%--    <link rel="shortcut icon" href="http://example.com/favicon.ico">--%>
    <link rel="shortcut icon" href="data:;base64,=">
    <link rel="stylesheet" href="style/header.css">
</head>
<body>
<header>
    <div class="inner">
        <nav>
            <a class="active" href="${pageContext.request.contextPath}/cabinet.jsp">Catalog</a>
            <a class="create-product-option" href="${pageContext.request.contextPath}/createProduct.jsp">New product</a>
            <a class="user-bucket-option" href="${pageContext.request.contextPath}/bucket.jsp">Bucket</a>
            <a class="logout" href="#">LogOut</a>
        </nav>
        <a href="https://u24.gov.ua/" class="donate-link">Donate</a>
    </div>
</header>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="js/header.js"></script>
</body>
</html>
