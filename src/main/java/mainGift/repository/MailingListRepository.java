package mainGift.repository;

import mainGift.entity.MailingList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MailingListRepository extends JpaRepository<MailingList, Long> {
}