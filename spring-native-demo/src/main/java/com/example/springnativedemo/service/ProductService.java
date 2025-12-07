package com.example.springnativedemo.service;

import com.example.springnativedemo.model.Product;
import com.opencsv.CSVReader;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final List<Product> products = new ArrayList<>();

    @PostConstruct
    public void init() {
        try (var reader = new CSVReader(
                new InputStreamReader(
                        getClass().getResourceAsStream("/products.csv")))) {

            String[] line = reader.readNext(); // sauter l’en-tête
            while ((line = reader.readNext()) != null) {
                String id = line[0];
                String name = line[1];
                double price = Double.parseDouble(line[2]);
                products.add(new Product(id, name, price));
            }
        } catch (Exception e) {
            throw new RuntimeException("Erreur de chargement du CSV", e);
        }
    }

    public List<Product> findAll() {
        return products;
    }

    public Optional<Product> findById(String id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }
}