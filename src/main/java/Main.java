import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;
import org.wayfinder.dao.HibernateUtil;
import org.wayfinder.dao.UserDAO;
import org.wayfinder.dao.UserDAOImpl;
import org.wayfinder.entity.UserEntity;

/**
 * Created by Иван on 14.10.14.
 */
public class Main {
    public static void main(String[] args) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        UserEntity user=new UserEntity();
        user=(UserEntity)session.get(UserEntity.class,"00884");
    }
}
