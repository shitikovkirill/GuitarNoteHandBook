from django.db import models
from redactor.fields import RedactorField
from  django.core.validators import RegexValidator


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
    char = models.CharField(max_length=1, editable=False)
    name = models.CharField(max_length=100, null=True)
    surname = models.CharField(max_length=100,
        validators=[RegexValidator(r'^[\w\d]+', message='This field must contain minimum 1 char')])

    char_en = models.CharField(max_length=1, editable=False)
    name_en = models.CharField(max_length=100, null=True)
    surname_en = models.CharField(max_length=100,
        validators=[RegexValidator(r'^[\w\d]+', message='This field must contain minimum 1 char')])
    biography = RedactorField(null=True)

    def save(self, *args, **kwargs):
        self.char = self.surname.strip()[0]
        self.char_en = self.surname_en.strip()[0]

        super(Author, self).save(*args, **kwargs)
