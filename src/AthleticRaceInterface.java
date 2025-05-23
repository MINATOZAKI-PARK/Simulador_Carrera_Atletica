import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;


public class AthleticRaceInterface{
    // Lista para almacenar los corredores participantes
    public static final int MAX = 5;
    public static final List<Runner> corredores = new ArrayList<>(MAX);

    public static JLabel label(String etiqueta){
        JLabel jlabel = new JLabel(etiqueta);
        jlabel.setFont(new Font("Arial", Font.BOLD, 16));
        jlabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        return jlabel;
    }

    public static JButton button(String etiqueta){
        JButton button = new JButton(etiqueta);
        button.setFont(new Font("Arial", Font.PLAIN, 14));
        button.setAlignmentX(Component.LEFT_ALIGNMENT);
        return button;
    }

    public static JTextArea textArea(){
        JTextArea textArea = new JTextArea(10, 30);
        textArea.setEditable(false);
        textArea.setFont(new Font("Arial", Font.PLAIN, 14));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        return textArea;
    }

    public static void main(String[] args) {
        // Crear y configurar la ventana principal
        JFrame frame = new JFrame("Carrera Atlética - TAP-R5-U3");
        frame.setSize(600, 750);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));

        // Configuración del panel de registro de corredores
        JPanel registroPanel = new JPanel();
        registroPanel.setLayout(new BoxLayout(registroPanel, BoxLayout.Y_AXIS));
        registroPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Título del panel de registro
        JLabel registroCorredoresLabel = label("Registro de corredores");

        // Panel para campo de texto y botón de registro
        JPanel inputButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        inputButtonPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Configuración del campo de texto para nombre
        JTextField runnerNameField = new JTextField(20);
        runnerNameField.setFont(new Font("Arial", Font.PLAIN, 14));

        // Configuración del botón de registro
        JButton registerButton = button("Agregar");

        // Agregar componentes al panel de entrada
        inputButtonPanel.add(new JLabel("Nombre: "));
        inputButtonPanel.add(runnerNameField);
        inputButtonPanel.add(registerButton);

        // Construir panel de registro completo
        registroPanel.add(registroCorredoresLabel);
        registroPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        registroPanel.add(inputButtonPanel);


        // Panel que muestra la lista de corredores registrados
        JPanel corredoresPanel = new JPanel();
        corredoresPanel.setLayout(new BoxLayout(corredoresPanel, BoxLayout.Y_AXIS));
        corredoresPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel corredoresLabel = label("Corredores registrados");

        // Área de texto para mostrar participantes
        JTextArea participantes = textArea();

        // Scroll para el área de participantes
        JScrollPane scroll = new JScrollPane(participantes);
        scroll.setAlignmentX(Component.LEFT_ALIGNMENT);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        corredoresPanel.add(corredoresLabel);
        corredoresPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        corredoresPanel.add(scroll);

        // Configuración de botones de control
        JButton initButton = button("Iniciar");
        JButton rebootButton = button("Reiniciar");
        JButton finishButton = button("Terminar");


// ActionListener para agregar nuevos corredores
        ActionListener addText = e -> {
            // Obtener el texto del campo de nombre y eliminar espacios
            String text = runnerNameField.getText().trim();
            // Verificar que el texto no esté vacío y no se haya alcanzado el máximo de corredores
            if (!text.isEmpty() && corredores.size() < MAX) {
                int puesto = corredores.size()+1; // segun el tamaño de la lista de corredores
                // Crear nuevo corredor y agregarlo a la lista
                Runner runner = new Runner(text);
                corredores.add(runner);
                // Mostrar el nombre en el área de participantes

                participantes.append(puesto+"- "+text + "\n");
                // Limpiar el campo de texto
                runnerNameField.setText("");


                // Verificar si ya alcanzamos el máximo de corredores
                if (corredores.size() >= MAX) {
                    // Deshabilitar controles de registro
                    registerButton.setEnabled(false);
                    runnerNameField.setEnabled(false);
                    // Mostrar mensaje de límite alcanzado
                    JOptionPane.showMessageDialog(null, "Se ha alcanzado el límite de " + MAX + " corredores",
                            "Límite alcanzado", JOptionPane.INFORMATION_MESSAGE);
                }
            }

        };

// Agregar el listener al botón y al campo de texto
        registerButton.addActionListener(addText);
        runnerNameField.addActionListener(addText);

        // Panel para los botones de control
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        buttonPanel.add(Box.createHorizontalGlue());

        buttonPanel.add(initButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPanel.add(rebootButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPanel.add(finishButton);

        // Panel de control para resultados
        JPanel controlCarrera = new JPanel(new BorderLayout(10, 10));
        controlCarrera.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel controlLabel = label("Control de carrera");

        // Panel superior para título y botones
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(controlLabel, BorderLayout.WEST);
        topPanel.add(buttonPanel, BorderLayout.EAST);

        // Área de texto para mostrar resultados
        JTextArea tableroRunners = textArea();

        JScrollPane scroll2 = new JScrollPane(tableroRunners);
        scroll2.setPreferredSize(new Dimension(500, 300));

        controlCarrera.add(topPanel, BorderLayout.NORTH);
        controlCarrera.add(scroll2, BorderLayout.CENTER);


        ActionListener start = e ->{
            for (Runner kD: corredores){
                Thread once = new Thread(new ThreadRunner(kD, tableroRunners));
                once.start();
            }
        };

        initButton.addActionListener(start);
        // boton de reiniciar
        rebootButton.addActionListener(e -> tableroRunners.setText(""));
        // cierre de ventana (pero con exprecion lambda)
        finishButton.addActionListener(e -> System.exit(0));

        // Agregar todos los paneles al frame principal
        frame.add(registroPanel, BorderLayout.NORTH);
        frame.add(corredoresPanel, BorderLayout.CENTER);
        frame.add(controlCarrera, BorderLayout.SOUTH);

        // Mostrar ventana
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}