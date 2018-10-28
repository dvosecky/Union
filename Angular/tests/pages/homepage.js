var AngularHomepage = function() {
    var usernameField = element(by.id('email'));
    var passwordField = element(by.id('password'));
    var loginButton = element(by.id('submit-login'));
  
    this.get = function() {
      browser.get('http://www.angularjs.org');
    };
  
    this.setName = function(name) {
      usernameField.sendKeys(name);
    };
  
    this.setPass = function(pass) {
      passwordField.sendKeys(pass);
    };
  
    this.submit = function() {
      loginButton.click();
    };
  };
  module.exports = new AngularHomepage();