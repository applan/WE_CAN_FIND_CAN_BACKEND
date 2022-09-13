package kr.co.wcfcb.we_can_find_can_backend.dao.impl;

import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import kr.co.wcfcb.we_can_find_can_backend.dao.TipOffDao;
import kr.co.wcfcb.we_can_find_can_backend.domain.TipOff;
import kr.co.wcfcb.we_can_find_can_backend.util.ElasticsearchUtil;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
public class TipOffDaoImpl implements TipOffDao {

    private final ElasticsearchUtil elasticsearchUtil;

    public TipOffDaoImpl(ElasticsearchUtil elasticsearchUtil) {this.elasticsearchUtil = elasticsearchUtil;}

    @Override
    public SearchResponse<TipOff> findByTipOff(SearchRequest searchRequest) throws IOException {
        return elasticsearchUtil.getClient().search(searchRequest, TipOff.class);
    }
}
