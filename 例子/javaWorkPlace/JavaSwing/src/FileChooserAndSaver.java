import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpringLayout;
import javax.swing.UIManager;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;


public class FileChooserAndSaver extends JFrame {

	private JTextField textField_1;
	private JTextField textField;
	/**
	 * Launch the application
	 * @param args
	 */
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					FileChooserAndSaver frame = new FileChooserAndSaver();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame
	 */
	public FileChooserAndSaver() {
		super();
		setResizable(false);
		getContentPane().setLayout(new GridLayout(2, 0));
		setSize(511, 136);
		setTitle("选件选择器");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final JPanel panel = new JPanel();
		getContentPane().add(panel);

		final JLabel label = new JLabel();
		panel.add(label);
		label.setText("打开文件：");

		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(30);

		final JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				openfile();
			}
		});
		panel.add(button);
		button.setText("...");

		final JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1);

		final JLabel label_1 = new JLabel();
		label_1.setText("保存文件：");
		panel_1.add(label_1);

		textField_1 = new JTextField();
		textField_1.setColumns(30);
		panel_1.add(textField_1);

		final JButton button_1 = new JButton();
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				savefile();
			}
		});
		button_1.setText("...");
		panel_1.add(button_1);
		//
	}
	
	void openfile(){
		JFileChooser fc=new JFileChooser();
		fc.setDialogTitle("保存文件演示");
		fc.setDialogType(JFileChooser.CUSTOM_DIALOG);
		if(fc.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){
			this.textField.setText(fc.getSelectedFile().toString());
			this.textField_1.setText(fc.getSelectedFile().toString());
		}
	}
	
	void savefile(){
		JFileChooser fc=new JFileChooser();
		fc.setDialogTitle("保存文件演示！");
		fc.setDialogType(JFileChooser.SAVE_DIALOG);
		File f1=new File(this.textField.getText());
		fc.setCurrentDirectory(f1);
		fc.setControlButtonsAreShown(true);
		fc.setSelectedFile(f1);
		if(fc.showSaveDialog(this)==JFileChooser.APPROVE_OPTION){
			
		}
	}

}
