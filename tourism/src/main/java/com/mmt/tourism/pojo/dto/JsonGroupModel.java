package com.mmt.tourism.pojo.dto;

import java.util.ArrayList;
import java.util.List;

public class JsonGroupModel<K,T> extends JsonModelSimpleImp{
	
	private List<GroupMap> groupItems=new ArrayList<GroupMap>();


	
	public void putGroup(K group,List<T> items,Page page) {
		JsonPageModel<T> model=new JsonPageModel<T>();
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
		JsonPageModel<T> items;
		public K getKey() {
			return key;
		}
		public void setKey(K key) {
			this.key = key;
		}
		public JsonPageModel<T> getItems() {
			return items;
		}
		public void setItems(JsonPageModel<T> items) {
			this.items = items;
		}
		
	}
	
}
