package net.websnet.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.AllArgsConstructor;
import net.websnet.domain.GuestVO;
import net.websnet.domain.PageVO;
import net.websnet.service.GuestService;
import net.websnet.util.PgIndex;

@Controller
@AllArgsConstructor
@RequestMapping("Guest/*")
public class GuestController {
	private static final Logger log = LoggerFactory.getLogger(GuestController.class);

	private GuestService service; // controller 에서는 자동주입

//	@GetMapping("guest_list")
//	public void guestList(Model model) {
//		//System.out.println("guest_list....");
//		model.addAttribute("list", service.guestList() );
//		//service.guestList().forEach(guest-> System.out.println(guest));
//		
//	}

	@GetMapping("guest_list")
	public void guestList(Model model, @RequestParam("page") int page) {
		System.out.println(" guest_list....  page : " + page);
		String url = "guest_list";
		String s_query = "";
		String addtag = "";
		String query = "";
		String key = "";

		int nowpage = 1;
		int maxlist = 10;
		int totpage = 1;
		int totcount = service.guestCount();
		if (totcount % maxlist == 0) {
			totpage = totcount / maxlist;
		} else {
			totpage = totcount / maxlist + 1;
		}

		if (totpage == 0)
			totpage = 1;
		if (page != 0)
			nowpage = page;
		if (nowpage > totpage)
			nowpage = totpage;
		
		int pagestart = (nowpage-1)*maxlist + 1;
		int endpage = nowpage * maxlist;
		int listcount = totcount - ((nowpage-1)*maxlist) + 1;
		
		PageVO pvo = new PageVO();
		pvo.setEndpage(endpage);
		pvo.setPagestart(pagestart);
		List<GuestVO> list = service.guestList_paged(pvo);
		
		System.out.println( "list : " + list.hashCode());
		System.out.println("----------------");
		for(int i = 0 ; i < list.size(); i ++) {
			System.out.print(list.get(i).getSubject() + " ");
		}
		System.out.println("----------------");
		
		System.out.println("endpage : " + pvo.getEndpage()  + " pagestart : "  + pvo.getPagestart());
		
		model.addAttribute("list" , list);
		model.addAttribute("addtag" , addtag);
		model.addAttribute("url" , url);
		model.addAttribute("nowpage" , nowpage);
		model.addAttribute("totpage" , totpage);
		model.addAttribute("totcount" , totcount);
		model.addAttribute("pagestart" , pagestart);
		model.addAttribute("listcount" , listcount);
		model.addAttribute("listpage" , PgIndex.pageList(nowpage, totpage, url, addtag));

	}

	@GetMapping("guest_write")
	public void guestWrite() {
		System.out.println("guest_write....");

	}

	@PostMapping("guest_write")
	public void guestWritePost() {
		System.out.println("guest_write_post");
	}
}
