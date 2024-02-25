package com.dws.challenge.dto.response;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class TrackDTO implements Serializable {
    private String name;
    private int duration;
    private String id;

}
