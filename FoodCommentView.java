/*
 * FoodCommentView.java
 *
 * Created on __DATE__, __TIME__
 */

package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

import com.mysql.fabric.xmlrpc.base.Data;

import server.Client;

import model.Business;
import model.Comment;
import model.ModelFactory;

/**
 *
 * @author  __USER__
 */
public class FoodCommentView extends javax.swing.JFrame implements
		ActionListener {

	Business business = new Business();
	String foodId;
	
	/** Creates new form FoodCommentView */
	public FoodCommentView() {
		initComponents();
		
		/**
		 * 处理页面美化
		 */
		drawFoodCommentView();
		
		
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public FoodCommentView(Business business, int foodNum) {
		this.business = business;

		initComponents();

		/**
		 * 显示对应食物
		 */
		try {
			this.viewFood(business, foodNum);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/**
		 * 显示所有评论
		 */
		try {
			this.viewAllComment(business.getBid(), ModelFactory.showFood(
					business.getBid()).get(foodNum).getFoodId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		/**
		 * 处理页面美化
		 */
		drawFoodCommentView();
		
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);

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
		jScrollPane1 = new javax.swing.JScrollPane();
		jPanel3 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jPanel2.setPreferredSize(new java.awt.Dimension(100, 150));

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 773,
				Short.MAX_VALUE));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 150,
				Short.MAX_VALUE));

		jScrollPane1
				.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		jPanel3.setPreferredSize(new java.awt.Dimension(100, 10000));

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(
				jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 754,
				Short.MAX_VALUE));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 10000,
				Short.MAX_VALUE));

		jScrollPane1.setViewportView(jPanel3);

		jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel1MouseClicked(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 773,
				Short.MAX_VALUE).addComponent(jScrollPane1,
				javax.swing.GroupLayout.DEFAULT_SIZE, 773, Short.MAX_VALUE)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel1Layout.createSequentialGroup().addContainerGap(
								669, Short.MAX_VALUE).addComponent(jLabel1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 51,
								javax.swing.GroupLayout.PREFERRED_SIZE).addGap(
								53, 53, 53)));
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
												javax.swing.GroupLayout.PREFERRED_SIZE,
												358,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(
												jLabel1,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												48, Short.MAX_VALUE).addGap(16,
												16, 16)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.PREFERRED_SIZE));

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
				new FoodCommentView().setVisible(true);
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

	
	/**
	 * 处理页面美化
	 */
	
	public void drawFoodCommentView() {

		ImageIcon icon = new ImageIcon("Image/flash黑.png");
		Image img = icon.getImage().getScaledInstance(jLabel1.getWidth(),
				jLabel1.getHeight(), Image.SCALE_DEFAULT);

		icon = new ImageIcon(img);
		this.jLabel1.setIcon(icon);
	}
	
	
	/**
	 * 显示对应食物的信息
	 */
	JLabel imageLabel;
	JLabel foodNameLabel;
	JLabel sellCountLabel;
	JLabel describeLabel;
	JLabel foodPriceLabel;
	int foodNum = 0;

	public void viewFood(Business business, int foodNum) throws SQLException,
			ClassNotFoundException {
		this.foodNum = foodNum;

		jPanel2.setSize(jPanel1.getWidth(), 150);
		jPanel2.setLayout(null);
		jPanel2.setBorder(BorderFactory.createEtchedBorder());

		/*添加食物图像*/
		imageLabel = new JLabel();
		ImageIcon icon = new ImageIcon("Image/Food/"
				+ ModelFactory.showFood(business.getBid()).get(foodNum)
						.getImage());
		imageLabel.setBounds(10, 10, 100, 100);

		Image temp = icon.getImage().getScaledInstance(imageLabel.getWidth(),
				imageLabel.getHeight(), Image.SCALE_DEFAULT);
		icon = new ImageIcon(temp);

		imageLabel.setIcon(icon);
		jPanel2.add(imageLabel);

		/*添加食物名称*/
		foodNameLabel = new JLabel(ModelFactory.showFood(business.getBid())
				.get(foodNum).getFoodName());
		foodNameLabel.setBounds(120, 5, 140, 50);
		foodNameLabel.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jPanel2.add(foodNameLabel);

		/*添加销量*/
		sellCountLabel = new JLabel("月售:"
				+ ModelFactory.showFood(business.getBid()).get(foodNum)
						.getSellCount() + "" + "份");
		sellCountLabel.setBounds(120, 40, 140, 50);
		jPanel2.add(sellCountLabel);

		/*添加食物信息*/
		describeLabel = new JLabel("描述:"
				+ ModelFactory.showFood(business.getBid()).get(foodNum)
						.getFoodInformation());
		describeLabel.setBounds(120, 70, 180, 50);
		jPanel2.add(describeLabel);

		/*添加食物价格*/
		foodPriceLabel = new JLabel("￥"
				+ ModelFactory.showFood(business.getBid()).get(foodNum)
						.getFoodPrice());
		foodPriceLabel.setBounds(620, 70, 50, 50);
		jPanel2.add(foodPriceLabel);

	}

	/**
	 * 显示所有评论
	 */

	ArrayList<Comment> comments;
	ArrayList<JPanel> jPanels;
	ArrayList<JLabel> userImageLabels;
	ArrayList<JLabel> userNameLabels;
	ArrayList<JLabel> contentLabels;
	ArrayList<JLabel> replayLabels;
	ArrayList<JLabel> timeLabels;
	ArrayList<JButton> replyButtons;
	Color color;

	public void viewAllComment(String bid, String foodId)
			throws UnknownHostException, IOException, ClassNotFoundException,
			SQLException {
		
		this.foodId = foodId;
		
		Client client = new Client();
		comments = client.viewAllComment(bid, foodId);

		jPanels = new ArrayList<JPanel>();
		userImageLabels = new ArrayList<JLabel>();
		userNameLabels = new ArrayList<JLabel>();
		contentLabels = new ArrayList<JLabel>();
		replayLabels = new ArrayList<JLabel>();
		timeLabels = new ArrayList<JLabel>();
		replyButtons = new ArrayList<JButton>();

		System.out.println("C" + comments.size());
		System.out.println("bid " + bid);
		System.out.println("foodId " + foodId);

		for (int i = 0; i < comments.size(); i++) {

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

			//添加食物图像

			ImageIcon icon = new ImageIcon("Image/Food/"
					+ comments.get(i).getCimage());
			userImageLabels.add(new JLabel());
			jPanels.get(i).setLayout(null);
			userImageLabels.get(i).setBounds(10, 10, 100, 100);

			Image temp = icon.getImage().getScaledInstance(
					userImageLabels.get(i).getWidth(),
					userImageLabels.get(i).getHeight(), Image.SCALE_DEFAULT);
			icon = new ImageIcon(temp);

			userImageLabels.get(i).setIcon(icon);
			userImageLabels.get(i)
					.setBorder(BorderFactory.createEtchedBorder());
			jPanels.get(i).add(userImageLabels.get(i));

			//添加用户名字
			userNameLabels.add(new JLabel(comments.get(i).getCname()));
			userNameLabels.get(i).setBounds(120, 5, 140, 50);
			userNameLabels.get(i).setFont(new java.awt.Font("微软雅黑", 0, 18));
			jPanels.get(i).add(userNameLabels.get(i));

			//添加评论内容
			contentLabels.add(new JLabel(comments.get(i).getComment()));
			contentLabels.get(i).setBounds(120, 40, 140, 50);
			jPanels.get(i).add(contentLabels.get(i));

			//添加回复内容
			replayLabels.add(new JLabel(comments.get(i).getBreplay()));
			replayLabels.get(i).setBounds(120, 70, 140, 50);
			jPanels.get(i).add(replayLabels.get(i));

			/*	//添加时间
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

				timeLabels.add(new JLabel(df.format(comments.get(i).getTime())));
				timeLabels.get(i).setBounds(620, 5, 140, 50);
				jPanels.get(i).add(timeLabels.get(i));*/

			//添加回复按钮
			replyButtons.add(new JButton("回复"));
			replyButtons.get(i).setBounds(620, 70, 50, 40);
			replyButtons.get(i).addActionListener(this);

			jPanels.get(i).add(replyButtons.get(i));

		}

	}

	/**
	 * 回复按钮
	 * */

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for (int i = 0; i < comments.size(); i++) {
			if (e.getSource().equals(replyButtons.get(i))) {

				String replayContent = JOptionPane.showInputDialog(null,
						"请回复：\n", "回复" + comments.get(i).getCname(),
						JOptionPane.PLAIN_MESSAGE);

				try {
					Client client = new Client();
					client.replayComment(comments.get(i).getCid(),
							replayContent);
					JOptionPane.showMessageDialog(this, "回复成功");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(this, "回复失败");
					e1.printStackTrace();
				}
			}

		}
	}
	
	/**
	 * 刷新
	 */
	
	private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		
		try {
			jPanel3.removeAll();
			viewAllComment(business.getBid(), foodId);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}