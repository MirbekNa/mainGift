package mainGift.entity;

import jakarta.persistence.*;
import lombok.*;
import mainGift.enums.ClothingSize;
import mainGift.enums.Country;
import mainGift.enums.Role;
import mainGift.enums.ShoeSize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;


@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class User implements UserDetails {

    @Id
    @SequenceGenerator(name = "user_gen", sequenceName = "user_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "user_gen", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String password;

    @Column(unique = true)
    private String email;

    @Column(name = "is_block")
    private Boolean isBlock;

    private String image;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(cascade = ALL, mappedBy = "user")
    private List<Wish> wishes;

    public void addWish(Wish wish) {
        wishes.add(wish);
    }

    @OneToMany(cascade = ALL, mappedBy = "user")
    private List<Gift> baskets;

    @OneToMany(cascade = ALL, mappedBy = "user")
    private List<Charity> charities;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<User> friends;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<User> requests;

    @OneToMany(cascade = ALL, mappedBy = "user")
    private List<Holiday> holidays;

    public void addHoliday(Holiday holiday) {
        holidays.add(holiday);
    }

    @Enumerated(EnumType.STRING)
    private Country country;

    private String city;

    private String phoneNumber;


    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    private ShoeSize shoeSize;

    @Enumerated(EnumType.STRING)
    private ClothingSize clothingSize;

    private String hobby;

    private String important;

    private String facebookLink;
    private String instagramLink;
    private String telegramLink;
    private String vkLink;

    public void addFriend(User friend) {
        friends.add(friend);
    }

    public void addRequest(User friend) {
        requests.add(friend);
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}