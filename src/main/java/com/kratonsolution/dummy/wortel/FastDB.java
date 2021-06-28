package com.kratonsolution.dummy.wortel;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.kratonsolution.dummy.wortel.data.AccountData;
import com.kratonsolution.dummy.wortel.data.ProfesionalData;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 0.1
 */
@Service
public class FastDB {

	private Map<String, AccountData> accountDB = new HashMap<>();
	private Map<String, ProfesionalData> profesionalDB = new HashMap<>();

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

	public synchronized Collection<ProfesionalData> getAllProfesionals() {
		return profesionalDB.values();
	}

	public ProfesionalData getProfesional(String id) {
		if(profesionalDB.containsKey(id)) {
			return profesionalDB.get(id);
		}

		return null;
	}

	public ProfesionalData createProfesional(ProfesionalData profesionalData) {

		if(profesionalData != null && profesionalData.getName() != null && profesionalData.getSport() != null) {

			if(!profesionalDB.containsKey(profesionalData.getId())) {
				profesionalDB.put(profesionalData.getId(), profesionalData);
			}
		}

		return profesionalData;
	}

	public ProfesionalData updateProfesional(ProfesionalData profesionalData) {

		if(profesionalData != null && profesionalData.getName() != null && profesionalData.getSport() != null) {
			
			if(profesionalDB.containsKey(profesionalData.getId())) {
				
				ProfesionalData on = profesionalDB.get(profesionalData.getId());
				
				on.setName(profesionalData.getName());
				on.setSport(profesionalData.getSport());
				on.setHasTag(profesionalData.isHasTag());
				
				if(profesionalData.getPictures().isEmpty())
				{
					on.getPictures().clear();
				}
				else {
					
					on.getPictures().clear();
					on.getPictures().addAll(profesionalData.getPictures());
				}
				
				if(profesionalData.getVidios().isEmpty()) {
					on.getVidios().clear();
				}
				else {
					
					on.getVidios().clear();
					on.getVidios().addAll(profesionalData.getVidios());
				}

			}
		}

		return profesionalData;
	}
	
	public synchronized ProfesionalData removeProfesional(String id) {
		
		if(id != null && !id.equals("") && profesionalDB.containsKey(id)) {
			
			ProfesionalData on = profesionalDB.get(id);
			profesionalDB.remove(id);
			
			return on;
		}
		
		return null;
	}
}
