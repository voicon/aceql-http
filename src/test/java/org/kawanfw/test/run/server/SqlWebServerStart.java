/*
 * This file is part of AceQL HTTP.
 * AceQL HTTP: SQL Over HTTP
 * Copyright (C) 2020,  KawanSoft SAS
 * (http://www.kawansoft.com). All rights reserved.
 *
 * AceQL HTTP is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * AceQL HTTP is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301  USA
 *
 * Any modifications to this file must keep this entire header
 * intact.
 */
package org.kawanfw.test.run.server;

import java.util.HashMap;
import java.util.Map;

import org.kawanfw.sql.WebServer;
import org.kawanfw.sql.api.server.web.WebServerApi;

/**
 * @author Nicolas de Pomereu
 *
 */
public class SqlWebServerStart {

    private static Map<Integer, String> map = new HashMap<>();

    /**
     * no constructor
     */
    private SqlWebServerStart() {

    }

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

	int port = 9095;

	map.put(port, "I:\\_dev_awake\\aceql-http-main\\aceql-http\\conf\\aceql-server-firewall.properties");
	start(port);

	while(true) {
	    WebServerApi webServerApi = new WebServerApi();
	    if (webServerApi.isServerRunning(port)) {
		System.out.println("Server running on port " + port + "...");
		break;
	    }
	}
    }


    /**
     *
     */
    public static void start(int port) {
	Thread t = new Thread() {
	    @Override
	    public void run() {
		try {
		    String fileStr = map.get(port);
		    String portStr = port + "";
		    WebServer.main(new String[] { "-start", "-host", "localhost", "-port", portStr, "-properties", fileStr });
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	};
	t.start();
    }

}
