<%@ include file="/WEB-INF/views/includes/includes.jsp"%>
<!-- DataTables CSS -->
<link
	href="<%=contextPath%>/resources/vendor/datatables-plugins/dataTables.bootstrap.css"
	rel="stylesheet">

<!-- DataTables Responsive CSS -->
<link href="<%=contextPath%>/resources/vendor/datatables-responsive/dataTables.responsive.css"
	rel="stylesheet">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="fr">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title><spring:message code="commandeClient.titre.ajouter" /></title>

</head>

<body>

	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="javascript:void(0)"><spring:message
						code="common.logos" /></a>
			</div>
			<!-- /.navbar-header -->
			<%@ include file="/WEB-INF/views/menu_top/topmenu.jsp"%>
			

			<!-- /.navbar-top-links -->

			<%@ include file="/WEB-INF/views/menu_left/leftmenu.jsp"%>
			<!-- /.navbar-static-side -->
		</nav>

		<!-- Page Content -->
		<div id="page-wrapper">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">
							<spring:message code="commandeClient.titre.ajouter" />
						</h1>
					</div>

					<div class="panel-body col-lg-6">

						<f:form modelAttribute="commandeClient" method="post"
							action="${majCommandeClientUrl}" >

							<f:hidden path="id" />
							<div class="form-group">
								<label class="control-label"><spring:message
										code="commandeClient.code" /></label>
								<f:input path="code" class="form-control" type="text"
									placeholder="Code Commande client" />
							</div>
							<div class="form-group">
								<label class="control-label"><spring:message
										code="commandeClient.date" /></label>
								<f:input path="date" class="form-control" type="date"
									placeholder="Date Commande client" />
							</div>
							<div class="form-group">
								<label class="control-label"><spring:message
										code="commandeClient.client" /></label>
								<f:select class="form-control" path="client.id"
									items="${clients}" itemLabel="nom" itemValue="id">

								</f:select>
							</div>
							<div class="panel-footer">
								<button class="btn btn-primary" type="submit">
									<i class="fa fa-save">&nbsp;<spring:message
											code="common.enregistrer" /></i>
								</button>
								<a href="${commandeClientUrl}" class="btn btn-danger"> <i
									class="fa fa-arrow-left">&nbsp;<spring:message
											code="common.annuler" /></i>
								</a>
							</div>


						</f:form>

					</div>

				</div>
				<!-- /.col-lg-12 -->
			</div>
		</div>
		<!-- DataTables JavaScript -->
		<script
			src="<%=contextPath%>/resources/vendor/datatables/js/jquery.dataTables.min.js"></script>
		<script
			src="<%=contextPath%>/resources/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
		<script
			src="<%=contextPath%>/resources/vendor/datatables-responsive/dataTables.responsive.js"></script>

		<!-- Custom Theme JavaScript -->
		<script src="<%=contextPath%>/resources/dist/js/sb-admin-2.js"></script>

		<!-- Page-Level Demo Scripts - Tables - Use for reference -->
		</body>

</html>
