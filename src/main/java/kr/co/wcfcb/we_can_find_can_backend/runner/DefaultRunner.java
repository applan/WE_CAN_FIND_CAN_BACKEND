package kr.co.wcfcb.we_can_find_can_backend.runner;

import kr.co.wcfcb.we_can_find_can_backend.prop.ElasticsearchIndex;
import kr.co.wcfcb.we_can_find_can_backend.util.ElasticsearchUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DefaultRunner implements ApplicationRunner {

    private final ElasticsearchUtil elasticsearchUtil;
    private final ApplicationContext context;

    public DefaultRunner(ElasticsearchUtil elasticsearchUtil, ApplicationContext context) {
        this.elasticsearchUtil = elasticsearchUtil;
        this.context = context;
    }

    @Override
    public void run(ApplicationArguments args) {
        try{
            elasticsearchUtil.createIndex(ElasticsearchIndex.TRACE_INDEX, "trash.json");
        }catch (Exception e) {
            log.error("RUNNER ERROR - " + e.getMessage());
            SpringApplication.exit(context, () -> 0);
        }
    }
}
