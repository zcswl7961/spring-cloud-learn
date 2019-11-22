import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhoucg
 * @date 2019-11-22 17:31
 */
@SpringBootApplication
@RestController
public class GatewayRatelimiterApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayRatelimiterApplication.class,args);
    }
}
