package in.co.rays.marksheet;

import java.util.Iterator;
import java.util.List;

public class MarksheetTest {
	public static void main(String[] args) throws Exception {
		
		//testAdd();
		//testUpdate();
		//testDelete();
		//testFindById();
		testSearch();
	}

	private static void testSearch() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		
		//bean.setName("");
		//bean.setRollNo(106);
		
		MarksheetModel model = new MarksheetModel();
		
		List list = model.search(null, 1, 5);
		Iterator it = list.iterator();
		
		while(it.hasNext()) {
			bean = (MarksheetBean) it.next();
			
			System.out.println(bean.getId());
			System.out.print("\t"+bean.getName());
			System.out.print("\t"+bean.getRollNo());
			System.out.print("\t"+bean.getPhysics());
			System.out.print("\t"+bean.getChemistry());
			System.out.println("\t"+bean.getMaths());
		}
		
	}

//	private static void testSearch() throws Exception{
//		MarksheetModel model = new MarksheetModel();
//		List list = model.search();
//		
//		Iterator it = list.iterator();
//		
//		while(it.hasNext()) {
//			MarksheetBean bean = (MarksheetBean) it.next();
//			
//			System.out.println(bean.getId());
//			System.out.print("\t"+bean.getName());
//			System.out.print("\t"+bean.getRollNo());
//			System.out.print("\t"+bean.getPhysics());
//			System.out.print("\t"+bean.getChemistry());
//			System.out.println("\t"+bean.getMaths());
//		}
//	}

	private static void testFindById() throws Exception {
		MarksheetModel model = new MarksheetModel();
		
		MarksheetBean bean = model.findById(9);
		
		if(bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t"+bean.getName());
			System.out.print("\t"+bean.getRollNo());
			System.out.print("\t"+bean.getPhysics());
			System.out.print("\t"+bean.getChemistry());
			System.out.println("\t"+bean.getMaths());
		}else {
			System.out.println("Id does not exist !!!!");
		}
	}

	private static void testDelete() throws Exception {
		MarksheetModel ms = new MarksheetModel();
		
		ms.delete(8);
		
	}

	private static void testUpdate() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		
		bean.setId(9);
		bean.setName("mridula");
		bean.setRollNo(109);
		bean.setPhysics(75);
		bean.setChemistry(84);
		bean.setMaths(60);
		
		MarksheetModel model = new MarksheetModel();
		
		model.update(bean);
		
	}

	private static void testAdd() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		
		bean.setId(9);
		bean.setName("mridula");
		bean.setRollNo(109);
		bean.setPhysics(75);
		bean.setChemistry(84);
		bean.setMaths(56);
		
		MarksheetModel model = new MarksheetModel();
		
		model.add(bean);
		
		
	}

}
