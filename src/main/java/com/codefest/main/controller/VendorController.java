package com.codefest.main.controller;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codefest.main.entity.Vendor;

@Controller
@RequestMapping("/vendor")
public class VendorController {
	
	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	@RequestMapping(method = RequestMethod.PUT)
	@SuppressWarnings("all")
	public String updateVendor(@RequestParam(value="vendor", required=true) Vendor vendor){
		System.out.println("Entered updateVendor");
		Long vendorId = vendor.getVendorId();
		String updateQuery = "UPDATE VENDOR SET VENDOR_NAME = ?, VEBDOR_EMAIL = ?, VENDOR_PHONE = ?, INCHARGE = ?, VENDOR_DETAIL = ? WHEN VENDOR_ID = ?";
		try{
		List<Vendor> vendorListDB = jdbcTemplate.query("SELECT * FROM VENDOR WHERE VENDOR_ID = ?", new Object[] { vendorId },
				new BeanPropertyRowMapper(Vendor.class));
		populateVendor(vendor,vendorListDB.get(0));
		Object[] params = { vendor.getVendorName(), vendor.getVendorEmail(), vendor.getVendorPhone(), vendor.getIncharge(), vendor.getVendorDetail()};
		int[] types = {Types.VARCHAR, Types.BIGINT};

		jdbcTemplate.update(updateQuery, params, types);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private void populateVendor(Vendor vendor, Vendor vendorDB){
		
	}

}
