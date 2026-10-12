package io.github.saurabhbiradar.airbnbclone.dto;

import io.github.saurabhbiradar.airbnbclone.entity.HotelContactInfo;
import lombok.Data;

@Data
public class HotelDto {

    private Long id;

    private String name;

    private String city;

    private HotelContactInfo contactInfo;

    private String[] photos;

    private String[] amenities;

    private Boolean active;

}
