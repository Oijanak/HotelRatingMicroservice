package com.microservices.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


class HotelMicroServiceApplicationTests {

	@Test
	void contextLoads() {
		assertEquals(2+2, 3);
	}
	@Test
	void testMult() {
		assertThat(7*8).isEqualTo(56);
	}

}
