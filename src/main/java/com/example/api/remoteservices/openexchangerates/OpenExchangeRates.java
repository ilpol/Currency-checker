package com.example.api.remoteservices.openexchangerates;

import feign.Param;
import feign.RequestLine;

public interface OpenExchangeRates {

	@RequestLine("GET /api/latest.json?app_id={apiCurrencyKey}")
	RatesData rate(@Param("apiCurrencyKey") String apiCurrencyKey);

}
