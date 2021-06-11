package com.stock.controlle;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import com.stock.dao.Interface.IFlickrDao;
import com.stock.entities.Utilisateur;
import com.stock.service.impl.UtilisateurServiceImpl;


@Controller
@RequestMapping("/utilisateur")
public class UtilisateurController{
	

	@Autowired
	private UtilisateurServiceImpl utilisateurService;
	@Autowired
	private IFlickrDao flickrService;

	@GetMapping("")
	public String list(Model model) {
		List<Utilisateur> utilisateurs = utilisateurService.selectAll();
		if (utilisateurs == null) {
			utilisateurs = new ArrayList<Utilisateur>();
		}
		model.addAttribute("list", utilisateurs);
		return "utilisateur/utilisateur";
		}

	@GetMapping("/ajouterUtilisateur")
	public String ajouter(Model model) {
			
		model.addAttribute("utilisateur", new Utilisateur());
		return "utilisateur/ajouterUtilisateur";
	}

	@GetMapping("/modifierUtilisateur/{id}")
	public String modifier(Model model, @PathVariable(name = "id") Long id) {
		model.addAttribute("utilisateur",utilisateurService.getById(id));
		return "/utilisateur/ajouterUtilisateur";
	}

	
	@GetMapping("suprimerUtilisateur/{idArtcle}")
	public String suprimer(Model model, @PathVariable(name = "idArtcle") Long id) {
		if(id!=null){
			Utilisateur entity = utilisateurService.getById(id);
			if(entity!=null){
				utilisateurService.remove(id);
			}
		}
		return  "redirect:/utilisateur/";
	}

	@PostMapping("/majUtilisateur")
	public String enregistrer(Utilisateur utilisateur ,MultipartFile file) {
		if (utilisateur != null) {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			utilisateur.setMotDePasse(passwordEncoder.encode(utilisateur.getMotDePasse()));	
			if (file != null && !file.isEmpty()) {
				InputStream stream = null;
				try {
					stream = file.getInputStream();
					utilisateur.setPhoto(flickrService.savePhoto(stream, utilisateur.getNom()));
					if (utilisateur.getId() == null) {
						utilisateurService.save(utilisateur);
					} else {
						utilisateurService.update(utilisateur);
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
			} else if (utilisateur.getId() != null) {
				utilisateurService.update(utilisateur);
			}
		}
		return "redirect:/utilisateur/";
	}

}