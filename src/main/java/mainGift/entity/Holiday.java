package mainGift.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "holidays")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Holiday {

    @Id
    @SequenceGenerator(name = "holiday_gen", sequenceName = "holiday_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "holiday_gen", strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    @Column(name = "date_of_holiday")
    private LocalDate dateOfHoliday;

    @Column(length = 1000)
    private String image;

    @Column(name = "is_block")
    private Boolean isBlock;

    @ManyToOne
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "holiday")

    private List<Wish> wishes;

    public void addWish(Wish wish) {
        this.wishes.add(wish);
    }
}