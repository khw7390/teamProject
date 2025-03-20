package com.spring.ex.command;

import javax.servlet.http.HttpServletRequest;

import com.spring.ex.dao.PersonDao;
import com.spring.ex.dto.PersonDto;

public class PersonUpdate implements PersonCommand{

	@Override
	public void execute(HttpServletRequest request) {

		PersonDto pd = new PersonDto();
		pd.setNum(Integer.parseInt(request.getParameter("num")));
		pd.setId(request.getParameter("id"));
		pd.setName(request.getParameter("name"));
		pd.setAge(Integer.parseInt(request.getParameter("age")));

		PersonDao pdao = PersonDao.getInstance();
		pdao.updatePerson(pd);
	}

}  