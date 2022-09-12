package kr.co.wcfcb.we_can_find_can_backend.util;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.GeoLocation;
import co.elastic.clients.elasticsearch._types.LatLonGeoLocation;
import co.elastic.clients.elasticsearch.indices.CreateIndexRequest;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import kr.co.wcfcb.we_can_find_can_backend.domain.Location;
import kr.co.wcfcb.we_can_find_can_backend.prop.ElasticsearchConf;
import kr.co.wcfcb.we_can_find_can_backend.prop.ElasticsearchIndex;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.InputStream;


@Slf4j
@Component
public class ElasticsearchUtil {

    private final ElasticsearchClient client;

    /**
     * Elasticsearch Client 생성
     * @param elasticsearchConf - 프로젝트 yml 파일과 연동되어있는 설정 값
     */
    public ElasticsearchUtil(ElasticsearchConf elasticsearchConf) {
        HttpHost httpHost = new HttpHost(
                elasticsearchConf.getHost(),
                elasticsearchConf.getPort());
        RestClient restClient = RestClient.builder(httpHost).build();
        ElasticsearchTransport transport = new RestClientTransport(
                restClient, new JacksonJsonpMapper());
        client = new ElasticsearchClient(transport);
    }

    /**
     * 생성된 Client 이용하기
     * @return 생성된 ElasticsearchClient
     */
    public ElasticsearchClient getClient() {
        return this.client;
    }

    /**
     * Elasticsearch 인덱스 생성
     * @param indexName - 생성할 인덱스 명
     * @param indexFileName - 생성할 익덱스 셋팅, 맵핑 파일
     * @throws Exception - 종합 에러 
     */
    public void createIndex(String indexName, String indexFileName) throws Exception {
        log.info("[CREATE]" + indexName + " CHECK...");
        if(this.client.indices().exists(e -> e.index(indexName)).value()){
            log.info("[CREATE]" + indexName + " EXIST!");
        }else{
            ClassPathResource classPathResource = new ClassPathResource(indexFileName);
            InputStream trashIndexFile = classPathResource.getInputStream();
            CreateIndexRequest rq = CreateIndexRequest.of(b -> b.index(ElasticsearchIndex.TRACE_INDEX).withJson(trashIndexFile));
            if(this.client.indices().create(rq).acknowledged()){
                log.info("[CREATE]" + indexName + " CREATE SUCCESS");
            }
        }
    }

    /**
     * GeoLocation 객체를 만들기 위한 작업 1단계
     * 받아온 location 객체에서 lon, lat을 이용하여 LatLonGeoLocation 객체 생성
     * @param location - 자신의 위도, 경도 정보가 담겨있는 객체
     * @return LatLonGeoLocation - 위도, 경도 정보가 셋팅된 객체 
     */
    public static LatLonGeoLocation caseLatLonGeoLocation(Location location) {
        return LatLonGeoLocation.of(llgl -> llgl
                .lon(location.getLon())
                .lat(location.getLat())
        );
    }

    /**
     * GeoDistanceQuery 객체를 만들기 위한 작업 2단계
     * latlon 셋팅된 데이터 담기
     * @param latLonGeoLocation - location 파라미터에서 받은 데이터로 셋팅된 위도, 경도를 가진 객체
     * @return GeoLocation - latLonGeoLocation 객체가 셋팅된 객체
     */
    public static GeoLocation caseGeoLocation(LatLonGeoLocation latLonGeoLocation) {
        return GeoLocation.of(gl -> gl.latlon(latLonGeoLocation));
    }
}
