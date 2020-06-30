package com.codelabs.konspirasisnack.connection;

public class ApiUtils {
    private ApiUtils(){}

    public static RetrofitInterface getAPIService(){
        return RetrofitClient.getClient(AppConstant.HostAPI).create(RetrofitInterface.class);
    }
}
