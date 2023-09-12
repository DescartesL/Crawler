package com.budu.crawler.entity;

import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.TargetUrl;

@TargetUrl("https://tool.lu/article/report/")
public class ZhiyaRepo {

    @ExtractBy(value = ".ct-link", type = ExtractBy.Type.Css)
    private String title;

    @ExtractBy(value = ".ct-link", type = ExtractBy.Type.Css)
    private String url;

    @ExtractBy(value = ".ct-note-content", type = ExtractBy.Type.Css)
    private String summary;

}
