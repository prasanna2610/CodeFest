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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codefest.main.entity.Transaction;
import com.codefest.main.entity.Vendor;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	@Autowired
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getAdminPage(){
		System.out.println("Entered getAdminPage");
		List<Vendor> vendor = new ArrayList<>();
		Class<?> entityClass = null;
		Object entityObj = null;
		String sqlVendor = "Select * from VENDOR;";
		String sqlTransaction = "Select * from Transaction where vendor_id in (:listOfValues)";
		String sqlMenu = "SELECT t.TRANSACTION_ID, m.MENU_NAME, m.PRICE, t.USER_ID FROM TRANSACTION t, ORDER_ITEMS o, "
				+ "MENU m where t.transaction_id = o.transaction_id and o.menu_id = m.menu_id and t.vendor_id = ?";
		/*String comibnedSql = "select v.vendor_id, v.vendor_name, v.vendor_email, v.vendor_phone, v.incharge, "
				+ "v.vendor_detail, t.transaction_id, t.date from vendor v, transaction t where v.vendor_id = t.vendor_id";*/
		List<Integer> vendorIds = new ArrayList<>();
		try{
		entityClass = Class.forName("com.codefest.main.entity.Vendor");
		entityObj = entityClass.newInstance();
		vendor = jdbcTemplate.query(sqlVendor, new BeanPropertyRowMapper(entityObj.getClass()));
		//vendor = jdbcTemplate.query(comibnedSql, new BeanPropertyRowMapper(entityObj.getClass()));
		for(Vendor ven : vendor){
			vendorIds.add(new Integer (ven.getVendorId().toString()));
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("listOfValues", vendorIds);

		List<Transaction> transactionList = namedParameterJdbcTemplate.query(
				sqlTransaction,
				params,
				ParameterizedBeanPropertyRowMapper.newInstance(Transaction.class));
		List<Transaction> tl = null;
		for(Vendor ven : vendor){
			tl = new ArrayList<>();
		for(Transaction transaction : transactionList){
			if(ven.getVendorId().longValue() == transaction.getVendorId().longValue()){
				tl.add(transaction);
				ven.setTransaction(tl);
			}
		}
		//vendor.add(ven);
		}
		
		/*Map namedParameters = Collections.singletonMap("listOfValues", vendorIds);
			List<Transaction> transactionList = (List<Transaction>) jdbcTemplate
					.queryForObject(sqlTransaction,
							new Object[] { namedParameters },
							new BeanPropertyRowMapper(Transaction.class));*/
		}catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	@RequestMapping(value = "/vendorId", method = RequestMethod.GET)
	public String getTransactionDetails(@RequestParam(value="vendorId", required=true) String vendorId, Model model){
		System.out.println("Entered getTransactionDetail");
		List<Transaction> transactionList = new ArrayList<>();
		Class<?> entityClass = null;
		Object entityObj = null;
		String sqlTransaction = "SELECT t.TRANSACTION_ID, m.MENU_NAME, m.PRICE, t.USER_ID FROM TRANSACTION t, ORDER_ITEMS o, "
				+ "MENU m where t.transaction_id = o.transaction_id and o.menu_id = m.menu_id and t.vendor_id = ?";
		try{
			entityClass = Class.forName("com.codefest.main.entity.Transaction");
			entityObj = entityClass.newInstance();
			transactionList = jdbcTemplate.query(sqlTransaction, new BeanPropertyRowMapper(entityObj.getClass()));
			//jdbcTemplate.query(sqlTransaction, args, new BeanPropertyRowMapper(entityObj.getClass()));
		}catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

}
