<%-- @elvariable id="sessions" type="java.util.List<com.hung.le.session.ChatSession>" --%>

<%-- this jsp responsible for listing pending chats for customer support personel to respond --%>
<template:basic htmlTitle="Support Chat" bodyTitle="Support Chat Request">
	<c:choose>
		<c:when test="${fn:length(sessions) == 0}">
			<i>There are no pending support chat requests.</i>
		</c:when>
		<c:otherwise>
			Click on a chat request to accept it: <br /><br />
			<c:forEach items="${sessions}" var="s">
				<a href="javascript:void 0;" onclick="join(${s.sessionId});">${s.customerUsername}</a><br />
			</c:forEach>
		</c:otherwise>
	</c:choose>
	<script type="text/javascript" language="javascript">
		var join = function(id){
			postInvisibleForm('<c:url value="/chat" />', {
				action: 'join', chatSessionId: id
			});
		};
	</script>
</template:basic>