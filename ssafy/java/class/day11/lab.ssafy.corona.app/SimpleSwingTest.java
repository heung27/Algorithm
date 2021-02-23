package lab.ssafy.corona.app;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SimpleSwingTest {
	
	public static void main(String[] args) {
		SwingUI ui = new SwingUI();
		ui.setTitle("Simple Swing");
		ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ui.pack();
		ui.setLocationRelativeTo(null);
		ui.setResizable(false);
		ui.setVisible(true);
	}
}

class SwingUI extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private JTextArea textArea;
    private JTextField inputTextField;
    private JButton sendButton;
    
    public SwingUI() {
    	createUI();
    }
    
    private void createUI() {
        textArea = new JTextArea(20, 50);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        add(new JScrollPane(textArea), BorderLayout.CENTER); 

        Box box = Box.createHorizontalBox();
        add(box, BorderLayout.SOUTH);
        inputTextField = new JTextField();
        sendButton = new JButton("Send");
        box.add(inputTextField);
        box.add(sendButton);

		ActionListener sendListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// 사용자 입력 값 
				String str = inputTextField.getText();
				if ( str != null && str.trim().length() > 0 ) {
					textArea.append(str);
			        textArea.append("\n");
				}
				inputTextField.selectAll();
				inputTextField.requestFocus();
				inputTextField.setText("");
			}
		};
        
        inputTextField.addActionListener(sendListener);
        sendButton.addActionListener(sendListener);
    }
}
