package kr.co.wcfcb.we_can_find_can_backend.ctrl;

import kr.co.wcfcb.we_can_find_can_backend.util.ElasticsearchUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TraceRestController {
    private final ElasticsearchUtil elasticsearchUtil;
    public TraceRestController(ElasticsearchUtil elasticsearchUtil) {
        this.elasticsearchUtil = elasticsearchUtil;
    }

    @GetMapping("/get/trace")
    public Map<String, Object> getList() {
        elasticsearchUtil.getClient();
        return null;
    }
}
