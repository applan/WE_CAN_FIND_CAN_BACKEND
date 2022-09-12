package kr.co.wcfcb.we_can_find_can_backend.ctrl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 제보하기 관련 처리 Controller 로직
 * @author applan
 * @version 1.0
 */
@RestController
@RequestMapping("/tip-off")
public class TipOffController {

    /**
     * 제보 객체 필드에 따른 조회
     */
    @GetMapping()
    public void findByTipOff() {

    }
}
