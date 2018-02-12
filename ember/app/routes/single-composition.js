import Ember from 'ember';

export default Ember.Route.extend({
  model(params){
    return this.get('store').findRecord('composition', params.composition_id)
  }
});
