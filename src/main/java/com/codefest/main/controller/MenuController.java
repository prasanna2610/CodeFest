package com.codefest.main.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codefest.main.entity.Menu;
import com.codefest.main.entity.Vendor;

@Controller
@RequestMapping(value = "/menu")
public class MenuController {

	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	@Autowired
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@RequestMapping(method = RequestMethod.GET)
	@SuppressWarnings("all")
	public String getMenu(){
		System.out.println("Entered getMenuPage");
		List<Vendor> vendorList = new ArrayList<>();
		Class<?> entityClass = null;
		Object entityObj = null;
		String sqlVendor = "Select * from VENDOR;";
		String sqlMenu = "Select * from Menu where vendor_id in (:listOfValues) and Availability = 'Y'";
		List<Long> vendorIds = new ArrayList<>();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("listOfValues", vendorIds);
		try{
			entityClass = Class.forName("com.codefest.main.entity.Vendor");
			entityObj = entityClass.newInstance();
			vendorList = jdbcTemplate.query(sqlVendor, new BeanPropertyRowMapper(entityObj.getClass()));
			for(Vendor vendor : vendorList){
				vendorIds.add(vendor.getVendorId());
			}
			params.put("listOfValues", vendorIds);
			 List<Menu> menuList =
			 namedParameterJdbcTemplate.query( sqlMenu, params,
			 ParameterizedBeanPropertyRowMapper.newInstance(Menu.class)
			 );
				List<Menu> ml = null;
				for (Vendor ven : vendorList) {
					ml = new ArrayList<>();
					for (Menu menu : menuList) {
						if (ven.getVendorId().longValue() == menu.getVendorId().longValue()) {
							ml.add(menu);
							ven.setMenu(ml);
						}
					}
					// vendor.add(ven);
				}
		}catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
