<%--
  Created by IntelliJ IDEA.
  User: MAHE
  Date: 7/13/2017
  Time: 5:38 PM
  To change this template use File | Settings | File Templates.
--%>
<div class="panel-heading" style="border-color:black">
    Login
</div>

<div class="panel-body">
    <form method="post" action="/login">
        <div class="form-group">
            <label for="usrlogin">Username:*</label>
            <input type="text" class="form-control" name="username" id="usrlogin" style="border-color:black" required>
        </div>
        <br>
        <div class="form-group">
            <label for="pwdlogin">Password:*</label>
            <input type="password" class="form-control" name="password" id="pwdlogin" style="border-color:black" required>
        </div>

        <a href="/forgotpwd">Forgot Password</a>
        <input type="submit" class="btn" style="border-color: #333;" value="Login"/>
    </form>
</div>
