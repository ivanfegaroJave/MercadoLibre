package com.co.fraud.entrypoint.controller;

import com.co.fraud.domain.AverageRs;
import com.co.fraud.entrypoint.service.implement.AddressIpServiceImpl;
import com.co.fraud.jpa.entity.CountryDao;
import com.co.fraud.jpa.repository.CountryRepository;
import com.co.fraud.mock.MockFactory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

 class AddressIPControllerTest {

    @Mock
    private AddressIpServiceImpl addressIpService;
    @InjectMocks
    private AddressIPController addressIPController;
    @Mock
    private CountryRepository countryRepository;


    @BeforeEach
     void setUp(){
        MockitoAnnotations.initMocks(this);
        Mockito.when(countryRepository.findFirstByOrderByDistanceCountryAsc()).thenReturn(MockFactory.countryDaoMock());
        Mockito.when(countryRepository.findFirstByOrderByDistanceCountryDesc()).thenReturn(MockFactory.countryDaoMock());
       Mockito.when(countryRepository.findAll()).thenReturn(MockFactory.countryDaoListMock());
    }

    @Test
     void WhenCallServiceGetMaxCountryResponseValid(){
        Assertions.assertNotNull(addressIPController.getMaxCountry());
    }

    @Test
     void getDescValue(){
        ResponseEntity<CountryDao> country = addressIPController.getMaxCountry();
        Assertions.assertEquals(HttpStatus.OK,country.getStatusCode());
    }

    @Test
     void getAscValue(){
        ResponseEntity<CountryDao> country = addressIPController.getMinCountry();
        Assertions.assertEquals(HttpStatus.OK,country.getStatusCode());
    }

    @Test
    void WhenCallServiceGetMinCountryResponseValid(){
       Assertions.assertNotNull(addressIPController.getMinCountry());
    }

    @Test
    void WhenCallServiceGetAverageCountryResponseValid(){
       Assertions.assertNotNull(addressIPController.getAverageStatistics());
    }

    @Test
    void getAverageValue(){
       ResponseEntity<AverageRs> country = addressIPController.getAverageStatistics();
       Assertions.assertEquals(HttpStatus.OK,country.getStatusCode());
    }

 }
