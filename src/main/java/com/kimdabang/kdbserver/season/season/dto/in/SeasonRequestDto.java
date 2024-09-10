package com.kimdabang.kdbserver.season.season.dto.in;

import com.kimdabang.kdbserver.season.season.domain.Season;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SeasonRequestDto {

    private Long id;
    private String name;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int discount;

    public Season toEntity() {
        return Season.builder()
                .id(id)
                .name(name)
                .description(description)
                .startDate(startDate)
                .endDate(endDate)
                .discount(discount)
                .build();
    }

    @Builder
    public SeasonRequestDto(Long id, String name, String description, LocalDateTime startDate, LocalDateTime endDate, int discount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.discount = discount;
    }
}
