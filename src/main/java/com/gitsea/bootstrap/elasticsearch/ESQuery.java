package com.gitsea.bootstrap.elasticsearch;

import java.util.Map;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder.Operator;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHits;

/**
 * @ClassName:     ESQuery.java
 * @Description:   TODO
 * @author         FrankWong
 * @version        V1.0  
 */
public class ESQuery {

	public void query(Client client, String indices, String mappingName){
		SearchRequestBuilder prepareSearch = client.prepareSearch(indices);
		QueryBuilder qb1 = QueryBuilders.matchQuery("name", "中国").operator(Operator.AND);
		QueryBuilder qb2 = QueryBuilders.matchQuery("address", "工业园区").operator(Operator.AND);
		
		BoolQueryBuilder boolQuery = QueryBuilders.boolQuery().must(qb1).must(qb2);
		final SearchResponse searchResponse = prepareSearch.setQuery(boolQuery)
		        .setFrom(0).setExplain(true)   .setSize(10)
		        .execute()   
		        .actionGet();  
	    SearchHits hits = searchResponse.getHits();
        for (int i = 0; i < hits.getTotalHits() && i < 10; i++) {  
            Map<String, Object> obj = hits.getAt(i).getSource();
            System.out.println(obj.get("name")+"  "+obj.get("address"));
        }
	}
}
