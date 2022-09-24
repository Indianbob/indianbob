package ac.mtvs.indianbob.member.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class MemberDTO implements UserDetails {
    private int staffCode;
    private String staffId;
    private String staffPw;
    private String staffName;
    private String staffPhone;
    private String staffRank;


    public MemberDTO() {
    }

    public MemberDTO(int staffCode, String staffId, String staffPw, String staffName, String staffPhone, String staffRank) {
        this.staffCode = staffCode;
        this.staffId = staffId;
        this.staffPw = staffPw;
        this.staffName = staffName;
        this.staffPhone = staffPhone;
        this.staffRank = staffRank;
    }

    public int getStaffCode() {
        return staffCode;
    }

    public void setStaffCode(int staffCode) {
        this.staffCode = staffCode;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffPw() {
        return staffPw;
    }

    public void setStaffPw(String staffPw) {
        this.staffPw = staffPw;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffPhone() {
        return staffPhone;
    }

    public void setStaffPhone(String staffPhone) {
        this.staffPhone = staffPhone;
    }

    public String getStaffRank() {
        return staffRank;
    }

    public void setStaffRank(String staffRank) {
        this.staffRank = staffRank;
    }

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> roles = new HashSet<>();
//        for(String role : memberRole.split(",")) {
//            roles.add(new SimpleGrantedAuthority(role));
//        }

        return roles;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "staffCode=" + staffCode +
                ", staffId='" + staffId + '\'' +
                ", staffPw='" + staffPw + '\'' +
                ", staffName='" + staffName + '\'' +
                ", staffPhone=" + staffPhone +
                ", staffRank='" + staffRank + '\'' +
                '}';
    }

    @Override
    public String getPassword() {
        return staffPw;
    }

    @Override
    public String getUsername() {
        return staffId;
    }

    // 계정 만료 여부
    @Override
    public boolean isAccountNonExpired() {
        return true; // 만료되지 않음
    }

    // 계정 잠김 여부
    @Override
    public boolean isAccountNonLocked() {
        return true; // 잠기지 않음
    }

    // 비밀번호 만료 여부
    @Override
    public boolean isCredentialsNonExpired() {
        return true; // 만료되지 않음
    }

    // 계정 활성화 여부
    @Override
    public boolean isEnabled() {
        return true; // 활성화
    }
}
