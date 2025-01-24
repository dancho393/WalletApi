package com.projects.webapi.service.base;

public interface Operation  <I extends OperationRequest, O extends OperationResponse>{
    O execute(I request);
}
