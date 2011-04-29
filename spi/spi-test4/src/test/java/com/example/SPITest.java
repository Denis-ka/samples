package com.example;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ServiceConfigurationError;

/**
 * @author Ivan Khalopik
 * @since 8.0
 */
public class SPITest extends Assert {

	@DataProvider
	public Object[][] testResolverData() {
		return new Object[][] {
				{ SPIResolver.DEFAULT_SPI_RESOLVER, "test3" },
				{ SPIResolver.SUN_SPI_RESOLVER, "test3" },
		};
	}

	@Test(dataProvider = "testResolverData")
	public void testResolver(final SPIResolver resolver, final String expected) {
		final SomeService service = resolver.resolveImplementation(SomeService.class);
		final String actual = service != null ? service.doSomeThing() : null;
		assertEquals(actual, expected);
	}
}