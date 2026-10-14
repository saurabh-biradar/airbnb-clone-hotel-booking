package io.github.saurabhbiradar.airbnbclone.service;

import io.github.saurabhbiradar.airbnbclone.dto.HotelDto;
import io.github.saurabhbiradar.airbnbclone.entity.Hotel;
import io.github.saurabhbiradar.airbnbclone.exception.ResourceNotFoundException;
import io.github.saurabhbiradar.airbnbclone.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    private final ModelMapper modelMapper;

    @Override
    public HotelDto createHotel(HotelDto hotelDto) {
        log.info("Creating Hotel with name: {}", hotelDto.getName());
        Hotel hotel = modelMapper.map(hotelDto, Hotel.class);
        return modelMapper.map(hotelRepository.save(hotel), HotelDto.class);
    }

    @Override
    public HotelDto getHotelById(Long id) {
        log.info("Getting Hotel with id: {}", id);
        return modelMapper.map(getHotel(id),
                HotelDto.class);
    }

    @Override
    public HotelDto updateHotelById(Long id, HotelDto hotelDto) {
        log.info("Updating Hotel with id: {}", id);
        Hotel hotel = getHotel(id); // Check and get hotel if it exists
        modelMapper.map(hotelDto, hotel);
        hotel.setId(id);
        return modelMapper.map(hotelRepository.save(hotel), HotelDto.class);
    }

    @Override
    public void deleteHotelById(Long id) {
        log.info("Deleting Hotel with id: {}", id);
        if(!hotelRepository.existsById(id)) {
            throw new ResourceNotFoundException("Hotel with id " + id + " not found");
        }
        hotelRepository.deleteById(id);
        //TODO: delete all future inventory for this hotel
    }


    private Hotel getHotel(Long id) {
        return hotelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel with id " + id + " not found"));
    }

}
