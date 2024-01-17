package com.mycode.hotel.HotelService.services;

import com.mycode.hotel.HotelService.entities.Hotel;

import java.util.List;

public interface HotelService {

    Hotel save(Hotel hotel);

    List<Hotel> findAll();

    Hotel findById(String id);
}
