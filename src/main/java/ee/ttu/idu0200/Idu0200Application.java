package ee.ttu.idu0200;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.lang.System.setProperty;
import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
public class Idu0200Application {

  public static void main(String[] args) {
    setProperty("spring.main.banner_mode", "off");

    setProperty("spring.mvc.view.prefix", "/WEB-INF/jsp/");
    setProperty("spring.mvc.view.suffix", ".jsp");

    run(Idu0200Application.class, args);
  }
}

// TODO: Logs