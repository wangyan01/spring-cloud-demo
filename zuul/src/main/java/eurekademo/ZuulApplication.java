package eurekademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 *
 * @author Gunnar Hillert
 *
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ZuulApplication.class, args);
	}

}
