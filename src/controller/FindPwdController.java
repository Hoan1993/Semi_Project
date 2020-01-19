package controller;

import javax.swing.JOptionPane;

import model.MemberDAO;
import util.SendEmail;
import view.FindPwdView;
import view.LoginView;

public class FindPwdController {
	
	private FindPwdView view;
    private MemberDAO model;

    public FindPwdController(FindPwdView findPwdView){
        this.view = findPwdView;
        model = MemberDAO.getInstance();
        
    }
    // 패스워드
	public void findPwd(String userid, int pwdq, String pwda) {
		String result = model.findUserpwd(userid, pwdq, pwda);
		String email = model.toSendEmail(userid);
		String name = model.findName(userid);
		// 이메일이 있는 것. 따라서 이 이메일로 id를 보내야 한다. result에 아이디가 들어있다. 
		if(result != null) { 
			//JOptionPane.showMessageDialog(null, "등록하신 메일로 아이디를 보내 드렸습니다.");
			JOptionPane.showMessageDialog(null, "등록하신 메일로 비밀번호를 보내드렸습니다.");
			// 이메일로 보내기
			SendEmail send = new SendEmail();
			send.sendEmail(name, email, result);
			
			// 여기서는 로그인 창으로 이동해야 한다.
			view.dispose();
			LoginView lgview = new LoginView();
			lgview.setVisible(true);
		} else {
			// 굳이 회원가입 창으로 자동 이동하게 할 필요는 없음.
			// 그냥 계속 시도하게 함.
			JOptionPane.showMessageDialog(null, "비밀번호를 찾는데 성공하지 못 했습니다.");
			
		}
		
	}
    
    
}
