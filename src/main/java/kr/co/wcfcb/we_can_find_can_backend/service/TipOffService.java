package kr.co.wcfcb.we_can_find_can_backend.service;

import kr.co.wcfcb.we_can_find_can_backend.domain.TipOff;

import java.util.List;

/**
 * 제보 처리 SERVICE 로직
 * @author applan
 * @version 1.0
 */
public interface TipOffService {

    /**
     * 제보 데이터 목록 조회
     * @param tipOff - 검색 조건 선택
     * @return 위치에 따른 데이터 결과
     */
    List<TipOff> findByLocation(TipOff tipOff);

}
