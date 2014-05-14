<%--elvariable id="numberOfSessions" type="java.lang.Integer" --%>
<%@ page import="java.util.List" %>

<%!
	private static String toString(long timeInterval){
	
		if(timeInterval < 1_000)
			return "less than one second";
		if(timeInterval < 60_000)
			return (timeInterval / 1_000) + " seconds";
		return "about " + (timeInterval / 60_000) + " minutes";
	}

%>

<%
	int numberOfSessions = (Integer) request.getAttribute("numberOfSessions");
	@SuppressWarnings("unchecked")
	List<HttpSession> sessions = (List<HttpSession>) request.getAttribute("sessionList");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Support</title>
</head>
<body>
	<a href="<c:url value="/login?logout"></c:url>">Logout</a>
	<h2>Sessions</h2>
	There are a total of ${numberOfSessions} active sessions in this application.<br /><br />
	<%
		long timestamp = System.currentTimeMillis();
		for(HttpSession aSession : sessions){
			out.print(aSession.getId() + " - " + aSession.getAttribute("username"));
			
			if(aSession.getId().equals(session.getId()))
				out.print(" (you)");
			out.print(" - last active " + toString(timestamp - aSession.getLastAccessedTime()));
			out.println(" ago<br />");
		}
	%>
</body>
</html>