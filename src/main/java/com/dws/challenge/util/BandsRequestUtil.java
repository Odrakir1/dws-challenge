package com.dws.challenge.util;

import com.dws.challenge.configuration.CustomWebClient;
import com.dws.challenge.dto.response.BandResponseDTO;
import com.dws.challenge.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class BandsRequestUtil {

    private final CustomWebClient webClient;

    public List<BandResponseDTO> getAll(String endpoint) {
        return webClient.getWebClient().get()
                .uri(endpoint)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<BandResponseDTO>>(){})
                .block();
    }

    public List<BandResponseDTO> getByName(String endpoint) {
        return webClient.getWebClient().get()
                .uri(endpoint)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<BandResponseDTO>>(){})
                .block();
    }
}
