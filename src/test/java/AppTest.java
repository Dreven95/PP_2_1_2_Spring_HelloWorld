import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring_hello.Cat;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = spring_hello.AppConfig.class)
public class AppTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void mainTest() {
        spring_hello.HelloWorld tree =
                applicationContext.getBean(spring_hello.HelloWorld.class);
        spring_hello.HelloWorld leaf =
                applicationContext.getBean(spring_hello.HelloWorld.class);

        Cat one = applicationContext.getBean(Cat.class);
        Cat two = applicationContext.getBean(Cat.class);

        Assert.assertSame("Тест провален, не корректная настройка бина spring_hello.HelloWorld", tree, leaf);
        Assert.assertNotSame("Тест провален, не корректная настройка бина Cat", one, two);
    }
}
