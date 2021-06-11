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
import com.stock.entities.Fournisseur;
import com.stock.service.impl.FournisseurServiceImpl;


@Controller
@RequestMapping("/fournisseur")
public class FournisseurController{
	

	@Autowired
	private FournisseurServiceImpl fournisseurService;
	@Autowired
	private IFlickrDao flickrService;

	@GetMapping("")
	public String list(Model model) {
		List<Fournisseur> fournisseurs = fournisseurService.selectAll();
		if (fournisseurs == null) {
			fournisseurs = new ArrayList<Fournisseur>();
		}
		model.addAttribute("list", fournisseurs);
		return "fournisseur/fournisseur";
		}

	@GetMapping("/ajouterFournisseur")
	public String ajouter(Model model) {
			
		model.addAttribute("fournisseur", new Fournisseur());
		return "fournisseur/ajouterFournisseur";
	}

	@GetMapping("/modifierFournisseur/{id}")
	public String modifier(Model model, @PathVariable(name = "id") Long id) {
		model.addAttribute("fournisseur",fournisseurService.getById(id));
		return "/fournisseur/ajouterFournisseur";
	}

	
	@GetMapping("suprimerFournisseur/{idFournisseur}")
	public String suprimer(Model model, @PathVariable(name = "idFournisseur") Long id) {
		if(id!=null){
			Fournisseur entity = fournisseurService.getById(id);
			if(entity!=null){
				fournisseurService.remove(id);
			}
		}
		return  "redirect:/fournisseur/";
	}

	@PostMapping("/majFournisseur")
	public String enregistrer(Fournisseur fournisseur ,MultipartFile file) {
		
		if (fournisseur != null) {
			
			if (file != null && !file.isEmpty()) {
				InputStream stream = null;
				try {
					stream = file.getInputStream();
					fournisseur.setPhoto(flickrService.savePhoto(stream, fournisseur.getNom()));
					if (fournisseur.getId() == null) {
						fournisseurService.save(fournisseur);
					} else {
						fournisseurService.update(fournisseur);
					}

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						stream.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} else if (fournisseur.getId() != null) {
				fournisseurService.update(fournisseur);
			}
		}
		return "redirect:/fournisseur/";
	}

}