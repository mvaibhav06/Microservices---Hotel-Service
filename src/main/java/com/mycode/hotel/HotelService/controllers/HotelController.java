package com.mycode.hotel.HotelService.controllers;

import com.mycode.hotel.HotelService.entities.Hotel;
import com.mycode.hotel.HotelService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){

        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.save(hotel));
    }

    @GetMapping("{id}")
    public ResponseEntity<Hotel> findHotelById(@PathVariable String id){
        return ResponseEntity.ok(hotelService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.findAll());
    }
}
