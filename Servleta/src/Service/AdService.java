package Service;

import java.util.List;

import Domain.Advertisement;

public interface AdService {
	
	public List<Advertisement> adselect(String name);
		
	public int adadd(Advertisement addtest);
	
	public Advertisement adremove(Advertisement adrm);
}
