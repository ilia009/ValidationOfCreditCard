import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
        Main() {
            JFrame jfrm = new JFrame("Validator of credit card");
            jfrm.setLayout(new FlowLayout());
            jfrm.setSize(200,200);
            jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JLabel jlab = new JLabel("Result is: ");
            JLabel jlab1 = new JLabel("true or false?");

            JButton ValidButton = new JButton("Validate");
            JButton ResetButton = new JButton("Reset");

            JTextField jtf = new JTextField(16);

            //actionListener for ValidButton
            ValidButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //ТУТ ВЫЗВАТЬ ФУНКЦИЮ ВАЛИДАЦИИ
                    String nomberCard = jtf.getText();
                    if(nomberCard.matches("[\\d]+")){
                        char[] digits = nomberCard.toCharArray();
                        jlab1.setText(String.valueOf(Check(nomberCard)));
                    }else {
                        jlab1.setText("Error");
                    }

                }
            });

             ResetButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    jlab.setText("Result is: ");
                    jlab1.setText("true or false?");
                    jtf.setText("");
                }
            });

            jfrm.add(jlab);
            jfrm.add(jlab1);
            jfrm.add(ValidButton);
            jfrm.add(ResetButton);
            jfrm.add(jtf);

            jfrm.setVisible(true);
        }

    public static boolean Check(String Number) {
        int sum = 0;
        boolean alt = false;
        for (int i = Number.length() - 1; i >= 0; i--)
        {
            int n = Integer.parseInt(Number.substring(i, i + 1));
            if (alt)
            {
                n *= 2;
                if (n > 9)
                {
                    n = (n % 10) + 1;
                }
            }
            sum += n;
            alt = !alt;
        }
        return (sum % 10 == 0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }
    }

