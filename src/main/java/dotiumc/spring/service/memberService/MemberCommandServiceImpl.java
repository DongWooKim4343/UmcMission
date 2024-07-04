package dotiumc.spring.service.memberService;

import dotiumc.spring.apiPayload.exception.handler.FoodCategoryHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import dotiumc.spring.apiPayload.code.status.ErrorStatus;
import dotiumc.spring.converter.MemberConverter;
import dotiumc.spring.converter.MemberPreferConverter;
import dotiumc.spring.domain.FoodCategory;
import dotiumc.spring.domain.Member;
import dotiumc.spring.domain.mapping.MemberPrefer;
import dotiumc.spring.repository.FoodCategoryRepository;
import dotiumc.spring.repository.MemberRepository;
import dotiumc.spring.web.dto.MemberRequestDTO;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        Member newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }
}