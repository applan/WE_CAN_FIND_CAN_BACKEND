package kr.co.wcfcb.we_can_find_can_backend.service;

import kr.co.wcfcb.we_can_find_can_backend.domain.Location;
import kr.co.wcfcb.we_can_find_can_backend.domain.Trace;

import java.util.List;

/**
 * 쓰레기통&생활 데이터 처리 용 Service 로직
 * @author applan
 */
public interface TraceService {

    /**
     * 쓰레기통&생활 쓰레기 목록 조회
     * @param location - 위치 정보
     * @return 위치에 따른 데이터 결과
     */
    List<Trace> findByLocation(Location location);

}
