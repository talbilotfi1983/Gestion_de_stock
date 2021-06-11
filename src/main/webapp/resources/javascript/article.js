/**
 * 
 */
$(document).ready(function() {
	$("#tauxTva").on("keyup",function(){
		//alert("Tva Event")
		tvaKeyUpFunction();
	});
	tvaKeyUpFunction = function() {
		var prixUnitaireHt= $("#prixUnitaireHt").val();
		var tauxTva=  $("#tauxTva").val();
		var prixUnitaireTtc = (parseFloat(tauxTva/100)*parseFloat(prixUnitaireHt))+parseFloat(prixUnitaireHt);
		$("#prixUnitaireTtc").val(prixUnitaireTtc);
	}
});