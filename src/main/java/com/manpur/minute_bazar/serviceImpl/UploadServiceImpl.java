package com.manpur.minute_bazar.serviceImpl;

import com.manpur.minute_bazar.model.Inventory;
import com.manpur.minute_bazar.model.Product;
import com.manpur.minute_bazar.repository.InventoryRepository;
import com.manpur.minute_bazar.repository.ProductRepository;
import com.manpur.minute_bazar.service.UploadService;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UploadServiceImpl implements UploadService {

    private final ProductRepository productRepository;

    private final InventoryRepository inventoryRepository;
    /**
     * @param file
     */
    @Override
    public void uploadExcel(MultipartFile file) {
        try(InputStream is = file.getInputStream()) {
            Workbook workbook = WorkbookFactory.create(is);
            Sheet sheet = workbook.getSheetAt(0);
            List<Product> newStock = new ArrayList<>();
            List<String> quantities = new ArrayList<>();
            for(int rowIdx = 1; rowIdx <= sheet.getLastRowNum(); rowIdx++) {
                Row row = sheet.getRow(rowIdx);
                if(row == null) continue;
                Product product = Product.builder()
                        .name(row.getCell(0).getStringCellValue())
                        .price(row.getCell(1).getNumericCellValue())
                        .unit(row.getCell(2).getStringCellValue())
                        .imageUrl(row.getCell(4).getStringCellValue())
                        .build();

                newStock.add(product);
                quantities.add(row.getCell(3).getStringCellValue());
            }

            List<Product> products = productRepository.saveAll(newStock);
            List<Inventory> inventories = new ArrayList<>();
            for(int inx = 0; inx < products.size(); inx++) {
                Inventory inventory = Inventory.builder()
                        .productId(products.get(inx).getProductId())
                        .stockQuantity(quantities.get(inx))
                        .build();
                inventories.add(inventory);
            }

            inventoryRepository.saveAll(inventories);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
