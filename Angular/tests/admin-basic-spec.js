var angularAdminHome = require('./pages/admin.js');
describe('Testing Admin home functionality', function() {

    beforeEach(function() {
      angularAdminHome.get();
    });

    it('Access page for viewing events', function() {
      angularAdminHome.getAllEvents();

      //If we go to the view all events page, there won't be the button we used to access
      expect(element(by.id('all-events'))).toBeFalsy;
    });

    it('Access page for creating events', function() {
      angularAdminHome.createNewEvent();
  
      //If we go to the add events page, there won't be the button we used to access
      expect(element(by.id('create-event'))).toBeFalsy;
    });

    it('Access page for managing events', function() {
        angularAdminHome.manageEvents();
  
        //If we go to the manage events page, there won't be the button we used to access
        expect(element(by.id('my-events'))).toBeFalsy;
    });
  });