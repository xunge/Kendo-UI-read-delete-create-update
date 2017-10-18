package com.xunge.kendo.dao;

import java.util.List;

import com.xunge.kendo.pojo.Kendo;


public interface KendoDao {
	public List<Kendo> findAll() throws Exception;
	
	public boolean updateRow(Kendo kendo) throws Exception;

	public boolean deleteRow(Kendo kendo) throws Exception;
	
	public boolean insertRow(Kendo kendo) throws Exception;
	
	public int findLastId() throws Exception;
}
