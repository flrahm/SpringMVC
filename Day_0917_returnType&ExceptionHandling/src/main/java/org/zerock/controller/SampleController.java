package org.zerock.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.SampleDTO;

@Controller
@RequestMapping("/sample/*")
public class SampleController {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	@RequestMapping("")
	public void basic() {
		logger.info("basic() call ... ");
		
	}
	

	
	@RequestMapping(value="/basic" , method= {RequestMethod.GET, RequestMethod.POST})
	public void basicGet(SampleDTO dto) {
		logger.info("basicGet call....");
		logger.info("dto : " + dto);
	}
	
	
	// Model 전달자
	@GetMapping("ex_model")
	public String ex_model(Model model) {

		List<String> list = new ArrayList<String>();
		list.add("ex_model_list1");
		list.add("ex_model_list2");
		list.add("ex_model_list3");
		
		model.addAttribute(list);
		logger.info("model : " + model );
		//System.out.println(model);
		return "ex_model";
	}
	
	
	@GetMapping("ex_04")
	public String ex_04(SampleDTO dto, int page) {
		logger.info("dto : " + dto);
		logger.info("page : " + page);
		System.out.println("dto : " + dto);
		System.out.println("page : " + page);
		return "ex_04";
	}
	
	@GetMapping("ex_04_2")
	public String ex_04_2(SampleDTO dto, @ModelAttribute("page") int page) {
		logger.info("dto : " + dto);
		logger.info("page : " + page);
		System.out.println("dto : " + dto);
		System.out.println("page : " + page);
		return "ex_04_2";
	}
	
	
	// redirection test
	@GetMapping("ex_05")
	public String ex_05() {
		
		return "redirect:/sample/ex_04?page=20";
	}
	
	// redirection test
	@GetMapping("ex_05_1")
	public String ex_05_1(RedirectAttributes rda) {
		
		rda.addFlashAttribute("page",10);
		
		
		return "redirect:/sample/ex_04_2";
	}
	
	@GetMapping("ex_upload")
	public String ex_upload() {
		System.out.println("ex_upload");
		
		return "ex_upload";
	}
	
	@PostMapping("ex_upload_pro")
	public void ex_upload_pro(ArrayList<MultipartFile> files) {
		files.forEach(file->{
			System.out.println("-------------");
			System.out.println("name : " + file.getOriginalFilename());
			System.out.println("size : " + file.getSize());
			
			
		});
	}

}
