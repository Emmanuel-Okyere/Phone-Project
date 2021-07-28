package simulator.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PhoneCall extends JPanel {
    static String input="";
    static Image clearNumber = new ImageIcon("src//simulator//view//Delete.png").getImage();
    static Image batteryIcon = new ImageIcon("src//simulator//view//Battery.png").getImage();
    static Image Signal = new ImageIcon("src//simulator//view//Signal.png").getImage();
    static Image Wifi = new ImageIcon("src//simulator//view//Wifi.png").getImage();
    static Image Speaker = new ImageIcon("src//simulator//view//Speaker.png").getImage();
    static Image PhoneCall = new ImageIcon("src//simulator//view//Phone Icon.png").getImage();
    static JFrame Phone;
    static JPanel phonePage;
    static JTextField inputNumber;
    static String getText;
    static JButton clearButton,backButton,homeButton,but1,but2,but3,but4,but5,but6,but7,but8,but9,but0,butStar,butHash,callButton;
    public static void main(String[] args){
        Phone =new JFrame("Phone Call");
        Phone.setVisible(true);
        Phone.setSize(350,600);
        Phone.setResizable(false);
        Phone.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //Setting the JPanel
        phonePage=new JPanel(null);
        phonePage.setBorder(BorderFactory.createTitledBorder("Phone"));
        phonePage.setBounds(11,80,315,415);
        phonePage.setBackground(new Color(255, 194, 106, 241));
        //Setting the Text field.
        inputNumber=new JTextField();
        inputNumber.setBounds(25,150,260,30);
        //inputNumber.addActionListener(new inputNumber_Action());
        //Drawing number Buttons
        //Number 1
        but1= new JButton("1");
        but1.setEnabled(true);
        but1.setBounds(60,220,50,40);
        but1.setBackground(new Color(255, 63, 135));
        //Number 2
        but2= new JButton("2");
        but2.setEnabled(true);
        but2.setBounds(140,220,50,40);
        but2.setBackground(new Color(48, 91, 200));
        //Number 3
        but3= new JButton("3");
        but3.setEnabled(true);
        but3.setBounds(220,220,50,40);
        but3.setBackground(new Color(255, 247, 51));
        //Number 4
        but4= new JButton("4");
        but4.setEnabled(true);
        but4.setBounds(60,280,50,40);
        but4.setBackground(new Color(255, 63, 135));
        //Number 5
        but5= new JButton("5");
        but5.setEnabled(true);
        but5.setBounds(140,280,50,40);
        but5.setBackground(new Color(48, 91, 200));
        //Number 6
        but6= new JButton("6");
        but6.setEnabled(true);
        but6.setBounds(220,280,50,40);
        but6.setBackground(new Color(255, 247, 51));
        //Number 7
        but7= new JButton("7");
        but7.setEnabled(true);
        but7.setBounds(60,340,50,40);
        but7.setBackground(new Color(255, 63, 135));
        //Number 8
        but8= new JButton("8");
        but8.setEnabled(true);
        but8.setBounds(140,340,50,40);
        but8.setBackground(new Color(48, 91, 200));
        //Number 9
        but9= new JButton("9");
        but9.setEnabled(true);
        but9.setBounds(220,340,50,40);
        but9.setBackground(new Color(255, 247, 51));
        //Number 0
        but0= new JButton("0");
        but0.setEnabled(true);
        but0.setBounds(140,400,50,40);
        but0.setBackground(new Color(48, 91, 200));
        //Number *
        butStar= new JButton("*");
        butStar.setEnabled(true);
        butStar.setBounds(60,400,50,40);
        butStar.setBackground(new Color(255, 63, 135));
        //Number #
        butHash= new JButton("#");
        butHash.setEnabled(true);
        butHash.setBounds(220,400,50,40);
        butHash.setBackground(new Color(255, 247, 51));
        //Call Button
        callButton =new JButton(new ImageIcon("src//simulator//view//Phone Icon.png"));
        callButton.setBounds(140,450,50,40);
        callButton.setEnabled(true);
        callButton.setBackground(new Color(48, 91, 200));
        //Clear Button
        clearButton = new JButton(new ImageIcon("src//simulator//view//Delete.png"));
        clearButton.setBounds(220,450,50,40);
        clearButton.setEnabled(true);
        clearButton.setBackground(Color.white);
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
        //Adding Buttons

        Phone.add(backButton);
        Phone.add(homeButton);
        Phone.add(inputNumber);
        Phone.add(but1);
        Phone.add(but2);
        Phone.add(but3);
        Phone.add(but4);
        Phone.add(but5);
        Phone.add(but6);
        Phone.add(but7);
        Phone.add(but8);
        Phone.add(but9);
        Phone.add(but0);
        Phone.add(butStar);
        Phone.add(butHash);
        Phone.add(callButton);
        Phone.add(clearButton);
        Phone.add(phonePage);
        Phone.add(new CallInterface());
        //Register buttons
        homeButton.addActionListener(new homeButton_Action());
        backButton.addActionListener(new backButton_Action());
        but1.addActionListener(new inputNumber_Action());
        but2.addActionListener(new inputNumber_Action());
        but3.addActionListener(new inputNumber_Action());
        but4.addActionListener(new inputNumber_Action());
        but5.addActionListener(new inputNumber_Action());
        but6.addActionListener(new inputNumber_Action());
        but7.addActionListener(new inputNumber_Action());
        but8.addActionListener(new inputNumber_Action());
        but9.addActionListener(new inputNumber_Action());
        butStar.addActionListener(new inputNumber_Action());
        but0.addActionListener(new inputNumber_Action());
        butHash.addActionListener(new inputNumber_Action());
        clearButton.addActionListener(new clearSpace_Action());
        callButton.addActionListener(new callButton_Action());

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
        phone.drawImage(PhoneCall,140,450,this);
        phone.drawImage(clearNumber,220,450,this);
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
    static class inputNumber_Action implements ActionListener{
        public void actionPerformed(ActionEvent e){
           input +=e.getActionCommand();
           inputNumber.setText(input);
           getText=input;
        }
    }
    static class clearSpace_Action implements ActionListener{
        public void actionPerformed(ActionEvent e){
            input="";
            inputNumber.setText("");
        }
    }
    static class callButton_Action implements ActionListener{
        public void  actionPerformed(ActionEvent e){
            input="";
            inputNumber.setText("");
            CallInterface.main(null);
            Phone.setVisible(false);
            Phone.dispose();

        }
    }
}
