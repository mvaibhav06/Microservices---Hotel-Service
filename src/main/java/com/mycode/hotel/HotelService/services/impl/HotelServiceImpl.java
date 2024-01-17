package com.mycode.hotel.HotelService.services.impl;

import com.mycode.hotel.HotelService.entities.Hotel;
import com.mycode.hotel.HotelService.exceptions.ResourceNotFoundException;
import com.mycode.hotel.HotelService.repositories.HotelRepository;
import com.mycode.hotel.HotelService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel save(Hotel hotel) {

        String randomHotelId = UUID.randomUUID().toString();
        hotel.setId(randomHotelId);

        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel findById(String id) {
        return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel with given id not found: " + id));
    }
}
