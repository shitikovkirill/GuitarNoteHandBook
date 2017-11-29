from rest_framework import serializers
from .models import *


class CompositionSerializer(serializers.ModelSerializer):
    """
    Serializer to parse Composition data
    """

    class Meta:
        model = Composition
        fields = ('title', 'description', 'id')


class AuthorSerializer(serializers.ModelSerializer):
    """
    Serializer to parse Author data
    """

    class Meta:
        model = Author
        fields = ('char', 'name', 'surname', 'char_en', 'name_en', 'surname_en', 'biography', 'id')
