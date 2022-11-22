
<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Login</title>
   </head>
   <body>


      <h3>Login Page</h3>
      <p style="color: red;">${errorString}</p>
	  

      <form method="POST" action='<c:url value="/login" />'>
         <table >
            <tr>
               <td>User Name</td>
               <td><input type="text" name="username" value= "" /> </td>
            </tr>
            <tr>
               <td>Password</td>
               <td><input type="password" name="password" value= "" /> </td>
            </tr>
            <tr>
               <td>Role</td>
               <td><input type="text" name="role" value= "" /> </td>
            </tr>
            <tr>
               <td><input type="hidden" name="action" value="login" />  </td>
            </tr>
            <tr>
               <td colspan ="2">
                  <input type="submit" value= "Submit" />
               </td>
            </tr>
         </table>
      </form>




   </body>
</html>