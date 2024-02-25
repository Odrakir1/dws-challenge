package com.dws.challenge.controller;

import com.dws.challenge.dto.response.ApiResponse;
import com.dws.challenge.dto.response.BandResponseDTO;
import com.dws.challenge.service.BandService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping(value = "${v1.0.bands.uri}")
@Tag(name = "Bands")
public class BandsController {

    private final BandService bandService;

    @GetMapping
    @Cacheable("bandsCache")
    public ResponseEntity<List<BandResponseDTO>> getAll(@RequestParam(value = "sorting", defaultValue = "ASC")
                                String sorting, @RequestParam(value = "sortBy", defaultValue = "name") String sortBy){
        List<BandResponseDTO> bandDTO = bandService.getAll(sortBy, sorting);

        return new ResponseEntity<>(bandDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Cacheable("bandsCacheId")
    public ResponseEntity<BandResponseDTO> getBandById(@PathVariable("id") String id){
        BandResponseDTO bandDTO = bandService.getById(id);

        return new ResponseEntity<>(bandDTO, HttpStatus.OK);
    }

    @GetMapping("/byName/{name}")
    @Cacheable("bandsCacheName")
    public ResponseEntity<List<BandResponseDTO>> getBandByName(@PathVariable("name") String name){
        List<BandResponseDTO> bandDTO = bandService.getByName(name);

        return new ResponseEntity<>(bandDTO, HttpStatus.OK);
    }
}
