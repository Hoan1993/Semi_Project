package view;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
//import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.JoinController;
import model.MemberVO;


public class JoinView extends JFrame{
	
	   private static final long serialVersionUID = 3566038652320101414L;
	    private JTextField txtUsername;
	    private JTextField txtUserid;
	    private JTextField txtPassword1;
	    private JTextField txtPassword2;
	    private JTextField txtUserAddress;
	    private JTextField txtUserEmail;
	    private JTextField txtPwdAnswer;
	    
	    private JButton btnJoin;
	    private JButton cancel;
	    
	    private String text = "로그인 화면으로 이동";
	    private JLabel hyperlink = new JLabel(text);
	    
	    public JoinView() {
	        setTitle("회원가입 페이지");
	        setResizable(true);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	        setExtendedState(JFrame.MAXIMIZED_BOTH); 
	        setUndecorated(false);
	        
	        Container contentPane = this.getContentPane();
	        contentPane.setLayout(null);
	        	     
	        JLabel lblUsername = new JLabel("Username:");
	        lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
	        lblUsername.setBounds(10, 11, 120, 25);
	        contentPane.add(lblUsername);

	        txtUsername = new JTextField();
	        txtUsername.setBounds(140, 11, 200, 25);
	        contentPane.add(txtUsername);

	        JLabel lblUserid = new JLabel("Userid :");
	        lblUserid.setHorizontalAlignment(SwingConstants.RIGHT);
	        lblUserid.setBounds(10, 52, 120, 25);
	        contentPane.add(lblUserid);
	        
	   
	        txtUserid = new JTextField();
	        txtUserid.setBounds(140, 52, 200, 25);
	        contentPane.add(txtUserid);
	        
	        JButton btnIdCheck = new JButton("중복체크");
	        btnIdCheck.setHorizontalAlignment(SwingConstants.RIGHT);
	        btnIdCheck.setBounds(350, 52, 89, 25);
	        contentPane.add(btnIdCheck);
	        
	        JoinController controller = new JoinController(this);
	        btnIdCheck.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					controller.useridCheck(txtUserid.getText(), txtUserid);
					
				}
			});
	        
	        JLabel lblPassword = new JLabel("Password:");
	        lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
	        lblPassword.setBounds(10, 93, 120, 25);
	        contentPane.add(lblPassword);
	        
	        txtPassword1 = new JPasswordField();
	        txtPassword1.setBounds(140, 93, 200, 25);
	        contentPane.add(txtPassword1);
	        
	        JLabel lblPassword2 = new JLabel("PWDCheck:");
	        lblPassword2.setHorizontalAlignment(SwingConstants.RIGHT);
	        lblPassword2.setBounds(10, 134, 120, 25);
	        contentPane.add(lblPassword2);
	        
	        txtPassword2 = new JPasswordField();
	        txtPassword2.setBounds(140, 134, 200, 25);
	        contentPane.add(txtPassword2);
	        
	        JLabel lblAddress = new JLabel("Address :");
	        lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
	        lblAddress.setBounds(10, 175, 120, 25);
	        contentPane.add(lblAddress);
	        txtUserAddress = new JTextField();
	        txtUserAddress.setBounds(140, 175, 200, 25);
	        contentPane.add(txtUserAddress);
	        	        
	        JLabel lblUserEmail = new JLabel("Email :");
	        lblUserEmail.setHorizontalAlignment(SwingConstants.RIGHT);
	        lblUserEmail.setBounds(10, 216, 120, 25);
	        contentPane.add(lblUserEmail);
	        txtUserEmail = new JTextField();
	        txtUserEmail.setBounds(140, 216, 200, 25);
	        contentPane.add(txtUserEmail);
	        
	        // 비밀번호 확인 질문.
	        JLabel lblPwdQ = new JLabel("비밀번호 확인 질문 :");
	        lblPwdQ.setHorizontalAlignment(SwingConstants.RIGHT);
	        lblPwdQ.setBounds(10, 257, 120, 25);
	        contentPane.add(lblPwdQ);
	        
	        // 콤보 박스
	        String [] job = {"기억에 남는 추억의 장소는?", 
	        		"자신의 인생 좌우명은?", "자신의 보물 제1호는?", 
	        		"가장 기억에 남는 선생님 성함은?", "타인이 모르는 자신만의 신체비밀이 있다면?",
	        		"추억하고 싶은 날짜가 있다면?", "받았던 선물 중 기억에 남는 독특한 선물은?",
	        		"유년시설 가장 생각나는 친구 이름은?", "인상 깊게 읽은 책 이름은?"};
	        
			JComboBox<String> jcb = new JComboBox<>(job);
	        //pwdCombo = new JComboBox();
			jcb.setBounds(140, 257, 200, 25);
			contentPane.add(jcb);

			jcb.setSelectedIndex(1);

			JLabel lblPwdAnswer = new JLabel("비밀번호 확인 답변 :");
			lblPwdAnswer.setHorizontalAlignment(SwingConstants.RIGHT);
			lblPwdAnswer.setBounds(10, 298, 120, 25);
	        contentPane.add(lblPwdAnswer);
	        txtPwdAnswer = new JTextField();
	        txtPwdAnswer.setBounds(140, 298, 200, 25);
	        contentPane.add(txtPwdAnswer);
			
		
		btnJoin = new JButton("회원가입");
		btnJoin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					// null 값이나 공백이 들어갔는지 확인.
					// 여기서 su1.requestFocus(); 이걸 써서 입력하지 않은걸 입력받을 것임.
					if (txtUsername.getText() == null || txtUsername.getText().trim().isEmpty()) {
						JOptionPane.showMessageDialog(null, "이름은 필수 입력 사항입니다.");
						txtUsername.requestFocus();
					} else if(txtUserid.getText() == null || txtUserid.getText().trim().isEmpty()) {
						JOptionPane.showMessageDialog(null, "아이디는 필수 입력 사항입니다.");
						txtUserid.requestFocus();
					} 
					else if(txtPassword1.getText() == null || txtPassword1.getText().trim().isEmpty()) {
						JOptionPane.showMessageDialog(null, "비밀번호는 필수 입력 사항입니다.");	
						txtPassword1.requestFocus();
					} else if(txtUserEmail.getText() == null || txtUserEmail.getText().trim().isEmpty()) {
						JOptionPane.showMessageDialog(null, "이메일은 필수 입력 사항입니다.");	
						txtUserEmail.requestFocus();
					} else if(txtPwdAnswer.getText() == null || txtPwdAnswer.getText().trim().isEmpty()) {
						JOptionPane.showMessageDialog(null, "비밀번호 확인 답변은 필수 입력 사항입니다.");	
						txtPwdAnswer.requestFocus();
					} else if(!txtPassword1.equals(txtPassword2)) {
						JOptionPane.showMessageDialog(null, "비밀번호를 정확히 다시 써 주세요.");
						txtPassword1.setText("");
						txtPassword2.setText("");
						txtPassword1.requestFocus();
					}
					
					if(txtUsername.getText() != null && !txtUsername.getText().trim().isEmpty() &&
							txtUserid.getText() != null && !txtUserid.getText().trim().isEmpty() &&
							txtPassword1.getText() != null && !txtPassword1.getText().trim().isEmpty() &&
							txtUserEmail.getText() != null && !txtUserEmail.getText().trim().isEmpty() &&
							txtPwdAnswer.getText() != null && !txtPwdAnswer.getText().trim().isEmpty()) {
								
						// 필수입력 사항이 정상적으로 입력되었을 때만, 아래 코드를 실행.
						MemberVO mVo = new MemberVO();
						mVo.setName(txtUsername.getText());
						mVo.setUserid(txtUserid.getText());
						mVo.setUserpwd(txtPassword1.getText());
						mVo.setAddress(txtUserAddress.getText());
						mVo.setEmail(txtUserEmail.getText());
						mVo.setPwdq(jcb.getSelectedIndex());
						mVo.setPwda(txtPwdAnswer.getText());
						
						controller.join(mVo, txtUserid, txtUserEmail);					
					} 
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "회원가입에 실패하였습니다.");
				}
			}
		});
		btnJoin.setBounds(152, 339, 89, 25);
		contentPane.add(btnJoin);
		
		
		cancel = new JButton("취소");
		cancel.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
					// 화면에 입력된 내용을 모두 초기화 시키는 버튼
				txtUsername.setText("");
				txtUserid.setText("");
				txtPassword1.setText("");
				txtPassword2.setText("");
				txtUserAddress.setText("");
				txtUserEmail.setText("");
				txtUsername.requestFocus();
					
			}
		});
		
		cancel.setBounds(251, 339, 89, 25);
		contentPane.add(cancel);
		
		
		Font f1 = new Font("바탕", Font.ITALIC, 12);
		hyperlink.setForeground(Color.BLUE.darker());
		hyperlink.setFont(f1);
        hyperlink.setCursor(new Cursor(Cursor.HAND_CURSOR));
 
        hyperlink.addMouseListener(new MouseAdapter() {
 
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                	
                   /* Desktop.getDesktop().browse(new URI("http://www.codejava.net"));*/
                	hyperlink.setText(text);
                	LoginView lgview = new LoginView();
                    lgview.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    lgview.setUndecorated(false);
                    dispose();
                    //view.setVisible(false);            
                    lgview.setVisible(true);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
 
            @Override
            public void mouseExited(MouseEvent e) {
                hyperlink.setText(text);
            }
 
            @Override
            public void mouseEntered(MouseEvent e) {
                hyperlink.setText("<html><a href=''>" + text + "</a></html>");
            }
 
        });
        
        hyperlink.setBounds(220, 353, 150, 50);
        //setLayout(new FlowLayout());
        contentPane.add(hyperlink);
		
		
		
	}
}
