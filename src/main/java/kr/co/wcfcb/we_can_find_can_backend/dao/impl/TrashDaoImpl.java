package kr.co.wcfcb.we_can_find_can_backend.dao.impl;

import co.elastic.clients.elasticsearch.core.BulkRequest;
import co.elastic.clients.elasticsearch.core.CreateRequest;
import co.elastic.clients.elasticsearch.core.IndexRequest;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import kr.co.wcfcb.we_can_find_can_backend.dao.TrashDao;
import kr.co.wcfcb.we_can_find_can_backend.domain.Trash;
import kr.co.wcfcb.we_can_find_can_backend.util.ElasticsearchUtil;
import org.springframework.stereotype.Repository;

import java.io.IOException;


@Repository
public class TrashDaoImpl implements TrashDao {

    private final ElasticsearchUtil elasticsearchUtil;

    public TrashDaoImpl(ElasticsearchUtil elasticsearchUtil) {this.elasticsearchUtil = elasticsearchUtil;}

    @Override
    public SearchResponse<Trash> findByLocation(SearchRequest searchRequest) throws IOException {
        return elasticsearchUtil.getClient().search(searchRequest, Trash.class);
    }
    
    @Override
    public void addByLocation(IndexRequest<Trash> indexRequest) throws IOException {
    	 elasticsearchUtil.getClient().index(indexRequest);
    }
}
