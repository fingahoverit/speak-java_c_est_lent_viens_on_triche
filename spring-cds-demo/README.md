# Demo : CDS

## Pré-requis

* Java 21
* maven
* Demo sous windows

## Lignes de commandes 

* Build de l'application

  A la racine ./ :
  ```  
    mvn clean package
  ```

* Génération du dump
 
  Dans le répertoire src/main/ps :
  ```  
    java -XX:ArchiveClassesAtExit=spring-cds-demo.jsa -jar ..\..\..\target\spring-cds-demo-0.0.1-SNAPSHOT.jar
  ```

* Démarrage de l'application avec AppCDS
 
  Dans le répertoire src/main/ps :
  ```  
    java -Xshare:on -XX:SharedArchiveFile=spring-cds-demo.jsa -jar .\..\..\..\target\spring-cds-demo-0.0.1-SNAPSHOT.jar
  ```

* Lancement du script de test
 
  Dans le répertoire src/main/ps :
  ```  
    .\test.spring-cds-demo.ps1
  ```