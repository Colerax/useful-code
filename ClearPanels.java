package util;

public class ClearPanels {

    /**
     * Método que limpia los datos de todos los componentes susceptibles de ser
     * puestos en blanco, como los "JTextField" "jTextAreas", etc…, que
     * pertenezcan a un "JPanel" o "JScrollPane", es recursivo, asi que si
     * dentro del panel hay otro panel con más componentes susceptibles también
     * los pondrá en blanco.
     */
    public static void clearForm(Object panel) {
        // Obtenemos el nombre de la clase
        String nombre_clase = panel.getClass().getName();
        if (nombre_clase.equals("javax.swing.JPanel")) {
            // Estamos en el caso de un JPanel
            clearPanel((javax.swing.JPanel) panel);
        } else if (nombre_clase.equals("javax.swing.JScrollPane")) {
            // Estamos en el caso de un JScrollPane
            clearScrollPane((javax.swing.JScrollPane) panel);
        }
    }

    /**
     * Método que limpia los datos de todos los componentes susceptibles de ser
     * puestos en blanco, como los "JTextField" "jTextAreas", etc…, que
     * pertenezcan a un "JPanel", es recursivo, asi que si dentro del panel hay
     * otro panel con más componentes susceptibles también los pondrá en blanco.
     */
    public static void clearPanel(javax.swing.JPanel panel) {
        // Obtenemos todos los componentes que cuelgan del panel
        java.awt.Component[] componentes = panel.getComponents();
        for (int i = 0; i < componentes.length; i++) {
            clearComponent(componentes[i]);
        }
    }

    /**
     * Método que limpia los datos de todos los componentes susceptibles de ser
     * puestos en blanco, como los "JTextField" "jTextAreas", etc…, que
     * pertenezcan a un "JScrollPane", es recursivo, asi que si dentro del panel
     * hay otro panel con más componentes susceptibles también los pondrá en
     * blanco.
     */
    public static void clearScrollPane(javax.swing.JScrollPane panel) {
        // Obtenemos todos los componentes que cuelgan del panel
        java.awt.Component[] componentes = panel.getViewport().getComponents();
        for (int i = 0; i < componentes.length; i++) {
            clearComponent(componentes[i]);
        }
    }

    /**
     * Este método al que le pasamos un Componente, comprueba si es susceptible
     * de ser puesto en blanco, si lo es, lo pone en blanco, si en otro caso es
     * un "JPanel" o un "JScrollPane" llamará recursivamente a "clearPanel" o
     * "clearScrollPane"
     */
    public static void clearComponent(java.awt.Component comp) {
        // Nombre de la clase del componente
        String nombre_clase = comp.getClass().getName();
        if (nombre_clase.equals("javax.swing.JTextField")) {
            // Es un JTextField asi que lo ponemos en blanco
            ((javax.swing.JTextField) comp).setText("");
        } else if (nombre_clase.equals("javax.swing.JComboBox")) {
            // Es un JComboBox asi que ponemos el primer elemento
            ((javax.swing.JComboBox) comp).setSelectedIndex(0);
        } else if (nombre_clase.equals("javax.swing.JTextArea")) {
            // Es un JTextArea asi que lo ponemos en blanco
            ((javax.swing.JTextArea) comp).setText("");
        } else if (nombre_clase.equals("javax.swing.JPanel")) {
            // Es un JPanel asi que llamamos a clearPanel
            clearPanel((javax.swing.JPanel) comp);
        } else if (nombre_clase.equals("javax.swing.JScrollPane")) {
            // Es un JScrollPane asi que llamamos a clearScrollPane
            clearScrollPane((javax.swing.JScrollPane) comp);
        }
    }
}
