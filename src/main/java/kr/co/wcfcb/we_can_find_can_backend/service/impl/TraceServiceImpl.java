package kr.co.wcfcb.we_can_find_can_backend.service.impl;

import co.elastic.clients.elasticsearch._types.GeoLocation;
import co.elastic.clients.elasticsearch._types.LatLonGeoLocation;
import co.elastic.clients.elasticsearch._types.query_dsl.GeoDistanceQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import kr.co.wcfcb.we_can_find_can_backend.dao.TraceDao;
import kr.co.wcfcb.we_can_find_can_backend.domain.Location;
import kr.co.wcfcb.we_can_find_can_backend.domain.Trash;
import kr.co.wcfcb.we_can_find_can_backend.prop.ElasticsearchIndex;
import kr.co.wcfcb.we_can_find_can_backend.service.TraceService;
import kr.co.wcfcb.we_can_find_can_backend.util.ElasticsearchUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraceServiceImpl implements TraceService {

    private final TraceDao traceDao;

    public TraceServiceImpl(TraceDao traceDao) {this.traceDao = traceDao;}

    @Override
    public List<Trash> findByLocation(Location location) {
        List<Trash> traceList = null;
        try{
            // https://www.elastic.co/guide/en/elasticsearch/client/java-api-client/current/searching.html
            LatLonGeoLocation llgl = ElasticsearchUtil.caseLatLonGeoLocation(location);
            GeoLocation gl = ElasticsearchUtil.caseGeoLocation(llgl);
            Query gdq = GeoDistanceQuery.of(g -> g
                    .distance("1km")
                    .location(gl))._toQuery();
            SearchRequest sr = SearchRequest.of(s -> s
                    .index(ElasticsearchIndex.TRACE_INDEX)
                    .query(gdq));
            SearchResponse<Trash> searchResponse = traceDao.findByLocation(sr);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return traceList;
    }
}
