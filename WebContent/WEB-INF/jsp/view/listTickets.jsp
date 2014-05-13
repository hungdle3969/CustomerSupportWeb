<%@ page session="false" import="java.util.Map" %>

<%
	@SuppressWarnings("unchecked")
	Map<Integer, Ticket> ticketDatabase = (Map<Integer, Ticket>) request.getAttribute("ticketDatabase");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Support</title>
</head>
<body>
	<a href="<c:url value="/login?logout"></c:url>">Logout</a>
	<h2>Tickets</h2>
	<a href="<c:url value="/tickets">
		<c:param name="action" value="create" />
	</c:url>">Create Ticket</a><br /><br />
	<%
		if(ticketDatabase.size() == 0){
			%><i>There are no tickets in the system.</i><%
		}
		else {
			for(int id : ticketDatabase.keySet()){
				String idString = "" + id;
				Ticket ticket = ticketDatabase.get(id);
				%>Ticket #<%= idString %>: <a href="<c:url value="/tickets">
					<c:param name="action" value="view" />
					<c:param name="ticketId" value="<%= idString %>" />
				</c:url>"><%= ticket.getSubject() %></a> (customer: <%= ticket.getCustomerName() %>)<br /><%
			}
		}
	%>
</body>
</html>