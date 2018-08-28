package top.qifansfc.study_springboot.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.qifansfc.study_springboot.dao.LiuShuiDao;
import top.qifansfc.study_springboot.domain.LiuShui;

import java.util.List;
@Service
@MapperScan("top.qifansfc.study_springboot.dao")
public class LiuShuiServiceImpl implements LiuShuiService {
    @Autowired
    LiuShuiDao liuShuiDao;
    @Override
    public List<LiuShui> getLiuShui(String beginDate, String endDate) {
        return liuShuiDao.getLiuShui(beginDate,endDate);
    }
}
