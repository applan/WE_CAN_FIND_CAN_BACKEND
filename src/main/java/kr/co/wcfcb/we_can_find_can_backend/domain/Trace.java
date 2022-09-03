package kr.co.wcfcb.we_can_find_can_backend.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Trace {

    // 쓰레기통 위치 명(?)
    private String title;
    // 비고
    private String contents;
    // 위치 (경도, 위도)
    private Location location;
    // 삽입일
    private String insDate;
    // 수정일
    private String updDate;

}
