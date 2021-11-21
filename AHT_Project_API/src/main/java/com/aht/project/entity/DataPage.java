package com.aht.project.entity;

import java.util.List;

import lombok.Data;


@Data
public class DataPage<T> {
	private int pageIndex ;
	private List<T> data;
	private int pageCount;
	private long dataCount;
}
