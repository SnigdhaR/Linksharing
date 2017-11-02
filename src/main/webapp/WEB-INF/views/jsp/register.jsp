<%--
  Created by IntelliJ IDEA.
  User: MAHE
  Date: 7/12/2017
  Time: 4:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="panel-heading" style="border-color:black">
    Register
</div>


<div class="panel-body">
    <form:form role="form" method="post" action="/register" data-toggle="validator" enctype="multipart/form-data" modelAttribute="user">
        <div class="form-group">
            <label>First Name:*</label>
            <input type="text" class="form-control" name="firstName" style="border-color:black">
            <form:errors path="firstName" cssClass="error"/>
        </div>
        <br>
        <div class="form-group">
            <label>Last Name:*</label>
            <input type="text" class="form-control" name="lastName" style="border-color:black">
            <form:errors path="lastName" cssClass="error"/>
        </div>
        <br>
        <div class="form-group">
            <label>Email:*</label>
            <input type="text" class="form-control" name="email" style="border-color:black">
            <form:errors path="email" cssClass="error"/>
        </div>
        <br>
        <div class="form-group">
            <label>Username:*</label>
            <input type="text" class="form-control" name="username" style="border-color:black">
            <form:errors path="username" cssClass="error"/>
        </div>
        <br>
        <div class="form-group">
            <label>Password:*</label>
            <form:password path="password" class="form-control" name="password" id="inputPassword" style="border-color:black"/>
            <form:errors path="password" cssClass="error"/>
        </div>
        <br>
        <div class="form-group">
            <label>Confirm Password:*</label>
            <input type="password" class="form-control" name="confirmpwd" style="border-color:black"
                   data-match="#inputPassword" data-match-error="Password does not match">
            <div class="help-block with-errors"></div>
        </div>
        <br>
        <div class="form-group">
            <label>Photo:</label>

                <%--<span class="input-group-btn">--%>
                <%--<button class="browse btn" type="button" style="border-color:black">--%>
                <%--Browse</button>--%>
            <input type="file" name="file" class="form-control" style="border-color:black">
        </div>
        <input type="submit" class="btn" style="border-color: #333;" value="Register"/>
    </form:form>
</div>
