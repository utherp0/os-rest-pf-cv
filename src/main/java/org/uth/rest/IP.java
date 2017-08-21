package org.uth.rest;

import java.net.InetAddress;
import java.util.Arrays;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/ip")
public class IP
{
  @GET
  @Produces({MediaType.APPLICATION_JSON})
  public String getLocalIP()
  {
    String localAddress = null;
    
    try
    {
      localAddress = InetAddress.getLocalHost().getHostAddress();    
    }
    catch( Exception exc )
    {
      localAddress = "Unable to attain address due to " + exc.toString();
    }

    return( "{ \"ip\" : \"" + localAddress + "\" }");    
  }
}
