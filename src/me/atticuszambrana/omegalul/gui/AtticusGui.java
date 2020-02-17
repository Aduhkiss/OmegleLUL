package me.atticuszambrana.omegalul.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import me.atticuszambrana.omegalul.common.AtticusSession;
import me.atticuszambrana.omegalul.common.Plugin;
import me.atticuszambrana.omegalul.common.util.F;

public class AtticusGui extends Plugin {
	
	public AtticusGui(boolean isEnabled, AtticusMessageGui messages) {
		super("Atticus Gui", isEnabled);
		this.messages = messages;
	}
	
	private JFrame frame;
	private AtticusSession session;
	
	private AtticusMessageGui messages;
	
	@Override
	public void onEnable() {
		// Create the session
		session = new AtticusSession();
		
		// Create the initial frame and set the layout for it
		
		System.out.println(F.main("Atticus Gui", "Opening Window..."));
		
		frame = new JFrame("OMEGLELUL - Created by Atticus Zambrana");
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		//TODO Make this scrolling text like the Mineplex Scoreboard
		JLabel titleLabel = new JLabel("Welcome to OMEGLELUL");
		
		JTextField messageBox = new JTextField(40);
		panel.add(messageBox, BorderLayout.CENTER);

		panel.add(titleLabel);
		
		// Lets make it so you can just hit enter to send your message
		messageBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!session.isAlive()) {
					return;
				}
				if(e.getActionCommand() != null && e.getActionCommand().length() != 0) {
					messageBox.setText("");
					session.send(e.getActionCommand());
					//messages.add("You: " + e.getActionCommand());
				}
			}
			
		});
		
		JButton sendButton = new JButton();
		sendButton.setText("Send");
		sendButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!session.isAlive()) {
					return;
				}
				if(messageBox.getText() != null && messageBox.getText().length() != 0) {
					String message = messageBox.getText();
					messageBox.setText("");
					session.send(message);
					//messages.add("You: " + message);
				}
			}
			
		});
		
		JButton reconnectButton = new JButton("Connect");
		//reconnectButton.setVisible(false);
		reconnectButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				if(session.isAlive()) {
					session.kill();
					session.disconnect();
				}
				session.create();
				reconnectButton.setText("Reconnect");
				messages.add("Reconnecting...");
			}
		});
		
		JButton clearButton = new JButton("Clear Chat");
		clearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(F.main("Atticus Gui", "Clearing the window..."));
				messages.clearChat();
			}
		});
		
		//panel.add(titleLabel);
		panel.add(messageBox);
		panel.add(sendButton);
		panel.add(reconnectButton);
		panel.add(clearButton);

		frame.add(panel);
		frame.setSize(500, 500);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public AtticusMessageGui getMessageGui() {
		return messages;
	}

}
