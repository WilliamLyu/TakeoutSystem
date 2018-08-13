package view;

import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.Business;
import model.Food;
import model.ModelFactory;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import server.Client;

/*
 * shops.java
 *
 * Created on __DATE__, __TIME__
 */

/**
 *
 * @author  __USER__
 */
public class Shops extends javax.swing.JFrame {
	Food food = new Food();
	Business business = new Business();
	
	/** Creates new form shops */
	public Shops() {
		initComponents();
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
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
		jLabel2 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jButton10 = new javax.swing.JButton();
		jButton8 = new javax.swing.JButton();
		jButton7 = new javax.swing.JButton();
		jButton5 = new javax.swing.JButton();
		jButton6 = new javax.swing.JButton();
		jButton9 = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1
				.setText("\u6b22\u8fce\u60a8\u6765\u5230\u9a6c\u4e0a\u70b9\u5916\u5356");

		jLabel2.setText("\u8bf7\u9009\u62e9\u670d\u52a1\uff1a");

		jButton1.setText("\u7269\u54c1\u4e0a\u67b6");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setText("\u7269\u54c1\u4e0b\u67b6");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jButton2ActionPerformed(evt);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		jButton3.setText("\u5f00\u4e1a");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		jButton10.setText("\u67e5\u770b\u7528\u6237\u4e0b\u5355");
		jButton10.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton10ActionPerformed(evt);
			}
		});

		jButton8.setText("\u9884\u6536\u5355\u67e5\u8be2");
		jButton8.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton8ActionPerformed(evt);
			}
		});

		jButton7.setText("\u5546\u5e97\u4fe1\u606f\u7ba1\u7406");
		jButton7.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton7ActionPerformed(evt);
			}
		});

		jButton5.setText("\u5546\u5e97\u4f18\u60e0\u7ba1\u7406");
		jButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton5ActionPerformed(evt);
			}
		});

		jButton6.setText("\u67e5\u770b\u8bc4\u8bba");
		jButton6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton6ActionPerformed(evt);
			}
		});

		jButton9.setText("\u67e5\u770b\u7528\u6237\u50ac\u5355");
		jButton9.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton9ActionPerformed(evt);
			}
		});

		jButton4.setText("\u4f11\u606f");
		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addGap(33, 33, 33)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(
																jButton1,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(jButton7))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jButton5,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																jButton2,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																105,
																Short.MAX_VALUE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																false)
														.addComponent(
																jButton6,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																jButton3,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																92,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(
																jButton10,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																jButton9,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																114,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jButton4,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																101,
																Short.MAX_VALUE)
														.addComponent(
																jButton8,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																101,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(62, 62, 62)).addGroup(
								jPanel1Layout.createSequentialGroup().addGap(
										23, 23, 23).addComponent(jLabel2)
										.addContainerGap(545, Short.MAX_VALUE))
						.addGroup(
								jPanel1Layout.createSequentialGroup().addGap(
										242, 242, 242).addComponent(jLabel1)
										.addContainerGap(278, Short.MAX_VALUE)));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(jLabel1)
										.addGap(31, 31, 31)
										.addComponent(jLabel2)
										.addGap(66, 66, 66)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jButton2)
														.addComponent(jButton8)
														.addComponent(jButton1)
														.addComponent(jButton3)
														.addComponent(jButton10))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jButton5)
														.addComponent(jButton4)
														.addComponent(jButton7)
														.addComponent(jButton6)
														.addComponent(jButton9))
										.addContainerGap(118, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.Alignment.TRAILING,
				javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	/*预收单查询*/
	private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	/*查看用户下单*/
	private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {
		//new FindUserOrder().setVisible(true);
		new ViewUserOrders().setVisible(true);
	}

	/*休息*/
	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
		//new EndBusiness().setVisible(true);
		int openshop = JOptionPane.showConfirmDialog(null, "晚上好呀，休息吗?", "休息",JOptionPane.YES_NO_OPTION);
		if(openshop == 0) {
			try {
				Client client = new Client();
				client.closeShop( "小黄厨");
				
				JOptionPane.showMessageDialog(this, "早点休息哦");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "休息失败");
				e.printStackTrace();
			}
		}
	}

	/*查看用户催单*/
	private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {
		//new FindReminder().setVisible(true);
	}

	/*商店优惠管理*/
	private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
		new DiscountManage().setVisible(true);
	}

	/*商店信息管理*/
	private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
		new InformationManage().setVisible(true);
	}

	/*开业*/
	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		//new StartBusiness().setVisible(true);
		
		int openshop = JOptionPane.showConfirmDialog(null, "早上好呀，开业吗?", "开业",JOptionPane.YES_NO_OPTION);
		if(openshop == 0) {
			try {
				Client client = new Client();
				client.openShop( "小黄厨");
				JOptionPane.showMessageDialog(this, "新的一天，加油哦");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "开业失败");
				e.printStackTrace();
			}
		}
	}

	/*物品下架*/
	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) throws SQLException, ClassNotFoundException, UnknownHostException, IOException {
		//new OffShelves().setVisible(true);
		String foodName = JOptionPane.showInputDialog("请输入要下架的物品：");
		System.out.println(foodName);
		
		Client client = new Client();
		client.downFood(foodName);

	}

	/*物品上架*/
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		
		new GoodsShelves().setVisible(true);
		
	}

	/*查看评论*/
	private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
		//new LookComment().setVisible(true);
		new ViewComments().setVisible(true);
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {

		try {
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Shops().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton10;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JButton jButton5;
	private javax.swing.JButton jButton6;
	private javax.swing.JButton jButton7;
	private javax.swing.JButton jButton8;
	private javax.swing.JButton jButton9;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JPanel jPanel1;
	// End of variables declaration//GEN-END:variables

}