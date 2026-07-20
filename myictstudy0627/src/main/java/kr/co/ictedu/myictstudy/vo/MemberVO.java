package kr.co.ictedu.myictstudy.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {
	private Long memberId;
	private String username;
	private String password;
	private String name;
	private String email;
	private String phone;
	private String address;
	private String role; // 권한 (USER, ADMIN 등)
	private String regDate;
}
