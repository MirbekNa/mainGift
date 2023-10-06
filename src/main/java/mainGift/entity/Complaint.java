package mainGift.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "complaints")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Complaint {

    @Id
    @SequenceGenerator(name = "complaint_gen", sequenceName = "complaint_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "complaint_gen", strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(cascade = {REFRESH, PERSIST, MERGE, DETACH})
    private Wish wish;

    @ManyToOne(cascade = {REFRESH, PERSIST, MERGE, DETACH})
    private Charity charity;

    @ManyToOne(cascade = CascadeType.ALL)
    private User complainer;

    @ManyToOne(cascade = ALL)
    private Notification notification;

    private LocalDate createdAt;

    private Boolean isSeen;

    @Column(length = 1000)
    private String reasonText;

    public Complaint(Long id, Wish wish, User complainer, LocalDate createdAt, Boolean isSeen, String reasonText) {
        this.id = id;
        this.wish = wish;
        this.complainer = complainer;
        this.createdAt = createdAt;
        this.isSeen = isSeen;
        this.reasonText = reasonText;
    }
}