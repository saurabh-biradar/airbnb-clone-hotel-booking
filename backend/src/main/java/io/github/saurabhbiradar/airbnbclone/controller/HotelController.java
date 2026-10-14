package io.github.saurabhbiradar.airbnbclone.controller;

import io.github.saurabhbiradar.airbnbclone.dto.HotelDto;
import io.github.saurabhbiradar.airbnbclone.service.HotelServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/hotels")
@Slf4j
@RequiredArgsConstructor
public class HotelController {

    private final HotelServiceImpl hotelService;

    @PostMapping
    public ResponseEntity<HotelDto> createHotel(@RequestBody HotelDto hotelDto) {
        return new ResponseEntity<>(hotelService.createHotel(hotelDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelDto> getHotelById(@PathVariable Long id) {
        return new ResponseEntity<>(hotelService.getHotelById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HotelDto> updateHotel(@PathVariable Long id, @RequestBody HotelDto hotelDto) {
        return new ResponseEntity<>(hotelService.updateHotelById(id, hotelDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHotel(@PathVariable Long id) {
        hotelService.deleteHotelById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
