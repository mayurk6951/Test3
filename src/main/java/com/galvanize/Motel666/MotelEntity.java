package com.galvanize.Motel666;

import org.hibernate.id.GUIDGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.math.BigInteger;
import java.util.UUID;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class MotelEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    private String type;
    private UUID userId;
    private String context;
    private BigInteger timestamp;

    public MotelEntity() {
    }

    public MotelEntity(long id, String type, UUID userId, String context, BigInteger timestamp) {
        this.id = id;
        this.type = type;
        this.userId = userId;
        this.context = context;
        this.timestamp = timestamp;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public BigInteger getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(BigInteger timestamp) {
        this.timestamp = timestamp;
    }
}

