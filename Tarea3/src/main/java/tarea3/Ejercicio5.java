package tarea3;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ejercicio5 extends JFrame {

    JTextField txtNombre = new JTextField();
    JTextField txtPais = new JTextField();
    JTextField txtOyentes = new JTextField();
    JTextField txtTitulo = new JTextField();
    JTextField txtInterprete = new JTextField();
    JTextField txtDuracion = new JTextField();
    JTextField txtGenero = new JTextField();
    JButton btnCrearArtista = new JButton("Crear Artista");
    JButton btnCrearCancion = new JButton("Crear Canción");
    JTextArea txtAreaResultados = new JTextArea();

    public Ejercicio5() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Registro de Plataforma de Streaming");
        setSize(480, 600);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JLabel l0 = new JLabel("--- Datos del Artista ---");
        l0.setBounds(20, 10, 200, 25);
        JLabel l1 = new JLabel("Nombre:");
        l1.setBounds(20, 40, 150, 25);
        JLabel l2 = new JLabel("País de Origen:");
        l2.setBounds(20, 70, 150, 25);
        JLabel l3 = new JLabel("Oyentes Mensuales:");
        l3.setBounds(20, 100, 150, 25);
        txtNombre.setBounds(190, 40, 230, 25);
        txtPais.setBounds(190, 70, 230, 25);
        txtOyentes.setBounds(190, 100, 230, 25);
        btnCrearArtista.setBounds(160, 135, 140, 30);

        JLabel l4 = new JLabel("--- Datos de la Canción ---");
        l4.setBounds(20, 185, 200, 25);
        JLabel l5 = new JLabel("Título:");
        l5.setBounds(20, 215, 150, 25);
        JLabel l6 = new JLabel("Intérprete (Artista):");
        l6.setBounds(20, 245, 150, 25);
        JLabel l7 = new JLabel("Duración (segundos):");
        l7.setBounds(20, 275, 150, 25);
        JLabel l8 = new JLabel("Género:");
        l8.setBounds(20, 305, 150, 25);
        txtTitulo.setBounds(190, 215, 230, 25);
        txtInterprete.setBounds(190, 245, 230, 25);
        txtDuracion.setBounds(190, 275, 230, 25);
        txtGenero.setBounds(190, 305, 230, 25);
        btnCrearCancion.setBounds(160, 340, 140, 30);

        JLabel l9 = new JLabel("Resultados en Memoria:");
        l9.setBounds(20, 385, 200, 25);
        JScrollPane scroll = new JScrollPane(txtAreaResultados);
        scroll.setBounds(20, 415, 430, 130);

        add(l0); add(l1); add(l2); add(l3);
        add(txtNombre); add(txtPais); add(txtOyentes);
        add(btnCrearArtista);
        add(l4); add(l5); add(l6); add(l7); add(l8);
        add(txtTitulo); add(txtInterprete); add(txtDuracion); add(txtGenero);
        add(btnCrearCancion);
        add(l9);
        add(scroll);

        btnCrearArtista.addActionListener(evt -> btnCrearArtistaActionPerformed());
        btnCrearCancion.addActionListener(evt -> btnCrearCancionActionPerformed());
    }

    private void btnCrearArtistaActionPerformed() {
        String nombre = txtNombre.getText();
        String pais = txtPais.getText();
        int oyentes = Integer.parseInt(txtOyentes.getText());

        Artista a = new Artista();
        a.nombre = nombre;
        a.paisOrigen = pais;
        a.oyentesMensuales = oyentes;

        txtAreaResultados.append("ARTISTA: " + a.nombre + " | País: " + a.paisOrigen
                + " | Oyentes: " + a.oyentesMensuales + "\n");

        txtNombre.setText("");
        txtPais.setText("");
        txtOyentes.setText("");
    }

    private void btnCrearCancionActionPerformed() {
        String titulo = txtTitulo.getText();
        String interprete = txtInterprete.getText();
        int duracion = Integer.parseInt(txtDuracion.getText());
        String genero = txtGenero.getText();

        Cancion c = new Cancion();
        c.titulo = titulo;
        c.nombreArtista = interprete;
        c.duracionSegundos = duracion;
        c.genero = genero;

        txtAreaResultados.append("CANCIÓN: " + c.titulo + " | Artista: " + c.nombreArtista
                + " | Duración: " + c.duracionSegundos + " seg | Género: " + c.genero + "\n");

        txtTitulo.setText("");
        txtInterprete.setText("");
        txtDuracion.setText("");
        txtGenero.setText("");
    }

    public static void main(String[] args) {
        new Ejercicio5().setVisible(true);
    }
}
