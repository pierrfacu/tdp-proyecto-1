package gui;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;
	private JTextField dLU;
	private JTextField dAp;
	private JTextField dNom;
	private JTextField dMail;
	private JTextField dGit;
    private JLabel ldFecha;
    private JLabel fotoAlum;

	public SimplePresentationScreen(Student studentData) {
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentación");
		Image iconVentana = new ImageIcon(getClass().getResource("/images/tdp.png")).getImage();
		setIconImage(iconVentana);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(601, 250));
		setResizable(false);
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		init();
		fechaEjecucion();
		muestraDatos();
	}
	
	private void init() {
		contentPane.setLayout(null);
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 430, 180);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 200));
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la información declarada por el alumno");
		tabInformation.setLayout(null);
		
		JLabel lblLu = new JLabel("LU");
		lblLu.setBounds(12, 12, 93, 15);
		tabInformation.add(lblLu);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(12, 39, 93, 15);
		tabInformation.add(lblApellido);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(12, 66, 93, 15);
		tabInformation.add(lblNombre);
		
		JLabel lblEmail = new JLabel("E-Mail");
		lblEmail.setBounds(12, 93, 93, 15);
		tabInformation.add(lblEmail);
		
		JLabel lblGithubUrl = new JLabel("Github URL");
		lblGithubUrl.setBounds(12, 120, 93, 15);
		tabInformation.add(lblGithubUrl);
		
		dLU = new JTextField();
		dLU.setEditable(false);
		dLU.setBounds(123, 10, 290, 19);
		tabInformation.add(dLU);
		dLU.setColumns(10);
		
		dAp = new JTextField();
		dAp.setEditable(false);
		dAp.setBounds(123, 37, 290, 19);
		tabInformation.add(dAp);
		dAp.setColumns(10);
		
		dNom = new JTextField();
		dNom.setEditable(false);
		dNom.setBounds(123, 64, 290, 19);
		tabInformation.add(dNom);
		dNom.setColumns(10);
		
		dMail = new JTextField();
		dMail.setEditable(false);
		dMail.setBounds(123, 91, 290, 19);
		tabInformation.add(dMail);
		dMail.setColumns(10);
		
		dGit = new JTextField();
		dGit.setEditable(false);
		dGit.setBounds(123, 118, 290, 19);
		tabInformation.add(dGit);
		dGit.setColumns(10);
		contentPane.add(tabbedPane);
		
		ldFecha = new JLabel("");
		ldFecha.setBounds(15, 194, 420, 15);
		contentPane.add(ldFecha);
		
		fotoAlum = new JLabel("");
		fotoAlum.setBounds(453, 23, 136, 162);
		contentPane.add(fotoAlum);
	}
	
	private void muestraDatos() {
		dLU.setText(studentData.getId()+"");
		dAp.setText(studentData.getLastName());
		dNom.setText(studentData.getFirstName());
		dMail.setText(studentData.getMail());
		dGit.setText(studentData.getGithubURL());
		fotoAlum.setIcon(new ImageIcon(this.getClass().getResource(studentData.getPathPhoto())));
	}
	
	private void fechaEjecucion() {
		String hora = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
		String fecha = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
		ldFecha.setText("Esta ventana fue generada el "+ fecha +" a las "+ hora);
	}
}
