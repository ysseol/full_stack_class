package memo;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import config.HibernateManager;



public class MemoDAO {
	public List<MemoDTO> listMemo(String searchkey, String search) {
		Session session = HibernateManager.getFactory().openSession();
		String sql = "select idx, writer, memo, post_date from memo ";
		if (searchkey.equals("writer_memo")) {
			sql += " where writer like :search or memo like :search ";
		} else {
			sql += " where " + searchkey + " like :search ";
		}
		sql += " order by idx desc ";
		List list = session.createNativeQuery(sql, MemoDTO.class).setParameter("search", "%" + search + "%").getResultList();
		session.close();
		return list;
	}
	
	public void deleteMemo(int idx) {
		Session session = HibernateManager.getFactory().openSession();
		session.beginTransaction();
		MemoDTO dto = new MemoDTO();
		dto.setIdx(idx);
		session.delete(dto);
		session.getTransaction().commit();
		session.close();
	}
	
	public void insertMemo(MemoDTO dto) {
		Session session = HibernateManager.getFactory().openSession();
		session.beginTransaction();
		session.save(dto);
		session.getTransaction().commit();
		session.close();
	}
	
	public void updateMemo(MemoDTO dto) {
		Session session = HibernateManager.getFactory().openSession();
		session.beginTransaction();
		dto.setPost_date(new Date());
		session.update(dto);
		session.getTransaction().commit();
		session.close();
	}
	
	public MemoDTO viewMemo(int idx) {
		Session session = HibernateManager.getFactory().openSession();
		MemoDTO dto = (MemoDTO) session.get(MemoDTO.class, idx);
		session.close();
		return dto;
	}
}
