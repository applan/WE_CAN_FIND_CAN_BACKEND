package kr.co.wcfcb.we_can_find_can_backend.util;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import kr.co.wcfcb.we_can_find_can_backend.prop.ElasticsearchConf;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.stereotype.Component;


@Component
public class ElasticsearchUtil {

    private final ElasticsearchClient client;

    public ElasticsearchUtil(ElasticsearchConf elasticsearchConf) {
        HttpHost httpHost = new HttpHost(
                elasticsearchConf.getHost(),
                elasticsearchConf.getPort());
        RestClient restClient = RestClient.builder(httpHost).build();
        ElasticsearchTransport transport = new RestClientTransport(
                restClient, new JacksonJsonpMapper());
        client = new ElasticsearchClient(transport);
    }

    public ElasticsearchClient getClient() {
        System.out.println(this.client.toString());
        return this.client;
    }
}
