package server;

import java.io.*;
import java.net.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import model.*;

/**
 * 
 * @author Administrator
 * Server: ip, port, oos, ois, s, ss
 * 		   Server, Clogin, Csignout, Cregister, Blogin, Bsignout ,Bregister,
 * 		   Cologin, Cosignout, Coregister, Alogin, Asignout
 */

public class Server implements Protocal {

	private int port = 1388;
	private static ObjectInputStream ois;
	private ObjectOutputStream oos;
	private ServerSocket ss;
	
	public Server() throws IOException, SQLException, ClassNotFoundException {
		ss = new ServerSocket(port);
		int count = 1;
		System.out.println("���������ڿ���...");
		
		while(true) {
			Socket s = ss.accept();
			System.out.println("�����������ɹ�");
			System.out.println("��"+count+"���û����ʷ�������"+s.getInetAddress()+new Date());
			count++;
			
			ois = new ObjectInputStream(s.getInputStream());
			oos = new ObjectOutputStream(s.getOutputStream());
			
			int command = ois.readInt();
			if(command == CUSTOMER_LOGIN) {
				cLogin();
			} else if(command == BUSINESS_LOGIN) {
				bLogin();
				System.out.println("���˵�½");
			} else if(command == COURIER_LOGIN) {
				coLogin();
			} else if(command == ADMINISTRATOR_LOGIN) {
				aLogin();
			} else if(command == CUSTOMER_REGISTER) {
				cRegister();
			} else if(command == BUSINESS_REGISTER) {
				bRegister();
			} else if(command == COURIER_REGISTER) {
				coRegister();
			} else if(command == BUSINESS_UPFOOD) {
				upFood();
			} else if(command == BUSINESS_DOWNFOOD) {
				downFood();
			} else if(command == BUSINESS_OPEN) {
				openShop();
			} else if(command == BUSINESS_CLOSE) {
				closeShop();
			} else if(command == BUSINESS_VIEWCOMMENT) {
				viewAllComment();
			} else if(command == BUSINESS_REPLAYCOMMENT) {
				replayComment();
			} else if(command == CUSTOMER_FAVORITE) {
				viewAllFavorites();
			} else if(command == BUSINESS_MODIFYINFORMATION) {
				modifyInformation();
			} else if(command == BUSINESS_VIEWORDER) {
				viewAllOrder();
			} else if(command==CUSTOMER_SEARCH){
				serachResult();
			}else if(command==SHOWALLSHOP){
				showShops();
			}else if(command==BUSINESS_SHOWFOODS){
				showFood();
			}else if(command==BUSINESS_GETSHOP){
				getShop();
			}else if(command==CUSTOMER_VIEWORDER){
				viewOrder();
			}else if(command==CUSTOMER_BUYFOOD){
				buyFood();
			}else if(command == BUSINESS_VIEWREDEVENLOPE) {
				viewRedEvenlope();
			}else if(command == BUSINESS_ADDREDEVENLOPE) {
				addRedEvenlope();
			}else if(command == BUSINESS_DELETEREDEVENLOPE) {
				deleteRedEvenlope();
			}else if(command == CUSTOMER_VIEWREDEVENLOPE) {
				viewCRedEvenlope();
			}else if(command == CUSTOMER_ADDREDEVENLOPE) {
				addCRedEvenlope();
			}else if(command==CUSTOMER_EDITINFORMATION){
				customer_edit_information();
			}else if(command==CUSTOMER_COLLECTION){
				addcollection();
			}else if(command==CUSTOMER_DELETECOLLECTION){
				deleteCollection();
			}else if(command==CUSTOMER_EVOLUATE){
				comment();
			}else if(command == CUSTOMER_USEREDEVENLOPE) {
				useRedEvenlope();
			}else if(command == CUSTOMER_COMMENT) {
				commentFood();
			}else if(command == CUSTOMER_CONNECTBUSINESS) {
				connectBusiness();
			}else if(command == BUSINESS_CONNECTCUSTOMER) {
				connectCustomer();
			}else if(command == BUSINESS_STATUS) {
				judgeOperating();
			}
		}
	}
	
	/**��ҳչʾ�����̵���Ϣ**/
	public void showShops() throws IOException, SQLException, ClassNotFoundException {
		//ArrayList<Shop> shops=ModelFactory.viewAllShop(new Customer());
		ArrayList<Shop> shops=ModelFactory.showShops();
		oos.writeObject(shops);
		oos.flush();
	}
	
	
	/**�û���¼**/
	public void cLogin() throws IOException, SQLException, ClassNotFoundException {
		
		String id = ois.readUTF();
		String password = ois.readUTF();
		Customer customer = ModelFactory.cLogin(id, password);
		System.out.println("���Դ���");
		oos.writeObject(customer);
		oos.flush();
	}
	
	/**�̼ҵ�¼**/
	public void bLogin() throws IOException, SQLException, ClassNotFoundException {
		String id = ois.readUTF();
		String password = ois.readUTF();
		Business business = ModelFactory.bLogin(id, password);
		oos.writeObject(business);
		oos.flush();
		
	}
	
	/**����Ա��¼**/
	public void coLogin() throws IOException, SQLException, ClassNotFoundException {
		String id = ois.readUTF();
		String password = ois.readUTF();
		Courier courier = ModelFactory.coLogin(id, password);
		oos.writeObject(courier);
		oos.flush();
	}
	
	/**����Ա��¼**/
	public void aLogin() {
		
		
	}
	
	/**�û�����
	 * @throws IOException **/
	public void customerBuy() throws IOException{
		String sid=ois.readUTF();
		String cid=ois.readUTF();
		String foodid=ois.readUTF();
		int count=ois.readInt();
		float price=ois.readFloat();
		String orderTime=ois.readUTF();
		
	}
	
	
	/****/
	public void cSignout() {
		
	}
	
	public void bSignout() {
		
	}
	
	public void coSignout() {
		
	}
	
	public void aSignout() {
		
	}
	
	
	/**�û�ע��
	 * @throws IOException **/
	
	public void cRegister() throws IOException, SQLException, ClassNotFoundException {
		String cid = ois.readUTF();
		String cname = ois.readUTF();
		String password = ois.readUTF();
		String sex = ois.readUTF();
		String phone = ois.readUTF();
		String address = ois.readUTF();
		
		
		ModelFactory.customerRegister(cid, cname, password, sex, phone, address);

	}
	
	
	/**�̼�ע��**/
	
	public void bRegister() throws SQLException, ClassNotFoundException, IOException {
		
		String bid = ois.readUTF();
		String bname = ois.readUTF();
		String password = ois.readUTF();
		String phone = ois.readUTF();
		String address = ois.readUTF();
		
		
		ModelFactory.businessRegister(bid, bname, password, phone, address);
	
	}
	
	/**����Աע��
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws SQLException **/
	
	public void coRegister() throws IOException, SQLException, ClassNotFoundException {

		String coid = ois.readUTF();
		String coname = ois.readUTF();
		String password = ois.readUTF();
		String phone = ois.readUTF();
		String information = ois.readUTF();
		
		
		ModelFactory.courierRegister(coid, coname, password, phone, information);
	}
	
	
	
	/**�û��鿴�ղ�
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws SQLException **/
	public void viewAllFavorites() throws IOException, SQLException, ClassNotFoundException {
		String cid=ois.readUTF();
		ArrayList<Favorite> favorites = ModelFactory.viewAllFavorite(cid);
		
		oos.writeObject(favorites);
		oos.flush();
	}
	
	
	/**
	 *�̼Ҳ鿴���º�� 
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public void viewCRedEvenlope() throws SQLException, ClassNotFoundException, IOException {
		String cid = ois.readUTF();
		
		ArrayList<RedEvenlope> redevenlopes = ModelFactory.viewCRedEvenlope(new Customer(), cid);
		
		oos.writeObject(redevenlopes);
		oos.flush();
	}
	
	/**
	 *�û�ɾ����� 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	/*public void deleteRedEvenlope() throws IOException, SQLException, ClassNotFoundException {
		String bid = ois.readUTF();
		String eid = ois.readUTF();
		
		ModelFactory.deleteRedEvenlope(new Business(), bid, eid);
	}*/
	
	/**
	 * �û���Ӻ��
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public void addCRedEvenlope() throws IOException, SQLException, ClassNotFoundException {
		String cid = ois.readUTF();
		String cname = ois.readUTF();
		String bid = ois.readUTF();
		String bname = ois.readUTF();
		float favorable = ois.readFloat();
		String status = ois.readUTF();
		
		ModelFactory.addCRedEvenlope(new Customer(), cid, cname, bid, bname, favorable, status);
	}
	
	/**
	 * �û�ʹ�ú��
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public void useRedEvenlope() throws IOException, SQLException, ClassNotFoundException {
		String cid = ois.readUTF();
		String bid = ois.readUTF();
		String isused = ois.readUTF();
		
		ModelFactory.useRedEvenlope(cid, bid, isused);
	}
	
	/**
	 * �û�����
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public void commentFood() throws IOException, SQLException, ClassNotFoundException {
		String cid = ois.readUTF();
		String cname = ois.readUTF();
		String bid = ois.readUTF();
		String bname = ois.readUTF();
		String foodId = ois.readUTF();
		String foodName = ois.readUTF();
		String comment = ois.readUTF();
		
		ModelFactory.commentFood(cid, cname, bid, bname, foodId, foodName, comment);
	}
	
	
	/**�̼ҹ���**/
	
	/**�̼��޸ĸ�����Ϣ
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws SQLException **/
	public void modifyInformation() throws IOException, SQLException, ClassNotFoundException {
		String bid = ois.readUTF();
		String phone = ois.readUTF();
		String address = ois.readUTF();
		
		ModelFactory.modifyInformation(new Business(), bid, phone, address);
	}
	
	
	
	/**��Ʒ�ϼ�
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws SQLException **/

	
	public void upFood() throws IOException, SQLException, ClassNotFoundException {
		
		String bid = ois.readUTF();
		String bname = ois.readUTF();
		String foodId = ois.readUTF();
		String foodName = ois.readUTF();
		float foodprice = ois.readFloat();
		String foodInformation = ois.readUTF();
		String foodImage = ois.readUTF();
		int sellcount = ois.readInt();
	
		File tempFile =new File(foodImage.trim()); 
		String fileName = tempFile.getName();  
		
		ModelFactory.upFood(bid, bname, foodId, foodName, 
				foodprice, foodInformation, fileName, sellcount);
		
		int len = 0;
		byte[] b = new byte[1024];
		
		File file = new File(foodImage);
		file.createNewFile();
		
		
		FileOutputStream fos = new FileOutputStream(file);
		
		while((len = ois.read(b)) != 1) {
			fos.write(b, 0, len);
			fos.flush();
		}
		
		fos.close();
	}
	
	/**
	 * ��Ʒ�¼�
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public void downFood() throws IOException, SQLException, ClassNotFoundException {
		String foodId = ois.readUTF();
		ModelFactory.downFood(new Food(), foodId);
	}
	
	/**����
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 * @throws IOException **/
	public void openShop() throws SQLException, ClassNotFoundException, IOException {
		String bname = ois.readUTF();
		ModelFactory.openShop(new Business(), bname);
	}
	
	/**�ص�
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 * @throws IOException **/
	public void closeShop() throws SQLException, ClassNotFoundException, IOException {
		String bname = ois.readUTF();
		ModelFactory.closeShop(new Business(), bname);
	}
	
	/**
	 * �̼Ҳ鿴����
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public void viewAllComment() throws SQLException, ClassNotFoundException, IOException {
		String bid = ois.readUTF();
		String foodid = ois.readUTF();
		ArrayList<Comment> comments = ModelFactory.viewAllComments(new Business(), bid, foodid);
		
		oos.writeObject(comments);
		oos.flush();
		
	}
	
	/**�̼һظ�����
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws SQLException **/
	public void replayComment() throws IOException, SQLException, ClassNotFoundException {
		String cid = ois.readUTF();
		String replay = ois.readUTF();
		
		ModelFactory.replayComment(new Business(), cid, replay);
	}
	
	/**
	 * �̼ҹ����Լҵ�ʳ��
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public void showFood() throws IOException, SQLException, ClassNotFoundException{
		String sid=ois.readUTF();
		ArrayList<Food> showFood=ModelFactory.showFood(sid);
		oos.writeObject(showFood);
		oos.flush();
	}
	
	/**
	 * �̼ҵ�½�ɹ��󣬻�ȡ�Լ��̵����Ϣ
	 * @throws IOException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void getShop() throws IOException, SQLException, ClassNotFoundException{
		String bid=ois.readUTF();
		Shop shop=ModelFactory.getShop(bid);
		System.out.println(shop);
		System.out.println(bid);
		oos.writeObject(shop);
		oos.flush();
	}
	
	
	/**
	 * �̼Ҳ鿴�û�����
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public void viewAllOrder() throws SQLException, ClassNotFoundException, IOException {
		
		ArrayList<Order> orders = ModelFactory.viewAllOrder(new Business());
		
		oos.writeObject(orders);
		oos.flush();
	}
	
	
	/**
	 *�̼Ҳ鿴���º�� 
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public void viewRedEvenlope() throws SQLException, ClassNotFoundException, IOException {
		String bid = ois.readUTF();
		
		ArrayList<RedEvenlope> redevenlopes = ModelFactory.viewRedEvenlope(new Business(), bid);
		
		oos.writeObject(redevenlopes);
		oos.flush();
	}
	
	/**
	 *�̼�ɾ����� 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public void deleteRedEvenlope() throws IOException, SQLException, ClassNotFoundException {
		String bid = ois.readUTF();
		String eid = ois.readUTF();
		
		ModelFactory.deleteRedEvenlope(new Business(), bid, eid);
	}
	
	/**
	 * �̼���Ӻ��
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public void addRedEvenlope() throws IOException, SQLException, ClassNotFoundException {
		String bid = ois.readUTF();
		String bname = ois.readUTF();
		String eid = ois.readUTF();
		float lowerlimit = ois.readFloat();
		float favorable = ois.readFloat();
		String descript = ois.readUTF();
		
		ModelFactory.addRedEvenlope(new Business(), bid, bname, eid, lowerlimit, favorable, descript);
	}
	
	/**
	 * �û�������Ʒ
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public void serachResult() throws IOException, SQLException, ClassNotFoundException{
		String search=ois.readUTF();
		ArrayList<Food> foods = ModelFactory.searchResult(search);
		oos.writeObject(foods);
		oos.flush();
	}
	
	/**
	 * �˿Ͳ鿴����
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public void viewOrder() throws IOException, SQLException, ClassNotFoundException{
		String cid=ois.readUTF();
		ArrayList<Order> viewOrder=ModelFactory.viewOrder(cid);
		oos.writeObject(viewOrder);
		oos.flush();
	}
	
	/**
	 * �˿�����
	 * @throws IOException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public void comment() throws IOException, SQLException, ClassNotFoundException{
		String cid=ois.readUTF();
		String cname=ois.readUTF();
		String bid=ois.readUTF();
		String bname=ois.readUTF();
		String foodname=ois.readUTF();
		String evaluate=ois.readUTF();
		ModelFactory.comment(cid, cname, bid, bname, foodname, evaluate);
	}
	
	/**
	 * �˿͹���ʳ��
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public void buyFood() throws IOException, SQLException, ClassNotFoundException{
		String bid = ois.readUTF();
		String bname = ois.readUTF();
		String foodid = ois.readUTF();
		String foodName=ois.readUTF();
		String foodImage=ois.readUTF();
		String cid=ois.readUTF();
		String cname=ois.readUTF();
		
		float price=ois.readFloat();
		int count = ois.readInt();
		
		String state = ois.readUTF();
		
		ModelFactory.buyFood(bid, bname, foodid, foodName, foodImage, cid, cname, price, count, state);
							
	}
	
	/**
	 * �˿��޸ĸ�����Ϣ
	 * @param args
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public void customer_edit_information() throws IOException, SQLException, ClassNotFoundException{
		String cid=ois.readUTF();
		String name=ois.readUTF();
		String phone=ois.readUTF();
		String address=ois.readUTF();
		ModelFactory.editInformation(cid,name,phone,address);
	} 
	
	/**
	 * �˿���������ղ�
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public void addcollection() throws IOException, SQLException, ClassNotFoundException{
		String foodname=ois.readUTF();
		String image=ois.readUTF();
		String bname=ois.readUTF();
		String sid=ois.readUTF();
		String sname=ois.readUTF();
		String cid=ois.readUTF();
		ModelFactory.addcollection(foodname, image, bname, sid, sname, cid);
	}
	
	/**
	 * �ͻ�ɾ���ղصĶ���
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public void deleteCollection() throws IOException, ClassNotFoundException, SQLException{
		String foodname=ois.readUTF();
		ModelFactory.deleteCollection(foodname);
	}
	
	/**********�˿ʹߵ�*************/
	public void customerReminder() {
		
	}
	
	public static void main(String[] args) {
		try {
			new Server();
			//new Server().cRegister();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
			e.printStackTrace();
		}
	}
	
	
	/**
	 * ���칦��
	 */
	
	/**
	 * �û���ϵ�̼�
	 * @throws IOException 
	 * */
	public void connectBusiness() throws IOException {
		String cid = ois.readUTF();
		String bid = ois.readUTF();
		String message = ois.readUTF();
		
		oos.writeUTF(cid);
		oos.flush();
		oos.writeUTF(bid);
		oos.flush();
		oos.writeUTF(message);
		oos.flush();
	}
	
	/**
	 * �̼���ϵ�û�
	 * @throws IOException 
	 * */
	public void connectCustomer() throws IOException {
		String bid = ois.readUTF();
		String cid = ois.readUTF();
		String message = ois.readUTF();
		
		oos.writeUTF(bid);
		oos.flush();
		oos.writeUTF(cid);
		oos.flush();
		oos.writeUTF(message);
		oos.flush();
	}
	
	/**
	 * �ж��̼��Ƿ�Ӫҵ
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 * @throws IOException 
	 */
	
	public void judgeOperating() throws SQLException, ClassNotFoundException, IOException {
		String bid = ois.readUTF();
		
		String status = ModelFactory.judgeOperating(bid);
		
		oos.writeUTF(status);
		oos.flush();
	}
}