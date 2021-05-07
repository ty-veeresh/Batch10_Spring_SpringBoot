package com.tyss.springboot.dao;
import java.util.List;

import com.tyss.springboot.dto.ItemBean;

public interface AdminDao {
	
	public ItemBean getItemData(Integer iid);

	public boolean addItem(ItemBean infoBean);
	public List<ItemBean> getAllItemDetails();

	
	
	public boolean deleteItem(Integer iid);
}
