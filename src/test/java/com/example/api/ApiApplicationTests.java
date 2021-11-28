package com.example.api;

import com.example.api.remoteservices.RemoteServices;
import com.example.api.domain.MoodChooser;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ApiApplicationTests {

	@MockBean
	private RemoteServices remoteServices;

	/*@Test
	void moodChooserHappy() throws NoSuchFieldException, IllegalAccessException {
		Mockito.when(remoteServices.getRate("AED")).thenReturn((float) 0.5);
		//System.out.println("helloService.getMessage() = " + helloService.getMessage());
		MoodChooser moodChooser = new MoodChooser();
		assertEquals(moodChooser.getMood(2), true);
	}

	@Test
	void moodChooserUnHappy() throws NoSuchFieldException, IllegalAccessException {
		Mockito.when(remoteServices.getRate("AED")).thenReturn((float) 0.5);
		//System.out.println("helloService.getMessage() = " + helloService.getMessage());
		MoodChooser moodChooser = new MoodChooser();
		assertEquals(moodChooser.getMood((float) 0.2), false);
	}*/

	@Test
	void moodChooserHappy() throws NoSuchFieldException, IllegalAccessException {
		Mockito.when(remoteServices.getRate("AED")).thenReturn((float) 2);
		//System.out.println("helloService.getMessage() = " + helloService.getMessage());
		MoodChooser moodChooser = new MoodChooser();
		assertEquals(moodChooser.getMood("AED"), true);
	}

	@Test
	void moodChooserUnHappy() throws NoSuchFieldException, IllegalAccessException {
		Mockito.when(remoteServices.getRate("BTC")).thenReturn((float) 0.02);
		//System.out.println("helloService.getMessage() = " + helloService.getMessage());
		MoodChooser moodChooser = new MoodChooser();
		assertEquals(moodChooser.getMood("BTC"), false);
	}


}
