package com.projects.webapi.service.wallet;

import com.projects.webapi.api.wallet.getbalance.GetWalletBalanceOperation;
import com.projects.webapi.api.wallet.getbalance.GetWalletBalanceRequest;
import com.projects.webapi.api.wallet.getbalance.GetWalletBalanceResponse;
import com.projects.webapi.exception.EntityNotFoundException;
import com.projects.webapi.model.Wallet;
import com.projects.webapi.repo.WalletRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetWalletBalanceService implements GetWalletBalanceOperation {
    private final WalletRepository walletRepository;

    @Override
    @Transactional
    public GetWalletBalanceResponse execute(GetWalletBalanceRequest request) {
        Wallet wallet = walletRepository.findById(UUID.fromString(request.getWalletId()))
                .orElseThrow(() -> new EntityNotFoundException("Wallet not found"));

        String response = wallet.getBalance()+" "+wallet.getCurrency().toString();

        return new GetWalletBalanceResponse(response);
    }
}
