package com.zhanghc.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityInfo implements Serializable {

    /** 城市 */
    private String city;

    /** 经度 */
    private Double longitude;

    /** 纬度 */
    private Double latitude;
}
