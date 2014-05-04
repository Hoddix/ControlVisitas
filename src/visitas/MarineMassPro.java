package visitas;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.awt.Font;
import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class MarineMassPro extends JFrame implements ActionListener{
	
	static Object[] focusList;
	static int focusNumber;
	ImageIcon buscarfcp,anadirfcp,eliminarfcp,editarfcp,anadirfcpmenu, edit ,clientenuevomenu, delete, printer, save, bacup, add, salir, key, lock;
	Font titleFont;
	Font titleFont2;
	Color rojo;
	Color verde;
	
	//Barra de menus
	static JMenuBar menuBarra;
	static JMenu menuClientes, menuEdicion, menuLock;
	static JMenuItem menuAnadir, menuEditar, menuLocker;
	
	//Panel Pass
		JPanel panelPass;
		JLabel pass, titulo, titulo2, titulo3, labellogo1, labellogo2, labellogo21;
		JPasswordField txtpass;
		JButton iniciarSesion;	
		File logoA, logoFS, logo1, logo2;
		Image imagenA, imagenFS, imagen1, imagen2;
	
	//Panel Añadir clientes
		static JLabel atitulo, atitulo2, atitulo3, alabel1, alabel2, alabel3, alabel4, alabel5, alabel6, alabel7, alabel8, alabel9, alabel10;
		static JLabel alabel11, alabel12, alabel13, alabel14, alabel15, alabel16, alabel17, alabel18;
		static JLabel alabellogo1, alabellogo2, alabellogo11, alabellogo21, adate, acontador;
		static JTextField atext1, atext2, atext3, atext4, atext5, atext6, atext7, atext8, atext10, atext11, atext12, atext14;
		static JTextField atextdate, atextcontador;
		static JTextArea atextarea16;
		static JScrollPane atextareaScroll;
		@SuppressWarnings("rawtypes")
		static JComboBox acombo8, acombo9, acombo13, acombo15;
		
		static JPanel apanel;
		static JButton aanadir, aimprimir, aclear, asave, aedit, abackup; 
		File alogoA, alogoFS, alogo1, alogo2;
		Image aimagenA, aimagenFS, aimagen1, aimagen2;
	
		//Tabla lista
		static DefaultTableModel amodeloTablaLista;
		static JTable atablaLista; 			
		static JScrollPane atablaListaScroll; 

	//Panel Editar clientes
		static JLabel etitulo, etitulo2, etitulo3, elabel1, elabel2, elabel3, elabel4, elabel5, elabel6, elabel7, elabel8, elabel9, elabel10;
		static JLabel elabel11, elabel12, elabel13, elabel14, elabel15, elabel16, elabel17, elabel18;
		static JLabel elabellogo1, elabellogo2, elabellogo11, elabellogo21, edate, econtador;
		static JLabel elabelbuscar,	elabelbuscar2, elabelbuscar3, elabaltitulobuscar;
		static JTextField etextbuscar, etextbuscar2;
		static JTextField etext1, etext2, etext3, etext4, etext5, etext6, etext7, etext10, etext11, etext12, etext14;
		static JTextField etextdate, etextcontador;
		static JTextArea etextarea16;
		static JScrollPane etextareaScroll;
		@SuppressWarnings("rawtypes")
		static JComboBox ecombo8, ecombo9, ecombo13, ecombo15, ecombobuscar, ecombobuscar2;
		
		static JPanel epanel;
		static JButton eactualizar, ebuscar, eborrar, eimprimir, eimprimirLista, esave, eanadir, ebackup; 
		File elogoA, elogoFS, elogo1, elogo2;
		Image eimagenA, eimagenFS, eimagen1, eimagen2;
	
		//Tabla lista
		static DefaultTableModel emodeloTablaLista, emodeloTablaBuscar;
		static JTable etablaLista, etablaBuscar; 			
		static JScrollPane etablaListaScroll, etablaBuscarScroll; 

		//Fecha
		static SimpleDateFormat formateador = new SimpleDateFormat("M'/'d'/'YYYY");
		static Date fechaDate = new Date();
		static String fecha = formateador.format(fechaDate);
		
		static SimpleDateFormat formateadoAnor = new SimpleDateFormat("YYYY");
		static Date fechaAno = new Date();
		static String fechaAnoIf = formateadoAnor.format(fechaAno);
		
		
	@SuppressWarnings({ "rawtypes", "unchecked" })
	MarineMassPro() throws Exception{
		titleFont = new Font("Arial", 0, 22);
		titleFont2 = new Font("Arial", 0, 16);
		rojo = new Color(255,140,140);
		verde = new Color(199,241,173);

		//Imagenes de botones
		buscarfcp=new ImageIcon("img/buscarfcp.png");
		anadirfcp=new ImageIcon("img/anadirfcp.png");
		eliminarfcp=new ImageIcon("img/eliminarfcp.png");
		editarfcp=new ImageIcon("img/editarfcp.png");
		anadirfcpmenu=new ImageIcon("img/anadirfcpmenu.png");
		clientenuevomenu=new ImageIcon("img/clientenuevomenu.png");
		delete = new ImageIcon("img/delete.png");
		printer = new ImageIcon("img/printer.png");
		save = new ImageIcon("img/disk.png");
		bacup = new ImageIcon("img/database_save.png");
		edit = new ImageIcon("img/user_edit.png"); 
		add = new ImageIcon("img/user_add.png"); 
		salir = new ImageIcon("img/door_out.png");
		key = new ImageIcon("img/key.png");
		lock = new ImageIcon("img/lock.png");
		
		//Menu
		menuBarra=new JMenuBar();
		setJMenuBar(menuBarra);
		menuBarra.setVisible(false);
		menuClientes=new JMenu("Visitors");
		menuBarra.add(menuClientes);
		menuAnadir=new JMenuItem("Add visitors",anadirfcpmenu);
		menuClientes.add(menuAnadir);
		menuAnadir.addActionListener(this);
		menuEdicion=new JMenu("Edition");
		menuBarra.add(menuEdicion);
		menuEditar=new JMenuItem("Edit visitors",editarfcp);
		menuEdicion.add(menuEditar);
		menuEditar.addActionListener(this);
		menuLock=new JMenu("Block");
		menuBarra.add(menuLock);
		menuLocker=new JMenuItem("Block program",lock);
		menuLock.add(menuLocker);
		menuLocker.addActionListener(this);
		
		//Panel PASSWORDS//
		panelPass = new JPanel();

		//Labels
		titulo = new JLabel("Enter the password to login:");
		pass = new JLabel("Password: ");
		//TextField
		txtpass = new JPasswordField(); //Efecto Cookie, Posteriormente es posible realizar IO con un txt con columnas.//
		//Boton
		iniciarSesion = new JButton("Login",key);
		
		//Logo astondoa
		logoA = new File("img/astondoalogo.jpg");
	    imagenA = ImageIO.read(logoA);
	    ImageIcon iconoA = new ImageIcon(imagenA);
		ImageIcon iconorA = new ImageIcon(iconoA.getImage().getScaledInstance(250, 79, Image.SCALE_SMOOTH));
		labellogo1 = new JLabel(iconorA);	
		
		//Logo FS
		logoFS = new File("img/flagshiplogo.jpg");
	    imagenFS = ImageIO.read(logoFS);
	    ImageIcon iconoFS = new ImageIcon(imagenFS);
		ImageIcon iconorFS = new ImageIcon(iconoFS.getImage().getScaledInstance(250, 96, Image.SCALE_SMOOTH));
		labellogo2 = new JLabel(iconorFS);	
		
		//Logo 1
//		alogo1 = new File("img/logo1.jpg");
//	    aimagen1 = ImageIO.read(alogo1);
//	    ImageIcon aicono1 = new ImageIcon(aimagen1);
		
		//Logo 2
		logo2 = new File("img/logo2.jpg");
		imagen2 = ImageIO.read(logo2);
	    ImageIcon icono2 = new ImageIcon(imagen2);
		ImageIcon iconor2 = new ImageIcon(icono2.getImage().getScaledInstance(80, 76, Image.SCALE_SMOOTH));
		
		//Logo 1
//		alabellogo11 = new JLabel(aicono1);

		//Logo 2
		labellogo21 = new JLabel(iconor2);
		
		titulo2 = new JLabel("VISITORS REGISTRATION");
		titulo3 = new JLabel("FORT LAUDERDALE BOAT SHOW 2013");
		
		
		//Panel Añadir
		apanel = new JPanel();
		atitulo = new JLabel("VISITORS REGISTRATION");
		atitulo2 = new JLabel("FORT LAUDERDALE BOAT SHOW 2013");
		//atitulo3 = new JLabel("MIAMI INTERNATIONAL BOAT SHOW 2014");

		adate = new JLabel("Date: ");
		alabel1 = new JLabel("Id: ");
		alabel2 = new JLabel("First name: ");
		alabel3 = new JLabel("Last name: ");
		alabel4 = new JLabel("Company Name: ");
		alabel5 = new JLabel("Email: ");
		alabel6 = new JLabel("Mobile Phone: ");
		alabel7 = new JLabel("Full Address: ");
		alabel8 = new JLabel("Type of visitor: ");
		alabel9 = new JLabel("Boat size: ");
		alabel10 = new JLabel("Brand: ");
		alabel11 = new JLabel("Model: ");
		alabel12 = new JLabel("Year: ");
		alabel13 = new JLabel("Sale Associate: ");
		alabel14 = new JLabel("VIP number: ");
		alabel15 = new JLabel("Rate: ");
		alabel16 = new JLabel("Aditional information: ");
//		alabel17 = new JLabel();
//		alabel18 = new JLabel();
		
		acontador = new JLabel("Number of visitors: ");
		
		atextdate = new JTextField(fecha);
		atext1 = new JTextField();
		atext2 = new JTextField();
		atext3 = new JTextField();
		atext4 = new JTextField();
		atext5 = new JTextField();
		atext6 = new JTextField();
		atext7 = new JTextField();
		
		acombo8 = new JComboBox();
		acombo8.addItem("Select one");
		acombo8.addItem("Yacht Owner");
		acombo8.addItem("Yacht Broker or Sales Associate");
		acombo8.addItem("Yacht Dessigner");
		acombo8.addItem("Yacht Supplier / Manufacturer");
		acombo8.addItem("Yacht Service Provider");
		acombo8.addItem("Yacht Captain");
		acombo8.addItem("Vissiting Press");
		acombo8.addItem("Others");
		acombo8.addActionListener(this);	
		
		acombo9 = new JComboBox();
		acombo9.addItem("Boat size");
		acombo9.addItem("< 60");
		acombo9.addItem("60-80");
		acombo9.addItem("80-100");
		acombo9.addItem("> 100");
		
		atext10 = new JTextField();
		atext11 = new JTextField();
		atext12 = new JTextField();
		
		acombo13 = new JComboBox();
		acombo13.addItem("Select one");
		acombo13.addItem("Juan Serrallés");
		acombo13.addItem("John Gaffen");
		acombo13.addItem("Mike Smally");
		acombo13.addItem("Juan Fiol");
		acombo13.addItem("Rafael Barca");
		acombo13.addItem("Javier Arkotxa");
		acombo13.addItem("Other 1");
		acombo13.addItem("Oyher 2");

		atext14 = new JTextField();
		acombo15 = new JComboBox();
		acombo15.addItem("Select rate");
		acombo15.addItem("*");
		acombo15.addItem("**");
		acombo15.addItem("***");
		acombo15.addItem("****");
		acombo15.addItem("*****");
		
		atextarea16 = new JTextArea();
		atextareaScroll = new JScrollPane(atextarea16);
		
		atextcontador = new JTextField();

		aanadir = new JButton("Add new visitor",anadirfcp);
		aclear = new JButton("Clear",delete);
		aimprimir = new JButton("Print",printer);
		asave = new JButton("Save visitor",save);
		aedit = new JButton("Edit visitor",edit);
		abackup = new JButton("BackUp",bacup);
		
		//Logo astondoa
		alogoA = new File("img/astondoalogo.jpg");
	    aimagenA = ImageIO.read(logoA);
	    ImageIcon aiconoA = new ImageIcon(imagenA);
		ImageIcon aiconorA = new ImageIcon(aiconoA.getImage().getScaledInstance(250, 79, Image.SCALE_SMOOTH));
		alabellogo1 = new JLabel(aiconorA);	
		
		//Logo FS
		alogoFS = new File("img/flagshiplogo.jpg");
	    aimagenFS = ImageIO.read(logoFS);
	    ImageIcon aiconoFS = new ImageIcon(imagenFS);
		ImageIcon aiconorFS = new ImageIcon(aiconoFS.getImage().getScaledInstance(250, 96, Image.SCALE_SMOOTH));
		alabellogo2 = new JLabel(aiconorFS);	
		
		//Logo 1
//		alogo1 = new File("img/logo1.jpg");
//	    aimagen1 = ImageIO.read(alogo1);
//	    ImageIcon aicono1 = new ImageIcon(aimagen1);
		
		//Logo 2
		alogo2 = new File("img/logo2.jpg");
		aimagen2 = ImageIO.read(alogo2);
	    ImageIcon aicono2 = new ImageIcon(aimagen2);
		ImageIcon aiconor2 = new ImageIcon(aicono2.getImage().getScaledInstance(80, 76, Image.SCALE_SMOOTH));
		
		//Logo 1
//		alabellogo11 = new JLabel(aicono1);

		//Logo 2
		alabellogo21 = new JLabel(aiconor2);
		
		//Panel Editar
		epanel = new JPanel();
		etitulo = new JLabel("VISITORS REGISTRATION");
		etitulo2 = new JLabel("FORT LAUDERDALE BOAT SHOW 2013");
		//etitulo3 = new JLabel("MIAMI INTERNATIONAL BOAT SHOW 2014");
		
		elabaltitulobuscar = new JLabel("Search: ");
		edate = new JLabel("Date: ");
		elabel1 = new JLabel("Id: ");
		elabel2 = new JLabel("First name: ");
		elabel3 = new JLabel("Last name: ");
		elabel4 = new JLabel("Company Name: ");
		elabel5 = new JLabel("Email: ");
		elabel6 = new JLabel("Mobile Phone: ");
		elabel7 = new JLabel("Full Address: ");
		elabel8 = new JLabel("Type of visitor: ");
		elabel9 = new JLabel("Boat size: ");
		elabel10 = new JLabel("Brand: ");
		elabel11 = new JLabel("Model: ");
		elabel12 = new JLabel("Year: ");
		elabel13 = new JLabel("Sale Associate: ");
		elabel14 = new JLabel("VIP number: ");
		elabel15 = new JLabel("Rate: ");
		elabel16 = new JLabel("Aditional information: ");
		
		econtador = new JLabel("Number of visitors: ");
		etextcontador = new JTextField();
		
		etextdate = new JTextField(fecha);
		etext1 = new JTextField();
		etext2 = new JTextField();
		etext3 = new JTextField();
		etext4 = new JTextField();
		etext5 = new JTextField();
		etext6 = new JTextField();
		etext7 = new JTextField();
		
		ecombo8 = new JComboBox();
		ecombo8.addItem("Select one");
		ecombo8.addItem("Yacht Owner");
		ecombo8.addItem("Yacht Broker or Sales Associate");
		ecombo8.addItem("Yacht Dessigner");
		ecombo8.addItem("Yacht Supplier / Manufacturer");
		ecombo8.addItem("Yacht Service Provider");
		ecombo8.addItem("Yacht Captain");
		ecombo8.addItem("Vissiting Press");
		ecombo8.addItem("Others");
		ecombo8.addActionListener(this);	
		
		ecombo9 = new JComboBox();
		ecombo9.addItem("Boat size");
		ecombo9.addItem("< 60");
		ecombo9.addItem("60-80");
		ecombo9.addItem("80-100");
		ecombo9.addItem("> 100");
		
		etext10 = new JTextField();
		etext11 = new JTextField();
		etext12 = new JTextField();
		
		ecombo13 = new JComboBox();
		ecombo13.addItem("Select one");
		ecombo13.addItem("Juan Serrallés");
		ecombo13.addItem("John Gaffen");
		ecombo13.addItem("Mike Smally");
		ecombo13.addItem("Juan Fiol");
		ecombo13.addItem("Rafael Barca");
		ecombo13.addItem("Javier Arkotxa");
		ecombo13.addItem("Other 1");
		ecombo13.addItem("Oyher 2");

		etext14 = new JTextField();
		ecombo15 = new JComboBox();
		ecombo15.addItem("Select rate");
		ecombo15.addItem("*");
		ecombo15.addItem("**");
		ecombo15.addItem("***");
		ecombo15.addItem("****");
		ecombo15.addItem("*****");
		
		etextarea16 = new JTextArea();
		etextareaScroll = new JScrollPane(etextarea16);
		
		esave = new JButton("Save data",save);
		eborrar = new JButton("Delete visitor",delete);
		eimprimir = new JButton("Print",printer);
		eimprimirLista = new JButton("Print list",printer);
		eanadir = new JButton("Exit edit",salir);
		ebackup = new JButton("BackUp",bacup);
		
		//buscar
		elabelbuscar = new JLabel("Visitor name:");
		elabelbuscar2 = new JLabel("Sale Associate: :");
		elabelbuscar3 = new JLabel("Rate:");
		etextbuscar = new JTextField();
		ecombobuscar = new JComboBox();
		ecombobuscar.addItem("Select one");
		ecombobuscar.addItem("Juan Serrallés");
		ecombobuscar.addItem("John Gaffen");
		ecombobuscar.addItem("Mike Smally");
		ecombobuscar.addItem("Juan Fiol");
		ecombobuscar.addItem("Rafael Barca");
		ecombobuscar.addItem("Javier Arkotxa");
		ecombobuscar.addItem("Other 1");
		ecombobuscar.addItem("Oyher 2");
		
		ecombobuscar2 = new JComboBox();
		ecombobuscar2.addItem("Select rate");
		ecombobuscar2.addItem("*");
		ecombobuscar2.addItem("**");
		ecombobuscar2.addItem("***");
		ecombobuscar2.addItem("****");
		ecombobuscar2.addItem("*****");
		ebuscar = new JButton("Search", buscarfcp);
		
		//Logo astondoa
		elogoA = new File("img/astondoalogo.jpg");
	    eimagenA = ImageIO.read(elogoA);
	    ImageIcon eiconoA = new ImageIcon(eimagenA);
		ImageIcon eiconorA = new ImageIcon(eiconoA.getImage().getScaledInstance(250, 79, Image.SCALE_SMOOTH));
		elabellogo1 = new JLabel(eiconorA);	
		
		//Logo FS
		elogoFS = new File("img/flagshiplogo.jpg");
		eimagenFS = ImageIO.read(elogoFS);
	    ImageIcon eiconoFS = new ImageIcon(eimagenFS);
		ImageIcon eiconorFS = new ImageIcon(eiconoFS.getImage().getScaledInstance(250, 96, Image.SCALE_SMOOTH));
		elabellogo2 = new JLabel(eiconorFS);
		
		//Logo 1
//		elogo1 = new File("img/logo1.jpg");
//	    eimagen1 = ImageIO.read(elogo1);
//	    ImageIcon eicono1 = new ImageIcon(eimagen1);
		
		//Logo 2
		elogo2 = new File("img/logo2.jpg");
		eimagen2 = ImageIO.read(elogo2);
	    ImageIcon eicono2 = new ImageIcon(eimagen2);
		ImageIcon eiconor2 = new ImageIcon(eicono2.getImage().getScaledInstance(80, 76, Image.SCALE_SMOOTH));
		
		//Logo 1
//		elabellogo11 = new JLabel(eicono1);

		//Logo 2
		elabellogo21 = new JLabel(eiconor2);
	}

	void panelPassVentana(){
		focusNumber = 0;
		focusList = new Object[]{txtpass};
		panelPass.setLayout(null);
		panelPass.setVisible(false);epanel.setVisible(false);apanel.setVisible(false);menuBarra.setVisible(false);
		panelPass.removeAll();
		epanel.removeAll();
		apanel.removeAll();
		panelPass.repaint();
		panelPass.setBounds(0, 0, 1250, 775);add(panelPass);panelPass.setVisible(true);panelPass.setBackground(Color.WHITE);
		
		//titulo
		titulo2.setBounds(465, 0, 280, 30);panelPass.add(titulo2);titulo2.setVisible(true);titulo2.setFont(titleFont);
		titulo3.setBounds(450, 80, 350, 50);panelPass.add(titulo3);titulo3.setVisible(true);titulo3.setFont(titleFont2);
		
		//Logo astondoa
		labellogo1.setBounds(20, 0, 260, 89);panelPass.add(labellogo1);labellogo1.setVisible(true);	
		//Logo FS
		labellogo2.setBounds(950, 0, 260, 106);panelPass.add(labellogo2);labellogo2.setVisible(true);		
		//Logo 1
		//alabellogo11.setBounds(800, 0, 260, 106);apanel.add(alabellogo11);alabellogo11.setVisible(true);	
		//Logo 2
		labellogo21.setBounds(475, 15, 260, 89);panelPass.add(labellogo21);labellogo21.setVisible(true);

		titulo.setBounds(450, 300, 200, 30);panelPass.add(titulo);titulo.setVisible(true);
		pass.setBounds(450, 340, 150, 30);panelPass.add(pass);pass.setVisible(true);
		txtpass.setBounds(550, 340, 150, 30);panelPass.add(txtpass);txtpass.setVisible(true);txtpass.setText("RISELDA");
		iniciarSesion.setBounds(550, 380, 150, 40);panelPass.add(iniciarSesion);iniciarSesion.setVisible(true);iniciarSesion.addActionListener(this);
		
	}
	
	void panelAnadir() throws Exception{

		focusNumber = 0;
		focusList = new Object[]{atext2, atext3, atext4, atext5, atext6, atext7, atext10, atext11, atext12, atext14, atextarea16};
		apanel.setLayout(null);
		panelPass.setVisible(false);epanel.setVisible(false);apanel.setVisible(false);
		panelPass.removeAll();
		epanel.removeAll();
		apanel.removeAll();
		apanel.repaint();
		
		apanel.setBounds(0, 0, 1250, 775);add(apanel);apanel.setVisible(true);menuBarra.setVisible(true); apanel.setBackground(Color.WHITE);
		
		//titulo
		atitulo.setBounds(465, 0, 280, 30);apanel.add(atitulo);atitulo.setVisible(true);atitulo.setFont(titleFont);
		atitulo2.setBounds(450, 80, 350, 50);apanel.add(atitulo2);atitulo2.setVisible(true);atitulo2.setFont(titleFont2);
		//atitulo3.setBounds(440, 50, 350, 50);apanel.add(atitulo3);atitulo3.setVisible(true);atitulo3.setFont(titleFont2);
		
		//Logo astondoa
		alabellogo1.setBounds(20, 0, 260, 89);apanel.add(alabellogo1);alabellogo1.setVisible(true);	
		//Logo FS
		alabellogo2.setBounds(950, 0, 260, 106);apanel.add(alabellogo2);alabellogo2.setVisible(true);		
		//Logo 1
		//alabellogo11.setBounds(800, 0, 260, 106);apanel.add(alabellogo11);alabellogo11.setVisible(true);	
		//Logo 2
		alabellogo21.setBounds(475, 15, 260, 89);apanel.add(alabellogo21);alabellogo21.setVisible(true);

		//columna1
		adate.setBounds(20, 140, 100, 30);apanel.add(adate);adate.setVisible(true); //combo
		alabel1.setBounds(20, 180, 150, 30);apanel.add(alabel1);alabel1.setVisible(true); //id
		alabel2.setBounds(20, 220, 150, 30);apanel.add(alabel2);alabel2.setVisible(true); //nombre
		alabel3.setBounds(20, 260, 150, 30);apanel.add(alabel3);alabel3.setVisible(true); //apellidos
		alabel4.setBounds(20, 300, 150, 30);apanel.add(alabel4);alabel4.setVisible(true); //combo
		alabel5.setBounds(20, 340, 150, 30);apanel.add(alabel5);alabel5.setVisible(true); //combo
		alabel6.setBounds(20, 380, 150, 30);apanel.add(alabel6);alabel6.setVisible(true); //combo
		alabel7.setBounds(20, 420, 150, 30);apanel.add(alabel7);alabel7.setVisible(true); //combo
		alabel8.setBounds(400, 140, 150, 30);apanel.add(alabel8);alabel8.setVisible(true); //nombre
		alabel9.setBounds(400, 180, 150, 30);apanel.add(alabel9);alabel9.setVisible(true); //apellidos
		alabel10.setBounds(400, 220, 150, 30);apanel.add(alabel10);alabel10.setVisible(true); //combo
		alabel11.setBounds(400, 260, 100, 30);apanel.add(alabel11);alabel11.setVisible(true); //combo
		alabel12.setBounds(400, 300, 150, 30);apanel.add(alabel12);alabel12.setVisible(true); //apellidos
		alabel13.setBounds(400, 340, 150, 30);apanel.add(alabel13);alabel13.setVisible(true); //combo
		alabel14.setBounds(400, 380, 100, 30);apanel.add(alabel14);alabel14.setVisible(true); //combo
		alabel15.setBounds(400, 420, 150, 30);apanel.add(alabel15);alabel15.setVisible(true); //apellidos
		alabel16.setBounds(800, 140, 150, 30);apanel.add(alabel16);alabel16.setVisible(true); //combo
		//Primera columna
		atextdate.setBounds(140, 140, 100, 30);apanel.add(atextdate);atextdate.setVisible(true);atextdate.setFocusable(false);
		atext1.setBounds(140, 180, 75, 30);apanel.add(atext1);atext1.setVisible(true);atext1.setFocusable(false);
		atext2.setBounds(140, 220, 150, 30);apanel.add(atext2);atext2.setVisible(true);atext2.setBackground(rojo);atext2.addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {if(atext2.getText().equalsIgnoreCase("")==false){atext2.setBackground(verde);}
			else{atext2.setBackground(rojo);}}});
		atext3.setBounds(140, 260, 150, 30);apanel.add(atext3);atext3.setVisible(true); atext3.setBackground(rojo);atext3.addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {if(atext3.getText().equalsIgnoreCase("")==false){atext3.setBackground(verde);}
			else{atext3.setBackground(rojo);}}});
		atext4.setBounds(140, 300, 150, 30);apanel.add(atext4);atext4.setVisible(true); atext4.setBackground(rojo);atext4.addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {if(atext4.getText().equalsIgnoreCase("")==false){atext4.setBackground(verde);}
			else{atext4.setBackground(rojo);}}});
		atext5.setBounds(140, 340, 150, 30);apanel.add(atext5);atext5.setVisible(true); atext5.setBackground(rojo);atext5.addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {if(atext5.getText().equalsIgnoreCase("")==false){atext5.setBackground(verde);}
			else{atext5.setBackground(rojo);}}});
		atext6.setBounds(140, 380, 150, 30);apanel.add(atext6);atext6.setVisible(true);atext6.addKeyListener(new KeyAdapterNumbersOnly());atext6.setBackground(rojo);atext6.addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {if(atext6.getText().equalsIgnoreCase("")==false){atext6.setBackground(verde);}
			else{atext6.setBackground(rojo);}}});
		atext7.setBounds(140, 420, 150, 30);apanel.add(atext7);atext7.setVisible(true);
		//Segunda columna
		acombo8.setBounds(530, 140, 150, 30);apanel.add(acombo8);acombo8.setVisible(true); //nombre	 
		acombo9.setBounds(530, 180, 150, 30);apanel.add(acombo9);acombo9.setVisible(true);acombo9.setEnabled(false); //apellido
		atext10.setBounds(530, 220, 150, 30);apanel.add(atext10);atext10.setVisible(true); //
		atext11.setBounds(530, 260, 150, 30);apanel.add(atext11);atext11.setVisible(true); //
		atext12.setBounds(530, 300, 150, 30);apanel.add(atext12);atext12.setVisible(true); atext12.addKeyListener(new KeyAdapterNumbersOnly());
		acombo13.setBounds(530, 340, 150, 30);apanel.add(acombo13);acombo13.setVisible(true); //nombre
		atext14.setBounds(530, 380, 150, 30);apanel.add(atext14);atext14.setVisible(true); atext14.addKeyListener(new KeyAdapterNumbersOnly());//
		acombo15.setBounds(530, 420, 150, 30);apanel.add(acombo15);acombo15.setVisible(true); //
		//Tercera columna
		atextareaScroll.setBounds(800, 180, 425, 270); apanel.add(atextareaScroll); 			
		atextarea16.setLineWrap(true);
		atextarea16.setWrapStyleWord(true);
		atextareaScroll.setVisible(true);
		atextarea16.setDocument(new LimitadorDeDocumento(750));
		
		acontador.setBounds(20, 685, 150, 30);apanel.add(acontador);acontador.setVisible(true); //combo
		atextcontador.setBounds(140, 685, 75, 30);apanel.add(atextcontador);atextcontador.setVisible(true); //combo
		
		aanadir.setBounds(170, 520, 120, 30);apanel.add(aanadir);aanadir.setVisible(true);aanadir.addActionListener(this);
		asave.setBounds(20, 520, 120, 30);apanel.add(asave);asave.setVisible(true);asave.addActionListener(this);
		    
		aimprimir.setBounds(400, 520, 120, 30);apanel.add(aimprimir);aimprimir.setVisible(true);aimprimir.addActionListener(this);
		aedit.setBounds(560, 520, 120, 30);apanel.add(aedit);aedit.setVisible(true);aedit.addActionListener(this);
		abackup.setBounds(1100, 680, 120, 30);apanel.add(abackup);abackup.setVisible(true);abackup.addActionListener(this);
		    
		//Tabla lista

		String calumnas[]={"Id", "Date", "First name", "Last name", "Company Name", "Email", "Mobile Phone", "Full Address", "Type of visitor", "Boat size", "Brand", "Model", "Year", "Sale Associate", "VIP", "Rate", "Aditional information"}; 
		amodeloTablaLista = new DefaultTableModel(calumnas,0);
		atablaLista = new JTable(amodeloTablaLista); 			
		atablaListaScroll = new JScrollPane(atablaLista); 
		atablaListaScroll.setBounds(20,570,1210,102); apanel.add(atablaListaScroll); atablaListaScroll.setVisible(true);
		
		DataBase.readXLSXFile();
		AdaptadorRatonPrincipal.iniciarFilas();
		filaFinal();
		acontadorClientes();
	}

	void panelEditar() throws Exception{

		focusNumber = 0;
		focusList = new Object[]{etext2, etext3, etext4, etext5, etext6, etext7, etext10, etext11, etext12, etext14, etextarea16};
		epanel.setLayout(null);
		
		apanel.setVisible(false);epanel.setVisible(false);
		apanel.removeAll();
		epanel.removeAll();
		epanel.repaint();
		
		epanel.setBounds(0, 0, 1250, 775);add(epanel);epanel.setVisible(true);menuBarra.setVisible(true); epanel.setBackground(Color.WHITE);
		
		//titulo
		etitulo.setBounds(465, 0, 280, 30);epanel.add(etitulo);etitulo.setVisible(true);etitulo.setFont(titleFont);
		etitulo2.setBounds(450, 80, 350, 50);epanel.add(etitulo2);etitulo2.setVisible(true);etitulo2.setFont(titleFont2);
		//etitulo3.setBounds(440, 50, 350, 50);epanel.add(etitulo3);etitulo3.setVisible(true);etitulo3.setFont(titleFont2);
		
		//Logo astondoa
		elabellogo1.setBounds(20, 0, 260, 89);epanel.add(elabellogo1);elabellogo1.setVisible(true);	
		//Logo FS
		elabellogo2.setBounds(950, 0, 260, 106);epanel.add(elabellogo2);elabellogo2.setVisible(true);	
		//Logo 1
		//elabellogo11.setBounds(700, 0, 260, 106);epanel.add(elabellogo11);elabellogo11.setVisible(true);	
		//Logo 2
		elabellogo21.setBounds(475, 15, 260, 89);epanel.add(elabellogo21);elabellogo21.setVisible(true);	
		
		edate.setBounds(20, 140, 100, 30);epanel.add(edate);edate.setVisible(true); //combo
		elabel1.setBounds(20, 180, 150, 30);epanel.add(elabel1);elabel1.setVisible(true); //id
		elabel2.setBounds(20, 220, 150, 30);epanel.add(elabel2);elabel2.setVisible(true); //nombre
		elabel3.setBounds(20, 260, 150, 30);epanel.add(elabel3);elabel3.setVisible(true); //apellidos
		elabel4.setBounds(20, 300, 150, 30);epanel.add(elabel4);elabel4.setVisible(true); //combo
		elabel5.setBounds(20, 340, 150, 30);epanel.add(elabel5);elabel5.setVisible(true); //combo
		elabel6.setBounds(20, 380, 150, 30);epanel.add(elabel6);elabel6.setVisible(true); //combo
		elabel7.setBounds(20, 420, 150, 30);epanel.add(elabel7);elabel7.setVisible(true); //combo
		elabel8.setBounds(400, 140, 150, 30);epanel.add(elabel8);elabel8.setVisible(true); //nombre
		elabel9.setBounds(400, 180, 150, 30);epanel.add(elabel9);elabel9.setVisible(true); //apellidos
		elabel10.setBounds(400, 220, 150, 30);epanel.add(elabel10);elabel10.setVisible(true); //combo
		elabel11.setBounds(400, 260, 100, 30);epanel.add(elabel11);elabel11.setVisible(true); //combo
		elabel12.setBounds(400, 300, 150, 30);epanel.add(elabel12);elabel12.setVisible(true); //apellidos
		elabel13.setBounds(400, 340, 150, 30);epanel.add(elabel13);elabel13.setVisible(true); //combo
		elabel14.setBounds(400, 380, 100, 30);epanel.add(elabel14);elabel14.setVisible(true); //combo
		elabel15.setBounds(400, 420, 150, 30);epanel.add(elabel15);elabel15.setVisible(true); //apellidos
		elabel16.setBounds(800, 140, 150, 30);epanel.add(elabel16);elabel16.setVisible(true); //combo
		//Primera columna
		etextdate.setBounds(140, 140, 100, 30);epanel.add(etextdate);etextdate.setVisible(true); //combo
		etext1.setBounds(140, 180, 75, 30);epanel.add(etext1);etext1.setVisible(true);//id
		etext2.setBounds(140, 220, 150, 30);epanel.add(etext2);etext2.setVisible(true);
		etext3.setBounds(140, 260, 150, 30);epanel.add(etext3);etext3.setVisible(true); //apellidos
		etext4.setBounds(140, 300, 150, 30);epanel.add(etext4);etext4.setVisible(true); //
		etext5.setBounds(140, 340, 150, 30);epanel.add(etext5);etext5.setVisible(true); //
		etext6.setBounds(140, 380, 150, 30);epanel.add(etext6);etext6.setVisible(true);etext6.addKeyListener(new KeyAdapterNumbersOnly());
		etext7.setBounds(140, 420, 150, 30);epanel.add(etext7);etext7.setVisible(true);
		//Segunda columna
		ecombo8.setBounds(530, 140, 150, 30);epanel.add(ecombo8);ecombo8.setVisible(true); //nombre	 
		ecombo9.setBounds(530, 180, 150, 30);epanel.add(ecombo9);ecombo9.setVisible(true);ecombo9.setEnabled(false); //apellido
		etext10.setBounds(530, 220, 150, 30);epanel.add(etext10);etext10.setVisible(true); //
		etext11.setBounds(530, 260, 150, 30);epanel.add(etext11);etext11.setVisible(true); //
		etext12.setBounds(530, 300, 150, 30);epanel.add(etext12);etext12.setVisible(true); etext12.addKeyListener(new KeyAdapterNumbersOnly());
		ecombo13.setBounds(530, 340, 150, 30);epanel.add(ecombo13);ecombo13.setVisible(true); //nombre
		etext14.setBounds(530, 380, 150, 30);epanel.add(etext14);etext14.setVisible(true);etext14.addKeyListener(new KeyAdapterNumbersOnly()); //
		ecombo15.setBounds(530, 420, 150, 30);epanel.add(ecombo15);ecombo15.setVisible(true); //
		//Tercera columna
		etextareaScroll.setBounds(800, 180, 425, 100); epanel.add(etextareaScroll); 			
		etextarea16.setLineWrap(true);
		etextarea16.setWrapStyleWord(true);
		etextareaScroll.setVisible(true);
		etextarea16.setDocument(new LimitadorDeDocumento(750));
		
		esave.setBounds(20, 520, 120, 30);epanel.add(esave);esave.setVisible(true);esave.addActionListener(this);
		eanadir.setBounds(560, 520, 120, 30);epanel.add(eanadir);eanadir.setVisible(true);eanadir.addActionListener(this);
		eborrar.setBounds(800, 520, 120, 30);epanel.add(eborrar);eborrar.setVisible(true);eborrar.addActionListener(this);
		eimprimir.setBounds(1100, 520, 120, 30);epanel.add(eimprimir);eimprimir.setVisible(true);eimprimir.addActionListener(this);
		eimprimirLista.setBounds(950, 520, 120, 30);epanel.add(eimprimirLista);eimprimirLista.setVisible(true);eimprimirLista.addActionListener(this);
		ebackup.setBounds(1100, 680, 120, 30);epanel.add(ebackup);ebackup.setVisible(true);ebackup.addActionListener(this);
		
		econtador.setBounds(20, 685, 150, 30);epanel.add(econtador);econtador.setVisible(true); //combo
		etextcontador.setBounds(140, 685, 75, 30);epanel.add(etextcontador);etextcontador.setVisible(true); //combo
		
		//Buscar
		//elabaltitulobuscar.setBounds(800, 220, 150, 30);epanel.add(elabaltitulobuscar);elabaltitulobuscar.setVisible(true); //id
		elabelbuscar.setBounds(800, 300, 150, 30);epanel.add(elabelbuscar);elabelbuscar.setVisible(true); //id
		etextbuscar.setBounds(910, 300, 115, 30);epanel.add(etextbuscar);etextbuscar.setVisible(true);
								//
		elabelbuscar2.setBounds(800, 340, 175, 30);epanel.add(elabelbuscar2);elabelbuscar2.setVisible(true); //id
		ecombobuscar.setBounds(910, 340, 115, 30);epanel.add(ecombobuscar);ecombobuscar.setVisible(true);
		
		elabelbuscar3.setBounds(1050, 340, 150, 30);epanel.add(elabelbuscar3);elabelbuscar3.setVisible(true); //id
		ecombobuscar2.setBounds(1100, 340, 125, 30);epanel.add(ecombobuscar2);ecombobuscar2.setVisible(true);
		
		ebuscar.setBounds(1100, 300, 125, 30);epanel.add(ebuscar);ebuscar.setVisible(true);ebuscar.addActionListener(this);
		
		//Tabla Buscar
		String calumnasBuscar[]={"Id", "Date", "First name", "Last name", "Company Name", "Email", "Mobile Phone", "Full Address", "Type of visitor", "Boat size", "Brand", "Model", "Year", "Sale Associate", "VIP", "Rate", "Aditional information"}; 
		emodeloTablaBuscar = new DefaultTableModel(calumnasBuscar,0){public boolean isCellEditable(int row, int column){
			return false;//This causes all cells to be not editable
		}};  
		etablaBuscar = new JTable(emodeloTablaBuscar); 			
		etablaBuscarScroll = new JScrollPane(etablaBuscar); 
		etablaBuscarScroll.setBounds(800,380,425,102); epanel.add(etablaBuscarScroll); etablaBuscarScroll.setVisible(true);
		etablaBuscar.getColumnModel().getColumn(1).setMaxWidth(0);
		etablaBuscar.getColumnModel().getColumn(1).setMinWidth(0);
		etablaBuscar.getColumnModel().getColumn(1).setPreferredWidth(0);
		etablaBuscar.getColumnModel().getColumn(5).setMaxWidth(0);
		etablaBuscar.getColumnModel().getColumn(5).setMinWidth(0);
		etablaBuscar.getColumnModel().getColumn(5).setPreferredWidth(0);
		etablaBuscar.getColumnModel().getColumn(7).setMaxWidth(0);
		etablaBuscar.getColumnModel().getColumn(7).setMinWidth(0);
		etablaBuscar.getColumnModel().getColumn(7).setPreferredWidth(0);
		etablaBuscar.getColumnModel().getColumn(8).setMaxWidth(0);
		etablaBuscar.getColumnModel().getColumn(8).setMinWidth(0);
		etablaBuscar.getColumnModel().getColumn(8).setPreferredWidth(0);
		etablaBuscar.getColumnModel().getColumn(9).setMaxWidth(0);
		etablaBuscar.getColumnModel().getColumn(9).setMinWidth(0);
		etablaBuscar.getColumnModel().getColumn(9).setPreferredWidth(0);
		etablaBuscar.getColumnModel().getColumn(10).setMaxWidth(0);
		etablaBuscar.getColumnModel().getColumn(10).setMinWidth(0);
		etablaBuscar.getColumnModel().getColumn(10).setPreferredWidth(0);
		etablaBuscar.getColumnModel().getColumn(11).setMaxWidth(0);
		etablaBuscar.getColumnModel().getColumn(11).setMinWidth(0);
		etablaBuscar.getColumnModel().getColumn(11).setPreferredWidth(0);
		etablaBuscar.getColumnModel().getColumn(12).setMaxWidth(0);
		etablaBuscar.getColumnModel().getColumn(12).setMinWidth(0);
		etablaBuscar.getColumnModel().getColumn(12).setPreferredWidth(0);
		etablaBuscar.getColumnModel().getColumn(14).setMaxWidth(0);
		etablaBuscar.getColumnModel().getColumn(14).setMinWidth(0);
		etablaBuscar.getColumnModel().getColumn(14).setPreferredWidth(0);
		etablaBuscar.getColumnModel().getColumn(16).setMaxWidth(0);
		etablaBuscar.getColumnModel().getColumn(16).setMinWidth(0);
		etablaBuscar.getColumnModel().getColumn(16).setPreferredWidth(0);
		
		
		
		//Tabla lista
		String calumnas[]={"Id", "Date", "First name", "Last name", "Company Name", "Email", "Mobile Phone", "Full Address", "Type of visitor", "Boat size", "Brand", "Model", "Year", "Sale Associate", "VIP", "Rate", "Aditional information"}; 
		emodeloTablaLista = new DefaultTableModel(calumnas,0){public boolean isCellEditable(int row, int column){
			return false;//This causes all cells to be not editable
		}};  
		etablaLista = new JTable(emodeloTablaLista); 			
		etablaListaScroll = new JScrollPane(etablaLista); 
		etablaListaScroll.setBounds(20,570,1210,102); epanel.add(etablaListaScroll); etablaListaScroll.setVisible(true);
		
		blanquear2();
		DataBase.readXLSXFileEditar();
		AdaptadorRaton.iniciarFilas();
		econtadorClientes();
	}
	
	void filaFinal(){
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		JTableFilas.colTablaAnadirVisitante("", "",  "", "", "", "", "", "", "", "", "", "","","","","",""); 
	    int mink = atablaLista.getRowCount();
	    amodeloTablaLista.removeRow(mink-1);
	}
	
	static void marcarFila(){
		MarineMassPro.etablaLista.addMouseListener(AdaptadorRaton.adaptador);
		MarineMassPro.etablaBuscar.addMouseListener(AdaptadorRaton.adaptador2);
	}
	

	static void marcarFilaPrincipal(){
		MarineMassPro.atablaLista.addMouseListener(AdaptadorRatonPrincipal.adaptadorTablaLista);
	}
	
	void acontadorClientes(){
		int numerodeclientes = atablaLista.getRowCount();
		atextcontador.setText(Integer.toString(numerodeclientes));
	}
	
	void econtadorClientes(){
		int numerodeclientes = etablaLista.getRowCount();
		etextcontador.setText(Integer.toString(numerodeclientes));
	}
	
	static void verAnadir(int row){
		//"Id","First Name","Last Name","Company Name","Email","Address","Mobile Phone", "Date", "Type of visitor", "Boat size", "broker", "Observations"
		//HECHO
		atext1.setText(amodeloTablaLista.getValueAt(row, 0).toString());
		atextdate.setText(amodeloTablaLista.getValueAt(row, 1).toString());
		atext2.setText(amodeloTablaLista.getValueAt(row, 2).toString());
		atext3.setText(amodeloTablaLista.getValueAt(row, 3).toString());
		atext4.setText(amodeloTablaLista.getValueAt(row, 4).toString());
		atext5.setText(amodeloTablaLista.getValueAt(row, 5).toString());
		atext6.setText(amodeloTablaLista.getValueAt(row, 6).toString());
		atext7.setText(amodeloTablaLista.getValueAt(row, 7).toString());
		acombo8.setSelectedItem(amodeloTablaLista.getValueAt(row, 8).toString());
		acombo9.setSelectedItem(amodeloTablaLista.getValueAt(row, 9).toString());
		atext10.setText(amodeloTablaLista.getValueAt(row, 10).toString());
		atext11.setText(amodeloTablaLista.getValueAt(row, 11).toString());
		atext12.setText(amodeloTablaLista.getValueAt(row, 12).toString());
		acombo13.setSelectedItem(amodeloTablaLista.getValueAt(row, 13).toString());
		atext14.setText(amodeloTablaLista.getValueAt(row, 14).toString());
		acombo15.setSelectedItem(amodeloTablaLista.getValueAt(row, 15).toString());
		atextarea16.setText(amodeloTablaLista.getValueAt(row, 16).toString());
	}
	
	
	static void ver(int row){
		//"Id","First Name","Last Name","Company Name","Email","Address","Mobile Phone", "Date", "Type of visitor", "Boat size", "broker", "Observations"
		etext1.setText(emodeloTablaLista.getValueAt(row, 0).toString());
		etextdate.setText(emodeloTablaLista.getValueAt(row, 1).toString());
		etext2.setText(emodeloTablaLista.getValueAt(row, 2).toString());
		etext3.setText(emodeloTablaLista.getValueAt(row, 3).toString());
		etext4.setText(emodeloTablaLista.getValueAt(row, 4).toString());
		etext5.setText(emodeloTablaLista.getValueAt(row, 5).toString());
		etext6.setText(emodeloTablaLista.getValueAt(row, 6).toString());
		etext7.setText(emodeloTablaLista.getValueAt(row, 7).toString());
		ecombo8.setSelectedItem(emodeloTablaLista.getValueAt(row, 8).toString());
		ecombo9.setSelectedItem(emodeloTablaLista.getValueAt(row, 9).toString());
		etext10.setText(emodeloTablaLista.getValueAt(row, 10).toString());
		etext11.setText(emodeloTablaLista.getValueAt(row, 11).toString());
		etext12.setText(emodeloTablaLista.getValueAt(row, 12).toString());
		ecombo13.setSelectedItem(emodeloTablaLista.getValueAt(row, 13).toString());
		etext14.setText(emodeloTablaLista.getValueAt(row, 14).toString());
		ecombo15.setSelectedItem(emodeloTablaLista.getValueAt(row, 15).toString());
		etextarea16.setText(emodeloTablaLista.getValueAt(row, 16).toString());
	}

	static void verBusqueda(int row){
		etext1.setText(emodeloTablaBuscar.getValueAt(row, 0).toString());
		etextdate.setText(emodeloTablaBuscar.getValueAt(row, 1).toString());
		etext2.setText(emodeloTablaBuscar.getValueAt(row, 2).toString());
		etext3.setText(emodeloTablaBuscar.getValueAt(row, 3).toString());
		etext4.setText(emodeloTablaBuscar.getValueAt(row, 4).toString());
		etext5.setText(emodeloTablaBuscar.getValueAt(row, 5).toString());
		etext6.setText(emodeloTablaBuscar.getValueAt(row, 6).toString());
		etext7.setText(emodeloTablaBuscar.getValueAt(row, 7).toString());
		ecombo8.setSelectedItem(emodeloTablaBuscar.getValueAt(row, 8).toString());
		ecombo9.setSelectedItem(emodeloTablaBuscar.getValueAt(row, 9).toString());
		etext10.setText(emodeloTablaBuscar.getValueAt(row, 10).toString());
		etext11.setText(emodeloTablaBuscar.getValueAt(row, 11).toString());
		etext12.setText(emodeloTablaBuscar.getValueAt(row, 12).toString());
		ecombo13.setSelectedItem(emodeloTablaBuscar.getValueAt(row, 13).toString());
		etext14.setText(emodeloTablaBuscar.getValueAt(row, 14).toString());
		ecombo15.setSelectedItem(emodeloTablaBuscar.getValueAt(row, 15).toString());
		etextarea16.setText(emodeloTablaBuscar.getValueAt(row, 16).toString());
	}
	//HECHO
	
	static void blanquear1(){
		//HECHO
		atextdate.setText(fecha);
		atext2.setText("");
		atext3.setText("");
		atext4.setText("");
		atext5.setText("");
		atext6.setText("");
		atext7.setText("");
		acombo8.setSelectedIndex(0);
		acombo9.setSelectedIndex(0);
		atext10.setText("");
		atext11.setText("");
		atext12.setText("");
		acombo13.setSelectedIndex(0);
		atext14.setText("");
		acombo15.setSelectedIndex(0);
		atextarea16.setText("");
	}
	//HECHO

	static void blanquear2(){
		//HECHO
		etextdate.setText("");
		etext1.setText("");
		etext2.setText("");
		etext3.setText("");
		etext4.setText("");
		etext5.setText("");
		etext6.setText("");
		etext7.setText("");
		String seleccion = ecombo8.getSelectedItem().toString();
		String seleccion2 = ecombo9.getSelectedItem().toString();
		if(seleccion.equalsIgnoreCase("Select one") == false){
			ecombo8.setSelectedIndex(0);
		}
		if(seleccion2.equalsIgnoreCase("Select one") == false){
			ecombo9.setSelectedIndex(0);
		}
		etext10.setText("");
		etext11.setText("");
		etext12.setText("");
		ecombo13.setSelectedIndex(0);
		etext14.setText("");
		ecombo15.setSelectedIndex(0);
		etextarea16.setText("");
		ecombobuscar.setSelectedIndex(0);
		ecombobuscar2.setSelectedIndex(0);
	}

	void inicioDeSesion(){
		String contrasena="RISELDA";
		String password = new String(txtpass.getPassword());
		if(password.equals(contrasena)==true){
			try {
				panelAnadir();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			JOptionPane.showMessageDialog(this,"Incorrect password", "Login Fail",JOptionPane.PLAIN_MESSAGE);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==iniciarSesion){inicioDeSesion();}
		else if(acombo8 == e.getSource()){
			String seleccionado = acombo8.getSelectedItem().toString();
			if(seleccionado.equalsIgnoreCase("Yacht Owner")){
				acombo9.setEnabled(true);
			}else{
				acombo9.setSelectedIndex(0);
				acombo9.setEnabled(false);
			}

		}
		
		else if(ecombo8 == e.getSource()){
			String seleccionado = ecombo8.getSelectedItem().toString();
			if(seleccionado.equalsIgnoreCase("Yacht Owner")){
				ecombo9.setEnabled(true);
			}else{
				ecombo9.setSelectedIndex(0);
				ecombo9.setEnabled(false);
			}

		}
		//HECHO
		else if(aanadir == e.getSource()){
			//HECHO
			int fila = amodeloTablaLista.getRowCount();
			String campo = MarineMassPro.amodeloTablaLista.getValueAt(fila-1, 0).toString();
			if(MarineMassPro.fechaAnoIf.equalsIgnoreCase("2013")==true){
				MarineMassPro.atext1.setText("FL"+Integer.toString(Integer.parseInt(campo.substring(2))+1));
			}else if(MarineMassPro.fechaAnoIf.equalsIgnoreCase("2014")==true){
				if(campo.substring(0, 2).equalsIgnoreCase("FL")==true){
					MarineMassPro.atext1.setText("MIA"+Integer.toString(Integer.parseInt(campo.substring(2))+1));
				}else{
					MarineMassPro.atext1.setText("MIA"+Integer.toString(Integer.parseInt(campo.substring(3))+1));
				}
			}
			atext2.setText("");
			atext3.setText("");
			atext4.setText("");
			atext5.setText("");
			atext6.setText("");
			atext7.setText("");
			acombo8.setSelectedIndex(0);
			acombo9.setSelectedIndex(0);
			atext10.setText("");
			atext11.setText("");
			atext12.setText("");
			acombo13.setSelectedIndex(0);
			atext14.setText("");
			acombo15.setSelectedIndex(0);
			atextarea16.setText("");
		}
		//HECHO
		else if(eanadir == e.getSource() || menuAnadir == e.getSource()){
			try {panelAnadir();} catch (Exception e1) {e1.printStackTrace();}
		}
		//HECHO
		else if(aedit == e.getSource() || menuEditar == e.getSource()){
			try {panelEditar();} catch (Exception e1) {e1.printStackTrace();}
		}
		else if(menuLocker == e.getSource()){
			try {panelPassVentana();} catch (Exception e1) {e1.printStackTrace();}
		}
		//HECHO
		else if(ebuscar == e.getSource()){
			try {		

				String seleccionado = ecombobuscar.getSelectedItem().toString();
				switch(seleccionado){
				case "Select one":
					seleccionado = "";
					break;
				case "Juan Serrallés":
					seleccionado = "Juan Serrallés";
					break;
				case "John Gaffen":
					seleccionado = "John Gaffen";
					break;
				case "Mike Smally":
					seleccionado = "Mike Smally";
					break;
				case "Juan Fiol":
					seleccionado = "Juan Fiol";
					break;
				case "Rafael Barca":
					seleccionado = "Rafael Barca";
					break;
				case "Javier Arkotxa":
					seleccionado = "Javier Arkotxa";
					break;
				case "Other 1":
					seleccionado = "Other 1";
					break;
				case "Other 2":
					seleccionado = "Other 2";
					break;
				}
				
				String seleccionado2 = ecombobuscar2.getSelectedItem().toString();
				switch(seleccionado2){
				case "Select rate":
					seleccionado2 = "";
					break;
				case "*":
					seleccionado2 = "*";
					break;
				case "**":
					seleccionado2 = "**";
					break;
				case "***":
					seleccionado2 = "***";
					break;
				case "****":
					seleccionado2 = "****";
					break;
				case "*****":
					seleccionado2 = "*****";
					break;
				}

				DataBase.burcarCliente(etextbuscar.getText(), seleccionado, seleccionado2);				
			} catch (Exception e1) {e1.printStackTrace();}
		}
		//HECHO
		else if(esave == e.getSource()){
			//id,  date,  firstname,  lastname,  company,  email,  mobile,  address,  visitor,  boatsize,  brand,  model,  year,  saleassociate,  vip,  rate,  aditionalinformation
			String date = etextdate.getText();
			String id = etext1.getText();
			String firstname = etext2.getText();
			String lastname = etext3.getText();
			String company = etext4.getText();
			String email = etext5.getText();
			String mobile = etext6.getText();
			String address = etext7.getText();
			String visitor = ecombo8.getSelectedItem().toString();
			String boatsize = ecombo9.getSelectedItem().toString();
			String brand = etext10.getText();
			String model = etext11.getText();
			String year = etext12.getText();
			String saleassociate = ecombo13.getSelectedItem().toString();
			String vip = etext14.getText();
			String rate = ecombo15.getSelectedItem().toString();
			String aditionalinformation = etextarea16.getText();
					
			try {
				JTableFilas.colTablaEditarVisitante(AdaptadorRaton.mandarFila(), id,  date,  firstname,  lastname,  company,  email,  mobile,  address,  visitor,  boatsize,  brand,  model,  year,  saleassociate,  vip,  rate,  aditionalinformation); 
				DataBase.writeXLSXFileEditarCliente();
				
				String seleccionado = ecombobuscar.getSelectedItem().toString();
				switch(seleccionado){
				case "Select one":
					seleccionado = "";
					break;
				case "Juan Serrallés":
					seleccionado = "Juan Serrallés";
					break;
				case "John Gaffen":
					seleccionado = "John Gaffen";
					break;
				case "Mike Smally":
					seleccionado = "Mike Smally";
					break;
				case "Juan Fiol":
					seleccionado = "Juan Fiol";
					break;
				case "Rafael Barca":
					seleccionado = "Rafael Barca";
					break;
				case "Javier Arkotxa":
					seleccionado = "Javier Arkotxa";
					break;
				case "Other 1":
					seleccionado = "Other 1";
					break;
				case "Other 2":
					seleccionado = "Other 2";
					break;
				}
				
				String seleccionado2 = ecombobuscar2.getSelectedItem().toString();
				switch(seleccionado2){
				case "Select rate":
					seleccionado2 = "";
					break;
				case "*":
					seleccionado2 = "*";
					break;
				case "**":
					seleccionado2 = "**";
					break;
				case "***":
					seleccionado2 = "***";
					break;
				case "****":
					seleccionado2 = "****";
					break;
				case "*****":
					seleccionado2 = "*****";
					break;
				}
				DataBase.burcarCliente(etextbuscar.getText(), seleccionado, seleccionado2);				
			}catch (Exception a) {a.printStackTrace();}
			
		}
		//HECHO
		else if(eborrar == e.getSource()){
			String id = etext1.getText();
			
			try {
				JTableFilas.colTablaEliminarVisitante(AdaptadorRaton.mandarFila(),id); 
				DataBase.writeXLSXFileEditarCliente();
				
			}catch (Exception a) {a.printStackTrace();}
			econtadorClientes();
			blanquear2();
		}
		//HECHO
		else if(aimprimir == e.getSource()){

			//id,  date,  firstname,  lastname,  company,  email,  mobile,  address,  visitor,  boatsize,  brand,  model,  year,  saleassociate,  vip,  rate,  aditionalinformation
			String date = atextdate.getText();
			String id = atext1.getText();
			String firstname = atext2.getText();
			String lastname = atext3.getText();
			String company = atext4.getText();
			String email = atext5.getText();
			String mobile = atext6.getText();
			String address = atext7.getText();
			String visitor = acombo8.getSelectedItem().toString();
			String boatsize = acombo9.getSelectedItem().toString();
			String brand = atext10.getText();
			String model = atext11.getText();
			String year = atext12.getText();
			String saleassociate = acombo13.getSelectedItem().toString();
			String vip = atext14.getText();
			String rate = acombo15.getSelectedItem().toString();
			String aditionalinformation = atextarea16.getText();
			
		  new ImprimirVisitor(id,  date,  firstname,  lastname,  company,  email,  mobile,  address,  visitor,  boatsize,  brand,  model,  year,  saleassociate,  vip,  rate,  aditionalinformation);
		
		}
		//HECHO
		else if(eimprimir == e.getSource()){

			//id,  date,  firstname,  lastname,  company,  email,  mobile,  address,  visitor,  boatsize,  brand,  model,  year,  saleassociate,  vip,  rate,  aditionalinformation
			String date = etextdate.getText();
			String id = etext1.getText();
			String firstname = etext2.getText();
			String lastname = etext3.getText();
			String company = etext4.getText();
			String email = etext5.getText();
			String mobile = etext6.getText();
			String address = etext7.getText();
			String visitor = ecombo8.getSelectedItem().toString();
			String boatsize = ecombo9.getSelectedItem().toString();
			String brand = etext10.getText();
			String model = etext11.getText();
			String year = etext12.getText();
			String saleassociate = ecombo13.getSelectedItem().toString();
			String vip = etext14.getText();
			String rate = ecombo15.getSelectedItem().toString();
			String aditionalinformation = etextarea16.getText();
			
		  new ImprimirVisitor(id,  date,  firstname,  lastname,  company,  email,  mobile,  address,  visitor,  boatsize,  brand,  model,  year,  saleassociate,  vip,  rate,  aditionalinformation);
		
		}
		//HECHO
		else if(eimprimirLista == e.getSource()){
			//HECHO
			String seleccionado = ecombobuscar.getSelectedItem().toString();
			switch(seleccionado){
			case "Select one":
				seleccionado = "";
				break;
			case "Juan Serrallés":
				seleccionado = "Juan Serrallés";
				break;
			case "John Gaffen":
				seleccionado = "John Gaffen";
				break;
			case "Mike Smally":
				seleccionado = "Mike Smally";
				break;
			case "Juan Fiol":
				seleccionado = "Juan Fiol";
				break;
			case "Rafael Barca":
				seleccionado = "Rafael Barca";
				break;
			case "Javier Arkotxa":
				seleccionado = "Javier Arkotxa";
				break;
			case "Other 1":
				seleccionado = "Other 1";
				break;
			case "Other 2":
				seleccionado = "Other 2";
				break;
			}
			
			String seleccionado2 = ecombobuscar2.getSelectedItem().toString();
			switch(seleccionado2){
			case "Select rate":
				seleccionado2 = "";
				break;
			case "*":
				seleccionado2 = "*";
				break;
			case "**":
				seleccionado2 = "**";
				break;
			case "***":
				seleccionado2 = "***";
				break;
			case "****":
				seleccionado2 = "****";
				break;
			case "*****":
				seleccionado2 = "*****";
				break;
			}
			
			try {
			DataBase.burcarCliente(etextbuscar.getText(), seleccionado, seleccionado2);				
			} catch (Exception e1) {e1.printStackTrace();}

			 new Thread(new Thread2()).start();
			 
		}
		
		else if (asave==e.getSource()){
			//id,  date,  firstname,  lastname,  company,  email,  mobile,  address,  visitor,  boatsize,  brand,  model,  year,  saleassociate,  vip,  rate,  aditionalinformation
			String date = atextdate.getText();
			String id = atext1.getText();
			String firstname = atext2.getText();
			String lastname = atext3.getText();
			String company = atext4.getText();
			String email = atext5.getText();
			String mobile = atext6.getText();
			String address = atext7.getText();
			String visitor = acombo8.getSelectedItem().toString();
			String boatsize = acombo9.getSelectedItem().toString();
			String brand = atext10.getText();
			String model = atext11.getText();
			String year = atext12.getText();
			String saleassociate = acombo13.getSelectedItem().toString();
			String vip = atext14.getText();
			String rate = acombo15.getSelectedItem().toString();
			String aditionalinformation = atextarea16.getText();
			
			if(firstname.equalsIgnoreCase("")!=true && lastname.equalsIgnoreCase("")!=true && mobile.equalsIgnoreCase("")!=true){
			try {
				if(DataBase.idRepeat(id) == false){
					JTableFilas.colTablaAnadirVisitante(id,  date,  firstname,  lastname,  company,  email,  mobile,  address,  visitor,  boatsize,  brand,  model,  year,  saleassociate,  vip,  rate,  aditionalinformation); 
					DataBase.writeXLSXFile();
				}
				acontadorClientes();
			}catch (Exception a) {a.printStackTrace();}
			}else{
				JOptionPane.showMessageDialog(apanel, "First name, last name and mobile phone are required.", "Data no complete", JOptionPane.WARNING_MESSAGE);
			}
		}
		
		else if(abackup == e.getSource()){
			try {DataBaseBackUp.writeXLSXFile();} catch (IOException e1) {e1.printStackTrace();}
		}
		
		else if(ebackup == e.getSource()){
			try {DataBaseBackUp.writeXLSXFileEditarCliente();} catch (IOException e1) {e1.printStackTrace();}
		}
		e.setSource(null);
	}
	
	public static void main(String[] args) throws Exception {

		MarineMassPro ventana = new MarineMassPro();
		ventana.setBounds(10, 10,1250, 775);
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		ventana.panelPassVentana();
		ventana.setResizable(false);
		ventana.setTitle("Marine MassPro 1.9");
		ventana.setFocusTraversalPolicy(new MyFocusTraversalPolicy());
		
	}
}
