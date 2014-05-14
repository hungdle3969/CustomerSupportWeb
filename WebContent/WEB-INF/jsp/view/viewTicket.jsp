<%@ page session="false" %>
<%--@elvariable id="ticketId" type="java.lang.String" --%>
<%--@elvarialbe id="ticket" type="com.hung.le.pojo.Ticket --%>

<%
	//String ticketId = (String) request.getAttribute("ticketId");
	Ticket ticket = (Ticket) request.getAttribute("ticket");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Support</title>
</head>
<body>
	<a href="<c:url value="/login?logout"></c:url>">Logout</a>
	<h2>Ticket #${ticketId}: <c:out value="${ticket.subject}" /></h2>
	<i>Customer Name - ${ticket.customerName}</i><br /><br />
	<c:out value="${ticket.body}" />
	<c:if test="${ticket.numberOfAttachments > 0}">
		Attachments:
		<c:forEach items="${ticket.attachments}" var="attachment" varStatus="status">
			<c:if test="${!status.fisrt}">, </c:if>
			<a href="<c:url value="/tickets">
				<c:param name="action" value="download" />
				<c:param name="ticketId" value="{ticketId}" />
				<c:param name="attachment" value="${attachment.name}" />
			</c:url>"><c:out value="${attachment.name}"></c:out></a>
		</c:forEach><br /><br />
	</c:if>
	<a href="<c:url value="/tickets"></c:url>">Return to list tickets</a>
</body>
</html>
