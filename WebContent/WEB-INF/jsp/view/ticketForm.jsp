<template:basic htmlTitle="Create a Ticket" bodyTitle="Create a Ticket">
	<form method="post" action="tickets" enctype="multipart/form-data">
		<input type="hidden" name="action" value="createssss" />
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
</template:basic>