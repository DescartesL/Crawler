package com.budu.crawler.processor;

import com.budu.crawler.entity.ZhiYa;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.ArrayList;
import java.util.List;

public class ZhiYaPageProcessor implements PageProcessor {

    private Site site = Site.me()
            .setSleepTime(1000)
            .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36");

    public void setSite(Site site){
        this.site = site;
    }

    public Site getSite(){
        return this.site;
    }

    @Override
    // 定制爬虫逻辑的核心接口，编写爬虫抽取逻辑
    public void process(Page page) {
          List<Selectable> nodes =  page.getHtml().xpath("//div[@class='page-inner']/div").nodes();
          List<ZhiYa> zhiYas = new ArrayList<>();
          for(Selectable node : nodes){
              String title = node.xpath("//a[@class='ct-link']/text()").toString();
              String url = node.xpath("//a[@class='ct-link']/@href").toString();
              String summary = node.xpath("//div[@class='ct-note-content']/p/text()").toString();
              zhiYas.add(ZhiYa.builder().title(title).url(url).summary(summary).build());
          }
        page.putField("zhiYas", zhiYas);

        page.addTargetRequest(page.getHtml().xpath("//a[@class='ct-link report-prev']/@href").toString());
    }
}
