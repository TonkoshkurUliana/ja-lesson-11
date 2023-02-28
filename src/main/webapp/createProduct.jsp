<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create product</title>
    <link rel="stylesheet" href="style/createProduct.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<form id="msform">
    <fieldset>
        <h2 class="fs-title">Create new product</h2>

        <input type="text" class="productName" name="productName" placeholder="Please enter name"/>
        <input type="text" class="productDescription" name="productDescription" placeholder="Please enter description"/>
        <input type="text" class="productPrice" name="productPrice" placeholder="Please enter price"/>
        <input type="button" name="createProduct" id="createProduct" class="next action-button " value="Create"/>
    </fieldset>
</form>

<jsp:include page="footer.jsp"></jsp:include>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
        integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
        crossorigin="anonymous"></script>
<script
        src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
        integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
        crossorigin="anonymous"></script>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="js/header.js"></script>
<script src="js/serverCalls.js"></script>
</body>
</html>
