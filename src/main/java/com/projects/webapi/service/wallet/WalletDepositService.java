package com.projects.webapi.service.wallet;

import com.projects.webapi.api.wallet.deposit.WalletDepositOperation;
import com.projects.webapi.api.wallet.deposit.WalletDepositRequest;
import com.projects.webapi.api.wallet.deposit.WalletDepositResponse;
import com.projects.webapi.exception.EntityNotFoundException;
import com.projects.webapi.model.Wallet;
import com.projects.webapi.repo.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WalletDepositService implements WalletDepositOperation {
    private final WalletRepository walletRepository;
    @Override
    public WalletDepositResponse execute(WalletDepositRequest request) {
        Wallet wallet = walletRepository.findById(UUID.fromString(request.getWalletId()))
                .orElseThrow(() -> new EntityNotFoundException("Wallet not found"));
        wallet.setBalance(wallet.getBalance() + request.getAmount());
        walletRepository.save(wallet);

        String response = wallet.getBalance()+" "+wallet.getCurrency();
        return new WalletDepositResponse(response);
    }
}
