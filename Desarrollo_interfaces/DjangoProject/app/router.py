class MongoRouter:
    route_app_labels = {"Videogames"}

    def db_for_read(self, model, **hints):
        # SI es el modelo Usuario, devuélveme la base de datos 'default' (SQLite)
        if model.__name__ == 'Usuario':
            return "default"
        # Para todo lo demás de Videogames, usa mongodb
        if model._meta.app_label in self.route_app_labels:
            return "mongodb"
        return "default"

    def db_for_write(self, model, **hints):
        if model.__name__ == 'Usuario':
            return "default"
        if model._meta.app_label in self.route_app_labels:
            return "mongodb"
        return "default"

    def allow_migrate(self, db, app_label, model_name=None, **hints):
        if app_label == "Videogames":
            # Si estamos migrando el usuario, que lo haga en SQLite (default)
            if model_name == "usuario":
                return db == "default"
            # Los demás modelos de la app van a mongo
            return db == "mongodb"
        # Tablas de admin, auth, sessions, etc., a SQLite
        return db == "default"