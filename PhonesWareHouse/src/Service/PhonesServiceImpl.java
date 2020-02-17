package Service;
import java.util.List;
import Bean.PhoneBean;
import Dao.PhonesDao;
import Dao.PhonesDaoImpl;
public class PhonesServiceImpl  implements PhonesService{
	public List<PhoneBean> getAllPhones() {
   PhonesDao phonesDao=new PhonesDaoImpl();
		return phonesDao.getAllPhones();
	}
}