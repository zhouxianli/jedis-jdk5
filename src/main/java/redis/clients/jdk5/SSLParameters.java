package redis.clients.jdk5; 

public class SSLParameters
{
  private String[] cipherSuites;
  private String[] protocols;
  private boolean wantClientAuth;
  private boolean needClientAuth;
  
  public SSLParameters() {}
  
  public SSLParameters(String[] paramArrayOfString)
  {
    setCipherSuites(paramArrayOfString);
  }
  
  public SSLParameters(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    setCipherSuites(paramArrayOfString1);
    setProtocols(paramArrayOfString2);
  }
  
  private static String[] clone(String[] paramArrayOfString)
  {
    return paramArrayOfString == null ? null : (String[])paramArrayOfString.clone();
  }
  
  public String[] getCipherSuites()
  {
    return clone(this.cipherSuites);
  }
  
  public void setCipherSuites(String[] paramArrayOfString)
  {
    this.cipherSuites = clone(paramArrayOfString);
  }
  
  public String[] getProtocols()
  {
    return clone(this.protocols);
  }
  
  public void setProtocols(String[] paramArrayOfString)
  {
    this.protocols = clone(paramArrayOfString);
  }
  
  public boolean getWantClientAuth()
  {
    return this.wantClientAuth;
  }
  
  public void setWantClientAuth(boolean paramBoolean)
  {
    this.wantClientAuth = paramBoolean;
    this.needClientAuth = false;
  }
  
  public boolean getNeedClientAuth()
  {
    return this.needClientAuth;
  }
  
  public void setNeedClientAuth(boolean paramBoolean)
  {
    this.wantClientAuth = false;
    this.needClientAuth = paramBoolean;
  }
}
