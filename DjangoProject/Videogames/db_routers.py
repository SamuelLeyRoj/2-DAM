class MongoRouter:
    """
    Un router para controlar todas las operaciones de base de datos
    para los modelos de la aplicación Videogames.
    """

    # IMPORTANTE: Asegúrate de que el 'app_label' coincida con el nombre
    # de tu aplicación. Normalmente Django lo pone en minúsculas.
    # Si tu carpeta se llama Videogames, prueba con 'Videogames' o 'videogames'.
    route_app_labels = {'Videogames', 'videogames'}

    def db_for_read(self, model, **hints):
        """
        Los intentos de lectura de modelos de 'Videogames' van a mongodb.
        """
        if model._meta.app_label in self.route_app_labels:
            return 'mongodb'
        return None

    def db_for_write(self, model, **hints):
        """
        Los intentos de escritura de modelos de 'Videogames' van a mongodb.
        """
        if model._meta.app_label in self.route_app_labels:
            return 'mongodb'
        return None

    def allow_relation(self, obj1, obj2, **hints):
        """
        Permitir relaciones si ambos modelos están en la app Videogames.
        """
        if (
                obj1._meta.app_label in self.route_app_labels or
                obj2._meta.app_label in self.route_app_labels
        ):
            return True
        return None

    def allow_migrate(self, db, app_label, model_name=None, **hints):
        """
        Asegura que los modelos de Videogames solo aparezcan en la base de datos mongodb.
        """
        if app_label in self.route_app_labels:
            return db == 'mongodb'
        return None