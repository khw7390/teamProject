package com.spring.ex.command;

import javax.servlet.http.HttpServletRequest;

import com.spring.ex.dao.PersonDao;
import com.spring.ex.dto.PersonDto;

public class PersonUpdateForm implements PersonCommand{

	@Override
	public void execute(HttpServletRequest request) {
		int num = Integer.parseInt(request.getParameter("num"));
		PersonDao pdao = PersonDao.getInstance();
		PersonDto pd = pdao.oneSelectNum(num);
		
		request.setAttribute("pd", pd);
	}

}
