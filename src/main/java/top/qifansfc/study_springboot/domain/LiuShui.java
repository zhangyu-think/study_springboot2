package top.qifansfc.study_springboot.domain;

import lombok.Data;

@Data
public class LiuShui {

    //商户编号
    private String shhudm;
    //POS终端号
    private String zdbsma;
    //交易日期
    private String jioyrq;
    //卡号
    private String kahaoo;
    //交易金额
    private String jioyje;
    //商户手续费
    private String shssfe;
    //发卡方手续费
    private String fkfsxf;
    //收单方手续费
    private String sdfsxf;
}
