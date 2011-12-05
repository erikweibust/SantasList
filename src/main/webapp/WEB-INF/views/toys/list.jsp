<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>Toy List</h2>

<a href="/santaslist/toys?new">Create</a>
<hr/>
<ul>
	<c:forEach items="${toys}" var="toy">
		<li><a href="toys/${toy.id}">${toy.name}</a></li>
	</c:forEach>
</ul>