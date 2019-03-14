import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Time;

public class GUI extends JFrame implements ActionListener
{
	private Container window;
	private JLabel title;
	private JLabel credit;
	private JLabel credit2;
	private JLabel info;
	private JLabel info2;
	private JLabel info3;
	private JTextArea info4;
	private JLabel versionInfo;
	private JLabel conversion;
	private JLabel conversion2;
	private JButton actionButton;
	private JTextField textField;
	private TimeConverter converter = new TimeConverter();
	private String time;

	private int screenHeight = (int)(java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight());
	private int screenWidth = (int)(java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth());

	public GUI()
	{
		makeTheWindow();
		makeTheText();
		makeTheButton();
	}

	public void makeTheWindow()
	{
		window = getContentPane();
		window.setLayout(null);
		window.setBackground(Color.GRAY);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("RP Time Converter");
		setSize(640, 480);
		setMinimumSize(new Dimension(640, 480));
		setLocation(screenWidth /4, screenHeight / 4);
		setResizable(true);
	}

	public void makeTheText()
	{
		System.out.println(window.getPreferredSize());
		System.out.println(window.getWidth());

		title = new JLabel("Time Converter");
		title.setBounds(220, 50, 200, 25);
		title.setForeground(Color.black);
		title.setFont(new Font("Verdana", Font.BOLD, 18));
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setVerticalAlignment(JLabel.CENTER);
		window.add(title);

		credit = new JLabel("Coded by Jon#3409");
		credit.setBounds(220, 75, 200, 20);
		credit.setForeground(Color.black);
		credit.setHorizontalAlignment(JLabel.CENTER);
		credit.setVerticalAlignment(JLabel.CENTER);
		window.add(credit);

		credit2 = new JLabel("Made for Geopolitics");
		credit2.setBounds(220, 100, 200, 20);
		credit2.setForeground(Color.black);
		credit2.setHorizontalAlignment(JLabel.CENTER);
		credit2.setVerticalAlignment(JLabel.CENTER);
		window.add(credit2);

		info = new JLabel("Format: HH:MM AM/PM");
		info.setBounds(220, 150, 200, 20);
		info.setForeground(Color.black);
		info.setHorizontalAlignment(JLabel.CENTER);
		info.setVerticalAlignment(JLabel.CENTER);
		window.add(info);

		info2 = new JLabel("Example: 12:45 PM");
		info2.setBounds(220, 175, 200, 20);
		info2.setForeground(Color.black);
		info2.setHorizontalAlignment(JLabel.CENTER);
		info2.setVerticalAlignment(JLabel.CENTER);
		window.add(info2);

		info3 = new JLabel("How to use:");
		info3.setBounds(25, 150, 200, 20);
		info3.setForeground(Color.black);
		info3.setHorizontalAlignment(JLabel.CENTER);
		info3.setVerticalAlignment(JLabel.CENTER);
		window.add(info3);

		info4 = new JTextArea("Enter the in-real-life time of day below.\n" +
				"The program will output the roleplay\n" +
				"date along with the time on that day.");
		info4.setBounds(25, 175, 225, 75);
		info4.setForeground(Color.black);
		info4.setBackground(Color.gray);
//		info4.setLineWrap(true);
		info4.setEditable(false);
		window.add(info4);

		versionInfo = new JLabel("Geopolitics IRL to RP Time Converter v1.1");
		versionInfo.setBounds(0, 415, 640, 20);
		versionInfo.setForeground(Color.black);
		versionInfo.setHorizontalAlignment(JLabel.CENTER);
		versionInfo.setVerticalAlignment(JLabel.CENTER);
		window.add(versionInfo);

		conversion = new JLabel("The conversion is:");
		conversion.setBounds(220, 225, 200, 20);
		conversion.setForeground(Color.black);
		conversion.setHorizontalAlignment(JLabel.CENTER);
		conversion.setVerticalAlignment(JLabel.CENTER);
		window.add(conversion);

		conversion2 = new JLabel("");
		conversion2.setBounds(220, 250, 200, 20);
		conversion2.setForeground(Color.black);
		conversion2.setFont(new Font("Verdana", Font.BOLD, 12));
		conversion2.setHorizontalAlignment(JLabel.CENTER);
		conversion2.setVerticalAlignment(JLabel.CENTER);
		window.add(conversion2);

		textField = new JTextField("");
		textField.setBounds(220, 300, 200, 25);
		textField.addActionListener(this);
		window.add(textField);
	}

	public void makeTheButton()
	{
		actionButton = new JButton("Calculate Time");
		actionButton.setBounds(220, 350, 200, 50);
		actionButton.addActionListener(this);
		window.add(actionButton);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() instanceof JButton || e.getSource() instanceof JTextArea)
		{
			time = textField.getText();
			converter.setHour(Integer.parseInt(time.substring(0,time.indexOf(":"))));
			converter.setMinute(Integer.parseInt(time.substring(time.indexOf(":") + 1, time.indexOf(" "))));
			converter.setAmpm(time.substring(time.indexOf(" ") + 1));

			conversion2.setText(converter.irlToRoleplay());
		}
	}
}
