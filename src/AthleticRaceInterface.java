import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AthleticRaceInterface {
    public static void main(String[] args) {
        JFrame window = new JFrame("TAP R5 U3");
        window.setSize(800,800);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));


        JLabel registro = new JLabel("Registro de corredores");
        registro.setFont(new Font("Arial", Font.BOLD, 25));
        panel.add(registro);

        JTextField registroNombre = new JTextField(3);
        registroNombre.setFont(new Font("Arial", Font.PLAIN, 15));
        panel.add(registroNombre);
        window.add(panel);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

}
