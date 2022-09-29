package ac.mtvs.indianbob.member.controller;

import ac.mtvs.indianbob.common.exception.member.MemberRegistException;
import ac.mtvs.indianbob.member.dto.MemberDTO;
import ac.mtvs.indianbob.member.service.MemberService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/member")
public class MemberController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final PasswordEncoder passwordEncoder;
    private final MemberService memberService;

    public MemberController(PasswordEncoder passwordEncoder, MemberService memberService) {
        this.passwordEncoder = passwordEncoder;
        this.memberService = memberService;
    }

    @GetMapping("/register")
    public String goRegister() {
        return "pages/member/register";
    }

    @PostMapping("/register")
    public String registMember(@ModelAttribute MemberDTO member,
                               RedirectAttributes rttr) throws MemberRegistException {

        log.info("");
        log.info("");
        log.info("[MemberController] registMember ==========================================================");

        member.setStaffPw(passwordEncoder.encode(member.getStaffPw()));

        log.info("[MemberController] registMember request Member : " + member);

        memberService.registMember(member);

        rttr.addFlashAttribute("message", "회원 가입에 성공하였습니다.");

        log.info("[MemberController] registMember ==========================================================");

        return "redirect:/";
    }

    @PostMapping("/idDupCheck")
    public ResponseEntity<String> checkDuplication(@RequestBody MemberDTO memberDto) throws JsonProcessingException {

        log.info("");
        log.info("");
        log.info("[MemberController] checkDuplication ==========================================================");

        String result = "사용 가능한 아이디 입니다.";
        log.info("[MemberController] Request Check ID : " + memberDto.getStaffId());

        if("".equals(memberDto.getStaffId())) {
            log.info("[MemberController] No Input Member ID");
            result = "아이디를 입력해 주세요";
        } else if(memberService.selectMemberById(memberDto.getStaffId())) {
            log.info("[MemberController] Already Exist");
            result = "중복된 아이디가 존재합니다.";
        }

        log.info("[MemberController] checkDuplication ==========================================================");

        return ResponseEntity.ok(result);
    }

    @GetMapping("/login")
    public String goLogin() {

        return "pages/member/login";
    }

    @GetMapping("/loginfail")
    public String goLoginFail() {

        return "pages/errors/login";
    }

    @GetMapping("")
    public ModelAndView memberList(ModelAndView mv){

        List<MemberDTO> memberList = memberService.selectAllMember();

        mv.addObject("memberList", memberList);

        mv.setViewName("/pages/member/staffList");

        return mv;
    }

}
