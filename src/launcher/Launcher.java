package launcher;

import entities.Student;
import gui.SimplePresentationScreen;

public class Launcher {
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	Student alumno = new Student(99694, "Pierrestegui", "Facundo", "facu.pierr@gmail.com", "https://github.com/pierrfacu", "/images/fotoAlum.png");
            	SimplePresentationScreen interfaz = new SimplePresentationScreen(alumno);
            	interfaz.setVisible(true);
            }
        });
    }
}