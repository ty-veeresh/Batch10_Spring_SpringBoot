package com.tyss.springboot.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Data
@JsonRootName("response")
@JsonPropertyOrder({"status" , "msg"})
@XmlRootElement(name = "response")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdminResponce implements Serializable {
	
	
	@JsonProperty("status")
	@XmlElement(name = "status-code")
	private int statusCode;
	
	
	private String  msg;
	
	@JsonProperty("item_info")
	@XmlElement(name = "item-info")
	private ItemBean bean;
	
	
	private List<ItemBean> infoBean;


	public void setStatusCode(int i) {
		// TODO Auto-generated method stub
		this.statusCode=i;
	}


	public void setMsg(String string) {
		// TODO Auto-generated method stub
		this.msg=string;
	}


	public void setBean(ItemBean itemBean) {
		this.bean=itemBean;
		
	}


	public void setInfoBean(List<ItemBean> infoBeans) {
		// TODO Auto-generated method stub
		this.infoBean=infoBeans;
	}
	

}
