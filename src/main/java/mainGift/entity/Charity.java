package mainGift.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mainGift.enums.Category;
import mainGift.enums.SubCategory;

import java.time.LocalDate;

@Entity
@Table(name = "charity")
@Getter
@Setter
@NoArgsConstructor
public class Charity {

    @Id
    @SequenceGenerator(name = "charity_gen", sequenceName = "charity_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "charity_gen", strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Enumerated(EnumType.STRING)
    private SubCategory subCategory;

    @ManyToOne(cascade = CascadeType.ALL)
    private User reservoir;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE})
    private User user;

//    @Enumerated(EnumType.STRING)
//    @Column(name = "charity_status")
//    private Status charityStatus;

    @Column(length = 1000)
    private String description;

    private String condition;

    @Column(length = 1000)
    private String image;

    @Column(name = "created_date")
    private LocalDate createdAt;

    @Column(name = "is_block")
    private Boolean isBlock;

}