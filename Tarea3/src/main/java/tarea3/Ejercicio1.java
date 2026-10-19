package tarea3;

import java.io.FileWriter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Ejercicio1 extends JFrame {

    double[] rutas = new double[7];
    int indice = 0;

    JTextField txtKilometraje = new JTextField();
    JButton btnAgregarRuta = new JButton("Agregar Ruta");
    JButton btnGenerarReporte = new JButton("Generar Reporte");

    public Ejercicio1() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Kilometraje Semanal");
        setSize(320, 180);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JLabel lbl = new JLabel("Kilometros:");
        lbl.setBounds(20, 20, 80, 25);
        txtKilometraje.setBounds(110, 20, 150, 25);
        btnAgregarRuta.setBounds(20, 70, 120, 30);
        btnGenerarReporte.setBounds(150, 70, 130, 30);

        add(lbl);
        add(txtKilometraje);
        add(btnAgregarRuta);
        add(btnGenerarReporte);

        btnAgregarRuta.addActionListener(evt -> btnAgregarRutaActionPerformed());
        btnGenerarReporte.addActionListener(evt -> btnGenerarReporteActionPerformed());
    }

    private void btnAgregarRutaActionPerformed() {
        if (indice < 7) {
            rutas[indice] = Double.parseDouble(txtKilometraje.getText());
            indice++;
            txtKilometraje.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Ya ingresaste los 7 recorridos");
        }
    }

    private void btnGenerarReporteActionPerformed() {
        if (indice < 7) {
            JOptionPane.showMessageDialog(this, "Faltan recorridos por ingresar");
            return;
        }

        double total = 0;
        for (int i = 0; i < 7; i++) {
            total = total + rutas[i];
        }
        double promedio = total / 7;
        promedio = Math.round(promedio * 100) / 100.0;

        try {
            FileWriter fw = new FileWriter("temp/andru_reporte_rutas.txt");
            fw.write("Reporte Semanal de Rutas\n");
            fw.write("Total de Kilómetros: " + total + "\n");
            fw.write("Promedio Diario: " + promedio + "\n");
            fw.close();
            JOptionPane.showMessageDialog(this, "Reporte generado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Ejercicio1().setVisible(true);
    }
}
