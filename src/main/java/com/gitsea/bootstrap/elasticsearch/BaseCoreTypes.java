package com.gitsea.bootstrap.elasticsearch;

/**
 * @ClassName:     CoreTypes.java
 * @Description:   TODO
 * @author         FrankWong
 * @version        V1.0  
 */
public enum BaseCoreTypes {
	
	STRING("string"),INTEGER("integer"),LONG("long"),FLOAT("float"),DOUBLE("double"),BOOLEAN("boolean"),NULL("null");
	
	private String val;
	
	private BaseCoreTypes(String val){
		this.val = val;
	}
	
	@Override
    public String toString() {
        return this.val;
    }
}
