import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

public class AthleticRaceInterface {
   public List<Runner> corredores = new ArrayList<>(5);
   private JFrame frame;
   private JTextField runnerNameField;
   private JButton registerButton;

   public AthleticRaceInterface(){

// Crear y configurar la ventana principal
      frame = new JFrame("Carrera Atlética - TAP-R5-U3");
      frame.setSize(600, 700);
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

// Panel para el registro de corredores con layout vertical
      JPanel registroCorredoresPanel = new JPanel();
      registroCorredoresPanel.setLayout(new BoxLayout(registroCorredoresPanel, BoxLayout.Y_AXIS));
      registroCorredoresPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

// Título del panel de registro
      JLabel registroCorredoresLabel = new JLabel("Registro de corredores");
      registroCorredoresLabel.setFont(new Font("Arial", Font.BOLD, 16));
      registroCorredoresLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

// Panel para el campo de texto y botón con layout horizontal
      JPanel inputButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
      inputButtonPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

// Campo de texto para ingresar nombre del corredor
      runnerNameField = new JTextField(20);
      runnerNameField.setFont(new Font("Arial", Font.PLAIN, 14));

// Botón para registrar corredor
      registerButton = new JButton("Añadir");
      registerButton.setFont(new Font("Arial", Font.PLAIN, 14));

// Agregar componentes al panel de entrada
      inputButtonPanel.add(new JLabel("Nombre: "));
      inputButtonPanel.add(runnerNameField);
      inputButtonPanel.add(registerButton);

// Agregar componentes al panel principal de registro
      registroCorredoresPanel.add(registroCorredoresLabel);
      registroCorredoresPanel.add(Box.createRigidArea(new Dimension(0, 5)));
      registroCorredoresPanel.add(inputButtonPanel);









// Agregar panel de registro a la ventana
      frame.add(registroCorredoresPanel);

// Centrar y mostrar la ventana
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      new AthleticRaceInterface();
   }
}
