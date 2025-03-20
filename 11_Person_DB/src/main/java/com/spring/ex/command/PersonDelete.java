package com.spring.ex.command;

import javax.servlet.http.HttpServletRequest;

import com.spring.ex.dao.PersonDao;

public class PersonDelete implements PersonCommand{

	@Override
	public void execute(HttpServletRequest request) {
		int num = Integer.parseInt(request.getParameter("num"));
		
		PersonDao pdao = PersonDao.getInstance();
		int cnt = pdao.deletePerson(num);
	}

}
