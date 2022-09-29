package com.totnesjava.teamitg;

import java.io.IOException;
import java.net.ServerSocket;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * This is to ensure we get coverage on the main class. A bit OTT, but satifies
 * coverage tools and helps keeps it clean 100%
 * 
 * @author developer
 *
 */
@RunWith(SpringRunner.class)
public class ApplicationStartTest {

	@Test
	public void applicationStarts() throws Exception {
		System.setProperty("server.port", Integer.toString(findFreePortWithoutOpeningIt()));
		TeamITGSpringApplication.main(new String[] {});
	}

	private int findFreePortWithoutOpeningIt() throws IOException {
		ServerSocket s = null;
		try {
			s = new ServerSocket(0);
			return s.getLocalPort();
		} finally {
			s.close();
		}
	}
	
}