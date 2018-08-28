package top.qifansfc.study_springboot.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.qifansfc.study_springboot.domain.LiuShui;

import java.util.List;

@Mapper
public interface LiuShuiDao {
    @Select("select * from T90_HQS_CR028 where JIOYRQ>=#{0} and JIOYRQ<=#{1}")
    List<LiuShui> getLiuShui(String beginDate, String endDate);
}
