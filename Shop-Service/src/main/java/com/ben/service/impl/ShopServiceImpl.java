package com.ben.service.impl;

import com.ben.entity.Shop;
import com.ben.repo.ShopRepo;
import com.ben.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService {

    private final ShopRepo shopRepo;

    @Override
    public Shop registerShop(Shop shop) {
        Shop savedShop = shopRepo.save(shop);
        return savedShop;
    }

    @Override
    public Shop updateShop(Shop shop, Long id) {
        Shop existing = getShop(id);
        existing.setName(shop.getName());
        existing.setOwnerEmail(shop.getOwnerEmail());
        existing.setAddress(shop.getAddress());
        existing.setOwnerPhone(shop.getOwnerPhone());
        existing.setOwnerName(shop.getOwnerName());
        existing.setService(shop.getService());
        existing.setVehicleType(shop.getVehicleType());
        Shop updatedShop = shopRepo.save(existing);
        return updatedShop;
    }

    @Override
    public Shop getShop(Long shopId) {
        return shopRepo.findById(shopId).get();
    }

    @Override
    public void deleteShop(Long shopId) {
        shopRepo.deleteById(shopId);
    }

    @Override
    public List<Shop> getShopByVehicleType(String vehicleType) {
        List<Shop> shops = shopRepo.findByVehicleType(vehicleType);
        return shops;
    }

    @Override
    public Optional<Shop> getShopByOwnerEmail(String email) {
        Optional<Shop> shop = shopRepo.findByOwnerEmail(email);
        return shop;
    }


}
