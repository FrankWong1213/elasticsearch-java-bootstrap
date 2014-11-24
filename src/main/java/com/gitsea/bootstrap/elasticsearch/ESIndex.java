package com.gitsea.bootstrap.elasticsearch;

import java.io.IOException;

import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;

/**
 * @ClassName: ESIndex.java
 * @Description: TODO
 * @author FrankWong
 * @version V1.0
 */
public class ESIndex {

	public void bulk(Client client, String indices, String mappingName) {
		XContentBuilder json;
		try {
			json = XContentFactory.jsonBuilder().startObject();
			json.field("name", "中国江苏苏州");
			json.field("address", "苏州工业园区国际科技园1203");
			BulkRequestBuilder bulkRequest = client.prepareBulk();
			bulkRequest.add(client.prepareIndex(indices, mappingName).setSource(json));
			BulkResponse actionGet = bulkRequest.execute().actionGet();
			if (actionGet.hasFailures()) {
				System.out.println("");
			}
			bulkRequest = client.prepareBulk();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
