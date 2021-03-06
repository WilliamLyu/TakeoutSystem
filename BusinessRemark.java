/*
 * BusinessRemark.java
 *
 * Created on __DATE__, __TIME__
 */

package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Food;
import model.Shop;
import server.Client;

/**
 *
 * @author  __USER__
 */
public class BusinessRemark extends javax.swing.JFrame {

	/** Creates new form BusinessRemark 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 * @throws UnknownHostException */
	public BusinessRemark() throws UnknownHostException, IOException,
			ClassNotFoundException {
		initComponents();
		Remark();
		jPanel2.setBackground(new Color(95, 142, 230));
		jScrollPane1
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jPanel2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,
				Color.LIGHT_GRAY));
		this.setLocationRelativeTo(null);
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		jPanel2 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jPanel3 = new javax.swing.JPanel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18));
		jLabel1.setForeground(new java.awt.Color(255, 255, 255));
		jLabel1.setText("\u8bc4\u8bba");

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel2Layout.createSequentialGroup().addGap(269, 269, 269)
						.addComponent(jLabel1).addContainerGap(310,
								Short.MAX_VALUE)));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel2Layout.createSequentialGroup().addContainerGap()
						.addComponent(jLabel1).addContainerGap(17,
								Short.MAX_VALUE)));

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(
				jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 613,
				Short.MAX_VALUE));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 367,
				Short.MAX_VALUE));

		jScrollPane1.setViewportView(jPanel3);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(jScrollPane1,
						javax.swing.GroupLayout.DEFAULT_SIZE, 615,
						Short.MAX_VALUE));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addComponent(
												jPanel2,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jScrollPane1,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												369, Short.MAX_VALUE)));

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
	public static void main(String args[]) {
		try {
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
		} catch (Exception e) {
			//TODO exception
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new BusinessRemark().setVisible(true);
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JLabel jLabel1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JScrollPane jScrollPane1;
	// End of variables declaration//GEN-END:variables

	/**评论**/

	ArrayList<JPanel> jPanels;
	ArrayList<JLabel> imageLabels;
	ArrayList<JLabel> nameLabels;
	ArrayList<JLabel> describeLabels;
	ArrayList<JLabel> sellCountLabels;
	ArrayList<JLabel> priceLabels;
	ArrayList<JLabel> addLabels;
	Color color;
	ArrayList<JButton> ReplyButton = new ArrayList<JButton>();

	public void Remark() throws UnknownHostException, IOException,
			ClassNotFoundException {

		jPanels = new ArrayList<JPanel>();
		imageLabels = new ArrayList<JLabel>();
		nameLabels = new ArrayList<JLabel>();
		describeLabels = new ArrayList<JLabel>();
		sellCountLabels = new ArrayList<JLabel>();
		priceLabels = new ArrayList<JLabel>();
		addLabels = new ArrayList<JLabel>();

		for (int i = 0; i < 5; i++) {
			/*首先放一个面板进去*/
			jPanels.add(new JPanel());
			jPanels.get(i).setSize(jPanel3.getWidth(), 120);
			jPanels.get(i).setBounds(0, jPanels.get(i).getHeight() * i,
					jPanel3.getWidth(), 120);
			jPanels.get(i).setBorder(BorderFactory.createEtchedBorder());
			jPanel3.add(jPanels.get(i));

			/*设置jPanel面板最大值*/
			Dimension ds = new Dimension(jPanel3.getWidth(), jPanels.get(i)
					.getHeight()
					* i + 150);
			jPanel3.setPreferredSize(ds);

			//获取背景颜色
			color = jPanels.get(i).getBackground();

			/*添加食物图像*/
			ImageIcon icon = new ImageIcon("Image/辣子鸡.jpg");
			imageLabels.add(new JLabel());
			jPanels.get(i).setLayout(null);
			imageLabels.get(i).setBounds(10, 10, 100, 100);
			Image temp = icon.getImage().getScaledInstance(
					imageLabels.get(i).getWidth(),
					imageLabels.get(i).getHeight(), Image.SCALE_DEFAULT);
			icon = new ImageIcon(temp);
			imageLabels.get(i).setIcon(icon);
			jPanels.get(i).add(imageLabels.get(i));

			/*添加商铺名字*/
			nameLabels.add(new JLabel("小黄家"));
			nameLabels.get(i).setBounds(120, 5, 140, 50);
			nameLabels.get(i).setFont(new java.awt.Font("微软雅黑", 0, 18));
			jPanels.get(i).add(nameLabels.get(i));

			/*添加食物名字*/
			sellCountLabels.add(new JLabel("辣子鸡"));
			sellCountLabels.get(i).setBounds(120, 40, 140, 50);
			jPanels.get(i).add(sellCountLabels.get(i));

			/*添加顾客评论*/
			describeLabels.add(new JLabel("评论：挺好吃的"));
			describeLabels.get(i).setBounds(120, 70, 180, 50);
			jPanels.get(i).add(describeLabels.get(i));

			/*添加时间*/
			priceLabels.add(new JLabel("2018-6-4"));
			priceLabels.get(i).setBounds(600, 70, 50, 50);
			jPanels.get(i).add(priceLabels.get(i));

			/*添加回复按钮*/
			ReplyButton.add(new JButton("回复"));
			ReplyButton.get(i).setBounds(500, 65, 50, 50);

			jPanels.get(i).add(ReplyButton.get(i));

			jPanels.get(i).addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					for (int i = 0; i < 5; i++) {
						if (e.getSource().equals(jPanels.get(i))) {

							jPanels.get(i).setBackground(color);

						}

					}
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					for (int i = 0; i < 5; i++) {
						if (e.getSource().equals(jPanels.get(i))) {
							jPanels.get(i).setBackground(
									new Color(255, 255, 255, 255));

						}
					}
				}

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub

				}
			});

		}
	}

}