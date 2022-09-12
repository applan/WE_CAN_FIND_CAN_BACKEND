package kr.co.wcfcb.we_can_find_can_backend.ctrl;

import kr.co.wcfcb.we_can_find_can_backend.domain.Location;
import kr.co.wcfcb.we_can_find_can_backend.domain.Trash;
import kr.co.wcfcb.we_can_find_can_backend.service.TrashService;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 쓰레기 관련 처리 Controller 로직
 * @author applan
 * @version 1.0
 */
@RestController
public class TrashRestController {

    private final TrashService trashService;

    public TrashRestController(TrashService trashService) {this.trashService = trashService;}

    @GetMapping("/trash/get")
    public List<Trash> findByLocation(@RequestParam() Location location) {
        return trashService.findByLocation(location);
=======
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 쓰레기 관련 처리 Controller 로직
 * @author applan
 * @version 1.0
 */
@RestController
public class TrashRestController {

    private final TrashService trashService;

    public TrashRestController(TrashService trashService) {this.trashService = trashService;}

    @GetMapping("/trash/get")
    public List<Trash> findByLocation(@RequestParam() Location location) {
        return trashService.findByLocation(location);
    }
    
    @PutMapping("/trash/put")
    public void addByLocation(@RequestParam() Location location) {
    	trashService.addByLocation(location);
    }
    
    @PostMapping("/trash/post")
    public void updateByLocation(@RequestParam() Location location) {
    	trashService.updateByLocation(location);
>>>>>>> branch 'noorykwon' of https://github.com/applan/WE_CAN_FIND_CAN_BACKEND.git
    }
}
