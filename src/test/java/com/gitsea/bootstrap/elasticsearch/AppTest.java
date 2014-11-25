package com.gitsea.bootstrap.elasticsearch;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.elasticsearch.client.Client;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	
	public static final String HOST="";
	public static final int PORT=9300;
	public static final String INDEX_NAME="index1";
	public static final String MAPPING_NAME="person";
	private Client client;
	private ESMapping esMapping ;
	private ESIndex esIndex;
	private ESQuery esQuery;
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
		client = ESClient.getTransportClient(new IPAddress(HOST));
		esMapping = new ESMapping();
		esIndex = new ESIndex();
		esQuery = new ESQuery();
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		assertTrue(true);
	}
	
	public void testCreateMapping(){
		MappingEntry mappingEntry =  new MappingEntry();
		List<MappingEntry> list = new ArrayList<MappingEntry>();
		mappingEntry.setName("name");
		mappingEntry.setType(BaseCoreTypes.STRING);
		mappingEntry.setAnalyzer("ik");
		list.add(mappingEntry);
		mappingEntry =  new MappingEntry();
		mappingEntry.setName("address");
		mappingEntry.setType(BaseCoreTypes.STRING);
		mappingEntry.setAnalyzer("ik");
		list.add(mappingEntry);
		esMapping.createMapping(client, INDEX_NAME, "mymapping", list);
		client.close();
	}
	
	public void testCreateIndices(){
		assertTrue(true);
		esMapping.createIndices(client, INDEX_NAME);
		client.close();
	}
	
	public void testDeleteIndices(String indices){
		esMapping.deleteIndices(client, indices);
	}
	
	public void testIndex(){
		
		esIndex.bulk(client, INDEX_NAME, MAPPING_NAME);
	}
	
	public void testQuery(){
		esQuery.query(client, INDEX_NAME, MAPPING_NAME);
	}
	
}
