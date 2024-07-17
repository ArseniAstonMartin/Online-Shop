package com.example.demo.services;

import com.example.demo.AmazonRepositories.ProductRepository;
import com.example.demo.entiteas.Image;
import com.example.demo.entiteas.Product;
import com.example.demo.errors.NoPreviewImageException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product findById(long id) {
        Product product = productRepository.findById(id);
        log.info("Returning with id= {}: {}", id, product.getTitle());
        return product;
    }

    public List<Product> findByTitleContainingIgnoreCase(String title) {
        List<Product> products = productRepository.findByTitleContainingIgnoreCase(title);
        StringBuilder str = new StringBuilder();
        products.forEach(x-> str.append(x.getTitle()).append("\n"));
        log.info("Returning with title= {}: {}", title, str);
        return products;
    }

    public List<Product> findAll() {
        List<Product> products = productRepository.findAll();
        log.info("Returning all products. ");
        return products;
    }
    public Product deleteById(long id) {
        Product product = productRepository.findById(id);
        log.info("Deleting with id= {}: {}", id, product.getTitle());
        productRepository.deleteById(id);
        log.info("Returning deleted product with id= {}: {}", id, product.getTitle());
        return product;
    }

    public void save(Product product, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException, NoPreviewImageException {
        Image image1 = toImage(file1);
        Image image2 = toImage(file2);
        Image image3 = toImage(file3);
        this.save(product, image1, image2, image3);
        /*if (image1.getSize() != 0) {
            image1.setPreviewImage(true);
            product.addImageToProduct(image1);
        }
        else throw new NoPreviewImageException();
        if (image2.getSize() != 0) {
            product.addImageToProduct(image2);
        }
        if (image3.getSize() != 0) {
            product.addImageToProduct(image3);
        }

        log.info("Saving new product. Title: {}; author: {}", product.getTitle(), product.getAuthor());
        Product productFromDB = productRepository.save(product);
        productFromDB.setPreviewImageId(productFromDB.getImageList().get(0).getId());
        productRepository.save(productFromDB);*/
    }

    public void save(Product product, Image image1, Image image2, Image image3) throws IOException, NoPreviewImageException {
        if (image1.getSize() != 0) {
            image1.setPreviewImage(true);
            product.addImageToProduct(image1);
        }
        else throw new NoPreviewImageException();
        if (image2.getSize() != 0) {
            product.addImageToProduct(image2);
        }
        if (image3.getSize() != 0) {
            product.addImageToProduct(image3);
        }

        log.info("Saving new product. Title: {}; author: {}", product.getTitle(), product.getAuthor());
        Product productFromDB = productRepository.save(product);
        productFromDB.setPreviewImageId(productFromDB.getImageList().get(0).getId());
        productRepository.save(productFromDB);
    }

    public Image toImage(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setContentType(file.getContentType());
        image.setBytes(file.getBytes());
        image.setSize(file.getSize());
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        return image;
    }
}
