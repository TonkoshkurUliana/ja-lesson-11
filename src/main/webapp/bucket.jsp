
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bucket</title>
</head>
<link rel="stylesheet" href="style/bucket.css">
<link rel="stylesheet" href="style/bootstrap.css">

<body>
<jsp:include page="header.jsp"></jsp:include>

<table className="table-fill">
    <thead>
    <tr>
        <th style='width: 20%; text-align: center'>Name</th>
        <th style='width: 20%; text-align: center'>Description</th>
        <th style='width: 20%; text-align: center'>Price</th>
        <th style='width: 20%; text-align: center'>PurchaseDate</th>
        <th style='width: 20%; text-align: center'>Options</th>
    </tr>
    </thead>
    <tbody className="table-hover"  id="table-bucket">
    </tbody>
</table>

<link rel="stylesheet" href="style/index.css">

<jsp:include page="footer.jsp"></jsp:include>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="js/bucket.js"></script>
</body>
</html>
