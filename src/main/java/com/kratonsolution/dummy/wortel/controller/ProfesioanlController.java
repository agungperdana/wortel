package com.kratonsolution.dummy.wortel.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kratonsolution.dummy.wortel.FastDB;
import com.kratonsolution.dummy.wortel.data.ProfesionalData;

@RestController
public class ProfesioanlController {

	@Autowired
	private FastDB db;

	@GetMapping("/profesional/list")
	public Map<String, Object> list() {

		Map<String, Object> map = new HashMap<String, Object>();

		try {

			map.put("status", true);
			map.put("profesionals", db.getAllProfesionals());
			map.put("message", "success");

		} catch (Exception e) {

			map.put("status", false);
			map.put("profesionals", new ArrayList<>());
			map.put("message", e.getMessage());
		}

		return map;
	}

	@PostMapping("/profesional/create")
	public Map<String, Object> create(@RequestBody ProfesionalData data) {

		Map<String, Object> map = new HashMap<String, Object>();

		try {

			if(data != null && 
					data.getName() != null 
					&& !data.getName().equals("")
					&& data.getSport() != null && 
					!data.getSport().equals(""))

				db.createProfesional(data);

			map.put("status", true);
			map.put("profesionals", data);
			map.put("message", "success");

		} catch (Exception e) {

			map.put("status", false);
			map.put("profesionals", new ArrayList<>());
			map.put("message", e.getMessage());
		}

		return map;
	}

	@PostMapping("/profesional/remove")
	public Map<String, Object> remove(@RequestBody ProfesionalData data) {

		Map<String, Object> map = new HashMap<String, Object>();

		try {

			if(data.getId() != null && !data.getId().equals("")) {


				ProfesionalData on = db.removeProfesional(data.getId());

				map.put("status", true);
				map.put("profesionals", on);
				map.put("message", "success");
			}

		} catch (Exception e) {

			map.put("status", false);
			map.put("profesionals", new ArrayList<>());
			map.put("message", e.getMessage());
		}

		return map;
	}
}
