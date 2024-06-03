package umcmission.spring.domain;

import umcmission.spring.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MyMission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String missionNameList;

    @Column
    private Integer completeMissionCount;

    @Column
    private Integer challengeMissionCount;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id") //MYMission 테이블의 user_id가 외래키다.
    private User user; //기본키를 참조

    @OneToMany(mappedBy = "myMission", cascade = CascadeType.ALL)
    private List<ChallengeMission> challengeMissionList = new ArrayList<>();

    @OneToMany(mappedBy = "myMission", cascade = CascadeType.ALL)
    private List<CompleteMission> completeMissionList = new ArrayList<>();
}