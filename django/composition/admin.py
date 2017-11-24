from django.contrib import admin
from import_export import resources
from import_export.admin import ImportExportModelAdmin
from .models import *


class CompositionResource(resources.ModelResource):

    class Meta:
        model = Composition


class CompositionAdmin(ImportExportModelAdmin, admin.ModelAdmin):
    resource_class = CompositionResource
    list_display = ('title', 'description')
    list_per_page = 20


admin.site.register(Composition, CompositionAdmin)
