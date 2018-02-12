from django.conf.urls import url
from .views import *

urlpatterns = [
    url(r'^compositions$', CompositionList.as_view(), name='composition_list'),
    url(r'^compositions/last-added$', LastAddedComposition.as_view(), name='last_added'),
    url(r'^compositions/(?P<pk>[0-9]+)$', CompositionDetail.as_view(), name='composition_detail'),
    url(r'^authors$', AuthorList.as_view(), name='author_list'),
    url(r'^authors/(?P<pk>[0-9]+)$', AuthorDetail.as_view(), name='author_detail'),
]
