package com.kimdabang.kdbserver.season.mediaList.vo;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class SeasonMediaListAddRequestVo {
    private Long seasonId;
    private String mediaURL;
    private String imageName;
    private String mediaType;
}
