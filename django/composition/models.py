from django.db import models
from redactor.fields import RedactorField

class Composition(models.Model):
    """
    Model for storing `tasks`
    """

    title = models.CharField(max_length=100)
    description = RedactorField()
