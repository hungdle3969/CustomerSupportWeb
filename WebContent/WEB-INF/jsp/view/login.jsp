<%--@elvariable id="loginFailed" type="java.lang.Boolean" --%>

<template:loggedOut htmlTitle="Log In" bodyTitle="Log In">
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
</template:loggedOut>