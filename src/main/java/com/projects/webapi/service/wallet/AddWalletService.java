package com.projects.webapi.service.wallet;

import com.projects.webapi.api.wallet.add.AddWalletOperation;
import com.projects.webapi.api.wallet.add.AddWalletRequest;
import com.projects.webapi.api.wallet.add.AddWalletResponse;

import com.projects.webapi.exception.InvalidEnumException;
import com.projects.webapi.model.User;
import com.projects.webapi.model.Wallet;
import com.projects.webapi.model.enums.Currency;

import com.projects.webapi.repo.WalletRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddWalletService implements AddWalletOperation {
    private final WalletRepository walletRepository;

    @Override
    public AddWalletResponse execute(AddWalletRequest request) {


            Wallet wallet = buildWallet(request,request.getUser());

            walletRepository.save(wallet);

            return buildWalletResponse(wallet);


    }
    private Wallet buildWallet(AddWalletRequest request,User user){
        try {
            return Wallet.builder()
                    .balance(0.0)
                    .user(user)
                    .currency(Currency.valueOf(request.getCurrency()))
                    .build();
        }
        catch (InvalidEnumException e){
            throw new InvalidEnumException("Invalid currency");
        }
    }
    private AddWalletResponse buildWalletResponse(
            Wallet wallet){

        String ownerName = wallet.getUser().getFirstName()+" "+ wallet.getUser().getLastName();

        return new AddWalletResponse(
                wallet.getId().toString(),
                wallet.getBalance(),
                wallet.getCurrency().toString(),
                ownerName);
    }
}
