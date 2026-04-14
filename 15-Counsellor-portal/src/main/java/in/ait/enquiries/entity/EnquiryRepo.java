package in.ait.enquiries.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EnquiryRepo extends JpaRepository<Enquiry, Long> {

}
