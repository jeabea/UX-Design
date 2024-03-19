# Rapport Projet Application Design

## Choix de l'application
Dans le cadre de notre projet universitaire en conception d'applications, notre objectif a été de développer une application mobile à partir de zéro. Le but principal était de concevoir une application hautement fonctionnelle, en choisissant soigneusement son thème et son design. Notre première étape a consisté à déterminer un thème et un design qui serviraient de fondement à notre application. Pour garantir une cohérence esthétique et l'adoption d'une charte graphique précise, nous avons décidé de nous inspirer d'un modèle existant sur Figma.

Nous avons exploré divers designs sur Figma, cherchant une inspiration qui corresponde à nos intérêts. Après une recherche approfondie, nous avons opté pour un thème centré sur une application de livraison de nourriture, inspiré par le modèle disponible à l'adresse suivante : https://www.figma.com/file/z5i2qMI5hlgFr6cUCm6Igj/Food-Delivery-Application-(Community)?type=design&node-id=4%3A102&mode=design&t=UNPyMQiNTGegwX9d-1. Bien que ce modèle ne comprenne que trois pages, il a fourni une direction claire pour le thème de notre application tout au long de notre processus créatif.

Nous avons conçu notre application avec les fonctionnalités suivantes :

* Un système permettant à l'utilisateur de se connecter ou de s'inscrire dans notre base de données clients.
* Après connexion, une liste de plats disponibles s'affiche, permettant à l'utilisateur de naviguer entre différentes catégories et de cliquer sur les plats pour obtenir plus d'informations.
* L'utilisateur peut sélectionner et ajouter autant de plats qu'il le souhaite à son panier. Il peut ensuite continuer à explorer l'offre et ajouter d'autres articles à son panier.
* Nous avons décidé de ne pas intégrer de fonction de paiement directement dans l'application, considérant qu'il n'était pas essentiel à la fonctionnalité de notre projet pilote.

Avec une vision claire de la structure et des fonctionnalités de notre application, nous avons pu répartir les tâches et entamer le développement de notre projet.

## Développement de l'application - Mini rapport individuel 
### Jade


### Andrea
Dès l'initiation de notre projet, nous avons procédé à une répartition équitable des tâches entre nous, m'attribuant la responsabilité de la conception de la page de présentation des plats. Pour ce faire, j'ai élaboré une page d'introduction, utilisant le modèle Figma comme guide pour notre charte graphique. Cette approche m'a permis de créer efficacement une page en XML dédiée à la première catégorie de plats (les hamburgers) et d'implémenter des boutons interactifs en Kotlin pour naviguer vers les autres catégories de plats (pizzas et sandwichs). Nous avons décidé de limiter notre sélection à quatre plats répartis dans trois catégories distinctes. Cette décision visait à démontrer la fonctionnalité des catégories sans nécessiter une base de données exhaustive et un travail répétitif.

Après avoir établi les pages des catégories, j'ai assisté Jeanne dans la création des pages d'informations détaillées pour chaque plat, en prenant en charge spécifiquement celles concernant les pizzas et les sandwiches. Ces pages ont été intégrées à la navigation principale, permettant un accès facile depuis la page d'accueil des plats en cliquant dessus. 



Par la suite, j'ai développé une base de données SQLite, facilitant l'intégration des fonctionnalités d'inscription et de connexion gérées par Jade.  En effet, notre application contenant une partie Connexion et une partie Inscription, il a fallu en premier lieu créer une base de donnée user avec en clé primaire le username rentré lors de l'inscription, le mail utilisateur, ainsi que le mot de passe. Une fois la base de donnée crée, il a été facile de créer une fonction permettant de prendre en entrée les données entrées par les utilisateurs dans des TextInputEditor, et les ajouter dans notre base de donnée. Un mécanisme de validation assure que tous les champs sont remplis avant de procéder à la création du compte, afin d'éviter toute erreur dans la base de données. En cas de succès, un message confirme la création du compte, après quoi l'utilisateur est redirigé vers la page de connexion. L'authentification est alors validée si les informations fournies correspondent à un enregistrement existant dans notre base, permettant ainsi l'accès à l'application. En cas d'échec, un message d'erreur est affiché.

Finalement, une fois la page profil crée, j'ai lié le design réalisé par jade à la base de donnée, permettant ainsi d'afficher sur le profil, le nom d'utilisateur de la personne connectée ainsi que son mail et son mot de passe. Permettant ainsi d'avoir une vue globale du profil crée par l'utilisateur connecté. 

### Jeanne
Ma contribution s'est principalement portée sur l'élaboration des interfaces pour la présentation des plats, avec un focus particulier sur les pages dédiées aux hamburgers et l'élaboration de la page panier. En utilisant Kotlin et XML pour le design, j'ai créé une page où les utilisateurs peuvent visualiser les détails du burger, ajuster la quantité via un système de compteur et les ajouter à leur panier. J'ai également intégré une option pour revenir en arrière à tout moment. Enfin, j’ai relié la page d’accueil aux différentes pages de burgers à l'aide de boutons.

Le travail sur les hamburgers a servi de modèle pour le développement des pages des autres catégories de plats, assurant une cohérence visuelle et fonctionnelle dans l'application. J'ai également mis en œuvre la page du panier.Ici, si un utilisateur choisit trois burgers, par exemple, il verra le total se mettre à jour automatiquement dans son panier. Face aux difficultés rencontrées avec l'utilisation d'une base de données pour le panier et les tentatives infructueuses d'implémentation via "SharedPreferences", j'ai finalement choisi une approche plus directe : inclure tous les articles par défaut avec un compteur initialisé à zéro. Ainsi, l'utilisateur peut ajuster la quantité désirée pour chaque article selon ses besoins avant de l'ajouter au panier.











