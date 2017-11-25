from django.conf.urls import url, include
from django.contrib import admin

urlpatterns = [
    # admin
    url(r'^admin/', admin.site.urls),
    url(r'^redactor/', include('redactor.urls')),
    # API
    url(r'^token/', include('autorisation.urls')),
    url(r'', include('composition.urls'))
]
