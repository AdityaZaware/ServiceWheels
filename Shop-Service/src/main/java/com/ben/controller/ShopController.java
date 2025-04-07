package com.ben.controller;

import com.ben.entity.Shop;
import com.ben.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/shop")
public class ShopController {

    private final ShopService shopService;

    @GetMapping
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello");
    }

    @PostMapping("/register")
    public ResponseEntity<Shop> registerShop(@RequestBody Shop shop) {
        Shop registeredShop = shopService.registerShop(shop);
        return ResponseEntity.ok(registeredShop);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Shop> getShop(@PathVariable Long id) {
        Shop shop = shopService.getShop(id);
        return ResponseEntity.ok(shop);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Shop> updateShop(@RequestBody Shop shop, @PathVariable Long id) {
        Shop updatedShop = shopService.updateShop(shop, id);
        return ResponseEntity.ok(updatedShop);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteShop(@PathVariable Long id) {
        shopService.deleteShop(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{email}")
    public ResponseEntity<Shop> getShopByOwnerEmail(@PathVariable String email) {
        Optional<Shop> shop = shopService.getShopByOwnerEmail(email);
        return shop.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/vehicleType/{vehicleType}")
    public ResponseEntity<List<Shop>> getShopByVehicleType(@PathVariable String vehicleType) {
        return ResponseEntity.ok(shopService.getShopByVehicleType(vehicleType));
    }
}
