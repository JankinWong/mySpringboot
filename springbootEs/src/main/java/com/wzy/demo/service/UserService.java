package com.wzy.demo.service;

import com.alibaba.fastjson.JSON;
import com.wzy.demo.constant.Constant;
import com.wzy.demo.document.portDocument;
import org.apache.ibatis.annotations.Mapper;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.rest.RestStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@Service
public class UserService {

    @Autowired
    private RestHighLevelClient client;

    public Boolean createPortDocument(portDocument portDocument) throws Exception {
        UUID uuid = UUID.randomUUID();
        portDocument.setId(uuid.toString());
        IndexRequest indexRequest = new IndexRequest(Constant.INDEX)
                .id(portDocument.getId())
                .source(JSON.toJSONString(portDocument), XContentType.JSON);
        IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
        return indexResponse.status().equals(RestStatus.CREATED);
    }


    public boolean createPortIndex(String index) throws IOException {
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(index);
        createIndexRequest.settings(Settings.builder()
                .put("index.number_of_shards", 1)
                .put("index.number_of_replicas", 0)
        );

        Map<String, Object> screenName = new HashMap<>();
        screenName.put("type", "keyword");
        Map<String,Object> userName = new HashMap<>();
        userName.put("type","keyword");

        Map<String, Object> properties = new HashMap<>();

        properties.put("userName",userName);
        properties.put("screenName", screenName);


        Map<String, Object> mapping = new HashMap<>();
        mapping.put("properties", properties);
        createIndexRequest.mapping(mapping);

        CreateIndexResponse createIndexResponse = client.indices().create(createIndexRequest, RequestOptions.DEFAULT);
        return createIndexResponse.isAcknowledged();
    }

    public Boolean bulkCreateDocument(List<portDocument> documents) throws IOException {
        BulkRequest bulkRequest = new BulkRequest();
        for (portDocument document : documents) {
            String id = UUID.randomUUID().toString();
            document.setId(id);
            IndexRequest indexRequest = new IndexRequest(Constant.INDEX)
                    .id(id)
                    .source(JSON.toJSONString(document), XContentType.JSON);
            bulkRequest.add(indexRequest);
        }
        BulkResponse bulkResponse = client.bulk(bulkRequest, RequestOptions.DEFAULT);
        return bulkResponse.status().equals(RestStatus.CREATED);
    }






}
