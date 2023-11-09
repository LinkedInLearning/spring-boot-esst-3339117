package linkedin.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
public class LoggingController {

  private Logger log = LoggerFactory.getLogger(LoggingController.class);

  @GetMapping
  public String log() {
    log.trace("This is a TRACE level message");
    log.debug("This is a DEBUG level message");
    log.info("This is an INFO level message");
    log.warn("This is a WARN level message");
    log.error("This is an ERROR level message");
    return "See the log for details";
  }
}
