/**
 *
 */
package org.kawanfw.test.api.server.auth;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import org.kawanfw.sql.api.server.auth.SshUserAuthenticator;
import org.kawanfw.sql.servlet.ServerSqlManager;

/**
 * @author Nicolas de Pomereu
 *
 */
public class SshUserAuthenticatorTest {

    /**
     * Tests a login using SSH.
     * @throws IOException
     * @throws SQLException
     */
    public static void test() throws IOException, SQLException {
	ServerSqlManager.setAceqlServerProperties(new File("I:\\_dev_awake\\aceql-http-main\\aceql-http\\conf\\aceql-server.properties"));
	SshUserAuthenticator sshUserAuthenticator = new SshUserAuthenticator();
	boolean logged = sshUserAuthenticator.login("user1", "password1".toCharArray(), "database", "10.0.0.10");
	System.out.println(new Date() + " SshUserAuthenticator logged: " + logged);
    }

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
	test();
    }



}