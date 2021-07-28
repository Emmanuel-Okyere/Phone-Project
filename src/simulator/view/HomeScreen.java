package simulator.view;
import org.omg.CORBA.CODESET_INCOMPATIBLE;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

public class HomeScreen extends JPanel {
    static Image wallPaper = new ImageIcon("src//simulator//view//2.jpg").getImage();
    static Image calendarIcon = new ImageIcon("src//simulator//view//Calendar.jpg").getImage();
    static Image batteryIcon = new ImageIcon("src//simulator//view//Battery.png").getImage();
    static Image Signal = new ImageIcon("src//simulator//view//Signal.png").getImage();
    static Image Wifi = new ImageIcon("src//simulator//view//Wifi.png").getImage();
    static Image Speaker = new ImageIcon("src//simulator//view//Speaker.png").getImage();
    static Image phoneIcon = new ImageIcon("src//simulator//view//Phone.png").getImage();
    static Image smsIcon = new ImageIcon("src//simulator//view//Sms.png").getImage();
    static Image contactIcon = new ImageIcon("src//simulator//view//Contact.png").getImage();
    static Image emailIcon = new ImageIcon("src//simulator//view//Email.png").getImage();
    static JFrame home;
    static JButton calenderButton, phoneButton, smsButton, callButton, contactButton, backButton, homeButton;

    public static void main(String args[]) {
        home = new JFrame("Samsung");
        //Creating the clock
        Clock clock = new Clock();
        home.add(clock.time);
        home.setVisible(true);
        home.setSize(350, 600);
        home.setResizable(false);
        home.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //Creating Icons Buttons
        //Calendar
        calenderButton = new JButton(new ImageIcon("src//simulator//view//Calendar.jpg"));
        calenderButton.setEnabled(true);
        calenderButton.setBackground(Color.BLACK);
        calenderButton.setBounds(40, 350, 48, 48);
        //Phone Button
        phoneButton = new JButton(new ImageIcon("src//simulator//view//Phone.png"));
        phoneButton.setEnabled(true);
        phoneButton.setBackground(new Color(0, 123, 109, 200));
        phoneButton.setBounds(40, 430, 48, 48);
        phoneButton.setToolTipText("Open Phone");
        //Sms Button
        smsButton = new JButton(new ImageIcon("src//simulator//view//Sms.png"));
        smsButton.setEnabled(true);
        smsButton.setBackground(new Color(0, 123, 109, 200));
        smsButton.setBounds(100, 430, 48, 48);
        //Contacts
        contactButton = new JButton(new ImageIcon("src//simulator//view//Contact.png"));
        contactButton.setEnabled(true);
        contactButton.setBackground(new Color(231, 100, 90, 200));
        contactButton.setBounds(160, 430, 50, 50);


        //Creating control buttons
        //Back Button
        backButton = new JButton();
        backButton.setEnabled(true);
        backButton.setBackground(Color.black);
        backButton.setBounds(260, 510, 20, 20);

        //Home Button
        homeButton = new JButton();
        homeButton.setEnabled(true);
        homeButton.setBackground(Color.black);
        homeButton.setBounds(155, 510, 20, 20);
        // Adding control Buttons
        home.add(backButton);
        home.add(homeButton);
        //Adding Icons
        home.add(calenderButton);
        home.add(phoneButton);
        home.add(smsButton);
        home.add(contactButton);
        //Drawing the Phone Simulator.
        home.add(new HomeScreen());
        //Registering Icon Buttons
        calenderButton.addActionListener(new calendar_Action());
        phoneButton.addActionListener(new phone_Action());
       // contactButton.addActionListener(new contact_Action());
        smsButton.addActionListener(new sms_Action());
        //Starting the Clock.
        clock.start();
    }

    @Override
    protected void paintComponent(Graphics home) {
        super.paintComponent(home);
        //Creating the phone interface without ICONS
        home.setColor(Color.BLACK);
        home.drawRoundRect(10, 10, 315, 535, 70, 70);
        //Creating the Top screen

        home.setColor(Color.black.brighter().brighter());
        home.fillRoundRect(10, 10, 315, 50, 70, 70);
        home.fillRect(10, 33, 315, 30);
        home.setColor(Color.gray.darker().darker());
        home.fillOval(160, 20, 15, 15);
        home.setColor(Color.darkGray.darker());
        home.fillOval(164, 24, 7, 7);
        home.setColor(Color.darkGray);
        home.fillOval(45, 20, 5, 5);
        // home.setColor(Color.gray);
        // home.fillRect(133,40,70,50);
        // home.setColor(Color.black);
        // home.drawString("SAMSUNG",140,55);
        //Creating the bottom Screen
        home.setColor(Color.black);
        home.fillRoundRect(10, 495, 315, 50, 70, 70);
        home.fillRect(10, 495, 315, 20);
        //Creating the buttons
        home.setColor(Color.white.brighter());
        home.drawRoundRect(155, 510, 19, 19, 19, 19);
        home.setColor(Color.white);
        home.setFont(new Font("Algeria", Font.PLAIN, 26));
        home.drawString("<", 260, 528);
        home.drawImage(wallPaper, 11, 60, this);
        //Drawing Icons on the HomeScreen
        home.drawImage(calendarIcon, 40, 350, this);
        home.drawImage(batteryIcon, 270, 60, this);
        home.drawImage(Signal, 252, 60, this);
        home.drawImage(Wifi, 234, 60, this);
        home.drawImage(Speaker, 214, 60, this);
        home.drawImage(phoneIcon, 40, 430, this);
        home.drawImage(smsIcon, 100, 430, this);
        home.drawImage(contactIcon, 160, 430, this);
        home.drawImage(emailIcon, 100, 350, this);
        //Labeling the ICONS
        home.setColor(Color.white.brighter().brighter());
        home.setFont(new Font("Algeria", Font.BOLD, 12));
        home.drawString("Phone", 48, 490);
        home.drawString("SMS", 113, 490);
        home.drawString("Contact", 163, 490);
        home.drawString("Calendar", 39, 410);
        home.drawString("Email", 108, 410);
    }

    static class calendar_Action implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Calendar.main(null);
            home.setVisible(false);
            home.dispose();
        }
    }
    static class phone_Action implements ActionListener{
        public void actionPerformed(ActionEvent e){
            PhoneCall.main(null);
            home.setVisible(false);
            home.dispose();
        }
    }
    /*static class contact_Action implements ActionListener{
        public void actionPerformed(ActionEvent e){
          Contacts.main(null);
       }
    }
    */
    static class sms_Action extends Component implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Sms.main(null);
            home.setVisible(false);
            home.dispose();
        }

    }
}
class Clock {
    static JLabel time = new JLabel();
    static SimpleDateFormat sdf  = new SimpleDateFormat("hh:mm");
    private int   currentSecond;
    private java.util.Calendar calendar;
    private void reset(){
        calendar = java.util.Calendar.getInstance();
        currentSecond = calendar.get(java.util.Calendar.SECOND);
    }
    public void start(){
        reset();
        java.util.Timer timer = new Timer();
        timer.scheduleAtFixedRate( new TimerTask(){
            public void run(){
                if( currentSecond == 60 ) {
                    reset();
                }
                time.setBounds(125,120,100,80);
                time.setForeground(new Color(0, 0, 0));
                time.setFont(new Font("Algeria",Font.BOLD,25));
                time.setText( String.format("%s:%02d", sdf.format(calendar.getTime()), currentSecond ));
                currentSecond++;
            }
        }, 0, 1000 );
    }
}