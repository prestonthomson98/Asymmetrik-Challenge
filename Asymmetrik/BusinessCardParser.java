package Asymmetrik;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class BusinessCardParser {
	
	public static void main(String[] args) {
		JFrame f=new JFrame("Business Card Parser"); //creates GUI
		//submit button
			f.setSize(600,1000);  //sets the GUI size
			JTextArea textfield= new JTextArea();
			textfield.setBounds(100, 200, 400, 200);
			//creates text area for the business card
			JLabel label = new JLabel();		
			label.setText("Enter Business \nCard Text:");
			label.setBounds(225, 100, 200, 100);
			//label that goes with the text area
			JButton b=new JButton("Parse"); 
			b.setBounds(200,500,200,100); 
			//Parse button
			JLabel resultLabel = new JLabel();		
			resultLabel.setText("Contact Info:");
			resultLabel.setBounds(265, 650, 100, 100);
			//label for result
			JLabel result = new JLabel();
			result.setBounds(200, 650, 300, 300);
			//result only exists if Parse button is pressed
			f.add(textfield);
			f.add(label);
			f.add(b); 
			f.add(resultLabel);
			f.add(result);
			f.setSize(300,300); 
			//adds all components to the frame
			f.setLayout(null); 
			b.addActionListener(new ActionListener() {  //adding action listener triggers an action if the button is pressed 
				public void actionPerformed(ActionEvent e) {
					getContactInfo(textfield.getText());
				}
				
				private void getContactInfo(String document) {
					ContactInfo contact = new ContactInfo(document); //Creates a set of contact information
					result.setText("<html>Name: " + contact.getName() + "<br>Phone: " + contact.getPhone() + "<br>Email: " + contact.getEmail() + "<html>");//format for the result					
				}
			});
			f.setVisible(true);   
			
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
			
	}
	
	
}