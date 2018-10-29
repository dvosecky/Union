// conf.js
var HtmlReporter = require('protractor-beautiful-reporter');

exports.config = {
    framework: 'jasmine',
    seleniumAddress: 'http://localhost:4444/wd/hub',
    

    //Added suites to organize tests and run specific suites
    suites: {
        smoke: 'homepage-smoke-spec.js',
        homepage: ['homepage-smoke-spec.js', 'homepage-login-spec.js'],
        admin: 'admin-basic-spec.js',
        basic: ['homepage-login-spec.js', 'admin-basic.spec.js']
    },
    jasmineNodeOpts: {
        showColors: true,
    },

    onPrepare: function() {
        // Add a screenshot reporter and store screenshots to `/tmp/screenshots`:
        jasmine.getEnv().addReporter(new HtmlReporter({
           baseDirectory: 'results/screenshots'
        }).getJasmine2Reporter());
     }
}