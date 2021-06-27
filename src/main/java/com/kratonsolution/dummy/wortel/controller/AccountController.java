package com.kratonsolution.dummy.wortel.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kratonsolution.dummy.wortel.FastDB;
import com.kratonsolution.dummy.wortel.data.AccountData;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 0.1
 */
@RestController
public class AccountController {
	
	@Autowired
	private FastDB db;
	
	@GetMapping("/account/GET/{email}")
	public Map<String, Object> get(@PathVariable String email) {
		
		Map<String, Object> map = new HashMap<>();
		
		AccountData data = db.getAccount(email);
		if(data != null) {

			AccountData ok = new AccountData();
			ok.setEmail(email);
			ok.setName(data.getName());
			
			map.put("status", true);
			map.put("message", "success");
			map.put("account", ok);
		}
		else {
			map.put("status", false);
			map.put("message", "User does not exist");
		}
		
		return map;
	}
	
	@PostMapping("/account/create")
	public Map<String, Object> create(@RequestBody Map<String, String> body) {
		
		Map<String, Object> map = new HashMap<>();
		
		try {

			if(body.get("password").equals(body.get("re_password"))) {
				
				AccountData data = new AccountData();
				data.setName(body.get("name"));
				data.setEmail(body.get("email"));
				data.setPassword(body.get("password"));
				
				db.saveAccount(data);
				
				map.put("status", true);
				map.put("message", "success");
				map.put("account", data);
			}
			else {
				
				map.put("status", false);
				map.put("message", "Password and Re-Password not equals");
			}

		} catch (Exception e) {
			
			map.put("status", false);
			map.put("message", e.getMessage());
		}
		
		return map;
	}
}
