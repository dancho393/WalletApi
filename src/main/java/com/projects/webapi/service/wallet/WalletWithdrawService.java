package com.projects.webapi.service.wallet;

import com.projects.webapi.api.wallet.withdraw.WalledWithdrawOperation;
import com.projects.webapi.api.wallet.withdraw.WalletWithdrawRequest;
import com.projects.webapi.api.wallet.withdraw.WalletWithdrawResponse;
import com.projects.webapi.exception.EntityNotFoundException;
import com.projects.webapi.exception.NotEnoughBalanceException;
import com.projects.webapi.model.Wallet;
import com.projects.webapi.repo.WalletRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WalletWithdrawService implements WalledWithdrawOperation {
    private final WalletRepository walletRepository;
    @Override
    @Transactional
    public WalletWithdrawResponse execute(WalletWithdrawRequest request) {
        Wallet wallet = walletRepository.findById(UUID.fromString(request.getWalletId()))
                .orElseThrow(() -> new EntityNotFoundException("Wallet not found"));

        if(wallet.getBalance()>=request.getAmount()){
            double newBalance = wallet.getBalance()-request.getAmount();
            wallet.setBalance(newBalance);
            walletRepository.save(wallet);

            String response = wallet.getBalance()+wallet.getCurrency().toString();
            return new WalletWithdrawResponse(response);
        }
        throw  new NotEnoughBalanceException("Sorry But Not Enough Balance. Deposit first please");

    }
}
