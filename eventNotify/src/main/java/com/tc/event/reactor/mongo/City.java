package com.tc.event.reactor.mongo;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @Description
 * @Author Administrator
 * @DATE 2019/4/4 15:58
 * @Version 1.0
 **/
@Data
public class City {
    @Id
    private String id;
    private Long provinceId;
    private String cityName;
    private String description;
}
