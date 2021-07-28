package simulator.view;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Calendar extends JPanel{
    static JLabel lblMonth, lblYear;
    static JButton btnPrev, btnNext,backButton,homeButton;
    static JTable tblCalendar;
    static JComboBox cmbYear;
    static JFrame frmMain;
    static DefaultTableModel mtblCalendar; //Table model
    static JScrollPane stblCalendar; //The scrollpane
    static JPanel pnlCalendar;
    static int realYear, realMonth, realDay, currentYear, currentMonth;

    static Image batteryIcon = new ImageIcon("src//simulator//view//Battery.png").getImage();
    static Image Signal = new ImageIcon("src//simulator//view//Signal.png").getImage();
    static Image Wifi = new ImageIcon("src//simulator//view//Wifi.png").getImage();
    static Image Speaker = new ImageIcon("src//simulator//view//Speaker.png").getImage();

    public static void main (String args[]){
        //Prepare frame
        frmMain = new JFrame ("Calendar"); //Create frame
        frmMain.setSize(350, 600); //Set size to 350x600 pixels


        frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Close when X is clicked

        //Creating control buttons
        //Back Button
        backButton = new JButton();
        backButton.setEnabled(true);
        backButton.setBounds(260,510,20,20);
        backButton.setBackground(Color.black);
        backButton.setToolTipText("Click to go back home");

        //Home Button
        homeButton = new JButton();
        homeButton.setEnabled(true);
        homeButton.setBounds(155,510,20,20);
        homeButton.setBackground(Color.black);
        homeButton.setToolTipText("Click to go back home");
        // Adding control Buttons


        //Create controls of the Calendar
        lblMonth = new JLabel ("May");
        lblYear = new JLabel ("Change year:");
        cmbYear = new JComboBox();
        btnPrev = new JButton ("<");
        btnNext = new JButton (">");
        mtblCalendar = new DefaultTableModel(){public boolean isCellEditable(int rowIndex, int mColIndex){return false;}};
        tblCalendar = new JTable(mtblCalendar);
        stblCalendar = new JScrollPane(tblCalendar);
        pnlCalendar = new JPanel(null);
        pnlCalendar.setBackground(Color.CYAN.darker());
        //Color of Buttons
       // backButton.setBackground(Color.red);
        btnNext.setBackground(Color.PINK);
        btnPrev.setBackground(Color.PINK);

        //Set border
        pnlCalendar.setBorder(BorderFactory.createTitledBorder("Calendar"));

        //Register action listeners
        btnPrev.addActionListener(new btnPrev_Action());
        btnNext.addActionListener(new btnNext_Action());
        cmbYear.addActionListener(new cmbYear_Action());
        backButton.addActionListener(new backButton_Action());
        homeButton.addActionListener(new homeButton_Action());

        //Add controls to pane
        frmMain.add(pnlCalendar);
        pnlCalendar.add(lblMonth);
        pnlCalendar.add(lblYear);
        pnlCalendar.add(cmbYear);
        pnlCalendar.add(btnPrev);
        pnlCalendar.add(btnNext);
        pnlCalendar.add(stblCalendar);
        frmMain.add(backButton);
        frmMain.add(homeButton);
        frmMain.add(new Calendar());


        //Set bounds
        pnlCalendar.setBounds(11, 80, 315, 415);
        lblMonth.setBounds(160-lblMonth.getPreferredSize().width/2, 25, 100, 25);
        lblYear.setBounds(10, 305, 80, 20);
        cmbYear.setBounds(230, 305, 80, 20);
        btnPrev.setBounds(10, 25, 50, 25);
        btnNext.setBounds(260, 25, 50, 25);
        stblCalendar.setBounds(10, 50, 300, 250);

        //Make frame visible
        frmMain.setResizable(false);
        frmMain.setVisible(true);
        //Get real month/year
        GregorianCalendar cal = new GregorianCalendar(); //Create calendar
        realDay = cal.get(GregorianCalendar.DAY_OF_MONTH); //Get day
        realMonth = cal.get(GregorianCalendar.MONTH); //Get month
        realYear = cal.get(GregorianCalendar.YEAR); //Get year
        currentMonth = realMonth; //Match month and year
        currentYear = realYear;

        //Add headers
        String[] headers = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"}; //All headers
        for (int i=0; i<7; i++){
            mtblCalendar.addColumn(headers[i]);
        }

        tblCalendar.getParent().setBackground(tblCalendar.getBackground()); //Set background

        //No resize/reorder
        tblCalendar.getTableHeader().setResizingAllowed(false);
        tblCalendar.getTableHeader().setReorderingAllowed(false);

        //Single cell selection
        tblCalendar.setColumnSelectionAllowed(true);
        tblCalendar.setRowSelectionAllowed(true);
        tblCalendar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //Set row/column count
        tblCalendar.setRowHeight(38);
        mtblCalendar.setColumnCount(7);
        mtblCalendar.setRowCount(6);

        //Populate table
        for (int i=realYear-100; i<=realYear+100; i++){
            cmbYear.addItem(String.valueOf(i));
        }

        //Refresh calendar
        refreshCalendar (realMonth, realYear); //Refresh calendar
    }
        //Drawing the Frame Border
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
        }

        //Refreshing the Calendar
        public static void refreshCalendar(int month, int year){
        //Variables
        String[] months =  {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int nod, som; //Number Of Days, Start Of Month

        //Allow/disallow buttons
        btnPrev.setEnabled(true);
        btnNext.setEnabled(true);
        //Button Descriptions
        btnNext.setToolTipText("Go to next month");
        btnPrev.setToolTipText("Go to previous Month");
        if (month == 0 && year <= realYear-10){btnPrev.setEnabled(false);} //Too early
        if (month == 11 && year >= realYear+100){btnNext.setEnabled(false);} //Too late
        lblMonth.setText(months[month]); //Refresh the month label (at the top)
        lblMonth.setBounds(160-lblMonth.getPreferredSize().width/2, 25, 180, 25); //Re-align label with calendar
        cmbYear.setSelectedItem(String.valueOf(year)); //Select the correct year in the combo box

        //Clear table
        for (int i=0; i<6; i++){
            for (int j=0; j<7; j++){
                mtblCalendar.setValueAt(null, i, j);
            }
        }

        //Get first day of month and number of days
        GregorianCalendar cal = new GregorianCalendar(year, month, 1);
        nod = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        som = cal.get(GregorianCalendar.DAY_OF_WEEK);

        //Draw calendar
        for (int i=1; i<=nod; i++){
            int row = new Integer((i+som-2)/7);
            int column  =  (i+som-2)%7;
            mtblCalendar.setValueAt(i, row, column);
        }

        //Apply renderers
        tblCalendar.setDefaultRenderer(tblCalendar.getColumnClass(0), new tblCalendarRenderer());
    }

    static class tblCalendarRenderer extends DefaultTableCellRenderer{
        public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column){
            super.getTableCellRendererComponent(table, value, selected, focused, row, column);
            if (column == 0 || column == 6){ //Week-end
                setBackground(new Color(152, 14, 14));
            }
            else{ //Week
                setBackground(new Color(238, 223, 18));
            }
            if (value != null){
                if (Integer.parseInt(value.toString()) == realDay && currentMonth == realMonth && currentYear == realYear){ //Today
                    setBackground(new Color(18, 157, 238));
                }
            }
            setBorder(null);
            setForeground(Color.black);
            return this;
        }
    }

    static class btnPrev_Action implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if (currentMonth == 0){ //Back one year
                currentMonth = 11;
                currentYear -= 1;
            }
            else{ //Back one month
                currentMonth -= 1;
            }
            refreshCalendar(currentMonth, currentYear);
        }
    }
    static class btnNext_Action implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if (currentMonth == 11){ //Foward one year
                currentMonth = 0;
                currentYear += 1;
            }
            else{ //Foward one month
                currentMonth += 1;
            }
            refreshCalendar(currentMonth, currentYear);
        }

    }
    static class backButton_Action implements ActionListener{
        public void actionPerformed (ActionEvent e){
            HomeScreen.main(null);
            frmMain.setVisible(false);
            frmMain.dispose();
        }
    }
    static class homeButton_Action implements ActionListener{
        public void  actionPerformed(ActionEvent e){
            HomeScreen.main(null);
            frmMain.setVisible(false);
            frmMain.dispose();
        }
    }
    static class cmbYear_Action implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if (cmbYear.getSelectedItem() != null){
                String b = cmbYear.getSelectedItem().toString();
                currentYear = Integer.parseInt(b);
                refreshCalendar(currentMonth, currentYear);
            }
        }
    }
}