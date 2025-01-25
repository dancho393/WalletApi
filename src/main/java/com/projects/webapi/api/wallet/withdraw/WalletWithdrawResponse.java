package com.projects.webapi.api.wallet.withdraw;

import com.projects.webapi.api.base.OperationResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WalletWithdrawResponse implements OperationResponse {
    private String updatedBalance;
}
