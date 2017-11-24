from django.db import models


class Composition(models.Model):
    """
    Model for storing `tasks`
    """

    title = models.CharField(max_length=100)
    description = models.CharField(max_length=100)