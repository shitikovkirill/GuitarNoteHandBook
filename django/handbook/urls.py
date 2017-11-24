from django.conf.urls import url, include
from django.contrib import admin

urlpatterns = [
    url(r'^admin/', admin.site.urls),
    url(r'^token/', include('autorisation.urls')),
    url(r'^composition/', include('composition.urls'))
]
