from rest_framework.generics import (
    ListCreateAPIView, RetrieveUpdateDestroyAPIView)
from .serializers import *


class CompositionMixin(object):
    """
    Mixin to inherit from.
    Here we're setting the query set and the serializer
    """
    queryset = Composition.objects.all()
    serializer_class = CompositionSerializer


class CompositionList(CompositionMixin, ListCreateAPIView):
    """
    Return a list of all the composition, or
    create new ones
    """
    pass


class CompositionDetail(CompositionMixin, RetrieveUpdateDestroyAPIView):
    """
    Return a specific composition, update it, or delete it.
    """
    pass


class AuthorMixin(object):
    """
    Mixin to inherit from.
    Here we're setting the query set and the serializer
    """
    queryset = Author.objects.all()
    serializer_class = AuthorSerializer


class AuthorList(AuthorMixin, ListCreateAPIView):
    """
    Return a list of all the composition, or
    create new ones
    """
    pass


class AuthorDetail(AuthorMixin, RetrieveUpdateDestroyAPIView):
    """
    Return a specific composition, update it, or delete it.
    """
    pass
