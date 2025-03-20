package com.spring.ex.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.spring.ex.dao.PersonDao;
import com.spring.ex.dto.PersonDto;

public class PersonList implements PersonCommand{

	@Override
	public void execute(HttpServletRequest request) {
		
		PersonDao pdao = PersonDao.getInstance();
		ArrayList<PersonDto> lists = pdao.getAllPerson();
		request.setAttribute("lists", lists);
	}

}
