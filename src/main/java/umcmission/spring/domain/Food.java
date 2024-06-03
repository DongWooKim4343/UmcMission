package umcmission.spring.domain;

import jakarta.persistence.*;
import umcmission.spring.domain.common.BaseEntity;
import lombok.*;
import umcmission.spring.domain.mapping.FoodPrefer;

import java.util.ArrayList;
import java.util.List;

@Builder
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Food extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "food", cascade = CascadeType.ALL)
    private List<FoodPrefer> foodPreferList = new ArrayList<>();
}
