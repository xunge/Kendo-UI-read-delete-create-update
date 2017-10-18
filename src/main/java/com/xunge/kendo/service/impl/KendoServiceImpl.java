package com.xunge.kendo.service.impl;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xunge.kendo.dao.KendoDao;
import com.xunge.kendo.pojo.Kendo;
import com.xunge.kendo.service.IKendoService;


@Service
public class KendoServiceImpl implements IKendoService{

    @Autowired
    KendoDao kendoDao;
    
	@Override
	public JSONArray queryData() throws Exception {
		List<Kendo> newList = new ArrayList<Kendo>();
		newList =kendoDao.findAll();
		//调用JSONArray.fromObject方法把array中的对象转化为JSON格式的数组
        JSONArray json=JSONArray.fromObject(newList);
		return json;
	}

	@Override
	public boolean updateData(Kendo kendo) throws Exception {
		boolean isSuccess = kendoDao.updateRow(kendo);
		if (isSuccess) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteData(Kendo kendo) throws Exception {
		boolean isSuccess = kendoDao.deleteRow(kendo);
		if (isSuccess) {
			return true;
		}
		return false;
	}

	@Override
	public boolean insertData(Kendo kendo) throws Exception {
		boolean isSuccess = kendoDao.insertRow(kendo);
		if (isSuccess) {
			return true;
		}
		return false;
	}

	@Override
	public int findLastId() throws Exception {
		int lastId = kendoDao.findLastId();
		return lastId - 1;
	}
}
