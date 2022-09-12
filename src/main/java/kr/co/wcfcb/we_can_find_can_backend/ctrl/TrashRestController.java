package kr.co.wcfcb.we_can_find_can_backend.ctrl;

import kr.co.wcfcb.we_can_find_can_backend.domain.Location;
import kr.co.wcfcb.we_can_find_can_backend.domain.Trash;
import kr.co.wcfcb.we_can_find_can_backend.service.TrashService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 쓰레기 관련 처리 Controller 로직
 * @author applan
 * @version 1.0
 */
@RestController
@RequestMapping("/trash")
public class TrashRestController {

    private final TrashService trashService;

    public TrashRestController(TrashService trashService) {this.trashService = trashService;}

    @GetMapping("/get")
    public List<Trash> findByLocation(@RequestParam() Location location) {
        return trashService.findByLocation(location);
    }

    @PutMapping("/put")
    public void addByLocation(@RequestParam() Location location) {
        trashService.addByLocation(location);
    }

    @PostMapping("/post")
    public void updateByLocation(@RequestParam() Location location) {
        trashService.updateByLocation(location);
    }
}
