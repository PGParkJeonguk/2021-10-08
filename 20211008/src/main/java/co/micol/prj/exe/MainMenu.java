package co.micol.prj.exe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.micol.prj.service.MemberService;
import co.micol.prj.service.MemberVO;
import co.micol.prj.serviceImpl.MemberServiceImpl;

public class MainMenu {
	private Scanner sc = new Scanner(System.in);

	private MemberService memberService = new MemberServiceImpl();

	private void menuTitle() {
		System.out.println("===================");
		System.out.println("======멤버관리========");
		System.out.println("====1.전체목록조회=====");
		System.out.println("====2. 회원조회 ======");
		System.out.println("====3. 회원등록 ======");
		System.out.println("====4.회원정보수정=====");
		System.out.println("====5.회원정보삭제=====");
		System.out.println("====6.  종료   =====");
		System.out.println("=== 원하는작업을선택 ===");
	}

	public void run() {
		while (true) {
			menuTitle();
			int key = sc.nextInt();
			sc.nextLine();
			switch (key) {
			case 1:
				selectMemberList();
				break;
			case 2:
				selectMember();
				break;
			case 3:
				insertMember();
				break;
			case 4:
				updateMember();
				break;
			case 5:
				deleteMember();
				break;
			case 6:
				sc.close();
				return;
			}
		}
	}

	private void deleteMember() {
		MemberVO vo = new MemberVO();
		System.out.println("============================");
		System.out.println("삭제할 회원 아이디를 정확히 입력하세요.");
		System.out.println("============================");
		vo.setId(sc.nextLine());
		int n = memberService.deleteMember(vo);
		if (n != 0) {
			System.out.println("==================");
			System.out.println("정상적으로 삭제되었습니다.");
			System.out.println("아무키나 입력하세요.");
			System.out.println("==================");
		} else {
			System.out.println("==================");
			System.out.println("삭제에 실패하였습니다.");
			System.out.println("아무키나 입력하세요.");
			System.out.println("==================");
		}
		sc.nextLine();
	}

	private void updateMember() {
		MemberVO vo = new MemberVO();
		boolean b = false;
		while (!b) {
			System.out.println("============================");
			System.out.println("회원정보를 변경하는 곳입니다.");
			System.out.println("============================");

			System.out.println("변경할 회원의 아이디를 입력하세요.");
			vo.setId(sc.nextLine());
			vo = memberService.selectMember(vo);
			if (vo.getName() != null) {
				b = true;
			} else {
				System.out.println("존재하지 않는 아이디 입니다.");
			}
		}
		System.out.println("이름을 입력하세요.");
		vo.setName(sc.nextLine());
		System.out.println("비밀번호를 입력하세요.");
		vo.setPassword(sc.nextLine());
		System.out.println("전화번호를 입력하세요.");
		vo.setTel(sc.nextLine());
		System.out.println("주소를 입력하세요.");
		vo.setAddresss(sc.nextLine());
		System.out.println("권한을 입력하세요.");
		vo.setAuthor(sc.nextLine());
//		System.out.println("id을 입력하세요.");
//		vo.setId(sc.nextLine());
		int n = memberService.updateMember(vo);
		if (n != 0) {
			System.out.println("정상적으로 변경되었습니다.");
		} else {
			System.out.println("변경에 실패하였습니다.");
		}
		sc.nextLine();

	}

	private void insertMember() {
		MemberVO vo = new MemberVO();
		System.out.println("============================");
		System.out.println("회원정보를 등록하는 곳입니다.");
		System.out.println("============================");
		System.out.println("ID를 입력하세요.");
		vo.setId(sc.nextLine());
		System.out.println("Password를 입력하세요.");
		vo.setPassword(sc.nextLine());
		System.out.println("이름를 입력하세요.");
		vo.setName(sc.nextLine());
		System.out.println("전화번호를를 입력하세요.");
		vo.setTel(sc.nextLine());
		System.out.println("주소를 입력하세요.");
		vo.setAddresss(sc.nextLine());
		System.out.println("권한을 입력하세요(ADMIN or USER).");
		vo.setAuthor(sc.nextLine());
		int n = memberService.insertMember(vo);
		if (n != 0) {
			System.out.println("잘 입력되었습니다.");
		} else {
			System.out.println("입력이 실패했습니다.");
		}
		sc.nextLine();

	}

	private void selectMember() {
		MemberVO vo = new MemberVO();
		System.out.println("============================");
		System.out.println("검색할 회원 아이디를 정확히 입력하세요.");
		System.out.println("============================");
		vo.setId(sc.nextLine());
		vo = memberService.selectMember(vo);
		vo.toString();
		System.out.println("============================");
		System.out.println("엔터키를 입력하세요.");
		sc.nextLine();

	}

	private void selectMemberList() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		list = memberService.selectMemberList();
		System.out.println("============================");
		System.out.println("=========회원목록정보===========");
		for (MemberVO vo : list) {
			vo.toString();
		}
		System.out.println("============================");
		System.out.println("엔터키를 입력하세요.");
		sc.nextLine();
	}
}
