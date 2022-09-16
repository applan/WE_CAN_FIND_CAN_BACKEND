package kr.co.wcfcb.we_can_find_can_backend.dao;

import co.elastic.clients.elasticsearch.core.BulkRequest;
import co.elastic.clients.elasticsearch.core.CreateRequest;
import co.elastic.clients.elasticsearch.core.IndexRequest;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.UpdateRequest;
import kr.co.wcfcb.we_can_find_can_backend.domain.Trash;

import java.io.IOException;


/**
 * 쓰레기 관련 처리 DAO 로직
 * @author applan
 * @version 1.0
 */
public interface TrashDao {

    /**
     * 쓰레기통&생활 쓰레기 목록 조회
     * @param searchRequest - 조회 조건을 담은 request 객체
     * @return 위치에 따른 데이터 결과
     */
    SearchResponse<Trash> findByLocation(SearchRequest searchRequest) throws IOException;

    /**
     * 쓰레기통&생활 쓰레기 폐기장소 추가
     * @param indexRequest - 추가정보를 담은 request 객체
     */
    void saveTrash(IndexRequest<Trash> indexRequest) throws IOException;
    
    /**
     * 쓰레기통&생활 쓰레기 폐기장소 수정
     * @param updateRequest - 수정할 객체의 id와 수정정보를 담은 request 객체
     */
    void updateTrash(UpdateRequest<Trash, Trash> updateRequest) throws IOException;
}
