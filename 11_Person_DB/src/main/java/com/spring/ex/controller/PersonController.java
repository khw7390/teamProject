package com.spring.ex.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.ex.command.PersonCommand;
import com.spring.ex.command.PersonDelete;
import com.spring.ex.command.PersonInsert;
import com.spring.ex.command.PersonList;
import com.spring.ex.command.PersonUpdate;
import com.spring.ex.command.PersonUpdateForm;

@Controller
public class PersonController {

	PersonCommand pcom = null;
	
	@RequestMapping("insertForm")
	public String insertForm() {
		
		return "insertForm";// insertForm.jsp
	}
	
	@RequestMapping("insert") // form.jsp에서 요청
	public String insert(HttpServletRequest request) {
		
		pcom = new PersonInsert();
		pcom.execute(request);
		
		//return "list"; // list.jsp
		return "redirect:/list";
	}
	
	@RequestMapping("list")
	public String list(HttpServletRequest request) {
		
		pcom = new PersonList();
		pcom.execute(request);
		
		return "list"; // list.jsp
	}
	
	@RequestMapping("updateForm")
	public String updateForm(HttpServletRequest request) {
		pcom = new PersonUpdateForm();
		pcom.execute(request);
		return "updateForm";
	}
	
	@RequestMapping("update")
	public String update(HttpServletRequest request) {
		
		pcom = new PersonUpdate();  
		
		pcom.execute(request);
		
		return "redirect:/list";
	}
	
	@RequestMapping("delete")
	public String delete(HttpServletRequest request) {
		pcom = new PersonDelete();
		pcom.execute(request);
		return "redirect:/list";
	}
}
