package umcmission.spring.domain;

import jakarta.persistence.*;
import lombok.*;
import umcmission.spring.domain.common.BaseEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Builder
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ChallengeMission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDate challengeDate;

    @Column(length = 100)
    private String missionName;

    @Column
    private Integer challengeMissionCount;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id") //ChallengeMission 테이블의 user_id가 외래키다.
    private User user; //기본키를 참조

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "myMission_id", referencedColumnName = "id", nullable = false) //@JoinColumn의 name 속성을 my_mission_id로 설정하고, referencedColumnName 속성을 id로 설정하여 MyMission의 기본 키를 참조합니다.
    private MyMission myMission; //기본키를 참조

}