package umcmission.spring.domain.mapping;

import umcmission.spring.domain.Food;
import umcmission.spring.domain.User;
import umcmission.spring.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FoodPrefer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "user_id") //FoodPrefer 테이블의 user_id가 외래키다.
    private User user; //기본키참조

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "category_id") //FoodPrefer 테이블의 food_id가 외래키다.
    private Food food;

}
