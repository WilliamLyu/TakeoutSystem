/*
 * ViewComments.java
 *
 * Created on __DATE__, __TIME__
 */

package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import server.Client;

import model.Business;
import model.Comment;
import model.ModelFactory;

/**
 *
 * @author  __USER__
 */
public class ViewComments extends javax.swing.JFrame implements ActionListener {
	Business business = new Business();

	/** Creates new form ViewComments 
	 * @throws ClassNotFoundException 
	 * @throws SQLException */
	public ViewComments() {

		initComponents();
		/*//this.addPanel();
		try {
			this.getAllComments();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
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
		jLabel1 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jPanel2 = new javax.swing.JPanel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jLabel1.setText("\u67e5\u770b\u8bc4\u8bba");

		jScrollPane1
				.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		jPanel2.setPreferredSize(new java.awt.Dimension(100, 10000));

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 532,
				Short.MAX_VALUE));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 10000,
				Short.MAX_VALUE));

		jScrollPane1.setViewportView(jPanel2);

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
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGap(
																				245,
																				245,
																				245)
																		.addComponent(
																				jLabel1))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				jScrollPane1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				551,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(28, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel1Layout.createSequentialGroup().addGap(25, 25, 25)
						.addComponent(jLabel1).addGap(18, 18, 18).addComponent(
								jScrollPane1,
								javax.swing.GroupLayout.DEFAULT_SIZE, 429,
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
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {

				new ViewComments().setVisible(true);

			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JLabel jLabel1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane1;

	// End of variables declaration//GEN-END:variables

	/**查看所有评论
	 * @throws ClassNotFoundException 
	 * @throws SQLException */
	ArrayList<Comment> comments;
	ArrayList<JButton> replayButtons = new ArrayList<JButton>();
	/*
	public void getAllComments() throws SQLException, ClassNotFoundException, UnknownHostException, IOException {
		/*Client client = new Client();
		comments = client.viewAllComment();
		
		ArrayList<JPanel> jPanels = new ArrayList<JPanel>();
		ArrayList<JLabel> imgLabels = new ArrayList<JLabel>();
		ArrayList<JLabel> nameLabels = new ArrayList<JLabel>();
		ArrayList<JLabel> contentLabels = new ArrayList<JLabel>();
		ArrayList<JLabel> replayLabels = new ArrayList<JLabel>();
		
		jPanel2.setLayout(null);
		
		System.out.println(comments.size());


		for (int i = 0; i < comments.size(); i++) {
			
			
			创建面板存储用户
			jPanels.add(new JPanel());
			jPanels.get(i).setSize(jPanel2.getWidth(), 150);
			jPanels.get(i).setBounds(0, jPanels.get(i).getHeight() * i, jPanel2.getWidth(), 150);
			jPanels.get(i).setBorder(BorderFactory.createEtchedBorder());
			jPanel2.add(jPanels.get(i));
			
			设置jPanel2面板最大值
			Dimension ds = new Dimension(jPanel2.getWidth(), jPanels.get(i).getHeight() * i + 300);
			jPanel2.setPreferredSize(ds);
			
			显示用户评论
			
			
			添加用户头像
			imgLabels.add(new JLabel(new ImageIcon(ModelFactory.viewAllComments(business).get(i).getCimage())));
			
			jPanels.get(i).setLayout(null);
			imgLabels.get(i).setBounds(20, 30, 80, 80);
			imgLabels.get(i).setBorder(BorderFactory.createEtchedBorder());
			jPanels.get(i).add(imgLabels.get(i));
			
			添加用户名
			nameLabels.add(new JLabel(ModelFactory.viewAllComments(business).get(i).getCname()));
			
			jPanels.get(i).setLayout(null);
			nameLabels.get(i).setBounds(120, 30, 100, 20);
			jPanels.get(i).add(nameLabels.get(i));

			添加用户评论
			contentLabels.add(new JLabel(ModelFactory.viewAllComments(business).get(i).getComment()));
			
			jPanels.get(i).setLayout(null);
			contentLabels.get(i).setBounds(120, 60, 200, 20);
			jPanels.get(i).add(contentLabels.get(i));
			
			
			添加回复评论按钮
			replayButtons.add(new JButton("回复"));
			
			jPanels.get(i).setLayout(null);
			replayButtons.get(i).setBounds(400, 110, 60, 20);
			jPanels.get(i).add(replayButtons.get(i));
			
			replayButtons.get(i).addActionListener(this);
			
			回复评论内容
			replayLabels.add(new JLabel(ModelFactory.viewAllComments(business).get(i).getBreplay()));
			
			jPanels.get(i).setLayout(null);
			replayLabels.get(i).setBounds(120, 100, 200, 20);
			jPanels.get(i).add(replayLabels.get(i));
		}
	}*/
/*
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int i = 0; i < comments.size();i++) {
			if(e.getSource().equals(replayButtons.get(i))) {
				
				String replay = JOptionPane.showInputDialog("请回复评论：");
				try {
					Client client = new Client();
					client.replayComment(ModelFactory.viewAllComments(business).get(i).getCid() ,replay);
					
					//this.refresh();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(this, "请检查您的网络");
					e1.printStackTrace();
				}

			}
		}
		
	}
	*/
	/*刷新*/
	/*public void refresh() {
		try {
			this.getAllComments();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
	}*/

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}