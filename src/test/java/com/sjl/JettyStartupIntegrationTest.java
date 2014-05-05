package com.sjl;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

public class JettyStartupIntegrationTest
{

    @Test
    public void homePageReturnsStatusOk() throws Exception
    {
        WebServer server = new WebServer(0);

        server.start();

        server.getLocalPort();

        URL url = new URL("http", "localhost", server.getLocalPort(), "/");
        URLConnection connection = url.openConnection();

        connection.connect();

        InputStream stream = null;
        try
        {
            stream = connection.getInputStream();

            String htmlContents = IOUtils.toString(connection.getInputStream());
            assertThat(htmlContents, containsString("<p>Hi</p>"));
        } finally {
            IOUtils.closeQuietly(stream);
        }
    }
}
