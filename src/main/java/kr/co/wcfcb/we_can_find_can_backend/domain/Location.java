package kr.co.wcfcb.we_can_find_can_backend.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class Location {

    // 위도
    private Double lat;
    // 경도
    private Double lon;
}
