package org.uth.rest.mbeans;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import org.uth.rest.utils.ByteConvert;

@Path("/mbeans/memory")
public class Memory
{
  @GET
  @Produces({MediaType.APPLICATION_JSON})
  public String getDetails()
  {
    MemoryMXBean mxbean = ManagementFactory.getMemoryMXBean();
  
    MemoryUsage heapMemory = mxbean.getHeapMemoryUsage();
    
    long committed = heapMemory.getCommitted();
    long init = heapMemory.getInit();
    long max = heapMemory.getMax();
    long used = heapMemory.getUsed();
    
    StringBuilder working = new StringBuilder();
    
    working.append( "{ \"heap\" : \n" );
    working.append( "  {\n" );
    working.append( "    \"initKB\" : " + ByteConvert.asKB(init) + "\",\n" );
    working.append( "    \"initMB\" : " + ByteConvert.asMB(init) + "\",\n" );
    working.append( "    \"initGB\" : " + ByteConvert.asGB(init) + "\",\n" );
    working.append( "    \"maxKB\" : " + ByteConvert.asKB(init) + "\",\n" );
    working.append( "    \"maxMB\" : " + ByteConvert.asMB(init) + "\",\n" );
    working.append( "    \"maxGB\" : " + ByteConvert.asGB(init) + "\",\n" );
    working.append( "    \"usedKB\" : " + ByteConvert.asKB(init) + "\",\n" );
    working.append( "    \"usedMB\" : " + ByteConvert.asMB(init) + "\",\n" );
    working.append( "    \"usedGB\" : " + ByteConvert.asGB(init) + "\",\n" );
    working.append( "    \"committed\" : " + committed + "\"\n" );
    working.append( "  }\n" );
    working.append( "}\n" );
    
    return working.toString();
  }
}
