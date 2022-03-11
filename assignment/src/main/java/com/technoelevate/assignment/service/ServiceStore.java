package com.technoelevate.assignment.service;

import java.util.ArrayList;

import antlr.collections.List;

public interface ServiceStore {



	String getAllStores();

	ArrayList getDataById(String str);

	ArrayList getDataByCityOrDate(String str,String s);

}
