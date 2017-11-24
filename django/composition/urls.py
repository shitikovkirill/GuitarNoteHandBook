from django.conf.urls import url
from .views import *

urlpatterns = [
    url(r'^compositions$', CompositionList.as_view(), name='composition_list'),
    url(r'^(?P<pk>[0-9]+)$', CompositionDetail.as_view(), name='composition_detail'),
]
