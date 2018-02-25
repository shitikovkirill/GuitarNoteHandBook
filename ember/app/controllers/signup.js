import Ember from 'ember';

export default Ember.Controller.extend({
  session: Ember.inject.service('session'),
  actions: {
    save(user){
      console.log(user);
      let newUser = user;
      newUser.save().catch((error) => {
        this.set('errorMessage', error)
      })
      .then(()=>{
        this.get('session')
        .authenticate('authenticator:oauth2',
          newUser.get('email'), newUser.get('password'))
        .catch((reason) => {
          this.set('errorMessage', reason.error ||reason);
        });
      })
    }
  }
});
