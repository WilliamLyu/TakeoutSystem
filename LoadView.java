/*
 * LoadView.java
 *
 * Created on __DATE__, __TIME__
 */

package view;

import java.awt.Color;

import javax.swing.ImageIcon;

import model.Business;
import model.Customer;

/**
 *
 * @author  __USER__
 */
public class LoadView extends javax.swing.JFrame {

	Customer Cu;
	Business Bu;
	/** Creates new form LoadView */
	public LoadView(Customer Cu) {
		try {
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
		} catch (Exception e) {
			//TODO exception
		}
		this.Cu=Cu;
		initComponents();
		this.drawLoadView(Cu);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	}
	
	public LoadView(Business Bu) {
		this.Bu=Bu;
		try {
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
		} catch (Exception e) {
			//TODO exception
		}
		
		initComponents();
		this.drawLoadView(Bu);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jProgressBar1 = new javax.swing.JProgressBar();
		jLabel2 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setText("jLabel1");

		jLabel2.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jLabel2.setForeground(new java.awt.Color(255, 255, 255));
		jLabel2.setText("jLabel2");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel1Layout.createSequentialGroup().addGap(76, 76, 76)
						.addComponent(jLabel1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 308,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(83, Short.MAX_VALUE)).addComponent(
				jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 467,
				Short.MAX_VALUE).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				jPanel1Layout.createSequentialGroup().addContainerGap(204,
						Short.MAX_VALUE).addComponent(jLabel2).addGap(201, 201,
						201)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel1Layout.createSequentialGroup().addGap(58, 58, 58)
						.addComponent(jLabel1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 290,
								javax.swing.GroupLayout.PREFERRED_SIZE).addGap(
								83, 83, 83).addComponent(jProgressBar1,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE).addGap(
								18, 18, 18).addComponent(jLabel2,
								javax.swing.GroupLayout.DEFAULT_SIZE, 32,
								Short.MAX_VALUE).addContainerGap()));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	/**
	 * @param args the command line arguments
	 */
	

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JProgressBar jProgressBar1;

	// End of variables declaration//GEN-END:variables

	/**处理主页美化**/
	public void drawLoadView(Customer Cu) {
		jPanel1.setBackground(new Color(95, 142, 230));
		jLabel1.setIcon(new ImageIcon("Image/Load.png"));

		Thread t1 = new Thread(new Load(this, this.jProgressBar1, this.jLabel2,Cu));
		t1.start();

	}
	/**处理主页美化**/
	public void drawLoadView(Business Bu) {
		jPanel1.setBackground(new Color(95, 142, 230));
		jLabel1.setIcon(new ImageIcon("Image/Load.png"));
		Thread t1 = new Thread(new Load(this, this.jProgressBar1, this.jLabel2,Bu));
		t1.start();

	}
}