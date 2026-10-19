package tarea3;

import java.io.File;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ejercicio3 extends JFrame {

    double[] temperaturas = new double[6];
    int indice = 0;
    String ruta = "temp/temperaturas.txt";

    JButton btnCargarDatos = new JButton("Cargar Datos");
    JButton btnCalcularEstadisticas = new JButton("Calcular Estadísticas");
    JTextArea txtAreaResultados = new JTextArea();

    public Ejercicio3() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Analizador de Temperaturas");
        setSize(400, 330);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        btnCargarDatos.setBounds(20, 20, 160, 30);
        btnCalcularEstadisticas.setBounds(200, 20, 170, 30);

        JScrollPane scroll = new JScrollPane(txtAreaResultados);
        scroll.setBounds(20, 70, 350, 190);

        add(btnCargarDatos);
        add(btnCalcularEstadisticas);
        add(scroll);

        btnCargarDatos.addActionListener(evt -> btnCargarDatosActionPerformed());
        btnCalcularEstadisticas.addActionListener(evt -> btnCalcularEstadisticasActionPerformed());
    }

    private void btnCargarDatosActionPerformed() {
        try {
            File archivo = new File(ruta);
            Scanner sc = new Scanner(archivo);
            indice = 0;
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                temperaturas[indice] = Double.parseDouble(linea);
                indice++;
            }
            sc.close();
            JOptionPane.showMessageDialog(this, "Datos cargados en memoria");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    private void btnCalcularEstadisticasActionPerformed() {
        double suma = 0;
        int calidos = 0;
        int frescos = 0;

        for (int i = 0; i < temperaturas.length; i++) {
            suma = suma + temperaturas[i];
            if (temperaturas[i] >= 25.0) {
                calidos++;
            } else {
                frescos++;
            }
        }
        double promedio = suma / temperaturas.length;
        promedio = Math.round(promedio * 100) / 100.0;

        txtAreaResultados.setText("Análisis Climático\n");
        txtAreaResultados.append("------------------\n");
        txtAreaResultados.append("Promedio de Temperatura: " + promedio + "\n");
        txtAreaResultados.append("Días Cálidos (>= 25°): " + calidos + "\n");
        txtAreaResultados.append("Días Frescos (< 25°): " + frescos + "\n");
    }

    public static void main(String[] args) {
        new Ejercicio3().setVisible(true);
    }
}
