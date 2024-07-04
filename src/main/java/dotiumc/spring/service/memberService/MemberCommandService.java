package dotiumc.spring.service.memberService;

import dotiumc.spring.domain.Member;
import dotiumc.spring.web.dto.MemberRequestDTO;

public interface MemberCommandService {

    Member joinMember(MemberRequestDTO.JoinDto request);
}