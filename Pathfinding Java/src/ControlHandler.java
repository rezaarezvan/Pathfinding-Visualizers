import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/* This class manages all components used on the main
 * control panel (bottom left) Meant to remove some
 * excessive graphics code from "Frame.java" class
 */
public class ControlHandler {
	private Frame frame;
	private JLabel modeText, speedT, speedC, openT, 
	closedT, pathT, openC, closedC, pathC, noPathT;
	private JCheckBox showStepsCheck, diagonalCheck, trigCheck;
	private JSlider speed;
	private JButton run;
	private ArrayList<JLabel> labels;
	private ArrayList<JCheckBox> checks;
	private ArrayList<JSlider> sliders;
	private ArrayList<JButton> buttons;
	Dimension npD;
	
	public ControlHandler(Frame frame) {
		this.frame = frame;
		labels = new ArrayList<JLabel>();
		checks = new ArrayList<JCheckBox>();
		sliders = new ArrayList<JSlider>();
		buttons = new ArrayList<JButton>();
		
		// Set up JLabels
		modeText = new JLabel("Mode: ");
		modeText.setName("modeText");
		modeText.setFont(Style.bigText);
		modeText.setForeground(Style.darkText);
		modeText.setVisible(true);
		
		speedT = new JLabel("Speed: ");
		speedT.setName("speedT");
		speedT.setFont(Style.numbers);
		speedT.setVisible(true);
		
		speedC = new JLabel("50");
		speedC.setName("speedC");
		speedC.setFont(Style.numbers);
		speedC.setVisible(true);
		
		openT = new JLabel("Open");
		openT.setName("openT");
		openT.setFont(Style.numbers);
		openT.setVisible(true);
		
		openC = new JLabel("0");
		openC.setName("openC");
		openC.setFont(Style.numbers);
		openC.setVisible(true);
		
		closedT = new JLabel("Closed");
		closedT.setName("closedT");
		closedT.setFont(Style.numbers);
		closedT.setVisible(true);
		
		closedC = new JLabel("0");
		closedC.setName("closedC");
		closedC.setFont(Style.numbers);
		closedC.setVisible(true);
		
		pathT = new JLabel("Path");
		pathT.setName("pathT");
		pathT.setFont(Style.numbers);
		pathT.setVisible(true);
		
		pathC = new JLabel("0");
		pathC.setName("pathC");
		pathC.setFont(Style.numbers);
		pathC.setVisible(true);
		
		noPathT = new JLabel("NO PATH");
		noPathT.setName("noPathT");
		noPathT.setForeground(Color.white);
		noPathT.setFont(Style.biggerText);
		npD = noPathT.getPreferredSize();
		
		// Add JLabels to list
		labels.add(modeText);
		labels.add(speedT);
		labels.add(speedC);
		labels.add(openT);
		labels.add(openC);
		labels.add(closedT);
		labels.add(closedC);
		labels.add(pathT);
		labels.add(pathC);
		labels.add(noPathT);
		
		// Set up JCheckBoxes
		showStepsCheck = new JCheckBox();
		showStepsCheck.setText("showSteps");
		showStepsCheck.setName("showStepsCheck");
		showStepsCheck.setSelected(true);
		showStepsCheck.setOpaque(false);
		showStepsCheck.setFocusable(false);
		showStepsCheck.setVisible(true);
		
		diagonalCheck = new JCheckBox();
		diagonalCheck.setText("Diagonal");
		diagonalCheck.setName("diagonalCheck");
		diagonalCheck.setOpaque(false);
		diagonalCheck.setSelected(true);
		diagonalCheck.setFocusable(false);
		diagonalCheck.setVisible(true);
		
		trigCheck = new JCheckBox();
		trigCheck.setText("Trig");
		trigCheck.setName("trigCheck");
		trigCheck.setOpaque(false);
		trigCheck.setFocusable(false);
		trigCheck.setVisible(true);
		
		// Add JCheckboxes to list
		checks.add(showStepsCheck);
		checks.add(diagonalCheck);
		checks.add(trigCheck);
		
		// Set up JSliders
		speed = new JSlider();
		speed.setName("speed");
		speed.setOpaque(false);
		speed.setVisible(true);
		speed.setFocusable(false);
		speed.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				speed.setValue(source.getValue());
				frame.setSpeed();
				frame.repaint();
			}
		});
		
		// Add JSliders to list
		sliders.add(speed);
		
		// Set up JButtons
		run = new JButton();
		run.setText("run");
		run.setName("run");
		run.setFocusable(false);
		run.addActionListener(frame);
		run.setMargin(new Insets(0,0,0,0));
		run.setVisible(true);
		
		// Add JButtons to list
		buttons.add(run);
	}
	
	// Gets a specific JLabel by name
	public JLabel getL(String t) {
		for(int i = 0; i < labels.size(); i++) {
			if(labels.get(i).getName().equals(t)) {
				return labels.get(i);
			}
		}
		return null;
	}
	
	// Gets specific JCheckBox by name
	public JCheckBox getC(String t) {
		for(int i = 0; i < checks.size(); i++) {
			if(checks.get(i).getName().equals(t)) {
				return checks.get(i);
			}
		}
		return null;
	}
	
	// Gets specific JCheckBox by name
	public JSlider getS(String t) {
		for(int i = 0; i < sliders.size(); i++) {
			if(sliders.get(i).getName().equals(t)) {
				return sliders.get(i);
			}
		}
		return null;
	}
	
	// Gets specific JCheckBox by name
	public JButton getB(String t) {
		for(int i = 0; i < buttons.size(); i++) {
			if(buttons.get(i).getName().equals(t)) {
				return buttons.get(i);
			}
		}
		return null;
	}
	
	public void noPathTBounds() {
		noPathT.setBounds((int)((frame.getWidth()/2)-(npD.getWidth()/2)), 
				(int)((frame.getHeight()/2)-70), 
				(int)npD.getWidth(), (int)npD.getHeight());
	}
	
	public void position() {
		// Set label bounds
		speedT.setBounds(180, frame.getHeight()-88, 60, 20);
		speedC.setBounds(224, frame.getHeight()-88, 60, 20);
		openT.setBounds(254, frame.getHeight()-92, 60, 20);
		openC.setBounds(300, frame.getHeight()-92, 60, 20);
		closedT.setBounds(254, frame.getHeight()-76, 60, 20);
		closedC.setBounds(300, frame.getHeight()-76, 60, 20);
		pathT.setBounds(254, frame.getHeight()-60, 60, 20);
		pathC.setBounds(300, frame.getHeight()-60, 60, 20);
		Dimension size = modeText.getPreferredSize();
		modeText.setBounds(20, frame.getHeight() - 39, size.width, size.height);
		
		// Set check box bounds
		showStepsCheck.setBounds(20, frame.getHeight()-88, 90, 20);
		diagonalCheck.setBounds(20, frame.getHeight()-64, 90, 20);
		trigCheck.setBounds(112, frame.getHeight()-63, 50, 20);
		
		// Set slider bounds
		speed.setBounds(178, frame.getHeight()-63, 68, 20);
		
		// Set button bounds
		run.setBounds(116, frame.getHeight()-88, 52, 22);
	}
	
	// Sets text of JLabels to lightText
	public void hoverColour() {
		modeText.setForeground(Style.lightText);
		showStepsCheck.setForeground(Style.lightText);
		diagonalCheck.setForeground(Style.lightText);
		trigCheck.setForeground(Style.lightText);
		speed.setForeground(Style.lightText);
		speedT.setForeground(Style.lightText);
		speedC.setForeground(Style.lightText);
		openT.setForeground(Style.lightText);
		openC.setForeground(Style.lightText);
		closedT.setForeground(Style.lightText);
		closedC.setForeground(Style.lightText);
		pathT.setForeground(Style.lightText);
		pathC.setForeground(Style.lightText);
	}
	
	// Sets text of JLabels to darkText
	public void nonHoverColour() {
		modeText.setForeground(Style.darkText);
		showStepsCheck.setForeground(Style.darkText);
		diagonalCheck.setForeground(Style.darkText);
		trigCheck.setForeground(Style.darkText);
		speed.setForeground(Style.darkText);
		speedT.setForeground(Style.darkText);
		speedC.setForeground(Style.darkText);
		openT.setForeground(Style.darkText);
		openC.setForeground(Style.darkText);
		closedC.setForeground(Style.darkText);
		closedT.setForeground(Style.darkText);
		pathT.setForeground(Style.darkText);
		pathC.setForeground(Style.darkText);
	}
	
	// Adds all components to frame
	public void addAll() {
		frame.add(showStepsCheck);
		frame.add(diagonalCheck);
		frame.add(trigCheck);
		frame.add(run);
		frame.add(modeText);
		frame.add(openT);
		frame.add(openC);
		frame.add(closedT);
		frame.add(closedC);
		frame.add(pathT);
		frame.add(pathC);
		frame.add(speed);
		frame.add(speedT);
		frame.add(speedC);
	}
	
}
