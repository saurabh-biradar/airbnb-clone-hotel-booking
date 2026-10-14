package io.github.saurabhbiradar.airbnbclone.service;

import io.github.saurabhbiradar.airbnbclone.dto.HotelDto;

public interface HotelService {

    HotelDto createHotel(HotelDto hotelDto);

    HotelDto getHotelById(Long id);

    HotelDto updateHotelById(Long id, HotelDto hotelDto);

    void deleteHotelById(Long id);
}
