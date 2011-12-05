<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>

<sf:form method="POST" commandName="toy">	
	<b>ID: </b><sf:hidden path="id"/><c:out value="${toy.id}" /><br/>
	<b>Name: </b><sf:input path="name"/><br/>
	<b>Description: </b><sf:input path="description"/><br/>
	<b>On Hand: </b><sf:input path="onhand"/><br/>
	<input type="submit" />
</sf:form>