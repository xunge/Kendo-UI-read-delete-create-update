package com.xunge.kendo.service;

import com.xunge.kendo.pojo.Kendo;

import net.sf.json.JSONArray;

public interface IKendoService {
	public JSONArray queryData() throws Exception;
	
	public boolean updateData(Kendo kendo) throws Exception;
	
	public boolean deleteData(Kendo kendo) throws Exception;
	
	public boolean insertData(Kendo kendo) throws Exception;

	public int findLastId() throws Exception;
}
