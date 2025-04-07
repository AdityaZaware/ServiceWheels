package com.ben.User.Service.external;

import com.ben.User.Service.dto.ShopDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "SHOP-SERVICE", url = "http://localhost:8082/api/shop/")
public interface ShopService {

    @PostMapping("/register")
    ShopDto registerShop(@RequestBody ShopDto shopDto);

    @GetMapping("/{email}")
    ShopDto getShopByOwnerEmail(@PathVariable String email);

    @GetMapping("/vehicleType/{vehicleType}")
    public List<ShopDto> getShopByVehicleType(@PathVariable String vehicleType);
}
