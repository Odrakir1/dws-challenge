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
public class BandResponseDTO implements Serializable {
    private String name;
    private String image;
    private String genre;
    private String biography;
    private long numPlays;
    private String id;
    private List<AlbumResponseDTO> albums;
}
