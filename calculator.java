//Dawson Lefebvre
//basic calculator



import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

class calculator extends JFrame implements ActionListener {

    //frame
    static JFrame frame;

    //textfield
    static JTextField tex;

    //operators
    String s1, s2, s3;


    //constructor
    calculator(){
      s1 = s2 = s3 = "";
    }

    public static void main(String args[]){
      // create a frame
    frame = new JFrame("calculator");

    try {
        // set look and feel
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }
    catch (Exception e) {
        System.err.println(e.getMessage());
    }

    // create a object of class
    calculator calc = new calculator();

    // create a textfield
    tex = new JTextField(16);

    // set the textfield to non editable
    tex.setEditable(false);

    // create number buttons and some operators
    JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bs, bd, bm, bdec, beq, bc;


    //numbers
    b0 = new JButton("0");
    b1 = new JButton("1");
    b2 = new JButton("2");
    b3 = new JButton("3");
    b4 = new JButton("4");
    b5 = new JButton("5");
    b6 = new JButton("6");
    b7 = new JButton("7");
    b8 = new JButton("8");
    b9 = new JButton("9");
    //ations
    ba = new JButton("+");
    bs = new JButton("-");
    bd = new JButton("/");
    bm = new JButton("*");
    beq = new JButton("=");
    bc = new JButton("CLEAR");

    //decimal
    bdec = new JButton(".");

    JPanel panel = new JPanel();


    //add action listeners

    b0.addActionListener(calc);
    b1.addActionListener(calc);
    b2.addActionListener(calc);
    b3.addActionListener(calc);
    b4.addActionListener(calc);
    b5.addActionListener(calc);
    b6.addActionListener(calc);
    b7.addActionListener(calc);
    b8.addActionListener(calc);
    b9.addActionListener(calc);
    ba.addActionListener(calc);
    bs.addActionListener(calc);
    bd.addActionListener(calc);
    bm.addActionListener(calc);
    beq.addActionListener(calc);
    bc.addActionListener(calc);
    bdec.addActionListener(calc);

    // add panels this is building calculator

    panel.add(tex);
    panel.add(b0);
    panel.add(b1);
    panel.add(b2);
    panel.add(b3);
    panel.add(b4);
    panel.add(b5);
    panel.add(b6);
    panel.add(b7);
    panel.add(b8);
    panel.add(b9);
    panel.add(ba);
    panel.add(bs);
    panel.add(bd);
    panel.add(bm);
    panel.add(beq);
    panel.add(bc);
    panel.add(bdec);

    //set background color

    panel.setBackground(Color.black);

    //must add panel to frame
    frame.add(panel);
    //set size
    frame.setSize(200, 220);
    //show display the calculator
    frame.show();
  }
    public void actionPerformed(ActionEvent action){

      String input = action.getActionCommand();


        // if the value is a number
      if ((input.charAt(0) >= '0' && input.charAt(0) <= '9') || input.charAt(0) == '.') {
          // if operand is present then add to second no
          if (!s2.equals(""))
              s3 = s3 + input;
          else
              s1 = s1 + input;

          // set the value of text
          tex.setText(s1 + s2 + s3);
        }
      else if (input.charAt(0) == 'C') {
        // clear the one letter
        s1 = s2 = s3 = "";

        // set the value of text
        tex.setText(s1 + s2 + s3);
      }
      else if (input.charAt(0) == '=') {

        double te;

        // store the value in 1st
        if (s2.equals("+"))
            te = (Double.parseDouble(s1) + Double.parseDouble(s3));
        else if (s2.equals("/"))
                te = (Double.parseDouble(s1) / Double.parseDouble(s3));
        else if (s2.equals("-"))
            te = (Double.parseDouble(s1) - Double.parseDouble(s3));
        else
            te = (Double.parseDouble(s1) * Double.parseDouble(s3));

        // set the value of text
        tex.setText(s1 + s2 + s3 + "=" + te);

        // convert it to string
        s1 = Double.toString(te);

        s2 = s3 = "";
      }
      else {
        // if there was no operand
        if (s2.equals("") || s3.equals(""))
            s2 = input;
        // else evaluate
        else {
            double te;

            // store the value in 1st
            if (s2.equals("+"))
                te = (Double.parseDouble(s1) + Double.parseDouble(s3));
            else if (s2.equals("-"))
                te = (Double.parseDouble(s1) - Double.parseDouble(s3));
            else if (s2.equals("/"))
                te = (Double.parseDouble(s1) / Double.parseDouble(s3));
            else
                te = (Double.parseDouble(s1) * Double.parseDouble(s3));

            // convert it to string
            s1 = Double.toString(te);

            // place the operator
            s2 = input;

            // make the operand blank
            s3 = "";
        }

        // set the value of text
        tex.setText(s1 + s2 + s3);

      }
    }
}
