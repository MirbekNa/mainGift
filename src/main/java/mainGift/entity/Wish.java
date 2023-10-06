package mainGift.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "wishes")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Wish {

    @Id
    @SequenceGenerator(name = "wish_gen", sequenceName = "wish_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "wish_gen", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "wish_name")
    private String wishName;

    @Column(name = "link_to_gift")
    private String linkToGift;

    @Column(name = "date_of_holiday")
    private LocalDate dateOfHoliday;

    @Column(length = 10000)
    private String description;

    @Column(length = 10000)
    private String image;

//    @Column(name = "wish_status")
//    @Enumerated(EnumType.STRING)
//    private Status wishStatus;

    @Column(name = "is_block")
    private Boolean isBlock;

    @OneToOne
    private User reservoir;
    @ManyToOne(cascade = {REFRESH, DETACH, MERGE, PERSIST})
    private User user;

    @OneToMany(cascade = ALL, mappedBy = "wish")
    private List<Complaint> complaints;



    @ManyToOne( cascade = {DETACH, MERGE, PERSIST}, fetch = FetchType.EAGER)
    private Holiday holiday;
}