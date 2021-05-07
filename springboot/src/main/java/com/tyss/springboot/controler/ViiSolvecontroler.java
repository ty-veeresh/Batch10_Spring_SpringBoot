package com.tyss.springboot.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.tyss.springboot.dto.AdminResponce;
import com.tyss.springboot.dto.ItemBean;
import com.tyss.springboot.service.AdminService;

@Controller
public class ViiSolvecontroler {
	
	@Autowired
	private AdminService service;
	
	@GetMapping(path="/get", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public AdminResponce getItemData(int id) {
		AdminResponce res=new AdminResponce();
		ItemBean itemBean=service.getItemData(id);
		if(itemBean != null) {
			res.setStatusCode(200);
			res.setMsg("success");
			res.setBean(itemBean);
		} else {
			res.setStatusCode(404);
			res.setMsg("Failure");
		}
		return res;
	}
	
	@GetMapping(path = "/getAll", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public AdminResponce getAllItemDetails() {
		AdminResponce response = new AdminResponce();
		List<ItemBean> infoBeans = service.getAllItemDetails();

		if (infoBeans != null) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setInfoBean(infoBeans);
		} else {
			response.setStatusCode(400);
			response.setMsg("Datas not found");
		}

		return response;
	}
	@PostMapping(path = "/add", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public AdminResponce addEmpData(@RequestBody ItemBean infoBean) {
		AdminResponce response = new AdminResponce();

		if (service.addItem(infoBean)) {
			response.setStatusCode(200);
			response.setMsg("success , Added the record");
		} else {
			response.setStatusCode(400);
			response.setMsg("Failure , Could not add the data");
		}

		return response;
	}
	
	@DeleteMapping(path = "/delete/{empId}" , produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public AdminResponce deleteEmpData(@PathVariable(name = "empId")int id ) {
		AdminResponce response = new AdminResponce();

		if (service.deleteItem(id)) {
			response.setStatusCode(200);
			response.setMsg("success , record deleted");
		} else {
			response.setStatusCode(400);
			response.setMsg("Failure , Could not delete the record");
		}
		return response;
	}
	

}
