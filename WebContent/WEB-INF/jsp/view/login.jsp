<%--@elvariable id="loginFailed" type="java.lang.Boolean" --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Support</title>
</head>
<body>
	<h2>Login</h2>
	You must log in to access the Customer Support site<br /><br />
	<c:if test="${loginFailed}">
		<b>The username or password you entered are not correct. Please try it again.</b><br /><br />
	</c:if>
	<form method="POST" action="<c:url value="/login"></c:url>">
		Username<br />
		<input type="text" name="username" /><br /><br />
		Password<br />
		<input type="password" name="password" /><br /><br />
		<input type="submit" value="Log In" />
	</form>
</body>
</html>