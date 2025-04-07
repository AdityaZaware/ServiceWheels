package com.ben.kafka;

import com.ben.entity.Shop;
import com.ben.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaConsumer {

    private final ShopService service;

    @KafkaListener(topics = "service_wheels", groupId = "shop-group")
    public void MechanicRegistered(String email) {
        Shop shop = new Shop();
        shop.setName("Mechanic' Shop");
        shop.setOwnerEmail(email);
        shop.setService("Mechanic");
        service.registerShop(shop);

    }
}
