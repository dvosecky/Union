var AngularHomepage = function() {
    var usernameField = element(by.id('email'));
    var passwordField = element(by.id('password'));
    var loginButton = element(by.id('submit-login'));
  
    this.get = function() {
      browser.get('http://18.220.118.195:8085/UnionFront/');
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

    this.adminLogin = function() {
        browser.get('http://18.220.118.195:8085/UnionFront/');
        usernameField.sendKeys('admin');
        passwordField.sendKeys('admin');
        loginButton.click();
    };
  };
  module.exports = new AngularHomepage();