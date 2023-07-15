package ovh.major.springcoursewebflux;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@Log4j2
public class SpringcoursewebfluxApplication {

    @Autowired
    ITunesProxy iTunesProxy;

    public static void main(String[] args) {
        SpringApplication.run(SpringcoursewebfluxApplication.class, args);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void makeRequest(){
        String response = iTunesProxy.search("shawnmendes",3);
        log.info(response);
    }

}
