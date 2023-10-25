package employeemanagement.system.com;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
public class ViewEmpolyee extends JFrame implements ActionListener{
    Choice choiceEMP;
    JTable table;

    JButton searchbn,print,update,back;
    ViewEmpolyee(){
        getContentPane().setBackground(new Color(0,139,139));


        JLabel search = new JLabel("Search by employee id :");
        search.setBounds(20,20,200,20);
        add(search);

        choiceEMP = new Choice();
        choiceEMP.setBounds(230,20,150,20);
        choiceEMP.setBackground(Color.WHITE);
        add(choiceEMP);

        try{
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");
            while (resultSet.next()){
                choiceEMP.add(resultSet.getString("empid"));
            }

        }catch (Exception E){
            E.printStackTrace();
        }
        table  = new JTable();
        try{
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception E){
            E.printStackTrace();
        }
        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(0,100,850,450);
        add(jp);

        searchbn = new JButton("Search");
        searchbn.setBounds(20,70,100,20);
        searchbn.addActionListener(this);
        add(searchbn);

        print = new JButton("Print");
        print.setBounds(140,70,100,20);
        print.addActionListener(this);
        add(print);

        update = new JButton("Update");
        update.setBounds(260,70,100,20);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(380,70,100,20);
        back.addActionListener(this);
        add(back);

        setSize(850,550);
        setLocation(300,100);
        setLayout(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==searchbn){
            String query = "select * from employee where empid = '"+choiceEMP.getSelectedItem()+"'";
            try{
                conn c = new conn();
                ResultSet resultSet = c.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (e.getSource()== print) {
            try{
                table.print();
            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (e.getSource()==update) {
            setVisible(false);
            new UpdateEmployee(choiceEMP.getSelectedItem());
        } else {
            setVisible(false);
            new Main_class();
        }
    }
    public static void main(String[] args) {
        new ViewEmpolyee();
    }
}
