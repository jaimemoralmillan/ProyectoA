package com.proyecto_a.ui;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(() -> {
            MonitorizacionGUI gui = new MonitorizacionGUI();
            gui.setVisible(true);
        });
    }
}
