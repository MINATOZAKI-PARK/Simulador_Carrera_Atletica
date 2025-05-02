import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

public class AthleticRaceInterface {
   private List<Runner> corredores = new ArrayList<>(5);
   private JFrame frame;
   // parte 1: un campo de texto y un botón para registrar a los corredores en el sistema
   private JTextField runnerNameField;
   private JButton registerButton;
    // parte 2: un JTextArea que muestra los participantes registrados hasta el momento.
   private JTextArea participantes;
    // parte 3: un JTextArea que muestra el orden de llegada de los competidores
   private JTextArea tableroRunners;
   private JButton initButton;
   private JButton rebootButton;
   private JButton finishButton;


   public AthleticRaceInterface(){

// Crear y configurar la ventana principal
      frame = new JFrame("Carrera Atlética - TAP-R5-U3");
      frame.setSize(600, 750);
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLayout(new BorderLayout(10, 10));

      // La número 1: un campo de texto y un botón para registrar a los corredores en el sistema
// Panel para el registro de corredores con layout vertical
      JPanel registroPanel = new JPanel();
         registroPanel.setLayout(new BoxLayout(registroPanel, BoxLayout.Y_AXIS));
         registroPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

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
      registroPanel.add(registroCorredoresLabel); // Título
      registroPanel.add(Box.createRigidArea(new Dimension(0, 5))); // Espacio entre título y campo de texto
      registroPanel.add(inputButtonPanel); // Panel de entrada


/*
*
*
* Logica bien verga de la parte 1
*
*
*
* */


// La número 2: es un JTextArea que muestra los participantes registrados hasta el momento.

      JPanel corredoresPanel = new JPanel();
         corredoresPanel.setLayout(new BoxLayout(corredoresPanel, BoxLayout.Y_AXIS));
         corredoresPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

      JLabel corredoresLabel = new JLabel("Corredores registrados");
         corredoresLabel.setFont(new Font("Arial", Font.BOLD, 16));
         corredoresLabel.setAlignmentX(Component.LEFT_ALIGNMENT);


      participantes = new JTextArea(10, 30);
         participantes.setEditable(false);
         participantes.setFont(new Font("Arial", Font.PLAIN, 14));
         participantes.setLineWrap(true); // para que se ajuste el texto
         participantes.setWrapStyleWord(true); // para que no se corte la palabra

      JScrollPane scroll = new JScrollPane(participantes);
         scroll.setAlignmentX(Component.LEFT_ALIGNMENT);
         scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);


      corredoresPanel.add(corredoresLabel);
      corredoresPanel.add(Box.createRigidArea(new Dimension(0, 5)));
      corredoresPanel.add(scroll);



      /* Panel de control de la carrera
       * Consiste en:
       * 1. JTextArea para mostrar el orden de llegada de los competidores
       * 2. Tres botones:
       *    - Iniciar carrera
       *    - Reiniciar carrera
       *    - Salir del programa
       */
      initButton = new JButton("Iniciar");
      initButton.setFont(new Font("Arial", Font.PLAIN, 14));
      initButton.setAlignmentX(Component.LEFT_ALIGNMENT);

      rebootButton = new JButton("Reiniciar");
      rebootButton.setFont(new Font("Arial", Font.PLAIN, 14));
      rebootButton.setAlignmentX(Component.LEFT_ALIGNMENT);

      finishButton = new JButton("Terminar");
      finishButton.setFont(new Font("Arial", Font.PLAIN, 14));
      finishButton.setAlignmentX(Component.LEFT_ALIGNMENT);

      JPanel buttonPanel = new JPanel();
      buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
      //buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
      buttonPanel.add(Box.createHorizontalGlue());

      buttonPanel.add(initButton);
      buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));  // Espacio fijo
      buttonPanel.add(rebootButton);
      buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));  // Espacio fijo
      buttonPanel.add(finishButton);


// Panel de control con BorderLayout para mejor distribución
      JPanel controlCarrera = new JPanel(new BorderLayout(10, 10));
      controlCarrera.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

      JLabel controlLabel = new JLabel("Resultados de la carrera");
        controlLabel.setFont(new Font("Arial", Font.BOLD, 16));
        controlLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

// Panel superior con label y botones
      JPanel topPanel = new JPanel(new BorderLayout());
      topPanel.add(controlLabel, BorderLayout.WEST);
      topPanel.add(buttonPanel, BorderLayout.EAST);

// JTextArea más grande
      tableroRunners = new JTextArea(15, 40);
      tableroRunners.setEditable(false);
      tableroRunners.setFont(new Font("Arial", Font.PLAIN, 14));
      tableroRunners.setLineWrap(true);
      tableroRunners.setWrapStyleWord(true);

      JScrollPane scroll2 = new JScrollPane(tableroRunners);
      scroll2.setPreferredSize(new Dimension(500, 300));


      controlCarrera.add(topPanel, BorderLayout.NORTH);
      controlCarrera.add(scroll2, BorderLayout.CENTER);


   /*   JPanel controlCarrera = new JPanel();
         controlCarrera.setLayout(new BoxLayout(controlCarrera, BoxLayout.Y_AXIS));
         controlCarrera.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

      tableroRunners = new JTextArea(15, 40);
      tableroRunners.setEditable(false);
      tableroRunners.setFont(new Font("Arial", Font.PLAIN, 14));
      tableroRunners.setLineWrap(true);
      tableroRunners.setWrapStyleWord(true);


*/
// Agregar panel de registro a la ventana
      frame.add(registroPanel, BorderLayout.NORTH);
      frame.add(corredoresPanel, BorderLayout.CENTER);
      frame.add(controlCarrera, BorderLayout.SOUTH);

// Centrar y mostrar la ventana
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      new AthleticRaceInterface();
   }
}
