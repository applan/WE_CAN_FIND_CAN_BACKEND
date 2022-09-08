package kr.co.wcfcb.we_can_find_can_backend.ctrl;

import kr.co.wcfcb.we_can_find_can_backend.domain.Location;
import kr.co.wcfcb.we_can_find_can_backend.domain.Trash;
import kr.co.wcfcb.we_can_find_can_backend.service.TraceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 쓰레기 관련 처리 Controller 로직
 * @author applan
 * @version 1.0
 */
@RestController
public class TraceRestController {

    private final TraceService traceService;

    public TraceRestController(TraceService traceService) {this.traceService = traceService;}

    @GetMapping("/get/trace")
    public List<Trash> findByLocation(Location location) {
        return traceService.findByLocation(location);
    }
}
