package com.ppt.api;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class JuegoGUI1 extends JFrame {
    private JTextField nombreField;
    private JTextArea resultadoArea;

    public JuegoGUI1() {
        setTitle("Piedra, Papel o Tijera - API");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        nombreField = new JTextField(20);
        JButton crearJugadorBtn = new JButton("Crear jugador");

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Nombre:"));
        topPanel.add(nombreField);
        topPanel.add(crearJugadorBtn);

        JPanel botones = new JPanel();
        JButton piedraBtn = new JButton("Piedra");
        JButton papelBtn = new JButton("Papel");
        JButton tijeraBtn = new JButton("Tijera");
        JButton verRankingBtn = new JButton("Ver ranking");
        botones.add(piedraBtn);
        botones.add(papelBtn);
        botones.add(tijeraBtn);
        botones.add(verRankingBtn);

        resultadoArea = new JTextArea(10, 50);
        resultadoArea.setEditable(false);
        resultadoArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(resultadoArea);

        add(topPanel, BorderLayout.NORTH);
        add(botones, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        crearJugadorBtn.addActionListener(e -> {
            String nombre = nombreField.getText();
            String res = enviarPOST("http://localhost:8080/jugadores?nombre=" + nombre);
            resultadoArea.setText("Jugador creado: " + nombre + "\n\n" + res);
        });

        piedraBtn.addActionListener(e -> jugar("PIEDRA"));
        papelBtn.addActionListener(e -> jugar("PAPEL"));
        tijeraBtn.addActionListener(e -> jugar("TIJERA"));

        verRankingBtn.addActionListener(e -> {
            String ranking = enviarGET("http://localhost:8080/ranking");
            resultadoArea.setText("Ranking actual:\n\n" + ranking);
        });
    }

    private void jugar(String movimiento) {
        String nombre = nombreField.getText();
        String url = "http://localhost:8080/jugar/contra-pc?nombre=" + nombre + "&movimiento=" + movimiento;
        String res = enviarPOST(url);
        resultadoArea.setText("Resultado de la partida:\n\n" + res);
    }

    private String enviarPOST(String urlStr) {
        try {
            URL url = new URL(urlStr);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            Scanner scanner = new Scanner(con.getInputStream()).useDelimiter("\\A");
            return scanner.hasNext() ? scanner.next() : "Sin respuesta";
        } catch (IOException e) {
            return "Error: " + e.getMessage();
        }
    }

    private String enviarGET(String urlStr) {
        try {
            URL url = new URL(urlStr);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            Scanner scanner = new Scanner(con.getInputStream()).useDelimiter("\\A");
            return scanner.hasNext() ? scanner.next() : "Sin respuesta";
        } catch (IOException e) {
            return "Error: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JuegoGUI1 gui = new JuegoGUI1();
            gui.setVisible(true);
        });
    }
}