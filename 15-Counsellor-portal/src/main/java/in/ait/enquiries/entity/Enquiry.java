package in.ait.enquiries.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import in.ait.counsellor.entity.Counsellor;
import in.ait.course.entity.Course;

@Entity
@Table(name = "enquiries_tbl")
public class Enquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enq_id")
    private Long enqId;

    @Column(name = "stu_name", nullable = false)
    private String stuName;

    @Column(name = "stu_phno", nullable = false)
    private String stuPhno;

    @Column(name = "class_mode")
    private String classMode;

    @Column(name = "enq_status")
    private String enqStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;  // FK reference to courses_offering

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "counsellor_id", nullable = false)
    private Counsellor counsellor;  // FK reference to counsellors_tbl

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
