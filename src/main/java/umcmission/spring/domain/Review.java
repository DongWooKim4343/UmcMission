package umcmission.spring.domain;

import umcmission.spring.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Builder
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int starScore;

    @Lob
    private byte photoReview;

    @Column(length = 200)
    private String commentReview;

    @Column(length = 50)
    private String nickName;

    @Column
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}