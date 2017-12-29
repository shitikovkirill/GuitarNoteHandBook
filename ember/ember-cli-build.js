/* eslint-env node */
'use strict';

const EmberApp = require('ember-cli/lib/broccoli/ember-app');

module.exports = function(defaults) {
  let app = new EmberApp(defaults, {
    adminLTE: {
    plugins: ['morris', 'icheck', 'datepicker',
      'bootstrap-wysihtml5', 'daterangepicker', 'jvectormap',
      'select2', 'input-mask'
    ]
  }
  });
  return app.toTree();
};
