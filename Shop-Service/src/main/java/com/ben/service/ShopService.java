package com.ben.service;


import com.ben.entity.Shop;

import java.util.List;
import java.util.Optional;

public interface ShopService {

    public Shop registerShop(Shop shop);

    public Shop updateShop(Shop shop, Long id);

    public Shop getShop(Long shopId);

    public void deleteShop(Long shopId);

    public List<Shop> getShopByVehicleType(String vehicleType);

    public Optional<Shop> getShopByOwnerEmail(String email);
}
