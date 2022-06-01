package com.hrd.basic.myprojectapi.utilities.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.hrd.basic.myprojectapi.model.BasicInformation;

import java.util.List;

public class JsonBasicInformationHandler extends  JsonTypeHandler<List<BasicInformation>>{

    public JsonBasicInformationHandler() {
        super(new TypeReference<List<BasicInformation>>(){});
    }
}
