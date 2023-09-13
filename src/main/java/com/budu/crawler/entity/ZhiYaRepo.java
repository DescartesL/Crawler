package com.budu.crawler.entity;

import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.TargetUrl;

import java.util.List;

@TargetUrl("https://tool.lu/article/report/")
public class ZhiYaRepo {

    @ExtractBy(value = "//a[@class='ct-link']/text()")
    private List<String> title;

    @ExtractBy(value = "//a[@class='ct-link']/@href")
    private List<String> url;

    @ExtractBy(value = "//div[@id='article_summary_5DS']/p/text()")
    private List<String> summary;
}
