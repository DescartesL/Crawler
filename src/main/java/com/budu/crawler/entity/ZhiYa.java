package com.budu.crawler.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ZhiYa {
    private String title;
    private String url;
    private String summary;

    @Override
    public String toString() {
        return "ZhiYa{" +
                "title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }
}
