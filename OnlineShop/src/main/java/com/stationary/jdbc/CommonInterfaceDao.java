package com.stationary.jdbc;

public interface CommonInterfaceDao<T> {
	public int insertObj(T p);
	public int deleteObj(T p);
	public int updateObj(T p);
	public T getOneObj(T p);
}
