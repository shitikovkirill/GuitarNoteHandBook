import DS from 'ember-data';

export default DS.Model.extend({
  name: DS.attr(),
  surname: DS.attr(),
  biography: DS.attr()
});
