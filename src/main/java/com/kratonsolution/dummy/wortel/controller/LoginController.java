package com.kratonsolution.dummy.wortel.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kratonsolution.dummy.wortel.FastDB;
import com.kratonsolution.dummy.wortel.data.AccountData;
import com.kratonsolution.dummy.wortel.data.LoginParam;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 0.1
 */
@RestController
public class LoginController {
	
	@Autowired
	private FastDB db;

	@PostMapping("/login")
	public Map<String, Object> login(@RequestBody LoginParam body) {
		
		System.out.println("User "+body.getEmail()+" trying to logged in....");
		
		Map<String, Object> map = new HashMap<>();
		AccountData data = db.getAccount(body.getEmail());
		
		if(data != null && data.getPassword().equals(body.getPassword())) {
			
			AccountData ok = new AccountData();
			ok.setEmail(body.getEmail());
			ok.setName(data.getName());
			
			map.put("status", true);
			map.put("message", "success");
			map.put("account", ok);
		}
		else {
			
			map.put("status", false);
			map.put("message", "User doesnot exist or wrong password");
			map.put("account", null);
		}
		
		return map;
	}
}
