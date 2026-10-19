package tarea3;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ejercicio6 extends JFrame {

    ArrayList<Videojuego> catalogo = new ArrayList<>();

    JTextField txtTitulo = new JTextField();
    JTextField txtConsola = new JTextField();
    JTextField txtAnio = new JTextField();
    JButton btnAgregar = new JButton("Agregar Juego");
    JButton btnMostrar = new JButton("Mostrar Catálogo");
    JButton btnEliminar = new JButton("Eliminar Último");
    JTextArea txtAreaInventario = new JTextArea();

    public Ejercicio6() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Catálogo de Videojuegos");
        setSize(500, 450);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JLabel l1 = new JLabel("Título del Juego:");
        l1.setBounds(20, 20, 140, 25);
        JLabel l2 = new JLabel("Consola:");
        l2.setBounds(20, 55, 140, 25);
        JLabel l3 = new JLabel("Año de Lanzamiento:");
        l3.setBounds(20, 90, 140, 25);
        txtTitulo.setBounds(170, 20, 250, 25);
        txtConsola.setBounds(170, 55, 250, 25);
        txtAnio.setBounds(170, 90, 250, 25);

        btnAgregar.setBounds(20, 135, 140, 30);
        btnMostrar.setBounds(170, 135, 150, 30);
        btnEliminar.setBounds(330, 135, 140, 30);

        JLabel l4 = new JLabel("Inventario Actual:");
        l4.setBounds(20, 180, 200, 25);
        JScrollPane scroll = new JScrollPane(txtAreaInventario);
        scroll.setBounds(20, 210, 450, 180);

        add(l1); add(l2); add(l3);
        add(txtTitulo); add(txtConsola); add(txtAnio);
        add(btnAgregar); add(btnMostrar); add(btnEliminar);
        add(l4);
        add(scroll);

        btnAgregar.addActionListener(evt -> btnAgregarActionPerformed());
        btnMostrar.addActionListener(evt -> btnMostrarActionPerformed());
        btnEliminar.addActionListener(evt -> btnEliminarActionPerformed());
    }

    private void btnAgregarActionPerformed() {
        String titulo = txtTitulo.getText();
        String consola = txtConsola.getText();
        int anio = Integer.parseInt(txtAnio.getText());

        Videojuego v = new Videojuego(titulo, consola, anio);
        catalogo.add(v);

        txtTitulo.setText("");
        txtConsola.setText("");
        txtAnio.setText("");
    }

    private void btnMostrarActionPerformed() {
        txtAreaInventario.setText("");
        for (int i = 0; i < catalogo.size(); i++) {
            Videojuego v = catalogo.get(i);
            txtAreaInventario.append((i + 1) + ". " + v.titulo + " - " + v.consola
                    + " - " + v.anioLanzamiento + "\n");
        }
        txtAreaInventario.append("\nTotal de juegos: " + catalogo.size());
    }

    private void btnEliminarActionPerformed() {
        if (catalogo.size() > 0) {
            catalogo.remove(catalogo.size() - 1);
            JOptionPane.showMessageDialog(this, "Se eliminó el último juego");
        } else {
            JOptionPane.showMessageDialog(this, "No hay juegos en el catálogo");
        }
    }

    public static void main(String[] args) {
        new Ejercicio6().setVisible(true);
    }
}
