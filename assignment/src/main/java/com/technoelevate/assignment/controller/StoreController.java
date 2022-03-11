package com.technoelevate.assignment.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.technoelevate.assignment.response.ResponseBean;
import com.technoelevate.assignment.service.ServiceStore;

import antlr.collections.List;

@RestController

public class StoreController {
	@Autowired
	ServiceStore store;

	@PostMapping(path = "/getAllStores")
	public ResponseBean getAllStores() {
		String emp = store.getAllStores();
		ResponseBean bean = new ResponseBean();
		if (emp != null) {
			bean.setStatus_code(200);
			bean.setMessage("OK");
			bean.setDescription("All the Store are");
			bean.setJson1(emp);
		} else {
			bean.setStatus_code(500);
			bean.setMessage("NOT OKK");
			bean.setDescription("data not found");
		}
		return bean;
	}

	@PostMapping(path = "/getStoresById")
	public ResponseBean getDataById(String str) {
		ArrayList emp = store.getDataById(str);
		ResponseBean bean = new ResponseBean();
		if (emp != null) {
			bean.setStatus_code(200);
			bean.setMessage("OK");
			bean.setDescription("All the Store are");
			bean.setJson(emp);
		} else {
			bean.setStatus_code(500);
			bean.setMessage("NOT OKK");
			bean.setDescription("Store with Id not found");
		}
		return bean;
	}

	@PostMapping(path = "/getStoresByCityOrDate")
	public ResponseBean getDataByCityOrDate(String str) {
		String s = "";
		ArrayList emp = store.getDataByCityOrDate(str, s);
		ResponseBean bean = new ResponseBean();
		if (emp != null) {
			bean.setStatus_code(200);
			bean.setMessage("OK");
			bean.setDescription("All the Store are");
			bean.setJson(emp);

		} else {
			bean.setStatus_code(500);
			bean.setMessage("NOT OKK");
			bean.setDescription("Store By City or Date not found");
		}
		return bean;
	}
}
