package com.spring.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface PersonCommand {
	void execute(HttpServletRequest request);
}
   