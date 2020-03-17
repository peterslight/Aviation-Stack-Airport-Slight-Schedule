package com.peterstev.nc_flightradar.provider_modules;

import dagger.Module;
import dagger.Provides;

@Module
public class StringProviderModule {

    @Provides
    String provideString(){
        return "";
    }
}
