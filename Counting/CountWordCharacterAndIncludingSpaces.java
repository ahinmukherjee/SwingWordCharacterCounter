import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CountWordCharacterAndIncludingSpaces{
	public static void main(String args[]){
		FrameTest ft= new FrameTest();
		ft.setVisible(true);
		ft.setDefaultCloseOperation(3);   	
	} 
}   
    
class FrameTest extends JFrame{
	public FrameTest(){
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension scrsize = kit.getScreenSize();
		int w = scrsize.width;
		int h = scrsize.height;
		setSize(600,500);
		setLocation(w/5, h/8);
		setTitle("Word counting");
		setResizable(false);
		FramePanels fp = new FramePanels();
		add(fp);
	}
} 
    
class FramePanels extends JPanel implements ActionListener{
	JLabel label1, label2, label3;
	JTextArea area;
	JButton n1, n2, n3, exit, clear;
	JScrollPane scrollpane;
	FramePanels(){
		setLayout(null);
		 setBackground(new Color(20, 25, 45));
		Font resultFont =new Font("Segoe UI", Font.BOLD, 14);

		label1=new JLabel("Word Count");
		label2=new JLabel("Character Count");
		label3=new JLabel("Character With Spaces");

		label1.setFont(resultFont);
		label2.setFont(resultFont);
		label3.setFont(resultFont);

		label1.setForeground(Color.WHITE);
		label2.setForeground(Color.WHITE);
		label3.setForeground(Color.WHITE);

		label1.setBounds(20,10,250,25);
		label2.setBounds(20,30,250,25);
		label3.setBounds(20,50,550,25);

		add(label1);
		add(label2);
		add(label3);

		area= new JTextArea();
		area.setBounds(20,90,550,300);
		area.setFont(new Font("Arial",Font.PLAIN,18));
		area.setLineWrap(true);
		area.setWrapStyleWord(true);
		area.setMargin(new Insets(10,10,10,10));
		//add(area);
		
		scrollpane=new JScrollPane(area);
		scrollpane.setBounds(20,90,550,300);
		add(scrollpane);

		n1= new JButton("Word count");
		n1.setBounds(10,400,100,50);
		add(n1);
		
		n2= new JButton("Character count");
		n2.setBounds(120,400,130,50);
		add(n2);

		n3= new JButton("Count with spaces");
		n3.setBounds(260,400,150,50);
		add(n3);
		
		exit= new JButton("Exit");
		exit.setBounds(420,400,80,50);
		add(exit);

		clear= new JButton("Clear");
		clear.setBounds(510,400,80,50);
		add(clear);

		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent av){
				System.exit(0);
			}
		});
		
		n1.addActionListener(this);
		n2.addActionListener(this);
		n3.addActionListener(this);
		clear.addActionListener(this);
	}

	public void actionPerformed(ActionEvent av){
		String s=area.getText();
		String words[]=s.split("\\s");

		int letters=s.replace(" ","").length();
		int spaces=s.length()-letters;

		if (s.isEmpty()) {
			label1.setText("Please Enter Text");
			label2.setText("Please Enter Text");
			label3.setText("Please Enter Text");
			return;
			}

		if(av.getSource()==n1){
			label1.setText("The number of words is: "+words.length);
			}
		if(av.getSource()==n2){
			label2.setText("The number of characters is: "+s.length());
			}
		if(av.getSource()==n3){
			label3.setText("The number of characters with spaces is: "+letters+" (letters) + "+spaces+" (spaces) = " +s.length());
			}
		if(av.getSource()==clear){
			area.setText("");
			label1.setText("Word Count");
			label2.setText("Character Count");
			label3.setText("Character With Spaces");
			}
	}
}
