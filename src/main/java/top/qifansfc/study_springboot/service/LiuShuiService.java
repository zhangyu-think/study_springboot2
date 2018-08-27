package top.qifansfc.study_springboot.service;

import top.qifansfc.study_springboot.domain.LiuShui;

import java.util.List;

public interface LiuShuiService {
    List<LiuShui> getLiuShui(String beginDate, String endDate);
}
