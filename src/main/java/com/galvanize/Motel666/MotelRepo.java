package com.galvanize.Motel666;

import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.UUID;

public abstract class MotelRepo implements CrudRepository<MotelEntity,Long> {


    public static MotelEntity getBytimestamp(BigInteger date) {
        return MotelRepo.getBytimestamp(date);
    }

    public abstract Iterable<MotelEntity> findAllByTimeframe(BigInteger timeframe1, BigInteger timeframe2);

    public abstract Iterable<MotelEntity> findAllbyUserID(UUID userID);
}
