from rest_framework import serializers
from .models import Composition


class CompositionSerializer(serializers.ModelSerializer):
    """
    Serializer to parse Composition data
    """

    class Meta:
        model = Composition
        fields = ('title', 'description', 'id')
