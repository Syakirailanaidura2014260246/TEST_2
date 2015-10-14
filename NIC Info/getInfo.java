import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class getInfo {
	
   public static void main(String[] args){
		
	InetAddress inet;
	try {
			
		inet = InetAddress.getLocalHost();
		System.out.println("Company IP address : " + inet.getHostAddress());
		
		NetworkInterface nic = NetworkInterface.getByInetAddress(inet);
			
		byte[] mac = nic.getHardwareAddress();
			
		System.out.print("Company MAC address : ");
			
		StringBuilder strb = new StringBuilder();
		for (int i = 0; i < mac.length; i++) {
			strb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));		
		}
		System.out.println(strb.toString());
			
	} catch (UnknownHostException ex) {
		
		ex.printStackTrace();
		
	} catch (SocketException e){
			
		e.printStackTrace();
			
	}
	    
   }

}