import Ember from 'ember';
import RSVP from 'rsvp';

export default Ember.Route.extend({
  model() {
    return RSVP.hash({
      composition: this.get('store').query('composition', {type: 'last-added'}),
      author: this.get('store').query('author', {type: 'last-added'})
    });
  }
});
