package top.qifansfc.study_springboot.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.qifansfc.study_springboot.domain.LiuShui;

import java.util.List;

@Mapper
public interface LiuShuiDao {
    @Select("select * from liushui where jyrq>=#{0} and jyrq<=#{1}")
    List<LiuShui> getLiuShui(String beginDate, String endDate);
}
