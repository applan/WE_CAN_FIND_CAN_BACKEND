package kr.co.wcfcb.we_can_find_can_backend.runner;

import kr.co.wcfcb.we_can_find_can_backend.prop.ElasticsearchIndex;
import kr.co.wcfcb.we_can_find_can_backend.util.ElasticsearchUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class DefaultRunner implements ApplicationRunner {

    private final ElasticsearchUtil elasticsearchUtil;
    private final ApplicationContext context;
    private final Logger logger;

    public DefaultRunner(ElasticsearchUtil elasticsearchUtil, ApplicationContext context) {
        this.elasticsearchUtil = elasticsearchUtil;
        this.context = context;
        this.logger = LoggerFactory.getLogger(getClass());
    }

    @Override
    public void run(ApplicationArguments args) {
        try{
            elasticsearchUtil.createIndex(ElasticsearchIndex.TRACE_INDEX, "trash.json");
        }catch (Exception e) {
            logger.error("RUNNER ERROR - " + e.getMessage());
            SpringApplication.exit(context, () -> 0);
        }
    }
}
