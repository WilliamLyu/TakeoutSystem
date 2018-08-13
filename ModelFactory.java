package model;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
/**
 * 
 * @author Administrator
 * ModelFactory: cLogin, bLogin, coLogin, aLogin, getShopDate
 */

public class ModelFactory {
	static Customer Cu=null;
	/**�û���½
	 * @throws ClassNotFoundException 
	 * @throws SQLException */
	
	public static Customer cLogin(String cid, String password) throws SQLException, ClassNotFoundException {
		System.out.println("ceshi");
		return new Customer().cLogin(cid, password);
	}
	
	/**�̼ҵ�½
	 * @throws ClassNotFoundException 
	 * @throws SQLException */

	public static Business bLogin(String bid, String password) throws SQLException, ClassNotFoundException {
		Business business;
		business=Business.bLogin(bid, password);
		return business;
		
	}
	
	/**����Ա��½
	 * @throws ClassNotFoundException 
	 * @throws SQLException */
	
	public static Courier coLogin(String coid, String password) throws SQLException, ClassNotFoundException {
		
		return new Courier().coLogin(coid, password);
	}
	
	/**����Ա��½*/
	public static Administrator aLogin(String id, String password) throws SQLException, ClassNotFoundException {
		
		Administrator administrator = null;
		String sql = "select * from Administrator where id='"+id+"' and password='"+password+"'";
		ResultSet rs = DatabaseConnect.getStat().executeQuery(sql);
		
		if(rs.next()) {
			administrator = new Administrator(id, password);
		}
		
		return administrator;
	}
	
	public void getShopDate() {
		
	}
	
	
	/**�鿴��������
	 * @throws ClassNotFoundException 
	 * @throws SQLException */
	public static ArrayList<Food> viewAllFoods(Homepage homepage) throws SQLException, ClassNotFoundException {
		return homepage.viewAllFood();
	}
	
	/**�û�ע��
	 * @throws IOException */
	
	
	public static void customerRegister(String cid, String cname,
			String password,String sex, String phone, String address) throws SQLException, ClassNotFoundException {
		
		Customer.register(cid, cname, password, sex, phone, address);
		

		
	}
	
	
	/**�̼�ע��*/
	
	
	public static void businessRegister(String bid, String bname,
			String password, String phone, String address) throws SQLException, ClassNotFoundException {
		
		Business.register(bid, bname, password, phone, address);
		
		
	}
	/**����Աע��*/
	
	
	public static void courierRegister(String coid, String coname, 
			String password, String phone, String information) throws SQLException, ClassNotFoundException {
		
		Courier.register(coid, coname, password, phone, information);	
		
	}
	
	/**
	 * �û�����
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	
	/**�鿴�ղ�**/
	public static ArrayList<Favorite> viewAllFavorite(String cid) throws SQLException, ClassNotFoundException {
		ArrayList<Favorite> viewAllFavorite=Customer.viewAllFavorite(cid);
		return viewAllFavorite;
	}
	
	/**
	 * �û��������
	 */
	public static ArrayList<Food> searchResult(String search) throws SQLException, ClassNotFoundException {
		ArrayList<Food> foods=null;
		foods=Food.searchResult(search);
		return foods; 
	}
	
	/**�û��鿴�ѻ���
	 * @throws ClassNotFoundException 
	 * @throws SQLException **/
	public static ArrayList<RedEvenlope> viewCRedEvenlope(Customer customer, String cid) throws SQLException, ClassNotFoundException {
		return customer.viewRedEvenlope(cid);
	}
	
	/**
	 * �û�ɾ�����
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	/*public static void deleteCRedEvenlope(Business business, String bid, String eid) throws SQLException, ClassNotFoundException {
		business.deleteRedEvenlope(bid, eid);
	}*/
	
	/**
	 * �û���Ӻ��
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static void addCRedEvenlope(Customer customer, String cid, String cname, String bid, String bname,
			float favorable, String status) throws SQLException, ClassNotFoundException {
		customer.addRedEvenlope(cid, cname, bid, bname, favorable, status);
	}
	
	
	/**
	 *�û�ʹ�ú�� 
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static void useRedEvenlope(String cid, String bid, String isused) throws SQLException, ClassNotFoundException {
		Customer.useRedEvenlope(cid, bid, isused);
	}
	
	
	
	/**
	 * �û�����
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static void commentFood(String cid, String cname, String bid, 
			String bname, String foodId, String foodName, String comment) throws SQLException, ClassNotFoundException {
		
		Customer.commentFood(cid, cname, bid, bname, foodId, foodName, comment);
	}
	
	
	
	
	/**
	 * �̼ҹ���
	 */
	
	/**�̼��޸ĸ�����Ϣ
	 * @throws ClassNotFoundException 
	 * @throws SQLException **/
	public static void modifyInformation(Business business, String bid, String phone, String address) throws SQLException, ClassNotFoundException {
		
		business.modifyInformation(bid, phone, address);
	}
	
	
	/**��Ʒ�ϼ�
	 * @throws ClassNotFoundException 
	 * @throws SQLException */
	
	/*public static void upFood(String foodName, int foodPrice, 
			String foodInformation, int sellcount) throws SQLException, ClassNotFoundException {
		
		Food.upFood(foodName, foodPrice, foodInformation, sellcount);
		
		
	}*/
	
	
	public static void upFood(String bid, String bname, String foodId, String foodName, float foodPrice, 
			String foodInformation, String foodimage, int sellcount) throws SQLException, ClassNotFoundException {
		
		Food.upFood(bid, bname, foodId, foodName, foodPrice, foodInformation, foodimage, sellcount);
		
		
	}
	
	/*public static void upFood(String foodImage) throws SQLException, ClassNotFoundException {
		
		String sql = "insert into image (image) " +
				"values('"+foodImage+"')";
		
		DatabaseConnect.getStat().executeUpdate(sql);
	}*/
	
	/**��Ʒ�¼�*/
	
	public static void downFood(Food food, String foodId) throws SQLException, ClassNotFoundException {
		food.downFood(foodId);
	}
	
	/**��ҵ*/
	
	public static void openShop(Business business, String bname) throws SQLException, ClassNotFoundException {
		business.openShop(bname);
	}
	
	/**��ҵ*/
	
	public static void closeShop(Business business, String bname) throws SQLException, ClassNotFoundException {
		business.closeShop(bname);
	}
	
	/**�鿴��������
	 * @throws ClassNotFoundException 
	 * @throws SQLException */
	
	/*public static ArrayList<Comment> viewAllComments(Business business) throws SQLException, ClassNotFoundException {
		return business.viewAllComment();
	}*/
	
	public static ArrayList<Comment> viewAllComments(Business business, String bid, String foodid) throws SQLException, ClassNotFoundException {
		return business.viewAllComment(bid, foodid);
	}
	
	
	/**
	 * �ظ�����
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	
	public static void replayComment(Business business, String cid, String replay) throws SQLException, ClassNotFoundException {
		business.replayComment(cid, replay);
	}
	
	
	/**�̼Ҳ鿴���º��
	 * @throws ClassNotFoundException 
	 * @throws SQLException **/
	public static ArrayList<RedEvenlope> viewRedEvenlope(Business business, String bid) throws SQLException, ClassNotFoundException {
		return Business.viewRedEvenlope(bid);
	}
	
	/**
	 * �̼�ɾ�����
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static void deleteRedEvenlope(Business business, String bid, String eid) throws SQLException, ClassNotFoundException {
		business.deleteRedEvenlope(bid, eid);
	}
	
	/**
	 * �̼���Ӻ��
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static void addRedEvenlope(Business business, String bid, String bname, String eid, float lowerlimit,
			float favorable, String descript) throws SQLException, ClassNotFoundException {
		business.addRedEvenlope(bid, bname, eid, lowerlimit, favorable, descript);
	}
	
	/**�鿴���ж���**/
	public static ArrayList<Order> viewAllOrder(Business business) throws SQLException, ClassNotFoundException {
		return business.viewAllOrder();
	}
	
	/**��ҳչʾ�̵�ͼƬ����Ϣ**/
	public static ArrayList<Shop> showShops() throws SQLException, ClassNotFoundException {
		ArrayList<Shop> showShops;
		showShops=Shop.showShops();
		return showShops;
	}
	
	
	/**
	 * �̼ҹ����Լҵ�ʳ��
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static ArrayList<Food> showFood(String bid) throws SQLException, ClassNotFoundException{
		ArrayList<Food> showFood;
		showFood=Food.showFood(bid);
		return showFood;
	}
	/***
	 * �̼ҵ�½�ɹ��󣬻�ȡ�Լ��̵����Ϣ
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static Shop getShop(String bid) throws SQLException, ClassNotFoundException{
		Shop shop=null;
		shop=Shop.getShop(bid);
		return shop;
	}
	
	/**
	 * ��ҳ��ʾ�����̼�
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static ArrayList<Shop> viewAllShop(Customer customer) throws SQLException, ClassNotFoundException {
		return customer.viewAllShop();
	}
	/**
	 * �û��鿴����
	 * @param cid
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static ArrayList<Order> viewOrder(String cid) throws SQLException, ClassNotFoundException{
		ArrayList<Order> viewOrder=null;
		viewOrder=Order.viewOrder(cid);
		return viewOrder;
	}
	
	/**
	 * �˿�����
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws IOException 
	 */
	public static void comment(String cid,String cname,String bid,String bname,String foodname,String evaluate) throws SQLException, ClassNotFoundException{
		Comment comments=null;
		comments.comment(cid, cname, bid, bname, foodname, evaluate);
	}
	
	/**
	 * �˿͹���ʳ��
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	/*public static void buyFood(String foodName,String foodImage,String price,String cid,String sid,String shop,int count,String shopName) throws SQLException, ClassNotFoundException{
		Food.buyFood(foodName, foodImage, price, cid, sid, shop,count,shopName);
	}*/

	
	public static void buyFood(String bid, String bname, String foodid, String foodName,
			String foodImage, String cid, String cname, float price,
			int count, String state) throws SQLException, ClassNotFoundException{
		
		Food.buyFood(bid, bname, foodid, foodName, foodImage, cid, cname, price, count, state);
		
	}
	
	
	/**
	 * �˿��޸ĸ�����Ϣ
	 */
	public static void editInformation(String cid,String cname,String phone,String address) throws SQLException, ClassNotFoundException{
		Customer.editInformation(cid,cname, phone, address);
		
	}
	
	/**
	 * �˿���������ղ�
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public static void addcollection(String foodname,String image,String bname,String sid,String sname,String cid) throws SQLException, ClassNotFoundException{
		Customer.addcollection(foodname, image, bname, sid, sname, cid);
	}
	
	/**
	 * �ͻ�ɾ���ղصĶ���
	 * @return 
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void deleteCollection(String foodname) throws SQLException, ClassNotFoundException{
		Customer.deleteCollection(foodname);
	}
	
	/**
	 * �ж��̼ҷ�Ӫҵ
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	
	public static String judgeOperating(String bid) throws SQLException, ClassNotFoundException {
		return Business.judgeOperating(bid);
	}
}
