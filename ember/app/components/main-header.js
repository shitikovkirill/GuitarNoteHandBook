import Ember from 'ember';

export default Ember.Component.extend({
  session: Ember.inject.service('session'),
  classNames: ["main-header"],
  tagName: "header",
  actions: {
    sidebarTogger: function(){
      var class_name = 'control-sidebar-open';
      if($('body').hasClass(class_name)){
        $('body').addClass(class_name);
      }else{
        $('body').removeClass(class_name);
      }
    },
    logout() {
      this.get('session').invalidate();
    }
  }
});
