package com.co.fraud.entrypoint.service;

import com.co.fraud.crosscuting.exception.NotNameCurrencyValidException;
import com.co.fraud.entrypoint.client.ExchangeServiceClient;
import com.co.fraud.entrypoint.service.implement.AddressIpServiceImpl;
import com.co.fraud.jpa.repository.CountryRepository;
import com.co.fraud.mock.MockFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

class AddressIpServiceImplTest {


    @InjectMocks
    private AddressIpServiceImpl addressIpService;

    @Mock
    private CountryRepository countryRepository;

    @Mock
    private ExchangeServiceClient exchangeServiceClient;



    @BeforeEach
    void setUp() {

        MockitoAnnotations.initMocks(this);
        Mockito.when(countryRepository.findAll()).thenReturn(MockFactory.countryDaoListMock());
        Mockito.when(countryRepository.findByNumberCode(ArgumentMatchers.anyString())).thenReturn(MockFactory.countryDaoOptionalMock());
        Mockito.when(countryRepository.save(MockFactory.countryDaoMock())).thenReturn(MockFactory.countryDaoMock());
        Mockito.when(exchangeServiceClient.getExchangeByCountry("USD")).thenReturn(MockFactory.exchangeRsMock());
        Mockito.when(countryRepository.findFirstByOrderByDistanceCountryAsc()).thenReturn(MockFactory.countryDaoMock());
        Mockito.when(countryRepository.findFirstByOrderByDistanceCountryDesc()).thenReturn(MockFactory.countryDaoMock());
    }

    @Test
    void callCalculateAverageValidResponse(){
        Assertions.assertNotNull(addressIpService.calculateAverage());
    }

    @Test
    void callSaveStatisticsValidResponse(){
        Assertions.assertNotNull(addressIpService.saveStatistics("548",
                "USA",14.265));
    }

    @Test
    void callGetExchangeValueValidResponse(){
        Assertions.assertNotNull(addressIpService.getExchangeValue(MockFactory.dataCountryRSListMock(),1040.356,"10.236.548"));
    }

    @Test
    void callGetDistancethenThrowsException(){
        Assertions.assertThrows(NotNameCurrencyValidException.class, () -> {
            Mockito.when(addressIpService.getDistance(MockFactory.dataCountryRSListMockNodata())).thenThrow();
                });

    }

    @Test
    void callGetDistanceValidResponse(){
        Assertions.assertNotNull(addressIpService.getDistance(MockFactory.dataCountryRSListMock()));
    }


    @Test
    void callgetDaaMaxValueCountryValidResponse(){
        Assertions.assertNotNull(addressIpService.getDaaMaxValueCountry());
    }

    @Test
    void callgetDaaMinValueCountryValidResponse(){
        Assertions.assertNotNull(addressIpService.getDataMinValueCountry());
    }


    @Test
    void callGetDataAverageConsultsValidResponse(){
        Assertions.assertNotNull(addressIpService.getDataAverageConsults());
    }



}
