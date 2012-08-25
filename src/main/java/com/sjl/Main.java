package com.sjl;

public class Main
{
	public static void main(String... anArgs) throws Exception
    {
        new Main().start();
    }
	
	private WebServer server;
    
    public Main()
    {
        server = new WebServer(8000);        
    }
    
    public void start() throws Exception
    {
        server.start();        
        server.join();
    }
}
