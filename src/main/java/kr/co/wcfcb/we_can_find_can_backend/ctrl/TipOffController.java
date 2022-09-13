package kr.co.wcfcb.we_can_find_can_backend.ctrl;

import kr.co.wcfcb.we_can_find_can_backend.domain.TipOff;
import kr.co.wcfcb.we_can_find_can_backend.service.TipOffService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 제보하기 관련 처리 Controller 로직
 * @author applan
 * @version 1.0
 */
@RestController
@RequestMapping("/tip-off")
public class TipOffController {

    private final TipOffService tipOffService;

    public TipOffController(TipOffService tipOffService) {
        this.tipOffService = tipOffService;
    }

    /**
     * 조건에 따른 제보 데이터 조회
     */
    @GetMapping()
    public List<TipOff> findByTipOff(@RequestParam TipOff tipOff) {
        return tipOffService.findByLocation(tipOff);
    }


}
