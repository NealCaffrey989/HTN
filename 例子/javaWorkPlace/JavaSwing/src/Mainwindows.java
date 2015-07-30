import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Mainwindows {

	private JList list;
	private JFrame frame;

	/**
	 * Launch the application
	 * @param args
	 */
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Mainwindows window = new Mainwindows();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application
	 */
	public Mainwindows() {
		createContents();
	}

	/**
	 * Initialize the contents of the frame
	 */
	private void createContents() {
		frame = new JFrame();
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setBounds(100, 100, 500, 375);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final JToolBar toolBar = new JToolBar();
		frame.getContentPane().add(toolBar, BorderLayout.NORTH);

		final JButton button = new JButton();
		button.setText("New JButton");
		toolBar.add(button);

		final JInternalFrame internalFrame = new JInternalFrame();
		internalFrame.setTitle("New JInternalFrame");
		internalFrame.setVisible(true);
		frame.getContentPane().add(internalFrame, BorderLayout.CENTER);

		list = new JList();
		list.setModel(new DefaultComboBoxModel(new String[] {"爱迪生", "大是大非", "哀悼飞"}));
		internalFrame.getContentPane().add(list, BorderLayout.CENTER);

		final JProgressBar progressBar = new JProgressBar();
		internalFrame.getContentPane().add(progressBar, BorderLayout.NORTH);

		final JSlider slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(final ChangeEvent e) {
				progressBar.setStringPainted(true);
				progressBar.setString((slider.getValue()*100/slider.getMaximum())+"%");
				progressBar.setValue(slider.getValue());
			}
		});
		internalFrame.getContentPane().add(slider, BorderLayout.SOUTH);

		final JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		final JMenu menu = new JMenu();
		menu.setText("New SubMenu");
		menuBar.add(menu);

		final JMenuItem newItemMenuItem = new JMenuItem();
		newItemMenuItem.setText("New Item");
		menu.add(newItemMenuItem);

		final JMenuItem newItemMenuItem_1 = new JMenuItem();
		newItemMenuItem_1.setText("New Item");
		menu.add(newItemMenuItem_1);

		final JMenu menu_1 = new JMenu();
		menu_1.setText("New SubMenu");
		menuBar.add(menu_1);

		final JMenuItem newItemMenuItem_2 = new JMenuItem();
		newItemMenuItem_2.setText("New Item");
		menuBar.add(newItemMenuItem_2);

	}

}
