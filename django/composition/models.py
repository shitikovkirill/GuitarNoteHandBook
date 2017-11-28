from django.db import models
from redactor.fields import RedactorField


class Composition(models.Model):
    """
    Model for storing `composition`
    """

    title = models.CharField(max_length=100)
    description = RedactorField()


class Author(models.Model):
    """
    Model for storing `author`
    """

    name = models.CharField(max_length=100)
    surname = models.CharField(max_length=100)
    name_en = models.CharField(max_length=100)
    surname_en = models.CharField(max_length=100)
    biography = RedactorField()
