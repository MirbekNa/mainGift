package mainGift.repository;

import mainGift.entity.Charity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharityRepository extends JpaRepository<Charity, Long> {
}