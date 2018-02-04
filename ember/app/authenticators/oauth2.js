import OAuth2PasswordGrantAuthenticator from 'ember-simple-auth/authenticators/oauth2-password-grant';

class MyOAuth2PasswordGrantAuthenticator extends OAuth2PasswordGrantAuthenticator{
  makeRequest(url, data, headers = {}) {

    let result = super.makeRequest(url, data, headers);

    result.then(function(value) {
      if(value.token){
        value.access_token = value.token
      }
    });
    return result;
  }
}


export default MyOAuth2PasswordGrantAuthenticator.extend({
  serverTokenEndpoint: '/api/token/',
});
