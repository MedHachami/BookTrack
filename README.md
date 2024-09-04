# Application BookTrack(Gestion des documents)

## Description
Cette application permet de gérer une bibliothèque de **documents** incluant des **livres** et des **magazines**. Les utilisateurs peuvent ajouter, consulter, emprunter et retourner des documents.

## Fonctionnalités
- Ajouter un **livre** ou un **magazine**
- Afficher tous les documents disponibles
- Rechercher un document par **titre**
- Emprunter et retourner un document

## Structure de l'Application

### 1. **Controllers**
Les contrôleurs gèrent les interactions de l'utilisateur avec l'interface utilisateur et orchestrent les actions sur les données à travers les services et DAOs.
- `HomeController` : Gère l'affichage de la page d'accueil.
- `LivreController` : Gère les interactions liées aux livres (crud)
- `MagazineController` : Gère les interactions liées aux magazines.

### 2. **DAO (Data Access Object)**
Les DAOs sont responsables de la gestion de la persistance des données.
- `DocumentDao` (Interface) : Définit les méthodes pour la gestion des documents.
- `LivreDao` : Implémente la gestion des livres.
- `MagazineDao` : Implémente la gestion des magazines.

### 3. **Modèle**
Les classes du modèle représentent les données.
- `Document` (Classe abstraite) : Classe de base pour tous les types de documents.
- `Livre` : Représente un livre avec ses attributs spécifiques .
- `Magazine` : Représente un magazine avec des attributs similaires aux livres.

### 4. **Services**
Les services contiennent la logique métier et font appel aux DAOs pour interagir avec les données.
- `BiblioDaoImpl` : Service principal pour la gestion des documents.
- `LivreDaoImpl` : Gère les opérations sur les livres.
- `MagazineDaoImpl` : Gère les opérations sur les magazines.

### 5. **Utils**
Les classes utilitaires fournissent des fonctionnalités réutilisables à travers l'application.
- `Utils` : Contient des méthodes utilitaires diverses.
- `DatabaseConnection` : Gère la connexion à la base de données.

### 6. **View**
Les vues représentent l'interface utilisateur pour chaque fonctionnalité.
- `EmpruntView` : Interface utilisateur pour emprunter des documents.
- `HomeView` : Interface pour la page d'accueil.
- `LivreView` : Interface pour afficher et manipuler les livres.
- `MagazineView` : Interface pour afficher et manipuler les magazines.
## Prérequis

### Environnement Java
- **Java JDK 8** ou version supérieure.
- **MySQL** pour la base de données.

### Librairies nécessaires
- JDBC pour connecter l'application à la base de données MySQL.
  
## Installation

### 1. Cloner le dépôt
Clonez le dépôt dans votre machine locale.

```bash
git clone https://github.com/votre-depot/gestion-documents.git
cd gestion-documents
```

### 2.Configurer database.properties en Utils/DatabaseConnection

### 3.run the run_app.sh script




