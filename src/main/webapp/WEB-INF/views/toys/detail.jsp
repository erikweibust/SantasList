<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<h2><c:out value="${toy.name}" /></h2>

<s:url var="editToyUrl" value="/toys/{toyId}?edit">
	<s:param name="toyId" value="${toy.id}" />
</s:url>

<a href="${editToyUrl}">Edit</a><br/>

<p><c:out value="${toy.description}"/></p>

<p><b>On hand</b>: <c:out value="${toy.onhand}"/></p> 