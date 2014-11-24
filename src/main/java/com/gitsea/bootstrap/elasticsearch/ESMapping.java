package com.gitsea.bootstrap.elasticsearch;

import java.io.IOException;
import java.util.List;

import org.elasticsearch.action.admin.indices.mapping.put.PutMappingRequest;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.Requests;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;

/**
 * @ClassName:     ESMapping.java
 * @Description:   TODO
 * @author         FrankWong
 * @version        V1.0  
 */
public class ESMapping {

	/**
	 * @Title:        createIndices 
	 * @Description:  创建indices,indices 名称必须为全部小写
	 * @param client
	 * @param indices    
	 * @return:       void    
	 * @throws 
	 * @author        FrankWong
	 */
	public void createIndices(Client client,String indices){
		client.admin().indices().prepareCreate(indices).execute().actionGet();
	}
	
	/**
	 * @Title:        deleteIndices 
	 * @Description:  删除indices
	 * @param client
	 * @param indices    
	 * @return:       void    
	 * @throws 
	 * @author        FrankWong
	 */
	public void deleteIndices(Client client,String indices){
		client.admin().indices().prepareDelete(indices).execute().actionGet();
	}
	/**
	 * @Title:        createMapping 
	 * @Description:  创建Mapping
	 * @param client 
	 * @param indices  
	 * @param mappingName
	 * @param mappingEntryList    
	 * @return:       void    
	 * @throws 
	 * @author        FrankWong
	 */
	public void createMapping(Client client,String indices,String mappingName,List<MappingEntry> mappingEntryList){
		try {
			XContentBuilder jsonBuilder = XContentFactory.jsonBuilder()
					.startObject()
						.startObject(mappingName)
							.startObject("properties");
			for(MappingEntry entry:mappingEntryList){
				jsonBuilder.startObject(entry.getName());
				if(entry.getType()!=null && !entry.getType().equals("")){
					jsonBuilder.field("type", entry.getType());
				}
				if(entry.getIndex()!=null && !entry.getIndex().equals("")){
					jsonBuilder.field("index", entry.getIndex());
				}
				if(entry.getAnalyzer()!=null && !entry.getAnalyzer().equals("")){
					jsonBuilder.field("analyzer", entry.getAnalyzer());
				}
				jsonBuilder.endObject();
			}
			jsonBuilder.endObject().endObject().endObject();
			PutMappingRequest mappingRequest = Requests.putMappingRequest(indices).type(mappingName).source(jsonBuilder);  
			client.admin().indices().putMapping(mappingRequest).actionGet();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
