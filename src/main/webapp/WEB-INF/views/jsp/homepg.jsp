<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>

<head>

    <!--For css, import:-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/core/css/homepage.css"/>                 <!--??-->

    <!--For bootstrap, import:-->
    <link rel="icon" type="image/x-icon" href="favicon.ico">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <!--For bootstrap validator, import:-->
    <script src="http://1000hz.github.io/bootstrap-validator/dist/validator.min.js"></script>


    <!--For icons, import:-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <style>
        .error {
            color: red; font-style: italic;
        }
    </style>

</head>

<body>

<!--Top part of page-->
<div class="top-box-border">
    <%@include file="homepgheader.jsp" %>
</div>


<br>
<h5 style="color: red">${msg}</h5>
<br>


<!--Bottom part of page-->
<div class="bottom-part" style="margin-top:2em">

    <div class="row">
        <div class="col-md-8">

            <!--Coding for the panel "Recent shares"-->
            <div class="panel panel-default" style="width:800px; border-color: #333;">
                <div class="panel-heading" style="border-color:black">
                    Recent shares

                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-2">
                            <img class="pic-class" src="/resources/images/default-img.jpg">
                        </div>

                        <div class="col-md-10">
                            <a href="#">Uday Pratap Singh </a>
                            <font size=2px class="text-muted"> @uday 5 min</font>
                            <a href="#" style="float: right; padding-right: 15px;">Grails</a>

                            <p>
                                To group many panels together, wrap a with class .panel-group a
                                round them. The .panel-group class clears the bottom-margin of each
                                panel: To group many panels together, wrap a with class .panel-group
                                around them. The .panel-group class clears the bottom.
                            </p>
                            <a href="https://www.facebook.com">
                                <i class="fa fa-facebook-square" style="font-size:20px"></i>
                            </a>
                            <a href="https://www.twitter.com">
                                <i class="fa fa-twitter" style="font-size:20px"></i>
                            </a>
                            <a href="https://www.plus.google.com">
                                <i class="fa fa-google-plus" style="font-size:20px" ></i>
                            </a>
                            <a href="#" style="float: right; padding-right:5%;">View Post</a>
                        </div>

                    </div>
                </div>
                <br>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-2">
                            <img class="pic-class" src="/resources/images/default-img.jpg">
                        </div>

                        <div class="col-md-10">
                            <a href="#">Uday Pratap Singh </a>
                            <font size=2px class="text-muted"> @uday 10 min</font>
                            <a href="#" style="float: right; padding-right: 15px;">Grails</a>

                            <p>
                                To group many panels together, wrap a with class .panel-group a
                                round them. The .panel-group class clears the bottom-margin of each
                                panel: To group many panels together, wrap a with class .panel-group
                                around them. The .panel-group class clears the bottom.
                            </p>
                            <a href="https://www.facebook.com">
                                <i class="fa fa-facebook-square" style="font-size:20px"></i>
                            </a>
                            <a href="https://www.twitter.com">
                                <i class="fa fa-twitter" style="font-size:20px"></i>
                            </a>
                            <a href="https://www.plus.google.com">
                                <i class="fa fa-google-plus" style="font-size:20px" ></i>
                            </a>
                            <a href="#" style="float: right; padding-right:5%;">View Post</a>
                        </div>

                    </div>
                </div>

            </div>
            <!--Coding for the panel "Top posts"-->
            <div class="panel panel-default" style="width:800px; border-color: #333;">
                <div class="panel-heading" style="border-color:black">
                    Top posts

                    <!--Coding for dropdown list-->
                    <div class="dropdown">
                        <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true" style="border-color:black">
                            Today
                            <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                            <li><a href="#" >Today</a></li>
                            <li><a href="#" >1 Week</a></li>
                            <li><a href="#" >1 Month</a></li>
                            <li><a href="#" >1 Year</a></li>
                        </ul>
                    </div>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-2">
                            <img class="pic-class" src="/resources/images/default-img.jpg">
                        </div>

                        <div class="col-md-10">
                            <a href="#">Uday Pratap Singh </a>
                            <font size=2px class="text-muted"> @uday 21 Jul 2014</font>
                            <a href="#" style="float: right; padding-right: 15px;">Grails</a>

                            <p>
                                To group many panels together, wrap a with class .panel-group a
                                round them. The .panel-group class clears the bottom-margin of each
                                panel: To group many panels together, wrap a with class .panel-group
                                around them. The .panel-group class clears the bottom.
                            </p>
                            <a href="https://www.facebook.com">
                                <i class="fa fa-facebook-square" style="font-size:20px"></i>
                            </a>
                            <a href="https://www.twitter.com">
                                <i class="fa fa-twitter" style="font-size:20px"></i>
                            </a>
                            <a href="https://www.plus.google.com">
                                <i class="fa fa-google-plus" style="font-size:20px" ></i>
                            </a>
                            <a href="#" style="float: right; padding-right:5%;">View Post</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-4">

            <div class="panel panel-default" style="width:400px; border-color: #333;">
                <%@include file="login.jsp" %>
            </div>

            <div class="panel panel-default" style="width:400px; border-color: #333;">
                <%@include file="register.jsp" %>
            </div>
        </div>
    </div>
</div>
</body>
</html>

