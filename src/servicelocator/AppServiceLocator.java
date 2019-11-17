package servicelocator;

public class AppServiceLocator {
	
	private IBookManager service;
	
	public void setService(String ip, String port, String serviceName) {
    	
    	String name = "//" + ip + ":" + port + "/" + serviceName;
    	try {
    		service = (IBookManager) java.rmi.Naming.lookup(name);
    	}
    	catch(Exception e){
    		
    		System.out.println("Server not defined : ");
    		e.printStackTrace();	
    	}
		
	}
	
	public IBookManager getService() { 	
    	return service;
    }

}
