var AngularAdminHome = function() {
    var viewEvents = element(by.id('all-events'));
    var addEvent = element(by.id('create-event'));
    var manageEvents = element(by.id('my-events'));

    this.get = function() {
        browser.get('http://18.220.118.195:8085/UnionFront/');
        element(by.id('email')).sendKeys('admin');
        element(by.id('password')).sendKeys('admin');
        element(by.id('submit-login')).click();
    };
  
    this.getAllEvents = function() {
      viewEvents.click();
    };
  
    this.createNewEvent = function() {
      addEvent.click();
    };
  
    this.manageEvents = function() {
      manageEvents.click();
    };
  };
  module.exports = new AngularAdminHome();