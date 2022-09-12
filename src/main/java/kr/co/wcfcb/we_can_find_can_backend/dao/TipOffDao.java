package kr.co.wcfcb.we_can_find_can_backend.dao;

import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import kr.co.wcfcb.we_can_find_can_backend.domain.TipOff;

import java.io.IOException;

/**
 * 제보하기 관련 처리 DAO 로직
 * @author applan
 * @version 1.0
 */
public interface TipOffDao {

    /**
     * 제보 데이터 목록 조회
     * @param searchRequest - 조회 조건을 담은 request 객체
     * @return 위치에 따른 데이터 결과
     */
    SearchResponse<TipOff> findByTipOff(SearchRequest searchRequest) throws IOException;
    
}
