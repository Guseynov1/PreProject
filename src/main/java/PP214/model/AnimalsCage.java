package PP214.model;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Getter
@Component
public class AnimalsCage {

    @Qualifier("cat")
    @Autowired
    private Animal cat;

    @Qualifier("dog")
    @Autowired
    private Animal dog;

    @Autowired
    private Timer timer;

    public void whatAnimalSay() {
        System.out.println("First say:");
        System.out.println(cat.toString());
        System.out.println("Second say:");
        System.out.println(dog.toString());
        System.out.println("At:");
        System.out.println(timer.getNanoTime());
        System.out.println("________________________");
    }
}