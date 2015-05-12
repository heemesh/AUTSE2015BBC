import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import java.awt.List;


public class SEgui {

	private JFrame frame;
	private JLabel lblAuther;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SEgui window = new SEgui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SEgui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(358, 161, 243, 41);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(634, 161, 243, 41);
		frame.getContentPane().add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(911, 161, 243, 41);
		frame.getContentPane().add(comboBox_2);
		
		lblAuther = new JLabel("Author");
		lblAuther.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		lblAuther.setHorizontalAlignment(SwingConstants.CENTER);
		lblAuther.setBounds(380, 103, 200, 50);
		frame.getContentPane().add(lblAuther);
		
		JLabel lblArticleTopic = new JLabel("Article Topic");
		lblArticleTopic.setHorizontalAlignment(SwingConstants.CENTER);
		lblArticleTopic.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		lblArticleTopic.setBounds(646, 103, 200, 50);
		frame.getContentPane().add(lblArticleTopic);
		
		JLabel lblSoftwareEngineering = new JLabel("SOFTWARE ENGINEERING");
		lblSoftwareEngineering.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoftwareEngineering.setFont(new Font("Trajan Pro 3", Font.BOLD, 44));
		lblSoftwareEngineering.setBounds(10, 10, 1244, 90);
		frame.getContentPane().add(lblSoftwareEngineering);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		lblDate.setBounds(932, 103, 200, 50);
		frame.getContentPane().add(lblDate);
		
		JButton btnPopularList = new JButton("Popular List");
		btnPopularList.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		btnPopularList.setBounds(657, 559, 200, 30);
		frame.getContentPane().add(btnPopularList);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		btnSearch.setBounds(609, 330, 300, 60);
		frame.getContentPane().add(btnSearch);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(358, 236, 243, 41);
		frame.getContentPane().add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(634, 236, 243, 41);
		frame.getContentPane().add(comboBox_4);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBounds(911, 236, 243, 41);
		frame.getContentPane().add(comboBox_5);
		
		List list = new List();
		list.setBounds(10, 161, 251, 511);
		frame.getContentPane().add(list);
	}
}
