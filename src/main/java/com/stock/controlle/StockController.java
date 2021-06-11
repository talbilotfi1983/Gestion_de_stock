package com.stock.controlle;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.stock.dao.Interface.IFlickrDao;
import com.stock.entities.MouvementStock;
import com.stock.entities.Article;
import com.stock.entities.Category;
import com.stock.service.impl.MouvementStockServiceImpl;
import com.stock.service.Interface.IArticleService;
import com.stock.service.impl.CategoryServiceImpl;

@Controller
@RequestMapping("/mouvementStock")
public class StockController {
	@Autowired
	private MouvementStockServiceImpl mouvementStockService;
	@Autowired
	private CategoryServiceImpl categoryService;

	@Autowired
	private IFlickrDao flickrService;
	@Autowired
	private IArticleService articleService;

	@GetMapping("")
	public String list(Model model) {
		List<MouvementStock> mouvementStocks = mouvementStockService.selectAll();
		if (mouvementStocks == null) {
			mouvementStocks = new ArrayList<MouvementStock>();
		}
		model.addAttribute("list", mouvementStocks);
	
		return "mouvementStock/mouvementStock";
	}

	@GetMapping("/ajouterMouvementStock")
	public String ajouter(Model model) {
		List<Category> categories = categoryService.selectAll();
		if (categories == null) {
			categories = new ArrayList<Category>();
		}
		model.addAttribute("categories", categories);
		List<Article> articles =  articleService.selectAll();
		if (articles == null) {
			articles = new ArrayList<Article>();
		}
		model.addAttribute("articles", articles);

		model.addAttribute("mouvementStock", new MouvementStock());
		return "mouvementStock/ajouterMouvementStock";
	}

	@GetMapping("/modifierMouvementStock/{id}")
	public String modifier(Model model, @PathVariable(name = "id") Long id) {
		List<Category> categories = categoryService.selectAll();
		if (categories == null) {
			categories = new ArrayList<Category>();

		}
		model.addAttribute("categories", categories);
		model.addAttribute("mouvementStock", mouvementStockService.getById(id));
		return "/mouvementStock/ajouterMouvementStock";
	}

	@GetMapping("/suprimerMouvementStock/{idArtcle}")
	public String suprimer(Model model, @PathVariable(name = "idArtcle") Long id) {
		if (id != null) {
			MouvementStock entity = mouvementStockService.getById(id);
			if (entity != null) {
				mouvementStockService.remove(id);
			}
		}
		return "redirect:/mouvementStock/";
	}

	@PostMapping("/majMouvementStock")
	public String enregistrer(MouvementStock mouvementStock, MultipartFile file) {
		if (mouvementStock != null) {
			if (mouvementStock.getId() != null) {
				mouvementStockService.update(mouvementStock);
			} else {
				mouvementStockService.save(mouvementStock);
			}
		} else {
			return "redirect:/mouvementStock/ajouterCommandeFournisseur";
		}
		return "redirect:/mouvementStock/";

	}

}