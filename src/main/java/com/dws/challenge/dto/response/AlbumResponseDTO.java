package com.dws.challenge.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlbumResponseDTO implements Serializable {
    private String name;
    private String image;
    private String releasedDate;
    private String band;
    private List<TrackDTO> tracks;
    private String id;

}
