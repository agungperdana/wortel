package com.kratonsolution.dummy.wortel;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.kratonsolution.dummy.wortel.data.AccountData;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 0.1
 */
@Service
public class FastDB {
	
	private Map<String, AccountData> accountDB = new HashMap<>();
	private Map<String, Object> profesionalDB = new HashMap<>();
	
	public FastDB() {
		
		AccountData dummy1 = new AccountData();
		dummy1.setName("Wortel Jus");
		dummy1.setEmail("wortel.jus@jus.com");
		dummy1.setPassword("worteljus");
		
		accountDB.put(dummy1.getEmail(), dummy1);
	}
	
	
	public synchronized AccountData getAccount(String emai) {
		
		if(accountDB.containsKey(emai)) {
			return accountDB.get(emai);
		}
		else {
			return null;
		}
	}
	
	public synchronized AccountData saveAccount(AccountData data) {
		
		if(data.getEmail() != null && !data.getEmail().equals("") && accountDB.containsKey(data.getEmail())) {
			
			AccountData on = accountDB.get(data.getEmail());
			on.setName(data.getName());
			on.setPassword(data.getPassword());			
		}
		else {
			
			accountDB.put(data.getEmail(), data);
		}
		
		return data;
	}
}
