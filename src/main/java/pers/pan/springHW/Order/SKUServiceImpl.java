package pers.pan.springHW.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SKUServiceImpl implements SKUService {
    @Autowired
    private SKURepository skuRepository;

    @Override
    public List<SKU> getAllSKUs() {
        return skuRepository.findAll();
    }

    @Override
    public void saveSKU(SKU sku) {
        this.skuRepository.save(sku);
    }

    @Override
    public SKU getSKUById(long id) {
        Optional<SKU> optional = skuRepository.findById(id);
        SKU sku = null;
        if (optional.isPresent()) {
            sku = optional.get();
        } else {
            throw new RuntimeException(" SKU not found for id :: " + id);
        }
        return sku;
    }

    @Override
    public void deleteSKUById(long id) {
        this.skuRepository.deleteById(id);
    }
}
