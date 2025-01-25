package com.projects.webapi.api.wallet.getbalance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projects.webapi.api.base.OperationRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class GetWalletBalanceRequest
 implements OperationRequest {

    private String walletId;
}
