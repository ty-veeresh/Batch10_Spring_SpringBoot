package com.tyss.springboot.service;
import java.util.List;

import com.tyss.springboot.dto.ItemBean;

public interface AdminService {
	
	
	public boolean addItem(ItemBean infoBean);
	public ItemBean getItemData(Integer iid);

	public List<ItemBean> getAllItemDetails();
	

	public boolean deleteItem(Integer iid);
}
