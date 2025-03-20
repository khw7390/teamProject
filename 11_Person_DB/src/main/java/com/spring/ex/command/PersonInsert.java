package com.spring.ex.command;

import javax.servlet.http.HttpServletRequest;

import com.spring.ex.dao.PersonDao;

public class PersonInsert implements PersonCommand{

	@Override
	public void execute(HttpServletRequest request) {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		PersonDao pdao = PersonDao.getInstance();
		int cnt = pdao.insertPerson(id,name,age);
	}

}
