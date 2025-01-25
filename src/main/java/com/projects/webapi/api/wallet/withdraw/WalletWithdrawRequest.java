package com.projects.webapi.api.wallet.withdraw;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projects.webapi.api.base.OperationRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;

import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class WalletWithdrawRequest implements OperationRequest {
    @JsonIgnore
    private String walletId;
    private Double amount;
}
