package simulator.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CallInterface extends JPanel {
    static Image endCallIcon = new ImageIcon("src//simulator//view//endCall.png").getImage();
    static Image contactIcon = new ImageIcon("src//simulator//view//contactImage.jpg").getImage();
    static Image batteryIcon = new ImageIcon("src//simulator//view//Battery.png").getImage();
    static Image Signal = new ImageIcon("src//simulator//view//Signal.png").getImage();
    static Image Wifi = new ImageIcon("src//simulator//view//Wifi.png").getImage();
    static Image Speaker = new ImageIcon("src//simulator//view//Speaker.png").getImage();
    static JFrame Phone;
    static JLabel calling, contactNumber, contactName;
    static JButton backButton, homeButton, endCallButton;

    public static void main(String[] args) {
        Phone = new JFrame("Calling........");
        Phone.setVisible(true);
        Phone.setSize(350, 600);
        Phone.setResizable(false);
        Phone.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Drawing the Calling Label
        calling = new JLabel();
        calling.setBounds(150, 150, 50, 20);
        calling.setForeground(Color.red.darker());
        calling.setText("Calling...");
        //Drawing the user Name
        contactName = new JLabel("Group 15");
        contactName.setBounds(142, 170, 60, 20);
        contactName.setForeground(Color.black);
        //Drawing the User Number
        contactNumber = new JLabel(PhoneCall.getText);
        contactNumber.setBounds(142,190,70,20);
        contactNumber.setForeground(Color.black);

        //Drawing the End Call button
        endCallButton = new JButton(new ImageIcon("src//simulator//view//endCall.png"));
        endCallButton.setBounds(145, 450, 50, 40);
        endCallButton.setEnabled(true);
        endCallButton.setBackground(new Color(248, 255, 232));
        //Drawing back Button
        backButton = new JButton();
        backButton.setEnabled(true);
        backButton.setBackground(Color.black);
        backButton.setBounds(260, 510, 20, 20);
        //Drawing home Button
        homeButton = new JButton();
        homeButton.setEnabled(true);
        homeButton.setBackground(Color.black);
        homeButton.setBounds(155, 510, 20, 20);
        //Adding Buttons
        Phone.add(backButton);
        Phone.add(homeButton);
        Phone.add(calling);
        Phone.add(contactName);
        Phone.add(contactNumber);
        Phone.add(endCallButton);
        Phone.add(new CallInterface());
        //Register buttons
        homeButton.addActionListener(new homeButton_Action());
        backButton.addActionListener(new backButton_Action());
        endCallButton.addActionListener(new endCall_Action());

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
        //Drawing contact Image Slot Image Slot
        phone.setColor(Color.black);
        phone.drawRect(132, 240, 80, 80);
        //Creating the buttons
        phone.setColor(Color.white.brighter());
        phone.drawRoundRect(155, 510, 19, 19, 19, 19);
        phone.setColor(Color.white);
        phone.setFont(new Font("Algeria", Font.PLAIN, 26));
        phone.drawString("<", 260, 528);
        phone.drawImage(batteryIcon, 270, 60, this);
        phone.drawImage(Signal, 252, 60, this);
        phone.drawImage(Wifi, 234, 60, this);
        phone.drawImage(Speaker, 214, 60, this);
        phone.drawImage(contactIcon, 132, 240, this);
        phone.drawImage(endCallIcon, 145, 450, this);
    }

    //Set On click For Buttons
    static class homeButton_Action implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            HomeScreen.main(null);
            Phone.setVisible(false);
            Phone.dispose();
        }
    }

    static class backButton_Action implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            PhoneCall.main(null);
            Phone.setVisible(false);
            Phone.dispose();
        }
    }

    static class endCall_Action implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            PhoneCall.main(null);
            Phone.setVisible(false);
            Phone.dispose();
        }
    }
}
