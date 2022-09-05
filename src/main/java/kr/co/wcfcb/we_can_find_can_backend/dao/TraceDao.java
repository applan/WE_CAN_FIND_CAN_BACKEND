package kr.co.wcfcb.we_can_find_can_backend.dao;

import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import kr.co.wcfcb.we_can_find_can_backend.domain.Trace;

import java.io.IOException;


/**
 * 쓰레기통&생활 데이터 처리 용 Dao 비즈니스 로직
 * @Auth applan
 */
public interface TraceDao {

    /**
     * 쓰레기통&생활 쓰레기 목록 조회
     * @param searchRequest - 조회 조건을 담은 request 객체
     * @return 위치에 따른 데이터 결과
     */
    SearchResponse<Trace> findByLocation(SearchRequest searchRequest) throws IOException;

}
