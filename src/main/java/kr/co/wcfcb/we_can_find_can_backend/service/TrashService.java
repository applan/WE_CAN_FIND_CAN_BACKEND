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
<<<<<<< HEAD
=======
    
    /**
     * 쓰레기통&생활 쓰레기 위치 추가
     * @param location
     */
    void addByLocation(Location location);

    /**
     * 쓰레기통&생활 쓰레기 정보 수정
     * @param location
     */
    void updateByLocation(Location location);
>>>>>>> branch 'noorykwon' of https://github.com/applan/WE_CAN_FIND_CAN_BACKEND.git

}
