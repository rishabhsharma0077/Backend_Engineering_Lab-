package in.ait.counsellor.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CounsellorRepo extends JpaRepository<Counsellor, Long> {

}
