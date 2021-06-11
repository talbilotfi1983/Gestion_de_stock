function updateDetailCommande(idCommandeClient){
	var json = $.parseJSON($("#json" + idCommandeClient).text());
	if (json) {
		var detailHtml = ""
		for (var i = 0; i < json.length; i++) {
			/*
			console.log(json[i].article.code);
			console.log(json[i].quantite);
			console.log(json[i].prixUnitaire);*/
			detailHtml += "<tr>" + "<td>"+json[i].article.code+"</td>" + "<td>"+json[i].quantite+"</td>" + "<td>"+json[i].prixUnitaire+"</td>"
					+ "<td>0</td>" + "</tr>";
		}
		$("#detailCommande").html(detailHtml);
	}
}