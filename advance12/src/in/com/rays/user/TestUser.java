package in.com.rays.user;

import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;



public class TestUser {

	public static void main(String[] args) throws Exception {
		
		//testAdd();
		//testUpdate();
		//testDelete();
		testSelect();
	}

	private static void testSelect() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserModel model = new UserModel();
		List list = model.search(null, 1, 5);
		Iterator it = list.iterator();
		while(it.hasNext()) {
			UserBean bean = (UserBean) it.next();
		
			System.out.println(bean.getId());
			System.out.print("\t"+bean.getFirstName());
			System.out.print("\t"+bean.getLastName());
			System.out.print("\t"+bean.getLoginId());
			System.out.print("\t"+bean.getPassword());
			System.out.print("\t"+bean.getDob().getTime());
			System.out.println("\t"+bean.getAddress());
		}
		
	}

	private static void testDelete() throws Exception {
		 UserModel model = new UserModel();
		
		model.delete(4);
		
	}


	

	private static void testUpdate() throws Exception {
		UserBean bean = new UserBean();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		bean.setId(2);
		bean.setFirstName("shubham");
		bean.setLastName("naagwanshi");
		bean.setLoginId("shubhammewarams@gmail.com");
		bean.setPassword("pass1234");
		bean.setDob(sdf.parse("1996-08-12"));
		bean.setAddress("vijaynagar");
		UserModel model = new UserModel();
		model.update(bean);
		
	}

	private static void testAdd() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		UserBean bean = new UserBean();
		bean.setFirstName("nikhil");
		bean.setLastName("khandelwal");
		bean.setLoginId("nikhilbawa@gmail.com");
		bean.setPassword("pass1234");
		bean.setDob(sdf.parse("2001-10-11"));
		bean.setAddress("geeta bhawan");
		
		UserModel model = new UserModel();
		model.add(bean);
		
	}
	
	
	
	
}
