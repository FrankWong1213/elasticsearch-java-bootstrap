package com.gitsea.bootstrap.elasticsearch;

import java.util.List;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.node.Node;
import org.elasticsearch.node.NodeBuilder;

/**
 * @ClassName: ESClient.java
 * @Description: TODO
 * @author FrankWong
 * @version V1.0
 */
public class ESClient {

	/**
	 * @Title: getTransportClient
	 * @Description: TODO
	 * @param clusterName  集群名字,可以为空 默认为elasticsearch，
	 * @param hosts  集群所有服务器地址
	 * @return: Client
	 * @throws
	 * @author FrankWong
	 */
	public static Client getTransportClient(String clusterName, List<IPAddress> hosts) {
		if(clusterName == null || clusterName.equals("")){
			clusterName = Constant.ES_DEFAULT_CLUSTER_NAME;
		}
		Settings settings = ImmutableSettings.settingsBuilder().put(Constant.CLUSTER_NAME, clusterName).build();
		TransportClient client = new TransportClient(settings);
		for (IPAddress entry : hosts) {
			client.addTransportAddress(new InetSocketTransportAddress(entry.getIp(), entry.getPort()));
		}
		return client;
	}
	
	/**
	 * @Title:        getTransportClientWithSniff 
	 * @Description:  嗅侦集群其他服务器，自动加入操作List
	 * @param clusterName 
	 * @param hosts
	 * @return    
	 * @return:       Client    
	 * @throws 
	 * @author        FrankWong
	 */
	public static Client getTransportClientWithSniff(String clusterName, List<IPAddress> hosts) {
		if(clusterName == null || clusterName.equals("")){
			clusterName = Constant.ES_DEFAULT_CLUSTER_NAME;
		}
		Settings settings = ImmutableSettings.settingsBuilder().put(Constant.CLUSTER_NAME, clusterName).put(Constant.ES_TRANSPORT_SNIFF, true).build();
		TransportClient client = new TransportClient(settings);
		for (IPAddress entry : hosts) {
			client.addTransportAddress(new InetSocketTransportAddress(entry.getIp(), entry.getPort()));
		}
		return client;
	}
	
	/**
	 * @Title:        getNodeClient 
	 * @Description:  根据集群名字获取client
	 * @param clusterName
	 * @return    
	 * @return:       Client    
	 * @throws 
	 * @author        FrankWong
	 */
	public static Client getNodeClient(String clusterName){
		if(clusterName == null || clusterName.equals("")){
			clusterName = Constant.ES_DEFAULT_CLUSTER_NAME;
		}
		Node node = NodeBuilder.nodeBuilder().clusterName(Constant.ES_DEFAULT_CLUSTER_NAME).client(true).node();
		Client client = node.client();
		return client;
	}
	
	/**
	 * @Title:        getTransportClient 
	 * @Description:  TODO
	 * @param ipAddress
	 * @return    
	 * @return:       Client    
	 * @throws 
	 * @author        FrankWong
	 */
	public static Client getTransportClient(IPAddress ipAddress){
		TransportClient client = new TransportClient();
		client.addTransportAddress(new InetSocketTransportAddress(ipAddress.getIp(), ipAddress.getPort()));
		return client;
	}
}
