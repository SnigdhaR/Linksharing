<%--
  Created by IntelliJ IDEA.
  User: MAHE
  Date: 7/22/2017
  Time: 7:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="icon" type="image/x-icon" href="favicon.ico">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <!--For bootstrap validator, import:-->
    <script src="http://1000hz.github.io/bootstrap-validator/dist/validator.min.js"></script>

</head>
<body>
Enter your registered email address:
<form action="/resetpwd" method="post" data-toggle="validator">
    <table>
        <tr>
            <td colspan="2"><input type="text" name="email" class="form-control" required></td>
        </tr>
        <tr>
            <td>New Password</td>
            <td colspan="2"><input type="password" class="form-control" name="password" id="prevPassword"></td>
        </tr>
        <tr>
            <td>Confirm Password </td>
            <td colspan="2"><input type="password" class="form-control" name="confirmpassword" data-match="#prevPassword" data-match-error="Password does not match">
                <div class="help-block with-errors"></div></td>
        </tr>
        <tr>
            <td><input type="Submit" value="Reset Password"></td>
            <%--<td><input type="reset" value="Cancel"></td>--%>
        </tr>
    </table>
</form>
</body>
</html>
