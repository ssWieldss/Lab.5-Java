package Lab5;

import javax.swing.*;
import java.io.IOException;

public class MyFrame extends JFrame {


    public MyFrame(boolean choice) {

        if(choice == true) {
            this.setTitle("LinkedList operations");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setSize(1000, 500);
            this.setVisible(true);
            try {
                this.add(new DrawLinkedList());
            }
            catch (IOException e)
            {
                JOptionPane.showMessageDialog(null, "Нет данных конфигурационного файла!",
                        "Error", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
            this.pack();
        }

        if(choice == false) {
            this.setTitle("ArrayList Operations");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setSize(1000, 500);
            this.setVisible(true);
            try {
                this.add(new DrawArrayList());
            }
            catch (IOException e)
            {
                JOptionPane.showMessageDialog(null, "Нет данных конфигурационного файла!",
                        "Error", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
            this.pack();
        }
    }

}