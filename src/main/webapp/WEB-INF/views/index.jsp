<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@include file="layout/header.jsp"%>



    <div id="myCarousel" class="carousel slide" data-ride="carousel">

        <!-- Indicators -->
        <ul class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ul>

        <!-- The slideshow -->
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="/images/Moment4U.png" alt="Moment4U" width="1100" height="500">
            </div>
            <div class="carousel-item">
                <img src="chicago.jpg" alt="Chicago" width="1100" height="500">
            </div>
            <div class="carousel-item">
                <img src="ny.jpg" alt="New York" width="1100" height="500">
            </div>
        </div>

        <!-- Left and right controls -->
        <a class="carousel-control-prev" href="#myCarousel" data-slide="prev">
            <span class="carousel-control-prev-icon"></span>
        </a>
        <a class="carousel-control-next" href="#myCarousel" data-slide="next">
            <span class="carousel-control-next-icon"></span>
        </a>
    </div>


<br>

<div class="container">

    <h1>People always tell me that "You are geezer!!". However, you are not geezer anymore at here. You are absolutely normal!!!</h1>

</div>

<%@include file="layout/footer.jsp"%>

