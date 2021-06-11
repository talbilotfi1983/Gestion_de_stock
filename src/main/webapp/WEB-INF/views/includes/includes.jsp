<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@page session="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page session="true"%>
<%@page trimDirectiveWhitespaces="true"%>
<%@page contentType="text/html;charset=UTF-8" %>
<%
	String contextPath = request.getContextPath();
%>

<link href="<%=contextPath%>/resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="<%=contextPath%>/resources/vendor/metisMenu/metisMenu.min.css"
	rel="stylesheet">
<!-- Custom CSS -->
<link href="<%=contextPath%>/resources/dist/css/sb-admin-2.css"
	rel="stylesheet">
<!-- Custom Fonts -->
<link
	href="<%=contextPath%>/resources/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
	
<!-- jQuery -->
<script src="<%=contextPath%>/resources/vendor/jquery/jquery.min.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="<%=contextPath%>/resources/vendor/bootstrap/js/bootstrap.min.js"></script>
<!-- Metis Menu Plugin JavaScript -->
<script src="<%=contextPath%>/resources/vendor/metisMenu/metisMenu.min.js"></script>
<!-- Custom Theme JavaScript -->
<script src="<%=contextPath%>/resources/dist/js/sb-admin-2.js"></script>

<c:url value="/home/" var="homeUrl" />
<c:url value="/article/" var="articleUrl" />
<c:url value="/role/" var="roleUrl" />
<c:url value="/commandeClient/" var="commandeClientUrl" />
<c:url value="/fournisseur/" var="fournisseurUrl" />
<c:url value="/commandeFournisseur/" var="commandeFournisseurUrl" />
<c:url value="/mouvementStock/" var="stockUrl" />
<c:url value="/vente/" var="venteUrl" />
<c:url value="/utilisateur/" var="utilisateurUrl" />
<c:url value="/category/" var="categoryUrl" />

<c:url value="/client/" var="clientUrl" />
<c:url value="/client/ajouterClient/" var="ajouterClientUrl" />
<c:url value="/client/modifierClient/" var="modifierClientUrl" />
<c:url value="/client/suprimerClient" var="suprimerClientUrl" />
<c:url value="/client/majClient/" var="majClientUrl" />

<c:url value="/article/majArticle/" var="majArticleUrl" />
<c:url value="/article/ajouterArticle/" var="ajouterArticleUrl" />
<c:url value="/article/modifierArticle/" var="modifierArticleUrl" />
<c:url value="/article/suprimerArticle/" var="suprimerArticleUrl" />

<c:url value="/category/majCategory/" var="majCategoryUrl" />
<c:url value="/category/ajouterCategory/" var="ajouterCategoryUrl" />
<c:url value="/category/modifierCategory/" var="modifierCategoryUrl" />
<c:url value="/category/suprimerCategory" var="suprimerCategoryUrl" />

<c:url value="/role/majRole/" var="majRoleUrl" />
<c:url value="/role/ajouterRole/" var="ajouterRoleUrl" />
<c:url value="/role/modifierRole/" var="modifierRoleUrl" />
<c:url value="/role/suprimerRole" var="suprimerRoleUrl" />

<c:url value="/utilisateur/majUtilisateur/" var="majUtilisateurUrl" />
<c:url value="/utilisateur/ajouterUtilisateur/" var="ajouterUtilisateurUrl" />
<c:url value="/utilisateur/modifierUtilisateur/" var="modifierUtilisateurUrl" />
<c:url value="/utilisateur/suprimerUtilisateur" var="suprimerUtilisateurUrl" />

<c:url value="/commandeClient/" var="commandeClientUrl" />
<c:url value="/commandeClient/ajouterCommandeClient/" var="ajouterCommandeClientUrl" />
<c:url value="/commandeClient/modifierCommandeClient/" var="modifierCommandeClientUrl" />
<c:url value="/commandeClient/suprimerCommandeClient" var="suprimerCommandeClientUrl" />
<c:url value="/commandeClient/majCommandeClient/" var="majCommandeClientUrl" />

<c:url value="/commandeFournisseur/" var="commandeFournisseurUrl" />
<c:url value="/commandeFournisseur/ajouterCommandeFournisseur/" var="ajouterCommandeFournisseurUrl" />
<c:url value="/commandeFournisseur/modifierCommandeFournisseur/" var="modifierCommandeFournisseurUrl" />
<c:url value="/commandeFournisseur/suprimerCommandeFournisseur" var="suprimerCommandeFournisseurUrl" />
<c:url value="/commandeFournisseur/majCommandeFournisseur/" var="majCommandeFournisseurUrl" />

<c:url value="/changeLocale/fr/" var="frUrl" />
<c:url value="/changeLocale/en/" var="enUrl" />

<c:url value="/j_spring_security_logout" var="logoutUrl"/>
<c:url value="/j_spring_security_check" var="loginUrl"/>


<c:url value="/fournisseur/" var="fournisseurUrl" />
<c:url value="/fournisseur/ajouterFournisseur/" var="ajouterFournisseurUrl" />
<c:url value="/fournisseur/modifierFournisseur/" var="modifierFournisseurUrl" />
<c:url value="/fournisseur/suprimerFournisseur" var="suprimerFournisseurUrl" />
<c:url value="/fournisseur/majFournisseur/" var="majFournisseurUrl" />



<c:url value="/mouvementStock/ajouterMouvementStock/" var="ajouterMouvementStockUrl" />
<c:url value="/mouvementStock/modifierMouvementStock/" var="modifierMouvementStockUrl" />
<c:url value="/mouvementStock/suprimerMouvementStock" var="suprimerMouvementStockUrl" />
<c:url value="/mouvementStock/majMouvementStock/" var="majMouvementStockUrl" />
