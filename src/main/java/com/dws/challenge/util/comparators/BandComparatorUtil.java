package com.dws.challenge.util.comparators;

import com.dws.challenge.dto.response.BandResponseDTO;
import com.dws.challenge.contants.SortingConstants;

import java.util.Comparator;
import java.util.Objects;

public class BandComparatorUtil {

    public static Comparator<BandResponseDTO> getNameAscComparator() {
        return Comparator.comparing(BandResponseDTO::getName);
    }

    public static Comparator<BandResponseDTO> getNameDescComparator() {
        return Comparator.comparing(BandResponseDTO::getName).reversed();
    }

    public static Comparator<BandResponseDTO> getComparator(String sortBy, String sorting) {
        if(Objects.isNull(sortBy)) return getBandResponseDTONameComparator(sorting);

        switch (sortBy){
            case SortingConstants.NAME:
                return getBandResponseDTONameComparator(sorting);
            case SortingConstants.POPULARITY:
                return getBandResponseDTOPopularityComparator(sorting);
            default: return getBandResponseDTONameComparator(sorting);
        }

    }

    private static Comparator<BandResponseDTO> getBandResponseDTOPopularityComparator(String sorting) {

        if(Objects.isNull(sorting)) return getNameAscComparator();

        Comparator<BandResponseDTO> comparator = Comparator.comparingLong(BandResponseDTO::getNumPlays);

        return switch (sorting) {
            case SortingConstants.ASC -> comparator;
            case SortingConstants.DESC -> comparator.reversed();
            default -> comparator.reversed();
        };
    }

    private static Comparator<BandResponseDTO> getBandResponseDTONameComparator(String sorting) {
        if(Objects.isNull(sorting)) return getNameAscComparator();

        return switch (sorting) {
            case SortingConstants.ASC -> getNameAscComparator();
            case SortingConstants.DESC -> getNameDescComparator();
            default -> getNameAscComparator();
        };
    }
}
