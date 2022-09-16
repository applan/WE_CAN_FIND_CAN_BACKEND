package kr.co.wcfcb.we_can_find_can_backend.service;

import kr.co.wcfcb.we_can_find_can_backend.domain.Location;
import kr.co.wcfcb.we_can_find_can_backend.domain.Trash;

import java.util.List;

/**
 * 쓰레기 관련 처리 SERVICE 로직
 * @author applan
 * @version 1.0
 */
public interface TrashService {

    /**
     * 쓰레기통&생활 쓰레기 목록 조회
     * @param location - 위치 정보
     * @return 위치에 따른 데이터 결과
     */
    List<Trash> findByLocation(Location location);

    /**
     * 쓰레기통&생활 쓰레기 위치 추가
     * @param trash 추가할 쓰레기 데이터 객체
     */
    void addByTrash(Trash trash);

    /**
     * 쓰레기통&생활 쓰레기 정보 수정
     * @param trash 수정할 쓰레기 데이터 객체
     */
    void updateByTrash(Trash trash);
}
