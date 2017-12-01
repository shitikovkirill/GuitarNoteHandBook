from django.contrib import admin
from import_export import resources
from import_export.admin import ImportExportModelAdmin
from .models import *


class NoteResource(resources.ModelResource):

    class Meta:
        model = Note


class NoteAdmin(ImportExportModelAdmin, admin.ModelAdmin):
    resource_class = NoteResource
    list_display = ('name', )
    list_per_page = 20


class AudioResource(resources.ModelResource):

    class Meta:
        model = Audio


class AudioAdmin(ImportExportModelAdmin, admin.ModelAdmin):
    resource_class = AudioResource
    list_display = ('name', )
    list_per_page = 20


class CompositionResource(resources.ModelResource):

    class Meta:
        model = Composition


class CompositionAdmin(ImportExportModelAdmin, admin.ModelAdmin):
    resource_class = CompositionResource
    list_display = ('title', )
    list_per_page = 20


class AuthorResource(resources.ModelResource):

    class Meta:
        model = Author


class AuthorAdmin(ImportExportModelAdmin, admin.ModelAdmin):
    resource_class = AuthorResource
    list_display = ('name', 'surname', 'name_en', 'surname_en')
    list_per_page = 20


admin.site.register(Composition, CompositionAdmin)
admin.site.register(Author, AuthorAdmin)
admin.site.register(Note, NoteAdmin)
admin.site.register(Audio, AudioAdmin)
