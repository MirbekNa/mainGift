package mainGift.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "messages")
@Getter
@Setter
@NoArgsConstructor
public class Comment {

    @Id
    @SequenceGenerator(name = "comm_gen", sequenceName = "comm_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "comm_gen", strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne(cascade = {REFRESH, DETACH, MERGE, PERSIST})
    private User user;
    private String text;
    private LocalDateTime createdAt;
}
