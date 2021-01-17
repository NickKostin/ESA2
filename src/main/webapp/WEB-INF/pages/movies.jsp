<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Movies Page</title>
</head>
<body>

<h1>Movie List</h1>

<c:if test="${!empty listMovies}">
    <table class="tg">
        <tr>
            <th width="120">Title</th>
            <th width="120">Price</th>
            <th width="120">Year</th>
            <th width="120">Directors</th>
        </tr>
        <c:forEach items="${listMovies}" var="movie">
            <tr>
                <td>${movie.title}</td>
                <td>${movie.price}</td>
                <td>${movie.year}</td>
                <c:forEach items="${movie.directors}" var="dir">
                    <td>${dir.name} ${dir.surname}</td>
                </c:forEach>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
