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
@RequestMapping(value = "/trash", produces="application/json;charset=UTF-8")
public class TrashRestController {

    private final TrashService trashService;

    public TrashRestController(TrashService trashService) {this.trashService = trashService;}

    /**
     * 위치에 따른 조회
     * @param location - 사용자 위치 정보
     * @return 사용자 위치 기준 
     */
    @GetMapping()
    public List<Trash> findByLocation(Location location) {
        return trashService.findByLocation(location);
    }

    /**
     * 쓰레기통 정보 생성
     * @param trash - 쓰레기통 관련 정보
     */
    @PutMapping()
    public void addByLocation(@RequestBody() Trash trash) {
        trashService.addByTrash(trash);
    }

    /**
     * 쓰레기통 정보 수정
     * @param trash - 쓰레기통 관련 정보
     */
    @PostMapping()
    public void updateByLocation(@RequestBody() Trash trash) {
        trashService.updateByTrash(trash);
    }
}
