package com.example.quarkusnativedemo.startup;

import com.example.quarkusnativedemo.model.Person;
import com.example.quarkusnativedemo.service.PersonService;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@ApplicationScoped
public class DataLoader {

    @Inject
    PersonService service;

    void onStart(@Observes StartupEvent ev) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                getClass().getResourceAsStream("/data.csv"), StandardCharsets.UTF_8))) {

            String line;
            reader.readLine(); // skip header
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Person p = new Person();
                p.name = parts[0];
                p.age = Integer.parseInt(parts[1]);
                p.city = parts[2];
                service.save(p);
            }
            System.out.println("✅ CSV data loaded into H2 database.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
