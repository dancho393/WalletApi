package com.projects.webapi.api.wallet.deposit;

import com.projects.webapi.api.base.OperationResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class WalletDepositResponse implements OperationResponse {
    private String newBalance;
}
