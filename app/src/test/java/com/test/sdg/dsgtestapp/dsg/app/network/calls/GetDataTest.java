package com.test.sdg.dsgtestapp.dsg.app.network.calls;

import com.test.sdg.dsgtestapp.first.page.model.IMainActivityModel;

import org.junit.Test;

/**
 * Created by Pankaj Nimgade on 1/25/2018.
 */
public class GetDataTest {


    @Test
    public void testGetDataResponse() {
        System.out.println("Before Calling");
        GetData getData = new GetData("https://movesync-qa.dcsg.com/dsglabs/mobile/api/venue/",
                new IMainActivityModel.VenueCollection() {
                    @Override
                    public void getVenueCollection(String responseText) {
                        System.out.println(responseText);
                    }
                });
        getData.getResponse();
        System.out.println("After Calling");
    }

}