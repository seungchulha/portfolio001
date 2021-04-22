<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@include file="../layout/header.jsp"%>

<div class="container">

    <h1>Login</h1>

    <form action="">

        <label for="email-signin"></label>
        <input type="email" id="email-signin" placeholder="Type Your Email" width="300px">

        <label for="password-signin"></label>
        <input type="password" id="password-signin" placeholder="Type Your Password">
        <br>
        <a href="">Find Account</a> |
        <a href="">Forgot Password</a>
        <br>
        <button>Login</button>
        <br>
        <button><img src="static/images/kakao_login_medium_wide.png" alt=""></button>
        
    </form>

    <form action="">

        <h3>Welcome New Eccentric</h3>
        <br>
        <h3>Hello New World</h3>
        <br>
        <h3>Find Your Sparkle inside of You</h3>
        <br>
        <h3>Seasonal Message</h3>

    </form>
    <h1>CREATE ACCOUNT</h1>



    <button>CREATE ACCOUNT</button>
    <button>START WITH KAKAO</button>


</div>

<%@include file="../layout/footer.jsp"%>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.4.js"></script>