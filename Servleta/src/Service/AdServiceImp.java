package Service;


import java.util.List;

import Dao.AdDao;
import Dao.AdDaoImp;
import Domain.Advertisement;


public class AdServiceImp implements AdService{
	AdDao dao = new AdDaoImp();

	@Override
	public List<Advertisement> adselect(String name) {
		return dao.list(name) ;
	}

	@Override
	public int adadd(Advertisement addtest) {
		return dao.add(addtest);
	}

	@Override
	public Advertisement adremove(Advertisement adrm) {
		return dao.remove(adrm);
	}


}
