package tarea3;

import java.io.FileWriter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ejercicio2 extends JFrame {

    String[] tareas = new String[5];
    int indice = 0;

    JTextField txtTarea = new JTextField();
    JTextArea txtAreaTareas = new JTextArea();
    JButton btnAgregarTarea = new JButton("Agregar Tarea");
    JButton btnExportarAgenda = new JButton("Exportar Agenda");

    public Ejercicio2() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Gestor de Tareas Pendientes");
        setSize(400, 350);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JLabel lbl = new JLabel("Tarea:");
        lbl.setBounds(20, 20, 50, 25);
        txtTarea.setBounds(70, 20, 290, 25);
        btnAgregarTarea.setBounds(20, 60, 160, 30);
        btnExportarAgenda.setBounds(200, 60, 160, 30);

        JScrollPane scroll = new JScrollPane(txtAreaTareas);
        scroll.setBounds(20, 110, 340, 180);

        add(lbl);
        add(txtTarea);
        add(btnAgregarTarea);
        add(btnExportarAgenda);
        add(scroll);

        btnAgregarTarea.addActionListener(evt -> btnAgregarTareaActionPerformed());
        btnExportarAgenda.addActionListener(evt -> btnExportarAgendaActionPerformed());
    }

    private void btnAgregarTareaActionPerformed() {
        if (indice < 5) {
            tareas[indice] = txtTarea.getText();
            txtAreaTareas.append((indice + 1) + ". " + tareas[indice] + "\n");
            indice++;
            txtTarea.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Ya ingresaste las 5 tareas");
        }
    }

    private void btnExportarAgendaActionPerformed() {
        if (indice < 5) {
            JOptionPane.showMessageDialog(this, "Faltan tareas por ingresar");
            return;
        }

        try {
            FileWriter fw = new FileWriter("temp/andru_agenda.txt");
            fw.write("Agenda de Tareas\n");
            for (int i = 0; i < 5; i++) {
                fw.write((i + 1) + ". " + tareas[i] + "\n");
            }
            fw.close();
            JOptionPane.showMessageDialog(this, "Agenda exportada");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Ejercicio2().setVisible(true);
    }
}
