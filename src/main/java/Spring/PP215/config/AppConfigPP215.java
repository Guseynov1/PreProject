package Spring.PP215.config;

import Spring.PP215.models.Island2;
import Spring.PP215.models.Wood3;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="Spring.PP215")
public class AppConfigPP215 {

    @Bean
    public static Island2 getIsland(Wood3 wood) {
        return new Island2(wood);
    }
}
