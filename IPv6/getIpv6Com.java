import java.util.ArrayList;
import java.util.List;
import java.net.*;
import java.net.InetAddress;
import java.net.NetworkInterface;


public class getIpv6Com
{

  public static void main(String[] args)  
  {
     
    try {
     
      InetAddress inet = InetAddress.getLocalHost();
      NetworkInterface netin = NetworkInterface.getByInetAddress(inet);
      String hostName = inet.getHostName();
          
      String address = inet.getHostAddress();
      InetAddress[] totaladdress= inet.getAllByName(hostName);
      System.out.println("\nThe Address of the Local Host:");
          
          for(int i=0; i<totaladdress.length; i++)
          {
              System.out.println(totaladdress[i]);
            }
      
          
      System.out.println("\nIPv4 address:");
            
      if (inet.isAnyLocalAddress()) 
      {
        System.out.println(inet + " , Wildcard address.");
      }
      if (inet.isLoopbackAddress()) 
      {
        System.out.println(inet + " , Loopback Address.");
      }

      if (inet.isLinkLocalAddress()) 
      {
        System.out.println(inet + " , Link-local Address.");
      } 
        else if (inet.isSiteLocalAddress()) 
        {
            System.out.println(inet + " , site-local address.");
        } 
            else 
            {
                System.out.println(inet + " , Global Address.");
            }

      if (inet.isMulticastAddress()) 
      {
        if (inet.isMCGlobal()) 
        {
          System.out.println(inet + " , Global Multicast Address.");
        } 
            else if (inet.isMCOrgLocal()) 
            {
                System.out.println(inet + " , Organization Wide Multicast Address.");
            }
            else if (inet.isMCSiteLocal()) 
            {
                System.out.println(inet + " , Site Wide Multicast Address.");
            } 
            else if (inet.isMCLinkLocal()) 
            {
                System.out.println(inet + " ,Subnet Wide Multicast Address.");
            } 
            else if (inet.isMCNodeLocal()) 
            {
                System.out.println(inet + " ,Interface-Local Multicast Address.");
            } 
                else 
                {
                    System.out.println(inet + " ,is an Unknown Multicast Address Type.");
                }
      } 
        
        else 
        {
        System.out.println(inet + " , Unicast Address.");
        }
      }
    
    catch (SocketException e){
            
        e.printStackTrace();
   }
    
    catch (UnknownHostException u) 
    {
      System.err.println("Could not resolve " + args[0]);
    }   
  }  
}

   