
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html><head><title>Login</title></head><body>
  <h2>Voter Login</h2>
  <form action="login" method="post">
    Email: <input type="email" name="email" required/><br/>
    Password: <input type="password" name="password" required/><br/>
    <button type="submit">Login</button>
  </form>
  <c:if test="${param.error == '1'}"><p style="color:red">Invalid credentials</p></c:if>
</body></html>
