<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@include file="../layout/header.jsp"%>

<div class="container">

    <div class="row" style="margin: 100px; text-align: center;">
        <div class="col" style="border-right: 1px solid black;">
            <div style="margin-right: 100px;">
                <h2>LOGIN</h2>
                <br>
                <br>
                <form action="">

                    <label for="email-signin" style="text-align: left;">Email : </label><br>
                    <input type="email" id="email-signin" placeholder="Type Your Email" width="300px">
                    <br><br>
                    <label for="password-signin" style="text-align: left;">Password : </label><br>
                    <input type="password" id="password-signin" placeholder="Type Your Password">
                    <br><br><br>
                    <a href="">Find Account</a> |
                    <a href="">Forgot Password</a>
                    <br><br><br><br>
                    <button>Login</button>
                    <br><br>
                    <button><img src="static/images/kakao_login_medium_wide.png" alt="">START WITH KAKAO</button>

                </form>
            </div>
        </div>


        <div class="col" style="text-align: center;">
            <div style="margin-left: 100px">
                <h2>CREATE ACCOUNT</h2>
                <br>
                <br>
                <form action="">

                    <div class="welcome_signup_message" style="background-color: lemonchiffon;">
                        <h4>Welcome New Eccentric</h4>
                        <br>
                        <h4>Hello New World</h4>
                        <br>
                        <h4>Find Your Sparkle inside of You</h4>
                        <br>
                        <h4>Seasonal Message</h4>
                    </div>

                </form>
                <br><br>

                <button><a href="/moment4u/customer/createAccount">CREATE ACCOUNT</a></button>
                <br><br>
                <button>START WITH KAKAO</button>
            </div>
        </div>
    </div>







</div>

<%@include file="../layout/footer.jsp"%>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.4.js"></script>