package com.mmt.tourism.pojo.dto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class JsonMapModel<T, K, V> extends JsonModelSimpleImp{

	private T menu;
	private List<Mapper> mappers = new ArrayList<Mapper>();

	public JsonMapModel(T t) {
		menu = t;
	}

	public JsonMapModel() {
	}

	public void putMappers(T t, Map<K, V> map) {
		menu = t;

		if (map == null || map.isEmpty())
			return;
		Iterator<Entry<K, V>> it = map.entrySet().iterator();

		while (it.hasNext()) {
			Entry<K, V> entry = it.next();
			Mapper mapper = new Mapper();
			mapper.key = entry.getKey();
			mapper.value = entry.getValue();
			mappers.add(mapper);
		}
	}

	public void putMapper(K key, V value) {
		Mapper mapper = new Mapper();
		mapper.key = key;
		mapper.value = value;
		mappers.add(mapper);
	}

	public T getMenu() {
		return menu;
	}

	public void setMenu(T menu) {
		this.menu = menu;
	}

	public List<Mapper> getMappers() {
		return mappers;
	}

	public void setMappers(List<Mapper> mappers) {
		this.mappers = mappers;
	}

	class Mapper {
		K key;
		V value;

		public K getKey() {
			return key;
		}

		public void setKey(K key) {
			this.key = key;
		}

		public V getValue() {
			return value;
		}

		public void setValue(V value) {
			this.value = value;
		}
	}
}
