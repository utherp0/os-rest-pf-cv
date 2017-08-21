package org.uth.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/quotas")
public class Quotas
{
  @GET
  @Produces({MediaType.APPLICATION_JSON})
  public String getVisibleQuotas()
  {
    StringBuilder working = new StringBuilder(); 
   
    Runtime runtime = Runtime.getRuntime();
    
    int processors = runtime.availableProcessors();
    long freeMem = runtime.freeMemory();
    long maxMem = runtime.maxMemory();
    long totalMem = runtime.totalMemory();
    
    working.append( "{\"stats\" : {\n");
    working.append( "  \"processors\" : " + processors + ",\n" );
    working.append( "  \"free_memoryKB\" : " + ( freeMem / 1024 ) + ",\n" );
    working.append( "  \"free_memoryMB\" : " + ( freeMem / 1048576 ) + ",\n" );
    working.append( "  \"free_memoryGB\" : " + ( freeMem / 1073741824) + ",\n" );
    working.append( "  \"max_memoryKB\" : " + ( maxMem / 1024 ) + ",\n" );
    working.append( "  \"max_memoryMB\" : " + ( maxMem / 1048576 ) + ",\n" );
    working.append( "  \"max_memoryGB\" : " + ( maxMem / 1073741824 ) + ",\n" );
    working.append( "  \"total_memoryKB\" : " + ( totalMem / 1024 ) + "\n"  );
    working.append( "  \"total_memoryMB\" : " + ( totalMem / 1048576 ) + "\n"  );
    working.append( "  \"total_memoryGB\" : " + ( totalMem / 1073741824 ) + "\n"  );
    working.append( "}}\n");
    
    return working.toString();
  }
}
