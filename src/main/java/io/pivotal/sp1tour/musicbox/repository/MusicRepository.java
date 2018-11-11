package io.pivotal.sp1tour.musicbox.repository;

import io.pivotal.sp1tour.musicbox.domain.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface MusicRepository extends JpaRepository<Music, Integer> {
}
