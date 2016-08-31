package com.holodniysvitanok.productmanager.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.holodniysvitanok.productmanager.dao.UserDAO;
import com.holodniysvitanok.productmanager.entity.User;
import com.holodniysvitanok.productmanager.entity.User.Role;

@Controller
public class UserController {

	
	@Autowired
	private UserDAO userDAOImpl;
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String user(HttpServletRequest request) {
		
		int count = 50;
		String countStr = request.getParameter("count");
		
		if(countStr != null){
			count = Integer.parseInt(countStr);
		}
			
		request.setAttribute("users", userDAOImpl.getAllUsers(count));
		
		return "user";
	}
	
	
	
	
	
	/*
	 * 
	 * Сохранение пользователя
	 * 
	 * */
	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public String addUserGET(HttpServletRequest request) {
		
		return "addUser";
	}
	
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public void addUserPOST(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String nameStr = request.getParameter("name");
		String loginStr  = request.getParameter("login");
		String roleStr = request.getParameter("role");
		String addressStr  = request.getParameter("address");
		String passwordStr  = request.getParameter("password");
		String phoneStr  = request.getParameter("phone");
		
		User user = new User();
		user.setName(nameStr);
		user.setLogin(loginStr);
		user.setRole(Role.fromString(roleStr));
		user.setAddressDescription(addressStr);
		user.setPassword(DigestUtils.md2Hex(passwordStr));
		user.setMobilePhone(phoneStr);
		
		userDAOImpl.saveOrUpdate(user);
		
		response.sendRedirect(request.getServletContext().getContextPath()+"/user");
	}
	
	
	
	
	
	/*
	 * 
	 * Настройка пользователя
	 * 
	 * */
	@RequestMapping(value = "/setUser", method = RequestMethod.GET)
	public String setUserGET(HttpServletRequest request) {
		
		
		long id = Long.parseLong(request.getParameter("id"));
		
		User user = userDAOImpl.getUser(id);
		
		request.setAttribute("user", user);
		
		
		
		return "setUser";
	}
	@RequestMapping(value = "/setUser", method = RequestMethod.POST)
	public String setUserPOST(HttpServletRequest request) throws ParseException {
		
		String idStr = request.getParameter("id");
		String nameStr = request.getParameter("name");
		String loginStr  = request.getParameter("login");
		String roleStr = request.getParameter("role");
		String addressStr  = request.getParameter("address");
		String phoneStr  = request.getParameter("phone");
		
		User user = userDAOImpl.getUser(Long.parseLong(idStr));
		
		user.setName(nameStr);
		user.setLogin(loginStr);
		user.setAddressDescription(addressStr);
		user.setRole(Role.fromString(roleStr));
		user.setMobilePhone(phoneStr);
		
		userDAOImpl.saveOrUpdate(user);
		request.setAttribute("user", user);

		
		
		request.setAttribute("message", "Сохранил");
		return "setUser";
	}
	
	
	
	
	
	/*
	 * 
	 * Отображение полной информации о пользователе
	 * 
	 * */
	@RequestMapping(value = "/showUser", method = RequestMethod.GET)
	public String showUser(HttpServletRequest request) {
		
		return "showUser";
	}
	
	
	
	/*
	 * 
	 * Удалить пользователя
	 * 
	 * */
	@RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
	public void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		long id = Long.parseLong(request.getParameter("id"));
		
		userDAOImpl.deleteUser(new User(id));
		
		response.sendRedirect(request.getServletContext().getContextPath()+"/user");
	}
	
}
