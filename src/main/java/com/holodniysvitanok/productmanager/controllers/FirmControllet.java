package com.holodniysvitanok.productmanager.controllers;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.holodniysvitanok.productmanager.dao.FirmDAO;
import com.holodniysvitanok.productmanager.entity.Firm;

@Controller
public class FirmControllet {

	@Autowired
	private FirmDAO firmDAO;

	/*
	 * 
	 * Отображение всех производителей
	 * 
	 * */
	@RequestMapping(value = "/firm", method = RequestMethod.GET)
	public String firm(HttpServletRequest request) {

		int count = 50;
		String countStr = request.getParameter("count");

		if (countStr != null) {
			count = Integer.parseInt(countStr);
		}

		request.setAttribute("firms", firmDAO.getAllFirm(count));

		return "firm";
	}

	
	/*
	 * 
	 * Вызов странички добавления инфомации производителя
	 * 
	 */
	@RequestMapping(value = "/addFirm", method = RequestMethod.GET)
	public String addFirmGET(HttpServletRequest request) {
		return "addFirm";
	}

	
	
	/*
	 * 
	 * Добавление производителя в БД
	 * 
	 */
	@RequestMapping(value = "/addFirm", method = RequestMethod.POST)
	public void addFirmPOST(HttpServletRequest request,
		HttpServletResponse response,
		@RequestParam("file") MultipartFile file) throws Exception {

		Firm firm = new Firm();

		if (file != null) {
			firm.setImage(file.getBytes());
			firm.setFileName(file.getName());
		}

		firm.setName(request.getParameter("name"));
		firm.setCountry(request.getParameter("country"));
		firm.setDescription(request.getParameter("description"));

		firmDAO.saveOrUpdate(firm);

		response.sendRedirect(request.getServletContext().getContextPath() + "/firm");
	}

	
	
	/*
	 * Получить изображение по id через GET
	 * 
	 */
	@RequestMapping(value = "/getImageFirm", method = RequestMethod.GET)
	public void getImageFirm(HttpServletRequest request, HttpServletResponse response) throws IOException {

		long id = Long.parseLong(request.getParameter("id"));

		Firm firm = firmDAO.getFirm(id);
		if (firm.getImage() == null) {
			return;
		}

		ServletOutputStream outputStream = response.getOutputStream();
		outputStream.write(firm.getImage());
		outputStream.close();
	}

	@RequestMapping(value = "/deleteFirm", method = RequestMethod.GET)
	public void deleteFirm(HttpServletRequest request, HttpServletResponse response) throws IOException{
		long id = Long.parseLong(request.getParameter("id"));
		
		firmDAO.deleteFirm(new Firm(id));
		
		response.sendRedirect(request.getServletContext().getContextPath() + "/firm");
	}
}
