from rest_framework import serializers
from .models import *


class NoteSerializer(serializers.ModelSerializer):
    """
    Serializer to parse Note data
    """

    class Meta:
        model = Note
        fields = ('name', 'note_type', 'file', 'id')


class AudioSerializer(serializers.ModelSerializer):
    """
    Serializer to parse Audio data
    """

    class Meta:
        model = Audio
        fields = ('name', 'audio_type', 'file', 'id')


class AuthorSerializer(serializers.ModelSerializer):
    """
    Serializer to parse Author data
    """

    class Meta:
        model = Author
        fields = ('char', 'name', 'surname', 'char_en', 'name_en', 'surname_en', 'biography', 'id')


class CompositionSerializer(serializers.ModelSerializer):
    """
    Serializer to parse Composition data
    """

    class Meta:
        model = Composition
        fields = ('title', 'description', 'author', 'note', 'audio', 'id')
