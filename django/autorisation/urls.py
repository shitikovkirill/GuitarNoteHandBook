from django.conf.urls import url
from .views import *

urlpatterns = [
    url(r'^$', custom_auth_token),
]
