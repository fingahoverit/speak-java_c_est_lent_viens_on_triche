# Demo : Quarkus Native

## Pré-requis

* Java 21
* podman (initialisé et démarré)
* maven
* Demo sous windows

## Lignes de commandes 

* Démarrer l'application en mode dev (DevUi)

  A la racine ./ :
  ```  
    mvn quarkus:dev
  ```

* Build de l'application native

  A la racine ./ :
  ```  
    mvn clean package -Pnative
  ```

* Accéder au conteneur pour démarrer l'app

  ```  
     wsl -d podman-machine-default
  ```

* Démarrer l'application native

  Dans le répertoire ./target :
  ```  
     ./quarkus-native-demo-1.0.0-SNAPSHOT-runner
  ```