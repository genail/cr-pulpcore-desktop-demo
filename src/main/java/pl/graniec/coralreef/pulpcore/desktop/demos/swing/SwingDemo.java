/**
 * Copyright (c) 2009, Coral Reef Project
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *  * Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *  * Neither the name of the Coral Reef Project nor the names of its
 *    contributors may be used to endorse or promote products derived from this
 *    software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package pl.graniec.coralreef.pulpcore.desktop.demos.swing;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JTextField;

import pl.graniec.coralreef.pulpcore.desktop.CoreApplication;
import pl.graniec.coralreef.pulpcore.desktop.CoreDisplayPanel;

/**
 * @author Piotr Korzuszek <piotr.korzuszek@gmail.com>
 *
 */
public class SwingDemo extends JFrame {
	
	private static final long serialVersionUID = 1L;

	/** Instance for first scene to access this object */
	static SwingDemo instance;
	
	/** PulpCore display panel */
	final CoreDisplayPanel panel = new CoreDisplayPanel();
	/** Input for fun :-) */
	final JTextField input = new JTextField("Try to change this :-)");
	
	public SwingDemo() {
		super();
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setSize(800, 600);
		
		panel.setPreferredSize(new Dimension(640, 480));
		
		add(panel);
		add(input);
	}
	
	public static void main(String[] args) {
		final SwingDemo demoWindow = new SwingDemo();
		SwingDemo.instance = demoWindow;
		
		demoWindow.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		demoWindow.setVisible(true);
		
		final CoreApplication coreApp = new CoreApplication(SwingScene.class, demoWindow.panel);
		coreApp.run();
		
	}
	
}
