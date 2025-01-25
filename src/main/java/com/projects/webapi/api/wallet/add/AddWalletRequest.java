package com.projects.webapi.api.wallet.add;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projects.webapi.api.base.OperationRequest;
import com.projects.webapi.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddWalletRequest implements OperationRequest {

    @JsonIgnore
    private User user;
    private String currency;
}
