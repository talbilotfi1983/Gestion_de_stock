package com.stock.controlle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stock.entities.Fournisseur;
import com.stock.entities.CommandeFournisseur;
import com.stock.entities.LigneCommandeFournisseur;
import com.stock.service.Interface.IFournisseurService;
import com.stock.service.Interface.ICommandeFournisseurService;
import com.stock.service.Interface.ILigneCommandeFournisseurService;


@Controller
@RequestMapping("/commandeFournisseur")
public class CommandeFournisseurController{
	

	@Autowired
	private ICommandeFournisseurService commandeFournisseurService;
	@Autowired
	private IFournisseurService fournisseurService;
	@Autowired
	private ILigneCommandeFournisseurService ligneCommandeFournisseurService;
	@GetMapping("")
	public String list(Model model) {
		List<CommandeFournisseur> commandeFournisseurs = commandeFournisseurService.selectAll();
		
		if (commandeFournisseurs.isEmpty()) {
			commandeFournisseurs = new ArrayList<CommandeFournisseur>();
			
		}else {
			commandeFournisseurs.forEach(commandeFournisseur->{
		
				List<LigneCommandeFournisseur> ligneCommandeFournisseurs 
				= ligneCommandeFournisseurService.getByIdCommandes(commandeFournisseur.getId()) ;
				commandeFournisseur.setLigneCommandeFournisseurs(ligneCommandeFournisseurs);
				
			});
		}
		
		model.addAttribute("list", commandeFournisseurs);
		return "commandeFournisseur/commandeFournisseur";
		}

	@GetMapping("/ajouterCommandeFournisseur")
	public String ajouter(Model model) {
		List<Fournisseur> fournisseurs= fournisseurService.selectAll();
		if(fournisseurs== null){
			fournisseurs = new ArrayList<Fournisseur>();
		}
		model.addAttribute("fournisseurs", fournisseurs);
		model.addAttribute("commandeFournisseur", new CommandeFournisseur());
		return "commandeFournisseur/ajouterCommandeFournisseur";
	}

	@GetMapping("/modifierCommandeFournisseur/{id}")
	public String modifier(Model model, @PathVariable(name = "id") Long id) {
		List<Fournisseur> fournisseurs= fournisseurService.selectAll();
		if(fournisseurs== null){
			fournisseurs = new ArrayList<Fournisseur>();
		}
		model.addAttribute("fournisseurs", fournisseurs);
		model.addAttribute("commandeFournisseur",commandeFournisseurService.getById(id));
		return "/commandeFournisseur/ajouterCommandeFournisseur";
	}

	
	@GetMapping("suprimerCommandeFournisseur/{idCommandeFournisseur}")
	public String suprimer(Model model, @PathVariable(name = "idCommandeFournisseur") Long id) {
		if(id!=null){
			CommandeFournisseur entity = commandeFournisseurService.getById(id);
			if(entity!=null){
				commandeFournisseurService.remove(id);
			}
		}
		return  "redirect:/commandeFournisseur/";
	}

	@PostMapping("/majCommandeFournisseur")
	public String enregistrer(CommandeFournisseur commandeFournisseur) {
		if (commandeFournisseur != null) {
			if (commandeFournisseur.getId() != null) {
				commandeFournisseurService.update(commandeFournisseur);
			} else {
				commandeFournisseurService.save(commandeFournisseur);
			}
		} else {
			return "redirect:/commandeFournisseur/ajouterCommandeFournisseur";
		}
		return "redirect:/commandeFournisseur/";
	}

}