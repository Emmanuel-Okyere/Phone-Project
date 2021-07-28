package simulator.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sms extends JPanel {
    static Image Wifi=new ImageIcon("src//Wifi.png").getImage();
    static Image batteryIcon=new ImageIcon("src//Battery.png").getImage();
    static Image Signal=new ImageIcon("src//Signal.png").getImage();
    static Image Speaker=new ImageIcon("src//Speaker.png").getImage();
    static Image send = new ImageIcon("src//simulator//view//send.jpg").getImage();
    static JFrame Phone;
    static JPanel smsPage;
    static JTextField smsTextBox;
    static JLabel s1, s2,s3,s4,s5,s6;
    static JButton backButton,homeButton,sendButton;
    public static void main(String[] args){
        //HomeScreen.main(null);
        Phone =new JFrame("SMS");
        Phone.setVisible(true);
        Phone.setSize(350,600);
        Phone.setResizable(false);
        Phone.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //Setting the JPanel for SMS
        smsPage = new JPanel(null);
        smsPage.setBorder(BorderFactory.createTitledBorder("Sms"));
        smsPage.setBounds(11,80,315,415);
        smsPage.setBackground(new Color(254, 196, 113));
        //Drawing back Button
        backButton=new JButton();
        backButton.setEnabled(true);
        backButton.setBackground(Color.black);
        backButton.setBounds(260, 510, 20, 20);
        //Drawing home Button
        homeButton = new JButton();
        homeButton.setEnabled(true);
        homeButton.setBackground(Color.black);
        homeButton.setBounds(155, 510, 20, 20);
        //Drawing the Text box
        smsTextBox = new JTextField();
        smsTextBox.setBounds(13,460,270,35);
        smsTextBox.setBackground(new Color(45, 52, 95));
        smsTextBox.setSelectedTextColor(Color.red);
        smsTextBox.setForeground(Color.white);
        smsTextBox.setFont(new Font("Algeria",Font.BOLD,14));
        //Drawing the Send Button
        sendButton = new JButton(new ImageIcon("src//simulator//view//send.jpg"));
        sendButton.setBounds(285,460,40,34);
        sendButton.setBackground(new Color(31, 123, 23));
        //Sent Text
        s1 = new JLabel();
        s1.setBounds(20,350,275,50);
        s1.setForeground(Color.BLUE);
        s2 = new JLabel();
        s2.setBounds(20,300,275,50);
        s2.setForeground(Color.blue);
        s3 =new JLabel();
        s3.setBounds(20,250,275,50);
        s3.setBackground(Color.pink);
        s4 =new JLabel();
        s4.setBounds(20,200,275,50);
        s4.setBackground(Color.pink);

        //Adding Buttons
        Phone.add(backButton);
        Phone.add(homeButton);
        Phone.add(smsTextBox);
        Phone.add(sendButton);
        Phone.add(s1);
        Phone.add(s2);
        Phone.add(s3);
        Phone.add(s4);
        Phone.add(smsPage);
        Phone.add(new CallInterface());

        //Register buttons
        sendButton.addActionListener(new sendButton_Action());
        homeButton.addActionListener(new homeButton_Action());
        backButton.addActionListener(new backButton_Action());

    }
    @Override
    protected void paintComponent(Graphics phone) {
        super.paintComponent(phone);
        //Creating the phone interface without ICONS
        phone.setColor(Color.BLACK);
        phone.drawRoundRect(10, 10, 315, 535, 70, 70);
        //Creating the Top screen
        phone.setColor(Color.black.brighter().brighter());
        phone.fillRoundRect(10, 10, 315, 50, 70, 70);
        phone.fillRect(10, 33, 315, 30);
        phone.setColor(Color.gray.darker().darker());
        phone.fillOval(160, 20, 15, 15);
        phone.setColor(Color.darkGray.darker());
        phone.fillOval(164, 24, 7, 7);
        phone.setColor(Color.darkGray);
        phone.fillOval(45, 20, 5, 5);
        //Creating the bottom Screen
        phone.setColor(Color.black);
        phone.fillRoundRect(10, 495, 315, 50, 70, 70);
        phone.fillRect(10, 495, 315, 20);
        //Creating the buttons
        phone.setColor(Color.white.brighter());
        phone.drawRoundRect(155, 510, 19, 19, 19, 19);
        phone.setColor(Color.white);
        phone.setFont(new Font("Algeria", Font.PLAIN, 26));
        phone.drawString("<", 260, 528);
        phone.drawImage(batteryIcon,270,60,this);
        phone.drawImage(Signal,252,60,this);
        phone.drawImage(Wifi,234,60,this);
        phone.drawImage(Speaker,214,60,this);
        phone.drawImage(send,285,460,this);
    }
    //Set On click For Buttons
    static class homeButton_Action implements ActionListener{
        public void actionPerformed(ActionEvent e){
            HomeScreen.main(null);
            Phone.setVisible(false);
            Phone.dispose();
        }
    }
    static class backButton_Action implements ActionListener{
        public void actionPerformed(ActionEvent e){
            HomeScreen.main(null);
            Phone.setVisible(false);
            Phone.dispose();
        }
    }
    static class sendButton_Action implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(s1.getText()==("")){
                s1.setText(smsTextBox.getText());
                smsTextBox.setText("");
            }
              else if(s1.getText()!=""){
                s2.setText(s1.getText());
                s1.setText(smsTextBox.getText());
                smsTextBox.setText("");

            }
              else if(s1.getText()==s1.getText() && s2.getText()==s2.getText()) {
                s3.setText(s2.getText());
                s2.setText(s1.getText());
                s1.setText(smsTextBox.getText());
                smsTextBox.setText("");
            }
              else if(s1.getText()!="" && s2.getText()!="" && s3.getText()!=""){
                s4.setText(s3.getText());
                s3.setText(s2.getText());
                s3.setText(s1.getText());
                s1.setText(smsTextBox.getText());
                smsTextBox.setText("");
            }
            }


        }

    }

