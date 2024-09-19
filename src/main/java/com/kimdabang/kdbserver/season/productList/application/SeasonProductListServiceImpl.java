package com.kimdabang.kdbserver.season.productList.application;

import com.kimdabang.kdbserver.common.exception.CustomException;
import com.kimdabang.kdbserver.common.exception.ErrorCode;
import com.kimdabang.kdbserver.product.product.infrastructure.ProductRepository;
import com.kimdabang.kdbserver.season.productList.domain.SeasonProductList;
import com.kimdabang.kdbserver.season.productList.dto.in.SeasonProductListAddRequestDto;
import com.kimdabang.kdbserver.season.productList.dto.in.SeasonProductListUpdateRequestDto;
import com.kimdabang.kdbserver.season.productList.dto.out.SeasonProductListResponseDto;
import com.kimdabang.kdbserver.season.productList.infrastructure.SeasonProductListRepository;
import com.kimdabang.kdbserver.season.season.domain.Season;
import com.kimdabang.kdbserver.season.season.infrastructure.SeasonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SeasonProductListServiceImpl implements SeasonProductListService {

    private final SeasonProductListRepository seasonProductListRepository;
    private final SeasonRepository seasonRepository;
//    private final ProductRepository productRepository;

    @Override
    @Transactional
    public void addSeasonProductList(SeasonProductListAddRequestDto seasonProductListAddRequestDto) {
        Season season = seasonRepository.findById(seasonProductListAddRequestDto.getSeasonId())
                .orElseThrow(() -> new CustomException(ErrorCode.SEASON_NOT_FOUND));

        seasonProductListRepository.save(seasonProductListAddRequestDto.toEntity(season));
    }

    @Override
    @Transactional
    public void updateSeasonProductList(SeasonProductListUpdateRequestDto seasonProductListUpdateRequestDto) {
        SeasonProductList seasonProductList = seasonProductListRepository.findById(seasonProductListUpdateRequestDto.getId())
                .orElseThrow(() -> new CustomException(ErrorCode.SEASONPRODUCT_NOT_FOUND));

        seasonProductListRepository.save(seasonProductListUpdateRequestDto.toEntity(seasonProductList));
    }

    @Override
    @Transactional
    public void deleteSeasonProductList(Long id) {
        SeasonProductList seasonProductList = seasonProductListRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.SEASONPRODUCT_NOT_FOUND));

        seasonProductListRepository.delete(seasonProductList);
    }

    @Override
    public SeasonProductListResponseDto getOneSeasonProductList(Long id) {
        // TODO: 9/19/24
        return null;
    }

    @Override
    public List<SeasonProductListResponseDto> getAllSeasonProductList() {
        // TODO: 9/19/24
        return null;
    }
}
