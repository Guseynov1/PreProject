package Spring.PP214;

import Spring.PP214.config.AppConfigPP214;
import Spring.PP214.model.AnimalsCage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfigPP214.class)
public class MainTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void mainTest() {
        long time = 0;
        for (int i = 0; i < 5; i++) {
            AnimalsCage bean = applicationContext.getBean(AnimalsCage.class);
            if (i == 0) {
                time = bean.getTimer().getNanoTime();
                continue;
            }
            Assert.assertEquals("Тест провален, не корректная реализация бинов.", time, bean.getTimer().getNanoTime().longValue());
            System.out.println(time);
        }
    }
}