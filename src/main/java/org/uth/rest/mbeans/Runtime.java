package org.uth.rest.mbeans;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import org.uth.rest.utils.DateFormatter;

@Path("/mbeans/runtime")
public class Runtime
{
  @GET
  @Produces({MediaType.APPLICATION_JSON})
  public String getDetails()
  {
    RuntimeMXBean mxbean = ManagementFactory.getRuntimeMXBean();
    
    StringBuilder working = new StringBuilder();
    
    working.append( "{ \"runtime\" : \n" );
    working.append( "  {\n" );
    working.append( "    \"vendor\" : \n" );
    working.append( "    {\n" );
    working.append( "      \"name\" : \"" + mxbean.getVmVendor() + "\",\n" );
    working.append( "      \"vm\" : \"" + mxbean.getVmName() + "\",\n" );
    working.append( "      \"version\" : \"" + mxbean.getVmVersion() + "\"\n" );
    working.append( "    },\n" );
    working.append( "    \"paths\" : \n" );
    working.append( "    {\n" );
    working.append( "      \"classPath\" : \"" + mxbean.getClassPath() + "\",\n" );
    working.append( "      \"bootClassPath\" : \"" + mxbean.getBootClassPath() + "\",\n" );
    working.append( "      \"libraryPath\" : \"" + mxbean.getLibraryPath() + "\"\n" );
    working.append( "    },\n" );
    working.append( "    \"specifications\" : \n" );
    working.append( "    {\n" );
    working.append( "      \"managementVersion\" : \"" + mxbean.getManagementSpecVersion() + "\",\n" );
    working.append( "      \"name\" : \"" + mxbean.getSpecName() + "\",\n" );
    working.append( "      \"vendor\" : \"" + mxbean.getSpecVendor() + "\",\n" );
    working.append( "      \"version\" : \"" + mxbean.getSpecVersion() + "\"\n" );
    working.append( "    },\n" );
    working.append( "    \"timings\" : \n" );
    working.append( "    {\n" );
    working.append( "      \"startTime\" : \"" + DateFormatter.longDateFormat(mxbean.getStartTime()) + "\",\n" );
    working.append( "      \"upTime\" : " + mxbean.getUptime() + "\n" );
    working.append( "    },\n" );    
    working.append( "  }\n" );
    working.append( "}\n" );
    
    return working.toString();
  }
}
