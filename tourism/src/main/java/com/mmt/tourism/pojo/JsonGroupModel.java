package com.mmt.tourism.pojo;

import java.util.ArrayList;
import java.util.List;

public class JsonGroupModel<K,T> implements IJsonModel{
	
	private List<GroupMap> groupItems=new ArrayList<GroupMap>();


	
	public void putGroup(K group,List<T> items,Page page) {
		JsonModel<T> model=new JsonModel<T>();
		model.setResult(items);
		model.setPage(page);
		GroupMap map=new GroupMap();
		map.key=group;
		map.items=model;
		groupItems.add(map);
	}

	
	public List<GroupMap> getGroupItems() {
		return groupItems;
	}


	public void setGroupItems(List<GroupMap> groupItems) {
		this.groupItems = groupItems;
	}


	class GroupMap{
		K key;
		JsonModel<T> items;
		public K getKey() {
			return key;
		}
		public void setKey(K key) {
			this.key = key;
		}
		public JsonModel<T> getItems() {
			return items;
		}
		public void setItems(JsonModel<T> items) {
			this.items = items;
		}
		
	}
	
}
