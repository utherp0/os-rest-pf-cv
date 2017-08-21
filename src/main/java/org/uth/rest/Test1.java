package org.uth.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;

@Path("/test1")
public class Test1
{
  @GET
  @Produces("text/plain")
  public String getBasicHTML()
  {
    return "<html><head><title>Test1</title></head><body><b>This is a REST test</b><br/>Should be easy?</body></html>";
  }
}
