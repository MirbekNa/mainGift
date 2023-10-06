package mainGift.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="baskets")
@Getter
@Setter
@NoArgsConstructor
public class Gift {

    @Id
    @SequenceGenerator(name = "gift_gen", sequenceName = "gift_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "gift_gen", strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    private User user;

    @OneToOne(cascade = {CascadeType.REFRESH,CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    private Wish wish;
}