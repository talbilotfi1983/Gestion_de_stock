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
import com.stock.entities.Role;
import com.stock.entities.Utilisateur;
import com.stock.service.impl.RoleServiceImpl;
import com.stock.service.impl.UtilisateurServiceImpl;


@Controller
@RequestMapping("/role")
public class RoleController{
	@Autowired
	private RoleServiceImpl roleService;
	@Autowired
	private UtilisateurServiceImpl utilisateurService;
	@GetMapping("")
	public String list(Model model) {
		List<Role> roles = roleService.selectAll();
		if (roles == null) {
			roles = new ArrayList<Role>();
		}
		model.addAttribute("list", roles);
		return "role/role";
		}

	@GetMapping("/ajouterRole")
	public String ajouter(Model model) {
		List<Utilisateur> utilisateurs= utilisateurService.selectAll();
		if(utilisateurs== null){
			utilisateurs = new ArrayList<Utilisateur>();
		}
		model.addAttribute("utilisateurs", utilisateurs);
		
		model.addAttribute("role", new Role());
		return "role/ajouterRole";
	}

	@GetMapping("/modifierRole/{id}")
	public String modifier(Model model, @PathVariable(name = "id") Long id) {
		List<Utilisateur> utilisateurs= utilisateurService.selectAll();
		if(utilisateurs== null){
			utilisateurs = new ArrayList<Utilisateur>();
			
		}
		model.addAttribute("utilisateurs", utilisateurs);
		model.addAttribute("role",roleService.getById(id));
		return "/role/ajouterRole";
	}

	
	@GetMapping("suprimerRole/{idArtcle}")
	public String suprimer(Model model, @PathVariable(name = "idArtcle") Long id) {
		if(id!=null){
			Role entity = roleService.getById(id);
			if(entity!=null){
				roleService.remove(id);
			}
		}
		return  "redirect:/role/";
	}

	@PostMapping("/majRole")
	public String enregistrer(Role role) {
		if (role != null) {
			if (role.getId() != null) {
				roleService.update(role);
			} else {
				roleService.save(role);
			}
		} else {
			return "redirect:/role/ajouterRole";
		}
		return "redirect:/role/";
	}

}