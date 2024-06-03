package umcmission.spring.domain;

import jakarta.persistence.*;
import lombok.*;
import umcmission.spring.domain.common.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Builder
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MyMenu extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int myPoint;

    @Column
    private String infoChange;

    @Column
    private String login;

    @Column
    private String logout;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id") //MyMenu 테이블의 user_id가 외래키다.
    private User user; //기본키를 참조

}