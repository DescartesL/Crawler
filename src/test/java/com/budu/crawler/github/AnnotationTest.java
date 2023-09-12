package com.budu.crawler.github;

import com.budu.crawler.entity.GithubRepo;
import org.junit.jupiter.api.Test;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.ConsolePageModelPipeline;
import us.codecraft.webmagic.model.OOSpider;

public class AnnotationTest {

    @Test
    public void test() {
        OOSpider.create(
                Site.me()
                .setSleepTime(1000), new ConsolePageModelPipeline(), GithubRepo.class)
                .addUrl("https://github.com/code4craft")
                .thread(5)
                .run();
    }
}
