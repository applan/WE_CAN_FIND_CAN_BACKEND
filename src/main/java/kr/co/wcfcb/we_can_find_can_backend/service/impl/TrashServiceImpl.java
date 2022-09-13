package kr.co.wcfcb.we_can_find_can_backend.service.impl;

import co.elastic.clients.elasticsearch._types.GeoLocation;
import co.elastic.clients.elasticsearch._types.LatLonGeoLocation;
import co.elastic.clients.elasticsearch._types.query_dsl.GeoDistanceQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import kr.co.wcfcb.we_can_find_can_backend.dao.TrashDao;
import kr.co.wcfcb.we_can_find_can_backend.domain.Location;
import kr.co.wcfcb.we_can_find_can_backend.domain.Trash;
import kr.co.wcfcb.we_can_find_can_backend.prop.ElasticsearchIndex;
import kr.co.wcfcb.we_can_find_can_backend.service.TrashService;
import kr.co.wcfcb.we_can_find_can_backend.util.ElasticsearchUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrashServiceImpl implements TrashService {

    private final TrashDao trashDao;

    public TrashServiceImpl(TrashDao trashDao) {this.trashDao = trashDao;}

    @Override
    public List<Trash> findByLocation(Location location) {
        List<Trash> traceList = new ArrayList<>();
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
            SearchResponse<Trash> searchResponse = trashDao.findByLocation(sr);

            List<Hit<Trash>> TrashHits = searchResponse.hits().hits();

            for(Hit<Trash> trashHit : TrashHits) {
                traceList.add(trashHit.source());
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        return traceList;
    }
    
    @Override
    public void addByTrash(Trash trash) {
    	try {
    		
    		
    	}catch (Exception e){
            e.printStackTrace();
    	}
    	
    }
    
    @Override
    public void updateByTrash(Trash trash) {
    	try {
    		
    	}catch (Exception e){
            e.printStackTrace();
    	}
    	
    }
}
