package kr.co.wcfcb.we_can_find_can_backend.ctrl;

import kr.co.wcfcb.we_can_find_can_backend.util.ElasticsearchUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class TraceRestController {

    private final ElasticsearchUtil elasticsearchUtil;

    @GetMapping("/get/trace")
    public Map<String, Object> getList() {
        elasticsearchUtil.getClient();
        return null;
    }
}
