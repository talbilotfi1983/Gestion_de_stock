<div class="navbar-default sidebar" role="navigation">
	<div class="sidebar-nav navbar-collapse">
		<ul class="nav" id="side-menu">
			<li class="sidebar-search">
				<div class="input-group custom-search-form">

					<input type="text" class="form-control"
						placeholder="<spring:message code="common.rechercher"/>">
					<span class="input-group-btn">
						<button class="btn btn-default" type="button">
							<i class="fa fa-search"></i>
						</button>
					</span>
				</div> <!-- /input-group -->
			</li>
			<li><a href="${homeUrl}"><i class="fa fa-dashboard fa-fw"></i>
					<spring:message code="common.dashbord" /> </a></li>
			<li><a href="${articleUrl}"><i class="fa fa-dashboard fa-fw"></i>
					<spring:message code="common.article" /> </a></li>
			<li><a href=""><i class="fa fa-bar-chart-o fa-fw"></i> <spring:message
						code="common.client" /><span class="fa arrow"></span></a>
				<ul class="nav nav-second-level">
					<li><a href="${clientUrl}"><spring:message
								code="common.client" /></a></li>
					<li><a href="${commandeClientUrl}"><spring:message
								code="common.client.commande" /></a></li>
				</ul> <!-- /.nav-second-level --></li>

			<li><a href=""><i class="fa fa-bar-chart-o fa-fw"></i> <spring:message
						code="common.fournisseur" /><span class="fa arrow"></span></a>
				<ul class="nav nav-second-level">
					<li><a href="${fournisseurUrl}"><spring:message
								code="common.fournisseur" /></a></li>
					<li><a href="${commandeFournisseurUrl}"><spring:message
								code="common.fournisseur.commande" /></a></li>
				</ul> <!-- /.nav-second-level --></li>

			<li><a href="${stockUrl}"><i class="fa fa-table fa-fw"></i>
					<spring:message code="common.mouvementStock" /></a></li>
			<li><a href="${venteUrl}"><i class="fa fa-edit fa-fw"></i> <spring:message
						code="common.vente" /></a></li>
			<li><a href="#"><i class="fa fa-wrench fa-fw"></i> <spring:message
						code="common.parametrage" /><span class="fa arrow"></span></a>
				<ul class="nav nav-second-level">
				
					<li><a href="${utilisateurUrl}"><i class="fa fa-user fa-fw"></i>&nbsp;&nbsp;<spring:message
								code="common.parametrage.utilisateur" /></a></li>
								
					<li><a href="${roleUrl}"><i class="fa fa-check fa-fw"></i>&nbsp;&nbsp;<spring:message
								code="common.parametrage.role" /></a></li>
								
					<li><a href="${categoryUrl}"><i class="fa fa-newspaper-o fa-fw" ></i>&nbsp;&nbsp;<spring:message
								code="common.parametrage.category" /></a></li>

				</ul> <!-- /.nav-second-level --></li>

		</ul>
	</div>
	<!-- /.sidebar-collapse -->
</div>