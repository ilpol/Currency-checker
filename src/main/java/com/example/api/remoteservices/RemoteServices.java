package com.example.api.remoteservices;

import com.example.api.remoteservices.giphy.data.GifData;
import com.example.api.remoteservices.openexchangerates.RatesData;
import com.example.api.remoteservices.giphy.data.Gif;
import com.example.api.remoteservices.giphy.Giphy;
import com.example.api.remoteservices.openexchangerates.OpenExchangeRates;
import com.example.api.remoteservices.openexchangerates.Rates;
import feign.Feign;
import feign.gson.GsonDecoder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.Random;

public class RemoteServices {

	private GifData getRandomElement(List<GifData> list)
	{
		Random rand = new Random();
		return list.get(rand.nextInt(list.size()));
	}

	public float getRate(String name) throws NoSuchFieldException, IllegalAccessException {

		try (InputStream input = new FileInputStream("src/main/resources/application.properties")) {

			Properties prop = new Properties();
			prop.load(input);

		    OpenExchangeRates exchangeRates = Feign.builder()
				.decoder(new GsonDecoder())
				.target(OpenExchangeRates.class, prop.getProperty("apiCurrency"));

		RatesData rateData = exchangeRates.rate(prop.getProperty("apiCurrencyKey"));

		Rates rates = rateData.rates;

		float ratesVal = (float) rates.getClass().getDeclaredField(name).get(rates);

			return ratesVal;
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	public String getGif(boolean isHappy) {
		try (InputStream input = new FileInputStream("src/main/resources/application.properties")) {

			Properties prop = new Properties();

			// load a properties file
			prop.load(input);

			Giphy giphy = Feign.builder()
				.decoder(new GsonDecoder())
				.target(Giphy.class, prop.getProperty("apiGif"));

		Gif gif = null;
		if (isHappy) {
			gif = giphy.rich(prop.getProperty("apiGifKey"), prop.getProperty("happyQuerry"));
		} else {

			gif = giphy.rich(prop.getProperty("apiGifKey"), prop.getProperty("unhappyQuerry"));
		}


			List<GifData> gifData = gif.data;
			GifData randomGifData = getRandomElement(gifData);

		    return randomGifData.images.original.url;
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return "";
	}
}
