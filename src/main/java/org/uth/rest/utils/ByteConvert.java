package org.uth.rest.utils;

/**
 * Conversion methods for KB, MB, GB
 * @author Ian Lawson
 */
public class ByteConvert 
{
  private ByteConvert()
  {
  }
  
  public static long asKB( long input )
  {
    return input / 1024;
  }
  
  public static long asMB( long input )
  {
    return input / 1048576;
  }
  
  public static long asGB( long input )
  {
    return input / 1073741824;
  }
}
