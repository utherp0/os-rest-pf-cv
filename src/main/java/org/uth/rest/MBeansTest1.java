package org.uth.rest;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/mbeans1")
public class MBeansTest1
{
  @GET
  @Produces({MediaType.APPLICATION_JSON})
  public String getVendor()
  {
    RuntimeMXBean mxbean = ManagementFactory.getRuntimeMXBean();
    String vendor = mxbean.getVmVendor(); 
    return "{ \"vendor\" : \"" + vendor + "\" }";
  }
}
