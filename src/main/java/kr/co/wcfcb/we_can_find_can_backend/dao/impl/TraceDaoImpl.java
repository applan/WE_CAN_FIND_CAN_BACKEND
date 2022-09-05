package kr.co.wcfcb.we_can_find_can_backend.dao.impl;

import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import kr.co.wcfcb.we_can_find_can_backend.dao.TraceDao;
import kr.co.wcfcb.we_can_find_can_backend.domain.Trace;
import kr.co.wcfcb.we_can_find_can_backend.util.ElasticsearchUtil;
import org.springframework.stereotype.Repository;

import java.io.IOException;


@Repository
public class TraceDaoImpl implements TraceDao {

    private final ElasticsearchUtil elasticsearchUtil;

    public TraceDaoImpl(ElasticsearchUtil elasticsearchUtil) {this.elasticsearchUtil = elasticsearchUtil;}

    @Override
    public SearchResponse<Trace> findByLocation(SearchRequest searchRequest) throws IOException {
        return elasticsearchUtil.getClient().search(searchRequest, Trace.class);
    }
}
