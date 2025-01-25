package com.projects.webapi.api.wallet.add;


import com.projects.webapi.api.base.OperationResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddWalletResponse implements OperationResponse {
    private String id;
    private double balance;
    private String currency;
    private String owner;
}
