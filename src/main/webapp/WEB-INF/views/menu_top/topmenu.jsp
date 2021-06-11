<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<ul class="nav navbar-top-links navbar-right">
	<li class="dropdown"><a class="dropdown-toggle"
		data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
			<i class="fa fa-caret-down"></i>
	</a>
		<ul class="dropdown-menu dropdown-user">
			<li><a href="${frUrl}"><i class="fa fa-globe fa-fw"></i> <spring:message
						code="locale.fr" /></a></li>
			<li><a href="${enUrl}"><i class="fa fa-globe fa-fw"></i> <spring:message
						code="locale.en" /></a></li>
			<li class="divider"></li>
			<c:url value="/j_spring_security_logout" var="logout"/>
			<li><a href="${logoutUrl}"><i class="fa fa-sign-out fa-fw"></i>
					Logout</a></li>
		</ul></li>
</ul>