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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.stock.service.Interface.ICategoryService;
import com.stock.service.Interface.IFlickrService;

import com.stock.entities.Category;

@Controller
@RequestMapping("/category")

public class CategoryController {

	@Autowired
	private ICategoryService categoryService;

	@Autowired
	private IFlickrService flickrService;

	@GetMapping("")
	public String list(Model model) {
		List<Category> categories = categoryService.selectAll();
		if (categories == null) {
			categories = new ArrayList<Category>();
		}
		Category cat;
		model.addAttribute("list", categories);
		return "category/category";
	}

	@GetMapping("/ajouterCategory")
	public String ajouter(Model model) {
		model.addAttribute("entity", new Category());
		return "category/ajouterCategory";
	}

	@GetMapping("/modifierCategory/{id}")
	public String modifier(Model model, @PathVariable(name = "id") Long id) {
		model.addAttribute("entity", categoryService.getById(id));
		return "/category/ajouterCategory";
	}

	@GetMapping("/suprimerCategory/{id}")
	public String suprimer(Model model, @PathVariable(name = "id") Long id) {
		if (id != null) {
			Category entity = categoryService.getById(id);
			if (entity != null) {
				categoryService.remove(id);
			}
		}
		return "redirect:/category/";
	}

	@PostMapping("/majCategory")
	public String enregistrer(Category category) {
		if (category != null) {
			if (category.getId() != null) {
				categoryService.update(category);
			} else {
				categoryService.save(category);
			}
		} else {
			return "redirect:/category/ajouterCategory";
		}
		return "redirect:/category/";
	}
}
