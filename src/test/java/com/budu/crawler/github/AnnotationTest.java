package com.budu.crawler.github;

import com.budu.crawler.entity.GithubRepo;
import com.budu.crawler.entity.ZhiyaRepo;
import org.junit.jupiter.api.Test;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.ConsolePageModelPipeline;
import us.codecraft.webmagic.model.OOSpider;

public class AnnotationTest {

    @Test
    public void test() {
        OOSpider.create(
                Site.me()
                .setSleepTime(1000).addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36"), new ConsolePageModelPipeline(), ZhiyaRepo.class)
                .addUrl("https://tool.lu/article/report/")
                .thread(5)
                .run();
    }
}
