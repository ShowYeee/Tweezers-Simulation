package MiniProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.JTextComponent;
import javax.swing.JComboBox;
import java.awt.Font;

public class Activity {

	private JFrame frmDiceSim;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnNewButton;
	private JLabel lblResult;
	
	int d;
	int n;
	int total[][];
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private JButton btnShowChart;
	private JLabel lblNumberTotal;
	private JComboBox comboBox;
	private JLabel lblPleaseInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Activity window = new Activity();
					window.frmDiceSim.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Activity() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDiceSim = new JFrame();
		frmDiceSim.setTitle("Dice Sim");
		frmDiceSim.setResizable(false);
		frmDiceSim.setBounds(100, 100, 643, 338);
		frmDiceSim.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDiceSim.getContentPane().setLayout(new MigLayout("", "[14.00][235.00,grow,left]", "[36.00,center][][210.00][-15.00,fill]"));
		
		lblPleaseInput = new JLabel("Please input                        ");
		frmDiceSim.getContentPane().add(lblPleaseInput, "flowx,cell 1 0");
		
		JLabel lblNewLabel = new JLabel("D ");
		frmDiceSim.getContentPane().add(lblNewLabel, "cell 1 0,alignx trailing");
		
		textField = new JTextField();
		frmDiceSim.getContentPane().add(textField, "cell 1 0,alignx left");
		textField.setColumns(10);
		
		JLabel lblN = new JLabel("N");
		frmDiceSim.getContentPane().add(lblN, "cell 1 0");
		
		textField_1 = new JTextField();
		frmDiceSim.getContentPane().add(textField_1, "cell 1 0,alignx left");
		textField_1.setColumns(10);
		
		lblResult = new JLabel("Result : ");
		frmDiceSim.getContentPane().add(lblResult, "cell 1 1");
		
		
		scrollPane = new JScrollPane();
		frmDiceSim.getContentPane().add(scrollPane, "flowy,cell 1 2,grow");
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("Monospaced", Font.BOLD, 12));
		scrollPane.setViewportView(textArea);
		
		lblNumberTotal = new JLabel("Number  :");
		frmDiceSim.getContentPane().add(lblNumberTotal, "flowx,cell 1 3");
		
		comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		frmDiceSim.getContentPane().add(comboBox, "cell 1 3");
		for(int i =1 ; i <= 6 ; i++)comboBox.addItem( i );

		
		
		btnShowChart = new JButton("Show Chart");
		btnShowChart.setEnabled(false);
		frmDiceSim.getContentPane().add(btnShowChart, "cell 1 3");
		btnShowChart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				try {
					int num = (int) comboBox.getSelectedItem();
					Histogram b = new Histogram();
					b.show(total,num);
				}catch (Exception e){
					
					btnShowChart.setEnabled(false);
					textArea.setText("Erro show, Maybe you have the erro input!! \n Message:\n"+e);
				}
				
				
			}
		});
		btnShowChart.setBackground(Color.WHITE);
		
		btnNewButton = new JButton("Start");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Simulatingthedice sim = new Simulatingthedice();
				
				
		
					
					try {
						
						d =  Integer.parseInt( textField.getText());
						n =  Integer.parseInt( textField_1.getText());	
						
						total = sim.total(d,n);
						
						String r = "Simulating success !! \n\n";
						
						for(int i = 0 ; i < 6 ; i++) {
							r += "=================================\n Total of "+(i+1)+"\n=================================\n";
							for(int j = 0 ; j < total[i].length ; j++) {
								r += " Num "+j+" : "+total[i][j]+"\n";
							}
							
							r += "\n";
							
						}
						
						textArea.setText(r);
						btnShowChart.setEnabled(true);
						
					}catch (Exception e){
						
						textArea.setText("* Erro input!! \n\n* Message:\n"+e);
						btnShowChart.setEnabled(false);

					}
					
					
				
				
				
				
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		frmDiceSim.getContentPane().add(btnNewButton, "cell 1 0");
		
		    
	}

}
