package dotiumc.spring.converter;

import dotiumc.spring.domain.FoodCategory;
import dotiumc.spring.domain.mapping.MemberPrefer;
import dotiumc.spring.domain.Member;

import java.util.List;
import java.util.stream.Collectors;

public class MemberPreferConverter {

    public static List<MemberPrefer> toMemberPreferList(List<FoodCategory> foodCategoryList){

        return foodCategoryList.stream()
                .map(foodCategory ->
                        MemberPrefer.builder()
                                .foodCategory(foodCategory)
                                .build()
                ).collect(Collectors.toList());
    }
}