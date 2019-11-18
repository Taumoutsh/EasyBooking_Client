package easbooking.client.servicelocator;

import easybooking.server.remote.IBookManager;

public class AppServiceLocator {
	
	private IBookManager service;
	
	public void setService(String args[]) {
    	
    	String name = "//" + args[0] + ":" + args[1] + "/" + args[2];
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
