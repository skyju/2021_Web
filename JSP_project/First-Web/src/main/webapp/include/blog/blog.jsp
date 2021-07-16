<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://fonts.googleapis.com/css2?family=Crimson+Pro&family=Literata" rel="stylesheet">
    <link rel="stylesheet" href="css/layout.css">
</head>

<body>
    <%@ include file="module/header.jsp" %>
    <nav class="div_algin_center">
        <%@ include file="module/nav.jsp" %>
    </nav>
    <div id="wrap" class="div_algin_center">
        <section class="text_left">
            <%@ include file="module/article.jsp" %>
        </section>
        <aside class="text_center">
            <%@ include file="module/aside_category.jsp" %>
            <%@ include file="module/aside_latest.jsp" %>
        </aside>
    </div>
   <%@ include file="module/footer.jsp" %>
</body>
</html>