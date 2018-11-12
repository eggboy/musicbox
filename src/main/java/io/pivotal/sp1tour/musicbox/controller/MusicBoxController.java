package io.pivotal.sp1tour.musicbox.controller;

import io.micrometer.core.instrument.MeterRegistry;
import io.pivotal.sp1tour.musicbox.domain.Music;
import io.pivotal.sp1tour.musicbox.repository.MusicRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@Slf4j
public class MusicBoxController {
    @Autowired
    Environment environment;

    @Autowired
    MusicRepository musicRepository;

    @Autowired
    MeterRegistry meterRegistry;

    @Value("${message:LOCAL-}")
    String message;
//
//    MusicBoxController(MusicRepository musicRepository, MeterRegistry meterRegistry) {
//        this.meterRegistry = meterRegistry;
//        this.musicRepository = musicRepository;
//    }

    @GetMapping("/music/{id}")
    public Music getAlbum(@PathVariable Integer id) {
        log.debug("getAlbum is invoked with id :" + id);

        meterRegistry.counter("music.controller.invoke").increment();
        Music music = musicRepository.getOne(id);

        return music.toBuilder().title(message+music.getTitle()).build();
    }

    @GetMapping("/session")
    public String hello(HttpSession session) {
        String sessionId = (String) session.getAttribute("sessionId");

        if (sessionId == null) {
            log.debug("New session is created :" + session.getId());

            sessionId = session.getId();
        }
        session.setAttribute("sessionId", sessionId);

        StringBuilder sb = new StringBuilder(100);
        sb.append("Session Id : ");
        sb.append(sessionId);
        sb.append(" on Instance : ");
        sb.append(environment.getProperty("INSTANCE_INDEX"));
        return sb.toString();
    }
}
