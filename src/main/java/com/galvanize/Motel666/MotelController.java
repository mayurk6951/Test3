package com.galvanize.Motel666;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class MotelController {
    @Autowired
    MotelRepo motelRepo;

    @PostMapping("post/event")
    public MotelEntity setEvent(@RequestBody MotelEntity motelEntity)
    {
        return this.motelRepo.save(motelEntity);
    }

    @GetMapping("event/{timeframe1}/{timeframe2}")
    public Iterable<MotelEntity> getAllbyTT(@PathVariable BigInteger timeframe1, @PathVariable BigInteger timeframe2){
        return this.motelRepo.findAllByTimeframe(timeframe1,timeframe2);}

    @GetMapping("event/{userID}")
    public Iterable<MotelEntity> getAllbyUID(@PathVariable UUID userID) {
    return this.motelRepo.findAllbyUserID(userID);
    }

    @GetMapping("/test")
    public String getHello() {
        return "hello";
    }

    //Another approach to get the data between two timeframes
    @GetMapping("event/{timeframe1}/{timeframe2}")
    public Iterable<MotelEntity> getAllbyTTNoCrud(@PathVariable BigInteger timeframe1, @PathVariable BigInteger timeframe2) {

        List<MotelEntity> ret = new ArrayList<MotelEntity>();
        for (BigInteger date = timeframe1; !date.equals(timeframe2); date = date.add(BigInteger.ONE)) {
            ret.add(MotelRepo.getBytimestamp(date));
        }
        return ret;
    }
}


