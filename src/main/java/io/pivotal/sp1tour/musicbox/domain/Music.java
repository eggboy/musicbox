package io.pivotal.sp1tour.musicbox.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Builder(toBuilder = true)
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Music {
    @Id
    private Integer id;
    private String album;
    private String title;
    private String artist;
}
