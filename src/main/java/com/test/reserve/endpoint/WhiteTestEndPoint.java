package com.test.reserve.endpoint;

import com.test.reserve.service.ExamService;
import com.test.reserve.service.WhiteTestService;
import de.tekup.soap.models.whitetest.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class WhiteTestEndPoint {

    public static final String nameSpace="http://www.tekup.de/soap/models/whitetest";

    @Autowired
    private WhiteTestService WhiteTestservice;

    @Autowired
    private ExamService Examservice;


    // student, date and test information
    @PayloadRoot(namespace = nameSpace, localPart = "StudentRequest")
    @ResponsePayload
    public WhiteTestResponse getTestStatus(@RequestPayload StudentRequest customerRequest) {

        WhiteTestResponse whiteTestResponse =WhiteTestservice.checkWhiteTest(customerRequest);
        return whiteTestResponse;
    }

    //list of exam available
    @PayloadRoot(namespace = nameSpace, localPart = "ExamRequest")
    @ResponsePayload
    public ExamListResponse getListDisponible(@RequestPayload ExamRequest examRequest){
        return Examservice.TestExam();
    }
}
