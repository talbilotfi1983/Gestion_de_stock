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

<title><spring:message code="mouvementStock.titre.ajouter" /></title>

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
							<spring:message code="mouvementStock.titre.ajouter" />
						</h1>
					</div>

					<div class="panel-body col-lg-6">

						<f:form modelAttribute="mouvementStock" method="post"
							action="${majMouvementStockUrl}" >

							<f:hidden path="id" />
							<div class="form-group">
								<label class="control-label"><spring:message
										code="mouvementStock.date" /></label>
								<f:input path="date" class="form-control" type="date"
									placeholder="Date mouvement stock" />
							</div>
							<div class="form-group">
								<label class="control-label"><spring:message
										code="mouvementStock.quantite" /></label>
								<f:input path="quantite" class="form-control" type="text"
									placeholder="Quantite" />
							</div>
							<div class="form-group">
								<label class="control-label"><spring:message
										code="mouvementStock.article" /></label>
								<f:select class="form-control" path="article.id"
									items="${articles}" itemLabel="designation" itemValue="id">

								</f:select>
							</div>
							<div class="panel-footer">
								<button class="btn btn-primary" type="submit">
									<i class="fa fa-save">&nbsp;<spring:message
											code="common.enregistrer" /></i>
								</button>
								<a href="${mouvementStockUrl}" class="btn btn-danger"> <i
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
