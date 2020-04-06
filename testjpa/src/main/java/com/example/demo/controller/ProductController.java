package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dao.CategoryDao;
import com.example.demo.dao.ProductDao;
import com.example.demo.entity.Product;

@Controller
public class ProductController {

	@Autowired
	private ProductDao dao;
	
	@Autowired
	private CategoryDao cdao;
		
	public void setCdao(CategoryDao cdao) {
		this.cdao = cdao;
	}

	public void setDao(ProductDao dao) {
		this.dao = dao;
	}

	@GetMapping("/insert")
	public String insertForm(Model model) {
		model.addAttribute("clist", cdao.findAll());
		return "insert";
	}
	
	@PostMapping("/insert")
	public String insertProduct(Product p) {
		dao.save(p);
		return "redirect:/list";
	}
	
	
	@GetMapping("/list")
	public void list(Model model) {
		model.addAttribute("title", "비트 쇼핑몰 상품목록");
		model.addAttribute("list", dao.findAll());
	}
	
	@GetMapping("/delete")
	public String delete(int id) {
		dao.deleteById(id);
		return "redirect:/list";
	}
	
	@GetMapping("/edit")
	public void edit(int id, Model model) {
		System.out.println("editForm call.....................");
	    System.out.println("id:"+id);
		System.out.println("상품정보 출력:"+dao.getOne(id));
		System.out.println("상품정보 출력:"+dao.findById(id));
		
		model.addAttribute("p", dao.getOne(id));
	}
	
	
}
