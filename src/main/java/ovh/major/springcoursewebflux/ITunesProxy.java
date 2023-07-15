package ovh.major.springcoursewebflux;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class ITunesProxy {

    @Autowired
    WebClient webClient;

    public String search(String term, int limit){
        return webClient.get()
                .uri( uriBuilder -> uriBuilder
                        .scheme("https")
                        .host("itunes.apple.com")
                        .path("/search")
                        .queryParam("term", term)
                        .queryParam("limit", limit)
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .block();

    }
}
