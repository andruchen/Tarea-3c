package tarea3;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Ejercicio4 extends JFrame {

    // arreglos paralelos
    String[] titulos = new String[5];
    int[] anios = new int[5];

    JTextField txtBuscar = new JTextField();
    JTextField txtNuevoAnio = new JTextField();
    JButton btnBuscar = new JButton("Buscar");
    JButton btnActualizar = new JButton("Actualizar Registro");
    JLabel lblAnio = new JLabel("Año actual: ");

    public Ejercicio4() {
        initComponents();
        leerArchivo();
    }

    private void initComponents() {
        setTitle("Biblioteca de Discos Musicales");
        setSize(380, 260);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JLabel lbl1 = new JLabel("Buscar Álbum:");
        lbl1.setBounds(20, 20, 100, 25);
        txtBuscar.setBounds(130, 20, 200, 25);
        btnBuscar.setBounds(130, 55, 100, 28);
        lblAnio.setBounds(20, 95, 300, 25);
        JLabel lbl2 = new JLabel("Nuevo Año:");
        lbl2.setBounds(20, 130, 100, 25);
        txtNuevoAnio.setBounds(130, 130, 200, 25);
        btnActualizar.setBounds(130, 165, 160, 28);

        add(lbl1);
        add(txtBuscar);
        add(btnBuscar);
        add(lblAnio);
        add(lbl2);
        add(txtNuevoAnio);
        add(btnActualizar);

        btnBuscar.addActionListener(evt -> btnBuscarActionPerformed());
        btnActualizar.addActionListener(evt -> btnActualizarActionPerformed());
    }

    // lee el archivo cuando se abre la ventana
    private void leerArchivo() {
        try {
            File archivo = new File("temp/discos.csv");
            Scanner sc = new Scanner(archivo);
            int i = 0;
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String[] partes = linea.split(",");
                titulos[i] = partes[0];
                anios[i] = Integer.parseInt(partes[1]);
                i++;
            }
            sc.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    private void btnBuscarActionPerformed() {
        String buscado = txtBuscar.getText();
        boolean encontrado = false;

        for (int i = 0; i < titulos.length; i++) {
            if (titulos[i].equalsIgnoreCase(buscado)) {
                lblAnio.setText("Año actual: " + anios[i]);
                encontrado = true;
            }
        }

        if (encontrado == false) {
            lblAnio.setText("Año actual: no encontrado");
        }
    }

    private void btnActualizarActionPerformed() {
        String buscado = txtBuscar.getText();
        int posicion = -1;

        for (int i = 0; i < titulos.length; i++) {
            if (titulos[i].equalsIgnoreCase(buscado)) {
                posicion = i;
            }
        }

        if (posicion == -1) {
            JOptionPane.showMessageDialog(this, "No se encontró el álbum");
            return;
        }

        anios[posicion] = Integer.parseInt(txtNuevoAnio.getText());

        try {
            FileWriter fw = new FileWriter("temp/discos.csv", false);
            for (int i = 0; i < titulos.length; i++) {
                fw.write(titulos[i] + "," + anios[i] + "\n");
            }
            fw.close();
            lblAnio.setText("Año actual: " + anios[posicion]);
            JOptionPane.showMessageDialog(this, "Registro actualizado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Ejercicio4().setVisible(true);
    }
}
