package com.gitsea.bootstrap.elasticsearch;

/**
 * @ClassName:     MappingEntry.java
 * @Description:   TODO
 * @author         FrankWong
 * @version        V1.0  
 */
public class MappingEntry {

	private String name;
	private BaseCoreTypes type;
	private String index;
	private String analyzer;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public BaseCoreTypes getType() {
		return type;
	}
	public void setType(BaseCoreTypes type) {
		this.type = type;
	}
	public String getAnalyzer() {
		return analyzer;
	}
	public void setAnalyzer(String analyzer) {
		this.analyzer = analyzer;
	}
	
}
