package kr.co.wcfcb.we_can_find_can_backend.runner;

import co.elastic.clients.elasticsearch.core.BulkRequest;
import co.elastic.clients.elasticsearch.core.bulk.BulkOperation;
import co.elastic.clients.elasticsearch.core.bulk.IndexOperation;
import kr.co.wcfcb.we_can_find_can_backend.domain.Location;
import kr.co.wcfcb.we_can_find_can_backend.domain.Trash;
import kr.co.wcfcb.we_can_find_can_backend.prop.ElasticsearchIndex;
import kr.co.wcfcb.we_can_find_can_backend.prop.ProjectProperties;
import kr.co.wcfcb.we_can_find_can_backend.util.ElasticsearchUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

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
            initTestData();

        }catch (Exception e) {
            logger.error("RUNNER ERROR - " + e.getMessage());
            SpringApplication.exit(context, () -> 0);
            System.exit(0);
        }
    }

    private IndexOperation<Trash> initTestDataObject(String title, Double lat, Double lon){
        LocalDateTime now = LocalDateTime.now();
        String nowStr = now.format(ProjectProperties.DATE_TIME_FORMATTER);
        Trash trash = new Trash(title, title + "_쓰레기통",
                new Location(lat, lon), nowStr, null, "CAN");
        return IndexOperation.of(indexOperation -> indexOperation.document(trash));
    }

    private void initTestData() throws IOException {
        /**
         * ### 테스트 데이터 추가
         * 부평문화의거리 : 37.494159, 126.754704
         * 부평역사거리 : 37.491406, 126.723831
         * 부평역광장 : 37.490281, 126.723292
         * 북인천우체국 : 37.491393, 126.722102
         * 부평공원1 : 37.490148, 126.715355
         * 부평공원2 : 37.486924, 126.711891
         * 투썸앞 : 37.493410, 126.725786
         * 랜덤 : 37.492498, 126.722902
         * 랜덤 : 37.492570, 126.723946
         * 랜덤 : 37.493193, 126.724375
         */
        List<Double> lats = new ArrayList<>();
        List<Double> lons = new ArrayList<>();
        for(int i=0; i<100000; i++) {
            lats.add(ThreadLocalRandom.current().nextDouble(37.4, 37.5));
            lons.add(ThreadLocalRandom.current().nextDouble(126.7, 126.8));
        }

        lats = lats.stream().distinct().collect(Collectors.toList());
        lons = lons.stream().distinct().collect(Collectors.toList());

        List<BulkOperation> bulkOperationList = new ArrayList<>();
        for(int i=0; i<lons.size(); i++) {
            IndexOperation io = initTestDataObject("부평 " + i, lats.get(i), lons.get(i));
            BulkOperation bo = BulkOperation.of(b -> b.index(io));
            bulkOperationList.add(bo);
        }

        BulkRequest br = BulkRequest.of(b -> b.operations(bulkOperationList).index(ElasticsearchIndex.TRACE_INDEX));


        logger.info("INSERT] TEST DATA INIT");
        elasticsearchUtil.getClient().bulk(br);
        logger.info("INSERT] TEST DATA INIT END...");
    }
}
