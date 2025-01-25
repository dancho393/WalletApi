package com.projects.webapi.api.wallet.getbalance;

import com.projects.webapi.api.base.OperationResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class GetWalletBalanceResponse implements OperationResponse {
    private String newBalance;

}
