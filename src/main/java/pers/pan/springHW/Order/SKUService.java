package pers.pan.springHW.Order;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SKUService {
    List<SKU> getAllSKUs();
    void saveSKU(SKU sku);
    SKU getSKUById(long id);
    void deleteSKUById(long id);
}
