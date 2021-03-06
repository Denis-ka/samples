package com.example;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author Ivan Khalopik
 * @since 1.0
 */
public class ParameterizedTest extends Assert {
	private DataSource dataSource;

	@Parameters({"driver", "url", "username", "password"})
	@BeforeClass(enabled = false)
	public void setUpDataSource(String driver, String url, @Optional("sa") String username, @Optional String password) {
		dataSource = null;
	}

	@Test(enabled = false)
	public void testOptionalData() throws SQLException {
		dataSource.getConnection();
		// do some staff
	}

}
