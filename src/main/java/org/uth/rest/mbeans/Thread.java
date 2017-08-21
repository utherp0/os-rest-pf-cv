package org.uth.rest.mbeans;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryUsage;
import java.lang.management.ThreadMXBean;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import org.uth.rest.utils.ByteConvert;

@Path("/mbeans/thread")
public class Thread
{
  @GET
  @Produces({MediaType.APPLICATION_JSON})
  public String getDetails()
  {
    ThreadMXBean mxbean = ManagementFactory.getThreadMXBean();
  
    long[] threadIDs = mxbean.getAllThreadIds();

    StringBuilder working = new StringBuilder();
    
    working.append( "{ \"threads\" : \n" );
    working.append( "  {\n" );
    working.append( "    \"activeCount\" : " + mxbean.getThreadCount() + ",\n" );
    working.append( "    \"historicalCount\" : " + mxbean.getTotalStartedThreadCount() + ",\n" );
    working.append( "    \"peakThreads\" : " + mxbean.getPeakThreadCount() + ",\n" );
    working.append( "    \"daemons\" : " + mxbean.getDaemonThreadCount() + ",\n" );
    working.append( "    \"activeThreads\" : \n" );
    working.append( "    {\n" );
    
    working.append( "    }\n" );
    
    working.append( "  }\n" );
    working.append( "}\n" );
    
    return working.toString();
  }
}
