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
import com.stock.entities.Article;
import com.stock.entities.Category;
import com.stock.service.impl.ArticleServiceImpl;
import com.stock.service.impl.CategoryServiceImpl;


@Controller
@RequestMapping("/article")
public class ArticleController{
	@Autowired
	private ArticleServiceImpl articleService;
	@Autowired
	private CategoryServiceImpl categoryService;

	@Autowired
	private IFlickrDao flickrService;

	@GetMapping("")
	public String list(Model model) {
		List<Article> articles = articleService.selectAll();
		if (articles == null) {
			articles = new ArrayList<Article>();
		}
		model.addAttribute("list", articles);
		return "article/article";
		}

	@GetMapping("/ajouterArticle")
	public String ajouter(Model model) {
		List<Category> categories= categoryService.selectAll();
		if(categories== null){
			categories = new ArrayList<Category>();
		}
		model.addAttribute("categories", categories);
		
		model.addAttribute("article", new Article());
		return "article/ajouterArticle";
	}

	@GetMapping("/modifierArticle/{id}")
	public String modifier(Model model, @PathVariable(name = "id") Long id) {
		List<Category> categories= categoryService.selectAll();
		if(categories== null){
			categories = new ArrayList<Category>();
			
		}
		model.addAttribute("categories", categories);
		model.addAttribute("article",articleService.getById(id));
		return "/article/ajouterArticle";
	}

	
	@GetMapping("/suprimerArticle/{idArtcle}")
	public String suprimer(Model model, @PathVariable(name = "idArtcle") Long id) {
		if(id!=null){
			Article entity = articleService.getById(id);
			if(entity!=null){
				articleService.remove(id);
			}
		}
		return  "redirect:/article/";
	}

	@PostMapping("/majArticle")
	public String enregistrer(Article article ,MultipartFile file) {
		System.out.println(article);
		if (article != null) {
			
			if (file != null && !file.isEmpty()) {
				InputStream stream = null;
				try {
					stream = file.getInputStream();
					article.setPhoto(flickrService.savePhoto(stream, article.getDesignation()));
					if (article.getId() == null) {
						articleService.save(article);
					} else {
						articleService.update(article);
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
			} else if (article.getId() != null) {
				articleService.update(article);
			}
		}
		return "redirect:/article/";
	}

}