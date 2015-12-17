
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rewdon
 */
public class MyApp extends JFrame implements ActionListener, DocumentListener {

    private JTextField firstName, surName, userName, passWord;//declaring text fields
    private JButton createUsername, setPassword, clear, finished;//declaring buttons
    private JLabel fn, sn, un, pw, result, result2;//declaring labels
    private JProgressBar pb;//declaring progressbar

    public MyApp() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        {
            firstName = new JTextField(10);
            surName = new JTextField(10);
            userName = new JTextField(10);
            passWord = new JPasswordField(5);
            userName.setEditable(false);//making the textfield not editable

            fn = new JLabel("First Name");
            sn = new JLabel("Surname");
            un = new JLabel("User Name");
            result = new JLabel("");
            pw = new JLabel("Type a Password of minimum 5 Characters");
            pb = new JProgressBar();
            result2 = new JLabel("");

            createUsername = new JButton("Create User");

            setPassword = new JButton("Set Password");

            clear = new JButton("Clear");
            finished = new JButton("Finished");

            JPanel jp = new JPanel(new GridLayout(0, 1));  //creating panel
            add(jp, BorderLayout.NORTH);//panel stays on the left
            jp.setPreferredSize(new Dimension(300, 200));//size of the panel

            jp.add(fn);
            jp.add(firstName);
            jp.add(sn);
            jp.add(surName);
            jp.add(createUsername).isPreferredSizeSet();
            jp.add(result);
            //adding elements on the panel

            JPanel jp2 = new JPanel(new GridLayout(0, 2));
            add(jp2, BorderLayout.CENTER);

            jp2.setPreferredSize(new Dimension(200, 30));
            jp2.add(un);
            jp2.add(userName);

            createUsername.addActionListener(this);//adding the action listener
            passWord.getDocument().addDocumentListener(this);
            setPassword.addActionListener(this);
            clear.addActionListener(this);
            finished.addActionListener(this);

            JPanel jp3 = new JPanel(new GridLayout(0, 1));
            add(jp3, BorderLayout.SOUTH);
            jp3.setPreferredSize(new Dimension(200, 200));

            jp3.add(pw);
            jp3.add(passWord);
            jp3.add(pb);
            jp3.add(setPassword);
            jp3.add(result2);
            jp3.add(clear);
            jp3.add(finished);

            pack();//putting all the elements together in the panel
        }

    }

    public static void main(String args[]) throws Exception {
        new MyApp().setVisible(true);//setting the form visible

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (e.getSource() == createUsername) {

            if (firstName.getText().isEmpty() || surName.getText().isEmpty()) {
                result.setText("Plese enter both First name and surname");

            } else {
                String f = firstName.getText();
                String s = surName.getText();
                userName.setText(f.charAt(0) + s);
                result.setText("");

            }
        }

        if (e.getSource() == setPassword) {
            if (passWord.getText().length() < 5) {
                result2.setText("Password should be minimum 5 characters. :(");
            } else {
                result2.setText("Password is set. :)");
                passWord.setEditable(false);
            }
        }

        if (e.getSource() == clear) {
            firstName.setText(null);
            surName.setText(null);
            userName.setText(null);
            passWord.setText(null);
            result.setText(null);
            result2.setText(null);
            passWord.setEditable(true);
        }

        if (e.getSource() == finished) {
            if (userName.getText().isEmpty() || passWord.isEditable()) {

            } else {
                System.exit(0);
            }
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        int a = passWord.getText().length();
        int b = a * 20;
        pb.setValue(b);//update the progressbar

    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int a = passWord.getText().length();
        int b = a * 20;
        pb.setValue(b);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int a = passWord.getText().length();
        int b = a * 20;
        pb.setValue(b);
    }

}
