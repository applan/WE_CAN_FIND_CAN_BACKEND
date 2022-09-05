package kr.co.wcfcb.we_can_find_can_backend.service.impl;

import co.elastic.clients.elasticsearch.core.SearchResponse;
import kr.co.wcfcb.we_can_find_can_backend.dao.TraceDao;
import kr.co.wcfcb.we_can_find_can_backend.domain.Location;
import kr.co.wcfcb.we_can_find_can_backend.domain.Trace;
import kr.co.wcfcb.we_can_find_can_backend.service.TraceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraceServiceImpl implements TraceService {

    private final TraceDao traceDao;

    public TraceServiceImpl(TraceDao traceDao) {this.traceDao = traceDao;}

    @Override
    public List<Trace> findByLocation(Location location) {
        List<Trace> traceList = null;
        try{
            SearchResponse<Trace> searchResponse = traceDao.findByLocation(null);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return traceList;
    }
}
