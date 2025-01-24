package com.projects.webapi.api.base;

public interface Operation  <I extends OperationRequest, O extends OperationResponse>{
    O execute(I request);
}
