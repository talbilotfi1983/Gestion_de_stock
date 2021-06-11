package com.stock.controlle;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import com.stock.dao.Interface.IFlickrDao;
import com.stock.entities.Client;
import com.stock.service.impl.ClientServiceImpl;


@Controller
@RequestMapping("/client")
public class ClientController{
	

	@Autowired
	private ClientServiceImpl clientService;
	@Autowired
	private IFlickrDao flickrService;

	@GetMapping("")
	public String list(Model model) {
		List<Client> clients = clientService.selectAll();
		if (clients == null) {
			clients = new ArrayList<Client>();
		}
		model.addAttribute("list", clients);
		return "client/client";
		}

	@GetMapping("/ajouterClient")
	public String ajouter(Model model) {
			
		model.addAttribute("client", new Client());
		return "client/ajouterClient";
	}

	@GetMapping("/modifierClient/{id}")
	public String modifier(Model model, @PathVariable(name = "id") Long id) {
		model.addAttribute("client",clientService.getById(id));
		return "/client/ajouterClient";
	}

	
	@GetMapping("suprimerClient/{idArtcle}")
	public String suprimer(Model model, @PathVariable(name = "idArtcle") Long id) {
		if(id!=null){
			Client entity = clientService.getById(id);
			if(entity!=null){
				clientService.remove(id);
			}
		}
		return  "redirect:/client/";
	}

	@PostMapping("/majClient")
	public String enregistrer(Client client ,MultipartFile file) {
		System.out.println(client);
		if (client != null) {
			
			if (file != null && !file.isEmpty()) {
				InputStream stream = null;
				try {
					stream = file.getInputStream();
					client.setPhoto(flickrService.savePhoto(stream, client.getNom()));
					if (client.getId() == null) {
						clientService.save(client);
					} else {
						clientService.update(client);
					}

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("ko");
				} finally {
					try {
						stream.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} else if (client.getId() != null) {
				clientService.update(client);
			}
		}
		return "redirect:/client/";
	}

}