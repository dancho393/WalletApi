package com.projects.webapi.controller;

import com.projects.webapi.api.wallet.add.AddWalletOperation;
import com.projects.webapi.api.wallet.add.AddWalletRequest;
import com.projects.webapi.api.wallet.add.AddWalletResponse;
import com.projects.webapi.api.wallet.deposit.WalletDepositOperation;
import com.projects.webapi.api.wallet.deposit.WalletDepositRequest;
import com.projects.webapi.api.wallet.deposit.WalletDepositResponse;
import com.projects.webapi.api.wallet.getbalance.GetWalletBalanceOperation;
import com.projects.webapi.api.wallet.getbalance.GetWalletBalanceRequest;
import com.projects.webapi.api.wallet.getbalance.GetWalletBalanceResponse;
import com.projects.webapi.api.wallet.withdraw.WalledWithdrawOperation;
import com.projects.webapi.api.wallet.withdraw.WalletWithdrawRequest;
import com.projects.webapi.api.wallet.withdraw.WalletWithdrawResponse;
import com.projects.webapi.model.User;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("api/v1/wallets")
@RequiredArgsConstructor
public class WalletController {
    private final AddWalletOperation addWalletOperation;
    private final GetWalletBalanceOperation getWalletBalanceOperation;
    private final WalletDepositOperation walletDepositOperation;
    private final WalledWithdrawOperation walledWithdrawOperation;

    @PostMapping
    public ResponseEntity<AddWalletResponse> addWallet(
            @RequestBody AddWalletRequest request,
            @AuthenticationPrincipal User user) {

        request.setUser(user);
        return ResponseEntity.ok().body(addWalletOperation.execute(request));
    }
    @GetMapping("{walletId}/balance")
    public ResponseEntity<GetWalletBalanceResponse> getWalletBalance(
            @PathVariable String walletId) {
        GetWalletBalanceRequest request = new GetWalletBalanceRequest(walletId);
        return ResponseEntity.ok().body(getWalletBalanceOperation.execute(request));
    }
    @PatchMapping("{walletId}/deposit")
    public ResponseEntity<WalletDepositResponse> depositMoney(
            @PathVariable String walletId,
            @RequestBody WalletDepositRequest depositRequest
    ){
        depositRequest.setWalletId(walletId);
        return ResponseEntity.ok().body(walletDepositOperation.execute(depositRequest));
    }
    @PatchMapping("{walletId}/withdraw")
    public ResponseEntity<WalletWithdrawResponse> withdrawMoney(
            @PathVariable String walletId,
            @RequestBody WalletWithdrawRequest withdrawRequest
    ){

        withdrawRequest.setWalletId(walletId);
        return ResponseEntity.ok().body(walledWithdrawOperation.execute(withdrawRequest));
    }
}
