 package server;

import java.io.*;
import java.net.*;
import java.sql.SQLException;
import java.util.ArrayList;

import view.showGoods;

import model.*;

/**
 * 
 * @author Administrator
 * Client: ip, port, oos, ois, s
 * 		   Client, Clogin, Csignout, Cregister, Blogin, Bsignout ,Bregister,
 * 		   Cologin, Cosignout, Coregister, Alogin, Asignout
 */

public class Client implements Protocal {
	
	private String ip = "111.230.73.191";
	private int port = 1388;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	
	public Client() throws UnknownHostException, IOException {
		Socket socket = new Socket(ip, port);
		
		oos = new ObjectOutputStream(socket.getOutputStream());
		ois = new ObjectInputStream(socket.getInputStream());
		
	}
	
	/**�û���½**/
	public Customer cLogin(String id, String password) throws IOException, ClassNotFoundException {
		oos.writeInt(CUSTOMER_LOGIN);
		oos.flush();
		oos.writeUTF(id);
		oos.flush();
		oos.writeUTF(password);
		oos.flush();
		
		Customer customer = (Customer) ois.readObject();
		return customer;
		
	}
	
	/**�̼ҵ�½**/
	public Business bLogin(String id, String password) throws IOException, ClassNotFoundException {
		oos.writeInt(BUSINESS_LOGIN);
		oos.flush();
		oos.writeUTF(id);
		oos.flush();
		oos.writeUTF(password);
		oos.flush();
		
		Business business = (Business) ois.readObject();
		return business;
		
	}
	
	/**������½**/
	public Courier coLogin(String id, String password) throws IOException, ClassNotFoundException {
		oos.writeInt(COURIER_LOGIN );
		oos.flush();
		oos.writeUTF(id);
		oos.flush();
		oos.writeUTF(password);
		oos.flush();
		
		Courier courier = (Courier) ois.readObject();
		return courier;
		
		
	}
	
	/**����Ա��½**/
	public Administrator aLogin(String name, String password) {
		return null;
		
	}
	
	public void cSignout() {
		
	}
	
	public void bSignout() {
		
	}
	
	public void coSignout() {
		
	}
	
	public void aSignout() {
		
	}
	/**
	 * �˿��޸ĸ�����Ϣ
	 */
	public void editInformation(String cid,String cname,String phone,String address) throws IOException, ClassNotFoundException {
		oos.writeInt(CUSTOMER_EDITINFORMATION);
		oos.flush();
		oos.writeUTF(cid);
		oos.flush();
		oos.writeUTF(cname);
		oos.flush();
		oos.writeUTF(phone);
		oos.flush();
		oos.writeUTF(address);
		oos.flush();
	}
	
	/**�û�ע��**/
	public void cRegister(String cid, String cname, String password,
			String sex, String phone, String address) throws IOException, ClassNotFoundException {
		
		oos.writeInt(CUSTOMER_REGISTER);
		oos.flush();
		oos.writeUTF(cid);
		oos.flush();
		oos.writeUTF(cname);
		oos.flush();
		oos.writeUTF(password);
		oos.flush();
		oos.writeUTF(sex);
		oos.flush();
		oos.writeUTF(phone);
		oos.flush();
		oos.writeUTF(address);
		oos.flush();
		
		
	}
	
	/**�û�����
	 * @throws IOException **/
	public void customerBuy(String sid,String cid,String foodid,int count,float price,String orderTime) throws IOException{
		oos.writeInt(CUSTOMER_BUY);
		oos.flush();
		oos.writeUTF(sid);
		oos.flush();
		oos.writeUTF(cid);
		oos.flush();
		oos.writeUTF(foodid);
		oos.flush();
		oos.writeInt(count);
		oos.flush();
		oos.writeFloat(price);
		oos.flush();
		oos.writeUTF(orderTime);
		oos.flush();
	}
	
	
	/**�̼�ע��**/
	public void bRegister(String bid, String bname, String password, 
			String phone, String address) throws IOException {
		
		oos.writeInt(BUSINESS_REGISTER);
		oos.flush();
		oos.writeUTF(bid);
		oos.flush();
		oos.writeUTF(bname);
		oos.flush();
		oos.writeUTF(password);
		oos.flush();
		oos.writeUTF(phone);
		oos.flush();
		oos.writeUTF(address);
		oos.flush();
		
	}
	
	/**����Աע��**/
	public void coRegister(String coid,String coname, String password, 
			String phone, String information) throws IOException {
		
		oos.writeInt(COURIER_REGISTER);
		oos.flush();
		oos.writeUTF(coid);
		oos.flush();
		oos.writeUTF(coname);
		oos.flush();
		oos.writeUTF(password);
		oos.flush();
		oos.writeUTF(phone);
		oos.flush();
		oos.writeUTF(information);
		oos.flush();
		
		
	} 
	
	/**
	 * �û�����
	 */
	
	
	
	/**�鿴�ղ�
	 * @throws ClassNotFoundException 
	 * @throws IOException **/
	
	public ArrayList<Favorite> viewAllFavorite(String cid) throws IOException, ClassNotFoundException {
		oos.writeInt(CUSTOMER_FAVORITE);
		oos.flush();
		oos.writeUTF(cid);
		oos.flush();
		ArrayList<Favorite> favorites = (ArrayList<Favorite>) ois.readObject();
		return favorites;
	}
	
	
	
	/**
	 *�û��鿴���º�� 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public ArrayList<RedEvenlope> viewCRedEvenlope(String cid) throws IOException, ClassNotFoundException {
		oos.writeInt(CUSTOMER_VIEWREDEVENLOPE);
		oos.flush();
		oos.writeUTF(cid);
		oos.flush();
		
		ArrayList<RedEvenlope> redevenlopes = (ArrayList<RedEvenlope>) ois.readObject();
		return redevenlopes;
	}
	
	/**
	 * �û�ɾ�����
	 * @throws IOException 
	 */
	
	/*public void deleteRedEvenlope(String bid, String eid) throws IOException {
		oos.writeInt(CUSTOMER_DELETEREDEVENLOPE);
		oos.flush();
		oos.writeUTF(bid);
		oos.flush();
		oos.writeUTF(eid);
		oos.flush();
	}*/
	
	/**
	 *�û���Ӻ�� 
	 * @throws IOException 
	 */
	
	public void addCRedEvenlope(String cid, String cname, String bid, String bname,
			float favorable, String status) throws IOException {
		oos.writeInt(CUSTOMER_ADDREDEVENLOPE);
		oos.flush();
		oos.writeUTF(cid);
		oos.flush();
		oos.writeUTF(cname);
		oos.flush();
		oos.writeUTF(bid);
		oos.flush();
		oos.writeUTF(bname);
		oos.flush();
		oos.writeFloat(favorable);
		oos.flush();
		oos.writeUTF(status);
		oos.flush();
	}
	
	
	/**
	 *�û�ʹ�ú�� 
	 * @throws IOException 
	 */
	public void useRedEvenlope(String cid, String bid, String isused) throws IOException {
		oos.writeInt(CUSTOMER_USEREDEVENLOPE);
		oos.flush();
		oos.writeUTF(cid);
		oos.flush();
		oos.writeUTF(bid);
		oos.flush();
		oos.writeUTF(isused);
		oos.flush();
		
		
	}
	
	/**
	 * �û�����
	 * @throws IOException 
	 */
	public void commentFood(String cid, String cname, String bid, 
			String bname, String foodId, String foodName, String comment) throws IOException {
		
		oos.writeInt(CUSTOMER_COMMENT);
		oos.flush();
		oos.writeUTF(cid);
		oos.flush();
		oos.writeUTF(cname);
		oos.flush();
		oos.writeUTF(bid);
		oos.flush();
		oos.writeUTF(bname);
		oos.flush();
		oos.writeUTF(foodId);
		oos.flush();
		oos.writeUTF(foodName);
		oos.flush();
		oos.writeUTF(comment);
		oos.flush();
	}
	
	
	
	/**
	 * �̼ҵ�½�ɹ��󣬻�ȡ�Լ��̵����Ϣ
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public Shop getShop(String bid) throws IOException, ClassNotFoundException{
		oos.writeInt(BUSINESS_GETSHOP);
		oos.flush();
		oos.writeUTF(bid);
		oos.flush();
		Shop shop=null;
		shop=(Shop)ois.readObject();
		return shop;
	}
	
	/**�̼ҹ����Լҵ�ʳ��
	 * @throws IOException 
	 * @throws ClassNotFoundException **/
	public ArrayList<Food> showFood(String sid) throws IOException, ClassNotFoundException{
		oos.writeInt(BUSINESS_SHOWFOODS);
		oos.flush();
		oos.writeUTF(sid);
		oos.flush();
		ArrayList<Food> showFood=(ArrayList<Food>)ois.readObject();
		return showFood;
	}
	
	/**�̼��޸ĸ�����Ϣ
	 * @throws IOException **/
	public void modifyInformation(String bid, String phone, String address) throws IOException {
		oos.writeInt(BUSINESS_MODIFYINFORMATION);
		oos.flush();
		oos.writeUTF(bid);
		oos.flush();
		oos.writeUTF(phone);
		oos.flush();
		oos.writeUTF(address);
		oos.flush();
		
	}
	
	
	
	/**��Ʒ�ϼ�
	 * @throws IOException **/
	
	public void upFood(String bid, String bname, String foodId, String foodName, float foodprice, 
			String foodInformation, String foodImage, int sellcount) throws IOException {
		
		oos.writeInt(BUSINESS_UPFOOD);
		oos.flush();
		
		oos.writeUTF(bid);
		oos.flush();
		oos.writeUTF(bname);
		oos.flush();
		oos.writeUTF(foodId);
		oos.flush();
		oos.writeUTF(foodName);
		oos.flush();
		oos.writeFloat(foodprice);
		oos.flush();
		oos.writeUTF(foodInformation);
		oos.flush();
		
		File tempFile =new File(foodImage.trim()); 
		//String fileName = "E://JavaProject/takeoutsystem/Image/" + tempFile.getName();  
		String fileName = "C://Users/ASUS/Desktop/system1/Image/Food/" + tempFile.getName();      
		
	    oos.writeUTF(fileName);
		oos.flush();
		oos.writeInt(sellcount);
		oos.flush();
		
		FileInputStream fis = new FileInputStream(new File(foodImage));
			
		int len = 0;
		byte[]b = new byte[1024];
			
		while((len=fis.read(b))!= -1){
			oos.write(b,0,len);
			oos.flush();

		}
			
		oos.write(b,0,1);
		oos.flush();
		fis.close();
			
	
		
	}
	
	/**��Ʒ�¼�**/
	public void downFood(String foodId) throws IOException {
		oos.writeInt(BUSINESS_DOWNFOOD);
		oos.flush();
		oos.writeUTF(foodId);
		oos.flush();
	}
	
	/**����
	 * @throws IOException **/
	public void openShop(String bname) throws IOException {
		oos.writeInt(BUSINESS_OPEN);
		oos.flush();
		oos.writeUTF(bname);
		oos.flush();
	}
	
	/**��Ϣ
	 * @throws IOException **/
	public void closeShop(String bname) throws IOException {
		oos.writeInt(BUSINESS_CLOSE);
		oos.flush();
		oos.writeUTF(bname);
		oos.flush();
	}
	
	public void customerReminder() {
		
	}
	
	/**�̼Ҳ鿴����
	 * @throws IOException 
	 * @throws ClassNotFoundException **/
	
	public ArrayList<Comment> viewAllComment(String bid, String foodid) throws IOException, ClassNotFoundException {
		oos.writeInt(BUSINESS_VIEWCOMMENT);
		oos.flush();
		oos.writeUTF(bid);
		oos.flush();
		oos.writeUTF(foodid);
		oos.flush();
		ArrayList<Comment> comments = (ArrayList<Comment>) ois.readObject();
		return comments;
		
	}
	
	/**�̼һظ�����
	 * @throws IOException **/
	public void replayComment(String cid, String replay) throws IOException {
		oos.writeInt(BUSINESS_REPLAYCOMMENT);
		oos.flush();
		oos.writeUTF(cid);
		oos.flush();
		oos.writeUTF(replay);
		oos.flush();
	}
	
	/**�̼Ҳ鿴�û�����
	 * @throws IOException 
	 * @throws ClassNotFoundException **/
	public ArrayList<Order> viewAllOrder() throws IOException, ClassNotFoundException {
		oos.writeInt(BUSINESS_VIEWORDER);
		oos.flush();
		
		ArrayList<Order> orders = (ArrayList<Order>) ois.readObject();
		return orders;
	}
	
	
	/**
	 *�̼Ҳ鿴���º�� 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public ArrayList<RedEvenlope> viewRedEvenlope(String bid) throws IOException, ClassNotFoundException {
		oos.writeInt(BUSINESS_VIEWREDEVENLOPE);
		oos.flush();
		oos.writeUTF(bid);
		oos.flush();
		
		ArrayList<RedEvenlope> redevenlopes = (ArrayList<RedEvenlope>) ois.readObject();
		return redevenlopes;
	}
	
	/**
	 * �̼�ɾ�����
	 * @throws IOException 
	 */
	
	public void deleteRedEvenlope(String bid, String eid) throws IOException {
		oos.writeInt(BUSINESS_DELETEREDEVENLOPE);
		oos.flush();
		oos.writeUTF(bid);
		oos.flush();
		oos.writeUTF(eid);
		oos.flush();
	}
	
	/**
	 *�̼���Ӻ�� 
	 * @throws IOException 
	 */
	
	public void addRedEvenlope(String bid, String bname, String eid, 
			float lowerlimit, float favorable, String descript) throws IOException {
		oos.writeInt(BUSINESS_ADDREDEVENLOPE);
		oos.flush();
		oos.writeUTF(bid);
		oos.flush();
		oos.writeUTF(bname);
		oos.flush();
		oos.writeUTF(eid);
		oos.flush();
		oos.writeFloat(lowerlimit);
		oos.flush();
		oos.writeFloat(favorable);
		oos.flush();
		oos.writeUTF(descript);
		oos.flush();
	}
	
	
	
	/**
	 * �û��������
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public ArrayList<Food> searchResult(String search) throws IOException, ClassNotFoundException{
		oos.writeInt(CUSTOMER_SEARCH);
		oos.flush();
		oos.writeUTF(search);
		oos.flush();
		ArrayList<Food> foods=(ArrayList<Food>)ois.readObject();
		return foods;
	}
	
	/**
	 * ��ҳչʾ�̵���Ϣ
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 */
	public ArrayList<Shop> showShop() throws IOException, ClassNotFoundException{
		oos.writeInt(SHOWALLSHOP);
		oos.flush();
		ArrayList<Shop> shops=(ArrayList<Shop>)ois.readObject();
		return shops;
	}
	
	/**
	 * �˿Ͳ鿴����
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public ArrayList<Order> viewOrder(String cid) throws IOException, ClassNotFoundException {
		oos.writeInt(CUSTOMER_VIEWORDER);
		oos.flush();
		oos.writeUTF(cid);
		oos.flush();
		
		ArrayList<Order> viewOrder=(ArrayList<Order>)ois.readObject();
		return viewOrder;
	}
	
	/**
	 * �˿�����
	 * @throws IOException 
	 */
	public void comment(String cid,String cname,String bid,String bname,String foodname,String evaluate) throws IOException{
		oos.writeInt(CUSTOMER_EVOLUATE);
		oos.flush();
		oos.writeUTF(cid);
		oos.flush();
		oos.writeUTF(cname);
		oos.flush();
		oos.writeUTF(bid);
		oos.flush();
		oos.writeUTF(bname);
		oos.flush();
		oos.writeUTF(foodname);
		oos.flush();
		oos.writeUTF(evaluate);
		oos.flush();
	}
	
	
	/**
	 * �˿͹���ʳ��
	 * @return 
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public void buyFood(String bid, String bname, String foodid, String foodName,
			String foodImage, String cid, String cname, float price,
			int count, String state) throws SQLException, ClassNotFoundException, IOException{
		
		oos.writeInt(CUSTOMER_BUYFOOD);
		oos.flush();
		oos.writeUTF(bid);
		oos.flush();
		oos.writeUTF(bname);
		oos.flush();
		oos.writeUTF(foodid);
		oos.flush();
		oos.writeUTF(foodName);
		oos.flush();
		oos.writeUTF(foodImage);
		oos.flush();
		oos.writeUTF(cid);
		oos.flush();
		oos.writeUTF(cname);
		oos.flush();
		oos.writeFloat(price);
		oos.flush();
		oos.writeInt(count);
		oos.flush();
		oos.writeUTF(state);
		oos.flush();
		
	}
	
	/**
	 * �˿���������ղ�
	 * @throws IOException 
	 */
	public void addcollection(String foodname,String image,String bname,String sid,String sname,String cid) throws IOException{
		oos.writeInt(CUSTOMER_COLLECTION);
		oos.flush();
		oos.writeUTF(foodname);
		oos.flush();
		oos.writeUTF(image);
		oos.flush();
		oos.writeUTF(bname);
		oos.flush();
		oos.writeUTF(sid);
		oos.flush();
		oos.writeUTF(sname);
		oos.flush();
		oos.writeUTF(cid);
		oos.flush();
	}
	
	/**
	 * �ͻ�ɾ���ղصĶ���
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public void deleteCollection(String foodname) throws IOException, ClassNotFoundException{
		oos.writeInt(CUSTOMER_DELETECOLLECTION);
		oos.flush();
		oos.writeUTF(foodname);
		oos.flush();
	}
	
	/**
	 * ���칦��
	 */
	
	/**
	 * �û���ϵ�̼�
	 * @throws IOException 
	 */
	
	public void connectBusiness(String cid, String bid, String message) throws IOException {
		oos.writeInt(CUSTOMER_CONNECTBUSINESS);
		oos.flush();
		oos.writeUTF(cid);
		oos.flush();
		oos.writeUTF(bid);
		oos.flush();
		oos.writeUTF(message);
		oos.flush();
	}
	
	/**
	 * �û���ȡ�̼ҷ��͵���Ϣ
	 * @throws IOException
	 */
	
	public String readBusinessMessage() throws IOException {
		return ois.readUTF();
	}
	
	/**
	 * �̼���ϵ�û�
	 * @throws IOException 
	 */
	
	public void connectCustomer(String bid, String cid, String message) throws IOException {
		oos.writeInt(BUSINESS_CONNECTCUSTOMER);
		oos.flush();
		oos.writeUTF(bid);
		oos.flush();
		oos.writeUTF(cid);
		oos.flush();
		oos.writeUTF(message);
		oos.flush();
	}
	
	/**
	 * �̼Ҷ�ȡ�û����͵���Ϣ
	 * @throws IOException 
	 */
	
	public String readCustomerMessage() throws IOException {
		return ois.readUTF();
	}
	
	/**
	 * �ж��̼��Ƿ�Ӫҵ��
	 * @throws IOException 
	 */
	
	public String judgeOperating(String bid) throws IOException {
		
		oos.writeInt(BUSINESS_STATUS);
		oos.flush();
		oos.writeUTF(bid);
		oos.flush();
		
		String status = ois.readUTF();
		
		return status;
	}
}
