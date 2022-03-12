package com.technoelevate.assignment.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.apache.catalina.mapper.Mapper;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.technoelevate.assignment.response.ResponseBean;

import aj.org.objectweb.asm.TypeReference;
import antlr.collections.List;

@Service
public class StoreService implements ServiceStore {
	@Override
	public String getAllStores() {

		String json = null;

		BufferedReader bufferedReader = null;
		String str = null;
		ArrayList<String[]> data = new ArrayList<>();
		int rowCounter = 0;
		try {
			bufferedReader = new BufferedReader(new FileReader("D:\\STS\\assignment\\stores.csv"));
			while ((str = bufferedReader.readLine()) != null) {
				if (rowCounter == 0) {
					data.add(str.split(","));
				} else {
					data.add(str.split(","));
				}
				rowCounter++;
			}

			json = new Gson().toJson(data);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json;
	}

	@Override
	public String getDataById(String str) {
		String json = null;
		BufferedReader bufferedReader = null;
		String str1 = null;
		ArrayList list1 = new ArrayList();
		ArrayList arrayList = new ArrayList();
		ArrayList<String[]> data = new ArrayList<>();
		int rowCounter = 0;
		try {
			bufferedReader = new BufferedReader(new FileReader("D:\\STS\\assignment\\stores.csv"));
			while ((str1 = bufferedReader.readLine()) != null) {
				if (rowCounter == 0) {
					data.add(str1.split(","));
				} else {
					data.add(str1.split(","));
				}
			}
			for (int i = 0; i < data.size(); i++) {
				String[] strings = data.get(i);
				if (str.equals(strings[0])) {
					list1.add(data.get(i));
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					Date openedDate = sdf.parse(strings[strings.length - 1]);
					Date today = new Date();
					long diffInMillies = Math.abs(today.getTime() - openedDate.getTime());
					long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
					arrayList.add(list1);
					arrayList.add(diff);
				}
				rowCounter++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (arrayList != null && !arrayList.isEmpty()) {
			json = new Gson().toJson(arrayList);
			return json;
		}
		else
			return null;
	}
	@Override
	public String getDataByCityOrDate(String str, String s) {
		String json = null;
		BufferedReader bufferedReader = null;
		String str1 = null;
		ArrayList list1 = new ArrayList();
		ArrayList arrayList = new ArrayList();
		ArrayList<String[]> data = new ArrayList<>();
		int rowCounter = 0;
		try {
			bufferedReader = new BufferedReader(new FileReader("D:\\STS\\assignment\\stores.csv"));
			while ((str1 = bufferedReader.readLine()) != null) {
				if (rowCounter == 0) {
					data.add(str1.split(","));
				} else {
					data.add(str1.split(","));
				}
			}
			for (int i = 0; i < data.size(); i++) {
				String[] strings = data.get(i);
				if (str.equals(strings[2]) || str.equals(strings[4])) {
					list1.add(data.get(i));
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					Date openedDate = sdf.parse(strings[strings.length - 1]);
					Date today = new Date();
					long diffInMillies = Math.abs(today.getTime() - openedDate.getTime());
					long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
					arrayList.add(list1);
					arrayList.add(diff);
				}
				rowCounter++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (arrayList != null && !arrayList.isEmpty()) {
			json = new Gson().toJson(arrayList);
		return json;
		}
		else
			return null;
	}

}
