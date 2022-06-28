package org.kjg.web;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@org.springframework.stereotype.Controller
public class Controller {
	private final BookDAO bookDao;
	private static final String FILE_SERVER_PATH = "C:\\javastudy\\stsworkspace\\book\\src\\main\\webapp\\resources\\file";
	public Controller(BookDAO bookDao) {this.bookDao = bookDao;}
	
	/*
	 * @RequestMapping(value="/list") public String bookList(Model model) {
	 * 
	 * List<BookDTO> booklist = bookDao.selectAll(); model.addAttribute("bookList",
	 * booklist); return "book_list"; }
	 */
	
	@RequestMapping("/list")
	public String bookList(PagingVO vo, Model model, @RequestParam(value="nowPage", required=false)String nowPage, @RequestParam(value="cntPerPage", required=false)String cntPerPage) {
		int total = bookDao.bookCount();
		
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) { 
			cntPerPage = "10";
		}
		vo = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		model.addAttribute("paging", vo);
		model.addAttribute("viewAll", bookDao.selectBook(vo));
		return "book_list";
	}
	
	@RequestMapping(value="/search")
	public String searchList(Model model, HttpServletRequest req) {
		BookDTO bdt = new BookDTO();
		bdt.setSearch(req.getParameter("search"));
		List<BookDTO> bookList = bookDao.selectSearch(bdt);
		model.addAttribute("viewAll", bookList);
		return "book_list";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String insertList(@ModelAttribute("bdt") BookDTO bdt) {
		return "book_reg_form";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String insertList(@RequestParam("uploadFile") MultipartFile file, @ModelAttribute("bdt") BookDTO bdt, Model model, HttpServletRequest req, Errors errors)throws IllegalStateException, IOException {

		new BookRequestValidator().validate(bdt, errors);
		
		if(errors.hasErrors()) {
			return "book_reg_form";
		}
		else {
			String imgName = req.getParameter("imgName");
			long isbn = Long.parseLong(req.getParameter("isbn"));
			String title = req.getParameter("title");
			String person = req.getParameter("person");
			String publisher = req.getParameter("publisher");
			long price = Long.parseLong(req.getParameter("price"));	
			String cont = req.getParameter("cont");
			bdt = new BookDTO(imgName, isbn, title, person, publisher, price, cont);
			bookDao.insert(bdt);

			if(!file.getOriginalFilename().isEmpty()) {
				file.transferTo(new File(FILE_SERVER_PATH, file.getOriginalFilename()));
				model.addAttribute("msg", "File uploaded successfully.");
			}else {
				model.addAttribute("msg", "Please select a valid mediaFile..");
			}
			return "redirect:list";
		}
	}
	
	@RequestMapping(value="/read")
	public String readList(Model model, HttpServletRequest req) {
		BookDTO bdt = new BookDTO();
		bdt.setTitle(req.getParameter("title"));
		bdt = bookDao.selectByTitle(bdt.getTitle());
		model.addAttribute("showList", bdt);
		return "book_read";
	}

}
