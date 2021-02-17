package com.kiran.ds.generics;

import java.util.Arrays;

public class ResponseBuilder {

    public Response buildResponse(String condition) {
        BlahResponse blahresponse = new BlahResponse();
        if(condition.equals("blah")) {
            Response response = new Response<BlahResponse>();

            blahresponse.setName("abc");
            response.setData(Arrays.asList(blahresponse));
            return response;
        } else {
            Response response = new Response<NonBlahResponse>();
            response.setData(Arrays.asList(new NonBlahResponse()));
            return response;
        }

    }

    public static void main(String[] args) {
        ResponseBuilder builder = new ResponseBuilder();
        System.out.println(builder.buildResponse("blah").toString());
        System.out.println(builder.buildResponse("nonblah").toString());
    }
}
