package co.micol.prj;

import co.micol.prj.exe.MainMenu;

//import java.util.ArrayList;
//import java.util.List;
//
//import co.micol.prj.service.MemberService;
//import co.micol.prj.service.MemberVO;
//import co.micol.prj.serviceImpl.MemberServiceImpl;

//import co.micol.prj.dao.DatasSource;


public class MainApp {
	
	public static void main(String[] args) {
//		DatasSource dao = DatasSource.getInstance();		//싱글톤 dao를 부를때 이렇게 쓴다.
//		dao.getConnection();	
//		
//		System.out.println("Hello World");
//		MemberService memberService = new MemberServiceImpl();
//		List<MemberVO> members = new ArrayList<MemberVO>();
//		members = memberService.selectMemberList();
		
//		MemberVO vo = new MemberVO();
//		vo.setId("kim");
//		vo.setPassword("4567");
//		vo.setName("김치국");
//		vo.setTel(null);
//		vo.setAddresss(null);
//		vo.setAuthor("USER");
//		int n = memberService.insertMember(vo);
//		if(n != 0) {
//			System.out.println("잘 입력되었습니다.");
//		}else {
//			System.out.println("입력이 실패했습니다.");
//		}
//		
//		System.out.println("=======================");
//		members = memberService.selectMemberList();
//		for(MemberVO member : members) {
//			member.toString();
//		}
//		System.out.println("=======================");
//		System.out.println("한명분의 아이디를 조회");
//		MemberVO vo = new MemberVO();
//		vo.setId("jeonguk");
//		vo = memberService.selectMember(vo);
//		vo.toString();
//		
//		System.out.println("=======================");
		
		MainMenu mainMenu = new MainMenu();
		mainMenu.run();
	}
}
