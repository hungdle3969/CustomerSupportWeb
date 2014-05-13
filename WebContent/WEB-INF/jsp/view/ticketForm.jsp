<%@ page session="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Support</title>
</head>
<body>
	<a href="<c:url value="/login?logout"></c:url>">Logout</a>
	<h2>Create a Ticket</h2>
	<form method="post" action="tickets" enctype="multipart/form-data">
		<input type="hidden" name="action" value="create" />
		<!-- don't need this input anymore since we can get it from session
		Your Name<br/>
		<input type="text" name="customerName"><br/><br/>
		-->
		Subject<br/>
		<input type="text" name="subject"><br/><br/>
		Body<br/>
		<textarea rows="5" cols="30" name="body"></textarea><br/><br/>
		<b>Attachments</b><br/>
		<input type="file" name="file1"/><br/><br/>
		<input type="submit" value="Submit"/>
	</form>
</body>
</html>