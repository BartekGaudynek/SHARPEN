package sharpenApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "sharpenControllers")
public class SharpenApplication {

	public static void main(String[] args) {
		SpringApplication.run(SharpenApplication.class, args);
	}

}
