from rest_framework.authtoken.views import ObtainAuthToken


class CustomAuthToken(ObtainAuthToken):
    def post(self, request, *args, **kwargs):
        respons = super(CustomAuthToken, self).post(request, *args, **kwargs)
        respons.data = {'access_token': str(respons.data['token'])}
        return respons


custom_auth_token = CustomAuthToken.as_view()
