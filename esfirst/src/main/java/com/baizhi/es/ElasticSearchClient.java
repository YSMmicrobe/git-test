package com.baizhi.es;

import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Test;

import java.net.InetAddress;

public class ElasticSearchClient {
    @Test
    public void createIndex() throws Exception{
        //创建一个Setting对象,相当于是一个配置信息,主配置集群的名称
        Settings settings = Settings.builder()
                .put("cluster.name","my-elasticsearch")
                .build();
        // 创建Client连接对象
        PreBuiltTransportClient client = new PreBuiltTransportClient(settings);
        client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"),9301));
        client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"),9302));
        client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"),9303));
        //创建名称为blog2的索引
        client.admin().indices().prepareCreate("index_hello")
                //
                .get();
        //释放资源
        client.close();
    }

    @Test
    public void test1(){

        System.out.println("aa");
    }
}
