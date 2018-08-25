package top.qifansfc.study_springboot.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.sql.Date;

public class User {
    private Integer id;
    private String name;
    private Integer age;
    private String sex;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private String addtime;
    public Integer getId() {
        return id;
    }
//    public void setId(Integer id) {
//        this.id = id;
//    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public Integer getAge() {
        return age;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", addtime=" + addtime +
                '}';
    }
}
