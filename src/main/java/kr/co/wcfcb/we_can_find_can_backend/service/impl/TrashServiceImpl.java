package kr.co.wcfcb.we_can_find_can_backend.service.impl;

import co.elastic.clients.elasticsearch._types.GeoLocation;
import co.elastic.clients.elasticsearch._types.LatLonGeoLocation;
import co.elastic.clients.elasticsearch._types.query_dsl.BoolQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.GeoDistanceQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch._types.query_dsl.TermQuery;
import co.elastic.clients.elasticsearch.core.IndexRequest;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.UpdateRequest;
import co.elastic.clients.elasticsearch.core.search.Hit;
import kr.co.wcfcb.we_can_find_can_backend.dao.TrashDao;
import kr.co.wcfcb.we_can_find_can_backend.domain.Location;
import kr.co.wcfcb.we_can_find_can_backend.domain.Trash;
import kr.co.wcfcb.we_can_find_can_backend.prop.ElasticsearchIndex;
import kr.co.wcfcb.we_can_find_can_backend.prop.ProjectProperties;
import kr.co.wcfcb.we_can_find_can_backend.service.TrashService;
import kr.co.wcfcb.we_can_find_can_backend.util.ElasticsearchUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class TrashServiceImpl implements TrashService {

    private final TrashDao trashDao;

    private final Logger logger;

    public TrashServiceImpl(TrashDao trashDao) {
        this.trashDao = trashDao;
        this.logger = LoggerFactory.getLogger(getClass());
    }

    @Override
    public List<Trash> findByLocation(Location location) {
        List<Trash> trashList = new ArrayList<>();
        try{
            // https://www.elastic.co/guide/en/elasticsearch/client/java-api-client/current/searching.html
            LatLonGeoLocation llgl = ElasticsearchUtil.caseLatLonGeoLocation(location);
            GeoLocation gl = ElasticsearchUtil.caseGeoLocation(llgl);
            Query gdq = GeoDistanceQuery.of(g -> g
                    .distance("1km")
                    .field("location")
                    .location(gl))._toQuery();
            SearchRequest sr = SearchRequest.of(s -> s
                    .index(ElasticsearchIndex.TRACE_INDEX)
                    .query(gdq).size(1000));

            logger.info("SearchRequest_ ####################");
            logger.info(sr.toString());
            logger.info("SearchRequest_ ####################");

            SearchResponse<Trash> searchResponse = trashDao.findByLocation(sr);

            List<Hit<Trash>> trashHits = searchResponse.hits().hits();

            for(Hit<Trash> trashHit : trashHits) {
                trashList.add(trashHit.source());
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        return trashList;
    }

    @Override
    public void saveTrash(Trash trash) {
        try {
            //https://www.elastic.co/guide/en/elasticsearch/client/java-rest/current/java-rest-high-document-index.html
            LocalDateTime now = LocalDateTime.now();
            String nowStr = now.format(ProjectProperties.DATE_TIME_FORMATTER);
            trash.setInsDate(nowStr);
            IndexRequest indexRequest = IndexRequest.of(ir -> ir
                    .index(ElasticsearchIndex.TRACE_INDEX)
                    .document(trash));
            trashDao.saveTrash(indexRequest);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void updateTrash(Trash trash) {
        try {
            //https://www.elastic.co/guide/en/elasticsearch/client/java-rest/current/java-rest-high-document-update.html#java-rest-high-document-update-request
            LocalDateTime now = LocalDateTime.now();
            String nowStr = now.format(ProjectProperties.DATE_TIME_FORMATTER);
            trash.setUpdDate(nowStr);
            UpdateRequest updateRequest = UpdateRequest.of(ir -> ir
                    .index(ElasticsearchIndex.TRACE_INDEX)
                    .id(trash.getId())
                    .doc(trash));
            trashDao.updateTrash(updateRequest);


        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
