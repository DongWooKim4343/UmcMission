package umcmission.spring.domain;

import jakarta.persistence.*;
import umcmission.spring.domain.common.BaseEntity;
import lombok.*;

@Builder
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Alarm extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String alarmContents;

    @Column(length = 100)
    private String alarmList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id") //Alarm 테이블의 user_id가 외래키다.
    private User user; //기본키를 참조
}