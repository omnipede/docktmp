package org.exmaple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import static net.logstash.logback.marker.Markers.append;

@RestController
@RequestMapping("/api/v1")
public class SampleController {

    private static Logger logger = LoggerFactory.getLogger(SampleController.class);

    /**
     * 정수를 받아 반환하는 컨트롤러
     * @param value 정수값
     * @return Hello world + value
     */
    @GetMapping("/hello/{value}")
    public String hello(@PathVariable Integer value) {
        logger.debug("Received: " + value);

        if (value > 100)
            throw new RuntimeException("Value is too large");

        String t = "Hello world " + value;
        logger.info("Respond with: " + t);

        // 더 자세한 방법은
        // https://github.com/logstash/logstash-logback-encoder#custom-fields 참조
        logger.info(append("parameterValue", value), "Log parameter value");

        return t;
    }

    @ExceptionHandler(Exception.class)
    public void exceptionHandler(Exception e) {
        logger.error("Exception occurred", e);
    }
}
