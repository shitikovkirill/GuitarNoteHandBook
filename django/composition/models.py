from django.db import models
from redactor.fields import RedactorField
from django.core.validators import RegexValidator


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


class Note(models.Model):
    """
    Model for storing `note`
    """

    FILE_TYPE = (
        ('pdf', 'PDF'),
        ('txt', 'TXT'),
        ('gif', 'GIF')
    )
    name = models.CharField(max_length=100, null=True)
    note_type = models.CharField(
        max_length=4,
        choices=FILE_TYPE,
    )
    file = models.FileField()


class Audio(models.Model):
    """
    Model for storing `note`
    """

    FILE_TYPE = (
        ('mp3', 'MP3'),
        ('midi', 'MIDI'),
    )
    name = models.CharField(max_length=100, null=True)
    audio_type = models.CharField(
        max_length=4,
        choices=FILE_TYPE,
    )
    file = models.FileField()


class Composition(models.Model):
    """
    Model for storing `composition`
    """

    title = models.CharField(max_length=100)
    description = RedactorField()
    author = models.ManyToManyField(Author)
    note = models.ManyToManyField(Note)
    audio = models.ManyToManyField(Audio)
