import DS from 'ember-data';

export default DS.Model.extend({
  char: DS.attr(),
  name: DS.attr(),
  surname: DS.attr(),
  'char-en': DS.attr(),
  'name-en': DS.attr(),
  'surname-en': DS.attr(),
  biography: DS.attr()
});
