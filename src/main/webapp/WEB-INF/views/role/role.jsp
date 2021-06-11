<%@ include file="/WEB-INF/views/includes/includes.jsp"%>

<!-- DataTables CSS -->
<link
	href="<%=contextPath%>/resources/vendor/datatables-plugins/dataTables.bootstrap.css"
	rel="stylesheet">

<!-- DataTables Responsive CSS -->
<link
	href="<%=contextPath%>/resources/vendor/datatables-responsive/dataTables.responsive.css"
	rel="stylesheet">
<!DOCTYPE html>
<html lang="fr">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title><spring:message code="common.role" /></title>

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
							<spring:message code="common.role" />
						</h1>
					</div>
					<div class="row">
						<div class="col-lg-12">
							<ol class="breadcrumb">
								<li><a href="${ajouterRoleUrl}"><i class="fa fa-plus">&nbsp;<spring:message
												code="common.ajouter" /></i></a></li>
								<li><a href="#"><i class="fa fa-upload">&nbsp;<spring:message
												code="common.exporter" /></i></a></li>
								<li><a href="#"><i class="fa fa-download">&nbsp;<spring:message
												code="common.importer" /></i></a></li>
							</ol>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-12">
							<div class="panel panel-default">

								<!-- /.panel-heading -->
								<div class="panel-body">
									<table width="100%"
										class="table table-striped table-bordered table-hover"
										id="dataTables-example">
										<thead>
											<tr>
												<th><spring:message code="role.name" /></th>
												<th><spring:message code="role.utilisateur" /></th>
												<th><spring:message code="common.actions" /></th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${list}" var="role">
												<tr class="something">
													<td class="col-md-2">${role.getRoleName()}</td>
													<td class="col-md-2">${role.getUtilisateur().getNom()}</td>

													<td class="col-md-2"><a
														href="${modifierRoleUrl}${role.getId()}"><i
															class="fa fa-edit"></i></a> &nbsp;|&nbsp; <a
														href="javascript:void(0)" data-toggle="modal"
														data-target="#modelRole${role.getId()}"> <i
															class="fa fa-trash-o"></i></a>
														<div class="modal fade" id="modelRole${role.getId()}"
															tabindex="-1" role="dialog"
															aria-labelledby="myModalLabel" aria-hidden="true">
															<div class="modal-dialog">
																<div class="modal-content">
																	<div class="modal-header">
																		<button type="button" class="close"
																			data-dismiss="modal" aria-hidden="true">&times;</button>
																		<h4 class="modal-title" id="myModalLabel">
																			<spring:message code="common.modal.title" />
																		</h4>
																	</div>
																	<div class="modal-body">
																		<spring:message code="common.modal.body" />
																	</div>
																	<div class="modal-footer">
																		<a href="${roleUrl}" class="btn btn-default"> <i
																			class="fa fa-arrow-left">&nbsp;<spring:message
																					code="common.annuler" /></i>
																		</a> <a href="${suprimerRoleUrl}/${role.getId()}"
																			class="btn btn-danger"> <i class="fa fa-trash-o">&nbsp;<spring:message
																					code="common.suprimer" /></i>
																		</a>
																	</div>
																</div>
																<!-- /.modal-content -->

																<!-- /.modal -->
															</div>
															<!-- .panel-body -->
														</div></td>
												</tr>
											</c:forEach>

										</tbody>
									</table>
									<!-- /.table-resp m mmonsive -->

								</div>
								<!-- /.panel-body -->
							</div>
							<!-- /.panel -->
						</div>
						<!-- /.col-lg-12 -->
					</div>
				</div>

			</div>
			<!-- /.container-fluid -->
		</div>
		<!-- /#page-wrapper -->
		<!-- Modal -->

		<!-- /.panel -->

	</div>
	<!-- /#wrapper -->
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
	<script>
		$(document).ready(function() {
			$('#dataTables-example').DataTable({
				responsive : true
			});
		});
	</script>


</body>

</html>
