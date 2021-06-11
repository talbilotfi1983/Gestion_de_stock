package com.stock.controlle;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stock.entities.Client;
import com.stock.entities.CommandeClient;
import com.stock.entities.LigneCommandeClient;
import com.stock.service.Interface.IClientService;
import com.stock.service.Interface.ICommandeClientService;
import com.stock.service.Interface.ILigneCommandeClientService;


@Controller
@RequestMapping("/commandeClient")
public class CommandeClientController{
	

	@Autowired
	private ICommandeClientService commandeClientService;
	@Autowired
	private IClientService clientService;
	@Autowired
	private ILigneCommandeClientService ligneCommandeClientService;
	@GetMapping("")
	public String list(Model model) {
		List<CommandeClient> commandeClients = commandeClientService.selectAll();
		if (commandeClients.isEmpty()) {
			commandeClients = new ArrayList<CommandeClient>();
		}else {
			commandeClients.forEach(commandeClient->{
		
				List<LigneCommandeClient> ligneCommandeClients 
				= ligneCommandeClientService.getByIdCommandes(commandeClient.getId()) ;
				commandeClient.setLigneCommandeClients(ligneCommandeClients);
				
			});
		}
		model.addAttribute("list", commandeClients);
		return "commandeClient/commandeClient";
		}

	@GetMapping("/ajouterCommandeClient")
	public String ajouter(Model model) {
		List<Client> clients= clientService.selectAll();
		if(clients== null){
			clients = new ArrayList<Client>();
		}
		model.addAttribute("clients", clients);
		model.addAttribute("commandeClient", new CommandeClient());
		return "commandeClient/ajouterCommandeClient";
	}

	@GetMapping("/modifierCommandeClient/{id}")
	public String modifier(Model model, @PathVariable(name = "id") Long id) {
		List<Client> clients= clientService.selectAll();
		if(clients== null){
			clients = new ArrayList<Client>();
		}
		model.addAttribute("clients", clients);
		model.addAttribute("commandeClient",commandeClientService.getById(id));
		return "/commandeClient/ajouterCommandeClient";
	}

	
	@GetMapping("suprimerCommandeClient/{idCommandeClient}")
	public String suprimer(Model model, @PathVariable(name = "idCommandeClient") Long id) {
		if(id!=null){
			CommandeClient entity = commandeClientService.getById(id);
			if(entity!=null){
				commandeClientService.remove(id);
			}
		}
		return  "redirect:/commandeClient/";
	}

	@PostMapping("/majCommandeClient")
	public String enregistrer(CommandeClient commandeClient) {
		if (commandeClient != null) {
			if (commandeClient.getId() != null) {
				commandeClientService.update(commandeClient);
				
			} else {
				commandeClientService.save(commandeClient);
			}
		} else {
			return "redirect:/commandeClient/ajouterCommandeClient";
		}
		return "redirect:/commandeClient/";
	}

}