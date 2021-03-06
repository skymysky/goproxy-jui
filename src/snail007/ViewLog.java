/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snail007;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 *
 * @author pengmeng
 */
public class ViewLog extends PFrame {

	private final File logFile;

	/**
	 * Creates new form ViewLog
	 *
	 * @param file
	 */
	public ViewLog(File file) {
		super();
		logFile = file;
		initComponents();
		if (logFile != null) {
			jLabel1.setText("日志文件:" + logFile.getAbsolutePath());
		}
		showLog();
	}

	private void showLog() {
		if (logFile != null && logFile.exists()) {
			try {
				final BufferedReader br = new BufferedReader(new FileReader(logFile));
				br.skip(logFile.length());
				ActionListener listener = (ActionEvent e) -> {
					try {
						String line = br.readLine();
						if (line != null) {
							jTextArea1.append(line + "\n");
						}
					} catch (IOException ex) {
						Logger.getLogger(ViewLog.class.getName()).log(Level.SEVERE, null, ex);
					}
				};
				Timer timer = new Timer(300, listener);
				timer.setRepeats(true);
				timer.start();
			} catch (Exception ex) {
				Logger.getLogger(ViewLog.class.getName()).log(Level.SEVERE, null, ex);
			} finally {

			}

		} else {
			jTextArea1.append("文件不存在\n");
		}
	}

	/**
	 * This method is called from within the constructor to initialize the
	 * form. WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jScrollPane2 = new javax.swing.JScrollPane();
                jLabel1 = new javax.swing.JLabel();

                setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                setTitle("查看日志");
                addWindowListener(new java.awt.event.WindowAdapter() {
                        public void windowClosing(java.awt.event.WindowEvent evt) {
                                formWindowClosing(evt);
                        }
                });

                jTextArea1.setEditable(false);
                jTextArea1.setColumns(20);
                jTextArea1.setRows(5);
                jScrollPane2.setViewportView(jTextArea1);

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 823, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                                .addContainerGap())
                );

                getAccessibleContext().setAccessibleDescription("");

                pack();
                setLocationRelativeTo(null);
        }// </editor-fold>//GEN-END:initComponents

        private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
		
        }//GEN-LAST:event_formWindowClosing


        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JLabel jLabel1;
        private javax.swing.JScrollPane jScrollPane2;
        private final javax.swing.JTextArea jTextArea1 = new javax.swing.JTextArea();
        // End of variables declaration//GEN-END:variables
}
