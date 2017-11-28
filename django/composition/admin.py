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


class AuthorResource(resources.ModelResource):

    class Meta:
        model = Author


class AuthorAdmin(ImportExportModelAdmin, admin.ModelAdmin):
    resource_class = AuthorResource
    list_display = ('name', 'surname', 'name_en', 'surname_en', 'biography')
    list_per_page = 20


admin.site.register(Composition, CompositionAdmin)
admin.site.register(Author, AuthorAdmin)
