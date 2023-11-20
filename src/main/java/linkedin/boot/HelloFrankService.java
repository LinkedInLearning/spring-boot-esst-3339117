package linkedin.boot;

import org.springframework.stereotype.Service;

@Service
public class HelloFrankService implements GreetingService {

  public String hello() {
    return "America, I'm only getting started.";
  }

}
