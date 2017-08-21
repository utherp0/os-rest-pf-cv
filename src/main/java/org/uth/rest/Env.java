package org.uth.rest;

import java.util.Arrays;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/env")
public class Env
{
  @GET
  @Produces({MediaType.APPLICATION_JSON})
  public String getSortedENV()
  {
    StringBuilder working = new StringBuilder(); 
   
    long start = System.currentTimeMillis();
    
    Map<String,String> envs = System.getenv();
    String[] sorted = new String[envs.keySet().size()];

    int pos = 0;
    for( String envName : envs.keySet())
    {
      sorted[pos] = envName;
      pos++;
    }
    
    Arrays.parallelSort(sorted);
    
    long end = System.currentTimeMillis();
    
    working.append( "{ \"envs\" : {\n" );
    working.append( "  \"duration\" : \"" + ( end - start ) + "\",\n");
    working.append( "  \"values\" : {\n");
    
    for( int loop = 0; loop < sorted.length; loop++ )
    {
      working.append( "    \"" + sorted[loop] + "\" : \"" + envs.get(sorted[loop]) + "\"" + ( loop != ( sorted.length - 1 ) ? "," : "" ) + "\n" );
    }
    
    working.append( "  }\n");    
    
    working.append("}}");
    
    return working.toString();
  }
}
