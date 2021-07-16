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
    <link rel="stylesheet" href="layout.css">
</head>

<body>
    <%@ include file="header.jsp" %>
    <nav class="div_algin_center">
        <%@ include file="nav.jsp" %>
    </nav>
    <div id="wrap" class="div_algin_center">
        <section class="text_left">
            <%@ include file="article.jsp" %>
        </section>
        <aside class="text_center">
            <%@ include file="aside_category.jsp" %>
            <%@ include file="aside_latest.jsp" %>
        </aside>
    </div>
   <%@ include file="footer.jsp" %>
</body>
</html>