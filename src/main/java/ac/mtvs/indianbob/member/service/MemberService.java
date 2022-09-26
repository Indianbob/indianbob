package ac.mtvs.indianbob.member.service;

import ac.mtvs.indianbob.common.exception.member.MemberRegistException;
import ac.mtvs.indianbob.member.dao.MemberMapper;
import ac.mtvs.indianbob.member.dto.MemberDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service

public class MemberService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final PasswordEncoder passwordEncoder;

    private final MemberMapper mapper;

    public MemberService(PasswordEncoder passwordEncoder, MemberMapper mapper) {
        this.passwordEncoder = passwordEncoder;
        this.mapper = mapper;
    }


    @Transactional
    public void registMember(MemberDTO member) throws MemberRegistException {

        log.info("[MemberService] Insert Member : " + member);
        int result = mapper.insertMember(member);

        log.info("[MemberService] Insert result : " + ((result > 0) ? "회원가입 성공" : "회원가입 실패"));

        if(!(result > 0 )){
            throw new MemberRegistException("회원 가입에 실패하였습니다.");
        }
    }

    public void login(MemberDTO memberDTO) {

        log.info("Login Start ===================================");
        log.info("memberDTO", memberDTO);

        MemberDTO member = mapper.findByMemberId(memberDTO.getStaffId());

        if (!passwordEncoder.matches(memberDTO.getStaffPw(), member.getStaffPw())) {
            log.info("Password Match Fail!!!!!!!!!!!!");
        }
    }

    public boolean selectMemberById(String staffId) {

        String result = mapper.selectMemberById(staffId);

        return result != null? true : false;
    }
}
