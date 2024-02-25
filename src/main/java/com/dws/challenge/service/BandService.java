package com.dws.challenge.service;

import com.dws.challenge.dto.response.BandResponseDTO;
import com.dws.challenge.exception.ResourceNotFoundException;
import com.dws.challenge.util.BandsRequestUtil;
import com.dws.challenge.util.comparators.BandComparatorUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BandService {
    @Value("${external.bands.url}")
    private String externalBandsURL;

    private final BandsRequestUtil bandsRequestUtil;

    public List<BandResponseDTO> getAll(String sortBy, String sorting) {
        Comparator<BandResponseDTO> comparator = BandComparatorUtil.getComparator(sortBy, sorting);

        List<BandResponseDTO> bands = bandsRequestUtil.getAll(externalBandsURL);

        bands.sort(comparator);

        return bands;
    }

    public BandResponseDTO getById(String id) {
        List<BandResponseDTO> bands = bandsRequestUtil.getAll(externalBandsURL);

        return bands.stream()
                .filter(band -> id.equalsIgnoreCase(band.getId()))
                .findFirst().orElseThrow(() -> new ResourceNotFoundException(String.format("Band with id %s was not found.", id)));
    }

    public List<BandResponseDTO> getByName(String name) {
        List<BandResponseDTO> bands = bandsRequestUtil.getByName(externalBandsURL);

        bands.stream()
                .filter(band -> name.equalsIgnoreCase(band.getName()))
                .collect(Collectors.toList());

        if (bands.isEmpty()) {
            throw new ResourceNotFoundException(String.format("No Band was found with name: '%s'", name));
        }

        return bands;
    }
}