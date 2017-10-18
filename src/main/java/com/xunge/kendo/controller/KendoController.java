package com.xunge.kendo.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xunge.kendo.pojo.Kendo;
import com.xunge.kendo.service.IKendoService;


@Controller
public class KendoController {

	@Autowired
	IKendoService kendoService;
	
	@RequestMapping("kendo")
	public ModelAndView kendo(){
		ModelAndView mv = new ModelAndView("kendo");
		return mv;
	}
	
	@RequestMapping("queryKendo")
	public void queryKendo(HttpServletResponse response) throws Exception {
		JSONArray json = kendoService.queryData();
        System.out.println(json.toString());
        PrintWriter out = response.getWriter();  
        out.println(json);  
        out.flush();  
        out.close();   
	}
	
	@RequestMapping("updateKendo")
	public @ResponseBody JSONObject updateKendo(@RequestBody Kendo kendo, HttpServletResponse response) throws Exception {
        boolean option = kendoService.updateData(kendo);
        if (option) {
			JSONObject json = JSONObject.fromObject(kendo);
	        return json;
        }
		else {
			System.out.println("updateError");
		}
        return null;
	}
	
	@RequestMapping("deleteKendo")
	public @ResponseBody JSONObject deleteKendo(@RequestBody Kendo kendo, HttpServletResponse response) throws Exception {
        boolean option = kendoService.deleteData(kendo);
        if (option) {
			JSONObject json = JSONObject.fromObject(kendo);   
	        return json;
        }
		else {
			System.out.println("deleteError");
		}
        return null;
	}
	
	@RequestMapping("insertKendo")
	public @ResponseBody JSONObject insertKendo(@RequestBody Kendo kendo, HttpServletResponse response) throws Exception {
        boolean option = kendoService.insertData(kendo);
        int lastId = kendoService.findLastId();
		if (option) {
			JSONObject json = JSONObject.fromObject(kendo);
			json.put("id", lastId);
	        return json;
		}
		else {
			System.out.println("error");
		}
		return null;
	}
}
