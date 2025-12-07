# Demo : Spring Native

## Pré-requis

* Java 21
* podman (initialisé et démarré)
* maven
* Demo sous windows

## Lignes de commandes 

* Build de l'application native

  A la racine ./ :
  ```  
    mvn clean package spring-boot:process-aot spring-boot:build-image -Pnative
  ```

* Démarrage du conteneur créé contenant l'application

  ```  
    podman run --rm -p 8080:8080 spring-native-demo:1.0-SNAPSHOT
  ```
