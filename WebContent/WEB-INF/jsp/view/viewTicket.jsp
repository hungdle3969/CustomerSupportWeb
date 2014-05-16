<%--@elvariable id="ticketId" type="java.lang.String" --%>
<%--@elvarialbe id="ticket" type="com.hung.le.pojo.Ticket --%>

<template:basic htmlTitle="${ticket.subject}" bodyTitle="Ticket #${ticketId}: ${ticket.subject}">
	<i>Customer Name - <c:out value="${ticket.customerName}"></c:out><br />
	Created <wrox:formatDate value="${ticket.dateCreated}" type="both" timeStyle="long" dateStyle="full" /></i><br /><br />
	<c:out value="${ticket.body}" /><br /><br />
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
</template:basic>