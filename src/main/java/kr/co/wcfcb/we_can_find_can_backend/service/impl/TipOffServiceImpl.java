package kr.co.wcfcb.we_can_find_can_backend.service.impl;

import kr.co.wcfcb.we_can_find_can_backend.dao.TipOffDao;
import kr.co.wcfcb.we_can_find_can_backend.domain.TipOff;
import kr.co.wcfcb.we_can_find_can_backend.service.TipOffService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TipOffServiceImpl implements TipOffService {

    private final TipOffDao tipOffDao;

    public TipOffServiceImpl(TipOffDao tipOffDao) {
        this.tipOffDao = tipOffDao;
    }

    @Override
    public List<TipOff> findByLocation(TipOff tipOff) {

        List<TipOff> tipOffList = new ArrayList<>();
        try{
            tipOffDao.findByTipOff(null);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
