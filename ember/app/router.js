import Ember from 'ember';
import config from './config/environment';

const Router = Ember.Router.extend({
  location: config.locationType,
  rootURL: config.rootURL
});

Router.map(function() {
  this.route('login');
  this.route('authenticated', { path: 'profile' }, function() {
    // all routes that require the session to be authenticated
  });
  this.route('composition');
  this.route('single_composition', { path: 'composition/:composition_id' });
  this.route('author');
  this.route('single_author', { path: 'author/:author_id' });
});

export default Router;
