from django.conf.urls import url, include
from django.contrib import admin
from django.conf.urls.static import static
from django.conf import settings
from rest_framework.authtoken import views

urlpatterns = [
    # admin
    url(r'^admin/', admin.site.urls),
    url(r'^redactor/', include('redactor.urls')),
    # API
    url(r'^token/', views.obtain_auth_token),
    url(r'^members/', include('autorisation.urls')),
    url(r'', include('composition.urls'))
] + static(settings.MEDIA_URL, document_root=settings.MEDIA_ROOT)
