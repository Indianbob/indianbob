package ac.mtvs.indianbob.member.dao;

import ac.mtvs.indianbob.member.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    MemberDTO findByMemberId(String staffId);

    String selectMemberById(String staffId);

    int insertMember(MemberDTO member);

    List<MemberDTO> findMemberAll();
}
