<%-- 
    Document   : Login
    Created on : 27/02/2019, 04:37:53 PM
    Author     : brown
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <style>
@import url('https://fonts.googleapis.com/css?family=Comfortaa');


body {
  background: #456;
  font-family: 'Comfortaa', cursive;
}

.login {
  width: 400px;
  margin: 16px auto;
  font-size: 16px;
}


.login-header,
.login p {
  margin-top: 0;
  margin-bottom: 0;
}


.login-triangle {
  width: 0;
  margin-right: auto;
  margin-left: auto;
  border: 12px solid transparent;
  border-bottom-color: #28d;
}

.login-header {
  background: #28d;
  padding: 30px;
  font-size: 1.4em;
  font-weight: normal;
  text-align: center;
  text-transform: uppercase;
  color: #fff;
}

.login-container {
  background: #ebebeb;
  padding: 12px;
}

.login p {
  padding: 12px;
}

.login input {
  box-sizing: border-box;
  display: block;
  width: 100%;
  border-width: 3px;
  border-style: solid;
  padding: 16px;
  outline: 0;
  font-family: inherit;
  font-size: 0.95em;
}
 
  .login input {
  box-sizing: border-box;
  display: block;
  width: 100%;
  border-width: 3px;
  border-style: solid;
  padding: 16px;
  outline: 0;
  font-family: inherit;
  font-size: 0.95em;
}  
.login input[type="text"],
.login input[type="password"] {
  background: #fff;
  border-color: #bbb;
  color: #555;
}


.login input[type="text"]:focus,
.login input[type="password"]:focus {
  border-color: #888;
}

.login input[type="submit"] {
  background: #28d;
  border-color: transparent;
  color: #fff;
  cursor: pointer;
  box-sizing: border-box;
  width: 50%;
}

.login input[type="submit"]:hover {
  background: #17c;
}

.login input[type="submit"]:focus {
  
  border-color: #05a;
}
</style>
<div class="login">
  <div class="login-triangle"></div>
  
  <h2 class="login-header">CopyQuick</h2>

  <form class="login-container">
    <p><input type="text" placeholder="Usuario"></p>
    <p><input type="password" placeholder="Contrase�a"></p>
   
    
 <p align="center"> 
<form action="" method=post>
<input type="submit" name="Submit" value="Ingresar" >
&nbsp;
<input name="submit2" type="submit" value="Registrarse">
</form>
</p>
    

  </form>
</div>
</html>
